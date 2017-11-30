package com.sy.service.us;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.sy.entity.BeOrderlite;
import com.sy.entity.SyEmp;
import com.sy.entity.SyMeterType;
import com.sy.entity.UsFormula;
import com.sy.entity.UsMeter;
import com.sy.entity.UsUser;
import com.sy.entity.page.Page;
import com.sy.entity.userhelp.GenerateExcelBean;
import com.sy.entity.userhelp.OrderLite;
import com.sy.entity.userhelp.UsUserHelpBean;
import com.sy.entity.view.MeterView;
import com.sy.projectUtils.GenerateExcelUtility;
import com.sy.projectUtils.UserUtility;
import com.sy.projectUtils.ValueVerify;

@Service(value="usUserService")
public class UsUserService extends UsParent {

	// 查询本月新增的用户数量
	public Integer selNowUserCount() {
		return ValueVerify.isnull(Integer.class, getUsUserMapper()
				.selNowUserCount());
	}

	/*
	 * @ author 卿建锋 version 1.0
	 */
	// 快捷重签-【条件查询用户】
	public List<UsUser> queryUsUsers(UsUser user) {

		List<UsUser> users=this.getUsUserMapper().queryUsers(
				new UserUtility().convertToUser(user));
		if(users.size()>0)
		{
			return users;
		}else{
			return null;
		}
	}

	// 快捷重签-【修改协议】
	public int updateProtocol(HttpServletRequest request, UsUser user,BeOrderlite orderLite) {

		/*
		 * 重签协议业务流程
		 * 
		 * 1. 根据用户编码 修改Us_User表中的formula字段值
		 * 
		 * 2. 根据用户编码删除 us_formula协议表中存在的该用户编码的协议【数据】
		 * 
		 * 3. 重新添加协议
		 * 
		 * 4. 添加快捷操作记录
		 */
		/*修改协议字段值*/
		int reSetNum = this.getUsUserMapper().reSetProtocol(user);
		/*删除用户协议*/
		int deleteNum = this.getUsFormulaMapper().deleteUsFormulaByUserNo(
				user);
		/*转换协议对象*/
		List<UsFormula> formulas = new UserUtility().userConvertToUsFormula(user);
		
		/*循环添加协议至协议表*/
		int updateNum = 0;
		for (UsFormula usFormula : formulas) {
			usFormula.setId(this.getUsFormulaMapper().countByExample(null) + 1); //编码自动增长
			updateNum += this.getUsFormulaMapper().inserUsFormulaByUsUser(
					usFormula);
		}
		
		/*生成自动增长 序列号*/
		Integer orderId=this.getOrderLiteMapper().countByExample(null)+1;
		
		/*查询当前自来水公司登录本系统的员工ID*/
		SyEmp emp=(SyEmp) request.getSession().getAttribute("empLogin");
		Integer empId=this.getEmpMapper().queryEmpIDByName(emp.getEmpNo());
		
		
		/*添加新快捷记录至快捷工单表*/
		
		orderLite.setId(orderId);
		orderLite.setEmpId(empId);
		BeOrderlite orderLiteTow=new UserUtility().convertTo(user,orderLite);
		int addOrderNum=this.getOrderLiteMapper().insert(orderLiteTow);

		int num = reSetNum + deleteNum + updateNum+addOrderNum;
		return num;
	}
	
	//快捷销户-注销用户
	public Integer addUserByCancellation(HttpServletRequest request,UsUser user,BeOrderlite orderLite){
		System.out.println("测试。。。。。。。。。。。。");
		//禁用用户
		int cancellationNum=this.getUsUserMapper().cancellationUser(user);
		
		//清除该用户协议
		int clearFormulaNum=this.getUsFormulaMapper().deleteUsFormulaByUserNo(user);
		
		//禁用水表
		int meterNum=this.getUsMeterMapper().cancellationUsMater(user.getUserNo());
		
		/*生成自动增长 序列号*/
		Integer orderId=this.getOrderLiteMapper().countByExample(null)+1;
		orderLite.setId(orderId);
		//操作人编号
		SyEmp emp=(SyEmp)request.getSession().getAttribute("empLogin");
		Integer empId=this.getEmpMapper().queryEmpIDByName(emp.getEmpNo());
		orderLite.setEmpId(empId);
		//新添加快捷操作记录
		int orderLiteNum=this.getOrderLiteMapper().insert(new UserUtility().convertTo(user, orderLite));
		
		int number=cancellationNum+meterNum+orderLiteNum;
		
		return number;
	}
	
	/*快捷操作记录-【绑定操作员工】*/
	public List<SyEmp> queryEmpAll(){
		return this.getEmpMapper().queryEmpAll();
	}
	
	/*快捷操作记录-【按照条件筛选条件匹配的快捷操作记录显示】*/
	public List<BeOrderlite> queryOrderliteByParameter(OrderLite orderLite){
		List<BeOrderlite>orderLites= converToListOrder(
				this.getOrderLiteMapper().queryEmpsByParemter(orderLite));
		orderLites.get(orderLites.size()-1).setPage(setPageConvert(orderLite));
		return orderLites;
	}
	
	//验证数据库内是否存在相同档案号
	public String queryDocNumByDocnum(String docNum)
	{
		return this.getUsUserMapper().queryDocNumReset(docNum);
	}
	
	//档案号管理-【修改档案号】
	public Integer updateDocById(UsUser user)
	{
		return this.getUsUserMapper().updateDocById(user);
	}
	
	//短信群发
	public List<UsUserHelpBean> queryMassUserData(UsUserHelpBean userBean)
	{
		
		List<UsUserHelpBean> userBeans=null;
		if(userBean.getUserType().equals("只给欠费用户发送")){
			//查询欠费的用户信息
			userBeans=this.getUsUserMapper().queryArreasUserData(
					new UserUtility().converToPage(userBean.getPage()));
			userBeans.get(userBeans.size()-1).setPage(setPageMsaaConverTo(userBean.getPage(),false));
		
		}else{
			//查询所有的用户信息
			userBeans=this.getUsUserMapper().queryOwnershipUserDate(
					new UserUtility().converToPage(userBean.getPage()));
			userBeans.get(userBeans.size()-1).setPage(setPageMsaaConverTo(userBean.getPage(),true));
		}
		
		return new UserUtility().converToUsUserHelpBean(userBeans, userBean);
	}

	//短信群发生成Excel表格报表-【新建Excel文件并且存档】
	public void generateExcelTable(UsUserHelpBean userBean)
	{
		List<UsUserHelpBean> userBeans=queryMassUserData(userBean);
		List<Object[]> objs=new GenerateExcelUtility().converToObjects(userBeans);
		GenerateExcelBean excelBean=new GenerateExcelBean(new String[]{"用户编号","用户姓名","短信号码","发送内容"}, objs);
		excelBean.setExcelPath("F:\\mass.xls");
		excelBean.setFileName("短信群发");
		excelBean.setSheetIndex(0);
		GenerateExcelUtility excel=new GenerateExcelUtility();
		excel.generateExcelTable(excelBean);
	}
	//短信群发生成Excel表格报表-【在原来的Excel文件追加新的内容并且存档】
	public void addExcelTable(UsUserHelpBean userBean)
	{
		List<UsUserHelpBean> userBeans=queryMassUserData(userBean);
		List<Object[]> objs=new GenerateExcelUtility().converToObjects(userBeans);
		GenerateExcelBean excelBean=new GenerateExcelBean(new String[]{"用户编号","用户姓名","短信号码","发送内容"}, objs);
		excelBean.setExcelPath("F:\\mass.xls");
		excelBean.setFileName("短信群发");
		excelBean.setSheetIndex(0);
		GenerateExcelUtility excel=new GenerateExcelUtility();
		excel.readExcelTable(excelBean);
	}
		
	//快捷换表-【条件用户查询】
	public List<MeterView> queryChangeTable(UsUser user)
	{
		List<MeterView>meters=new ArrayList<MeterView>(this.getUsUserMapper().queryChangeTable(new UserUtility().convertToUser(user)));
	
		return new UserUtility().converToMeterView(meters);
	}
	
	//快捷换表-【换表处理】
	public Integer updateMeter(HttpServletRequest request,UsMeter meter,String userName)
	{
		int userNumber=this.getUsUserMapper().replaceUserByMeter(meter);
		Integer replaceNumber=this.getUsMeterMapper().updateMeterByUser(meter);
		int syMeterNumber=this.getSyMeterTypeMapper().updateSyMeterType(meter);
		//准备添加一行新的快捷操作记录
		BeOrderlite order=new BeOrderlite();
		order.setDatee(new Date());
		order.setOrderType(5);
		order.setDescription(null);
		order.setId(this.getOrderLiteMapper().countByExample(null)+1);
		order.setUserName(userName);
		order.setUserNo(meter.getUserNo());
		SyEmp emp=(SyEmp)request.getSession().getAttribute("empLogin");
		order.setEmpId(emp.getEmpId());
		//添加快捷记录
		Integer addOrderNumber=this.getOrderLiteMapper().insert(order);
		return replaceNumber+addOrderNumber+userNumber;
	}
	
	/*快捷换表-【绑定水表类型】*/
	public List<SyMeterType> bindingMeterType()
	{
		return new ArrayList<SyMeterType>(this.getSyMeterTypeMapper().selectAll());
		
	}
	
	
	
	
	
	
	
	
	/*page运算*/
	private Page setPageConvert(OrderLite orderLite){
		Page pageNoe=new Page();
		pageNoe.setPageCount(this.getOrderLiteMapper().queryOrderLiteCount(orderLite));
		pageNoe.setPageNumber(orderLite.getPage().getPageNum());
		Integer count=0;
		Integer shang=pageNoe.getPageCount()/10;
		if(shang==0)
		{
			if(orderLite.getPage().getPageNumber()==0)
			{
				count+=1;
			}else{
				count=orderLite.getPage().getPageNumber();
			}
		}else if(shang>0)
		{
			count=shang+1;
		}else{
		
			count=orderLite.getPage().getPageNumber()+1;
		}
		pageNoe.setPageNum(count);
		return pageNoe;
	}
	/*短信息page运算*/
	private Page setPageMsaaConverTo(Page page,boolean flag)
	{
		if(flag){
			//统计所有用户
			page.setPageCount(this.getUsUserMapper().queryTrueUserCount());
		}else{
			//统计欠费用户
			page.setPageCount(this.getUsUserMapper().queryArreasUserCount());
		}
		page=new UserUtility().changPage(page);
		return page;
	}
	/*数据展示视图转换*/
	private List<BeOrderlite> converToListOrder(List<BeOrderlite> orderLites){
		List<BeOrderlite> orders=new ArrayList<BeOrderlite>();
		for (BeOrderlite beOrderlite : orderLites) {
			beOrderlite.setDateeTime(new UserUtility().converToString(beOrderlite.getDatee()));
			beOrderlite.setEmpName(this.getEmpMapper().queryEmpNameById(beOrderlite.getEmpId()));
			beOrderlite.setOrderTypeString(new UserUtility().convertToOrderType(beOrderlite.getOrderType()));
			beOrderlite.setDescription(new UserUtility().isNull(beOrderlite.getDescription()));
			orders.add(beOrderlite);
		}
		orderLites.clear();
		return new LinkedList<BeOrderlite>(orders);
	}
	
	//唐雪松 添加

	public void insert(UsUser user) {
		getUsUserMapper().insert(user);
	}

	//唐雪松 查询
	public UsUser selByuserName(String userName, String phone) {
		return getUsUserMapper().selByuserName(userName, phone);
	}

	//唐雪松 修改
	public void update(UsUser user) {
		getUsUserMapper().updateByPrimaryKey(user);
	}
	
	
	
	
	//快捷过户
	public void updateUserByUserNo(UsUser user,HttpServletRequest request)
	{
		
		int number=this.getUsUserMapper().updateUserByUserNo(user);
		if(number>0){
			//快捷操作记录 实例
			BeOrderlite order=new BeOrderlite();
			order.setId(this.getOrderLiteMapper().countByExample(null)+1);
			order.setDatee(new Date());
			SyEmp emp=(SyEmp)request.getSession().getAttribute("empLogin");
			order.setEmpId(emp.getEmpId());
			order.setUserName(user.getUserName());
			order.setUserNo(user.getUserNo());
			order.setDescription(null);
			order.setOrderType(3);
			int num=this.getOrderLiteMapper().insert(order);
		}
	}

	//Monkey 注入
	public Integer monkeyUpdate(UsUser user,HttpServletRequest req){
		
		int number=getUsUserMapper().updateByPrimaryKeySelective(user);
		
		if(number>0)
		{
			SyEmp emp = (SyEmp) req.getSession().getAttribute("empLogin");
			BeOrderlite order = new BeOrderlite();
			order.setOrderType(4);
			order.setDatee(new Date(System.currentTimeMillis()));
			order.setEmpId(emp.getEmpId());
			order.setUserNo(user.getUserNo());
			order.setUserName(user.getUserName());
			return this.getOrderLiteMapper().insert(order);
		}else{
			return 0;
		}
		
		
	}
	
}