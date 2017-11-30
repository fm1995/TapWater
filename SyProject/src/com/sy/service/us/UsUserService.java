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

	// ��ѯ�����������û�����
	public Integer selNowUserCount() {
		return ValueVerify.isnull(Integer.class, getUsUserMapper()
				.selNowUserCount());
	}

	/*
	 * @ author �佨�� version 1.0
	 */
	// �����ǩ-��������ѯ�û���
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

	// �����ǩ-���޸�Э�顿
	public int updateProtocol(HttpServletRequest request, UsUser user,BeOrderlite orderLite) {

		/*
		 * ��ǩЭ��ҵ������
		 * 
		 * 1. �����û����� �޸�Us_User���е�formula�ֶ�ֵ
		 * 
		 * 2. �����û�����ɾ�� us_formulaЭ����д��ڵĸ��û������Э�顾���ݡ�
		 * 
		 * 3. �������Э��
		 * 
		 * 4. ��ӿ�ݲ�����¼
		 */
		/*�޸�Э���ֶ�ֵ*/
		int reSetNum = this.getUsUserMapper().reSetProtocol(user);
		/*ɾ���û�Э��*/
		int deleteNum = this.getUsFormulaMapper().deleteUsFormulaByUserNo(
				user);
		/*ת��Э�����*/
		List<UsFormula> formulas = new UserUtility().userConvertToUsFormula(user);
		
		/*ѭ�����Э����Э���*/
		int updateNum = 0;
		for (UsFormula usFormula : formulas) {
			usFormula.setId(this.getUsFormulaMapper().countByExample(null) + 1); //�����Զ�����
			updateNum += this.getUsFormulaMapper().inserUsFormulaByUsUser(
					usFormula);
		}
		
		/*�����Զ����� ���к�*/
		Integer orderId=this.getOrderLiteMapper().countByExample(null)+1;
		
		/*��ѯ��ǰ����ˮ��˾��¼��ϵͳ��Ա��ID*/
		SyEmp emp=(SyEmp) request.getSession().getAttribute("empLogin");
		Integer empId=this.getEmpMapper().queryEmpIDByName(emp.getEmpNo());
		
		
		/*����¿�ݼ�¼����ݹ�����*/
		
		orderLite.setId(orderId);
		orderLite.setEmpId(empId);
		BeOrderlite orderLiteTow=new UserUtility().convertTo(user,orderLite);
		int addOrderNum=this.getOrderLiteMapper().insert(orderLiteTow);

		int num = reSetNum + deleteNum + updateNum+addOrderNum;
		return num;
	}
	
	//�������-ע���û�
	public Integer addUserByCancellation(HttpServletRequest request,UsUser user,BeOrderlite orderLite){
		System.out.println("���ԡ�����������������������");
		//�����û�
		int cancellationNum=this.getUsUserMapper().cancellationUser(user);
		
		//������û�Э��
		int clearFormulaNum=this.getUsFormulaMapper().deleteUsFormulaByUserNo(user);
		
		//����ˮ��
		int meterNum=this.getUsMeterMapper().cancellationUsMater(user.getUserNo());
		
		/*�����Զ����� ���к�*/
		Integer orderId=this.getOrderLiteMapper().countByExample(null)+1;
		orderLite.setId(orderId);
		//�����˱��
		SyEmp emp=(SyEmp)request.getSession().getAttribute("empLogin");
		Integer empId=this.getEmpMapper().queryEmpIDByName(emp.getEmpNo());
		orderLite.setEmpId(empId);
		//����ӿ�ݲ�����¼
		int orderLiteNum=this.getOrderLiteMapper().insert(new UserUtility().convertTo(user, orderLite));
		
		int number=cancellationNum+meterNum+orderLiteNum;
		
		return number;
	}
	
	/*��ݲ�����¼-���󶨲���Ա����*/
	public List<SyEmp> queryEmpAll(){
		return this.getEmpMapper().queryEmpAll();
	}
	
	/*��ݲ�����¼-����������ɸѡ����ƥ��Ŀ�ݲ�����¼��ʾ��*/
	public List<BeOrderlite> queryOrderliteByParameter(OrderLite orderLite){
		List<BeOrderlite>orderLites= converToListOrder(
				this.getOrderLiteMapper().queryEmpsByParemter(orderLite));
		orderLites.get(orderLites.size()-1).setPage(setPageConvert(orderLite));
		return orderLites;
	}
	
	//��֤���ݿ����Ƿ������ͬ������
	public String queryDocNumByDocnum(String docNum)
	{
		return this.getUsUserMapper().queryDocNumReset(docNum);
	}
	
	//�����Ź���-���޸ĵ����š�
	public Integer updateDocById(UsUser user)
	{
		return this.getUsUserMapper().updateDocById(user);
	}
	
	//����Ⱥ��
	public List<UsUserHelpBean> queryMassUserData(UsUserHelpBean userBean)
	{
		
		List<UsUserHelpBean> userBeans=null;
		if(userBean.getUserType().equals("ֻ��Ƿ���û�����")){
			//��ѯǷ�ѵ��û���Ϣ
			userBeans=this.getUsUserMapper().queryArreasUserData(
					new UserUtility().converToPage(userBean.getPage()));
			userBeans.get(userBeans.size()-1).setPage(setPageMsaaConverTo(userBean.getPage(),false));
		
		}else{
			//��ѯ���е��û���Ϣ
			userBeans=this.getUsUserMapper().queryOwnershipUserDate(
					new UserUtility().converToPage(userBean.getPage()));
			userBeans.get(userBeans.size()-1).setPage(setPageMsaaConverTo(userBean.getPage(),true));
		}
		
		return new UserUtility().converToUsUserHelpBean(userBeans, userBean);
	}

	//����Ⱥ������Excel��񱨱�-���½�Excel�ļ����Ҵ浵��
	public void generateExcelTable(UsUserHelpBean userBean)
	{
		List<UsUserHelpBean> userBeans=queryMassUserData(userBean);
		List<Object[]> objs=new GenerateExcelUtility().converToObjects(userBeans);
		GenerateExcelBean excelBean=new GenerateExcelBean(new String[]{"�û����","�û�����","���ź���","��������"}, objs);
		excelBean.setExcelPath("F:\\mass.xls");
		excelBean.setFileName("����Ⱥ��");
		excelBean.setSheetIndex(0);
		GenerateExcelUtility excel=new GenerateExcelUtility();
		excel.generateExcelTable(excelBean);
	}
	//����Ⱥ������Excel��񱨱�-����ԭ����Excel�ļ�׷���µ����ݲ��Ҵ浵��
	public void addExcelTable(UsUserHelpBean userBean)
	{
		List<UsUserHelpBean> userBeans=queryMassUserData(userBean);
		List<Object[]> objs=new GenerateExcelUtility().converToObjects(userBeans);
		GenerateExcelBean excelBean=new GenerateExcelBean(new String[]{"�û����","�û�����","���ź���","��������"}, objs);
		excelBean.setExcelPath("F:\\mass.xls");
		excelBean.setFileName("����Ⱥ��");
		excelBean.setSheetIndex(0);
		GenerateExcelUtility excel=new GenerateExcelUtility();
		excel.readExcelTable(excelBean);
	}
		
	//��ݻ���-�������û���ѯ��
	public List<MeterView> queryChangeTable(UsUser user)
	{
		List<MeterView>meters=new ArrayList<MeterView>(this.getUsUserMapper().queryChangeTable(new UserUtility().convertToUser(user)));
	
		return new UserUtility().converToMeterView(meters);
	}
	
	//��ݻ���-��������
	public Integer updateMeter(HttpServletRequest request,UsMeter meter,String userName)
	{
		int userNumber=this.getUsUserMapper().replaceUserByMeter(meter);
		Integer replaceNumber=this.getUsMeterMapper().updateMeterByUser(meter);
		int syMeterNumber=this.getSyMeterTypeMapper().updateSyMeterType(meter);
		//׼�����һ���µĿ�ݲ�����¼
		BeOrderlite order=new BeOrderlite();
		order.setDatee(new Date());
		order.setOrderType(5);
		order.setDescription(null);
		order.setId(this.getOrderLiteMapper().countByExample(null)+1);
		order.setUserName(userName);
		order.setUserNo(meter.getUserNo());
		SyEmp emp=(SyEmp)request.getSession().getAttribute("empLogin");
		order.setEmpId(emp.getEmpId());
		//��ӿ�ݼ�¼
		Integer addOrderNumber=this.getOrderLiteMapper().insert(order);
		return replaceNumber+addOrderNumber+userNumber;
	}
	
	/*��ݻ���-����ˮ�����͡�*/
	public List<SyMeterType> bindingMeterType()
	{
		return new ArrayList<SyMeterType>(this.getSyMeterTypeMapper().selectAll());
		
	}
	
	
	
	
	
	
	
	
	/*page����*/
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
	/*����Ϣpage����*/
	private Page setPageMsaaConverTo(Page page,boolean flag)
	{
		if(flag){
			//ͳ�������û�
			page.setPageCount(this.getUsUserMapper().queryTrueUserCount());
		}else{
			//ͳ��Ƿ���û�
			page.setPageCount(this.getUsUserMapper().queryArreasUserCount());
		}
		page=new UserUtility().changPage(page);
		return page;
	}
	/*����չʾ��ͼת��*/
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
	
	//��ѩ�� ���

	public void insert(UsUser user) {
		getUsUserMapper().insert(user);
	}

	//��ѩ�� ��ѯ
	public UsUser selByuserName(String userName, String phone) {
		return getUsUserMapper().selByuserName(userName, phone);
	}

	//��ѩ�� �޸�
	public void update(UsUser user) {
		getUsUserMapper().updateByPrimaryKey(user);
	}
	
	
	
	
	//��ݹ���
	public void updateUserByUserNo(UsUser user,HttpServletRequest request)
	{
		
		int number=this.getUsUserMapper().updateUserByUserNo(user);
		if(number>0){
			//��ݲ�����¼ ʵ��
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

	//Monkey ע��
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