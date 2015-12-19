package com.sy.service.rd;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.mbeans.UserMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sy.entity.PyBalance;
import com.sy.entity.PyBalancedetail;
import com.sy.entity.PyBill;
import com.sy.entity.PyBilldetail;
import com.sy.entity.PyUserhistory;
import com.sy.entity.RdRead;
import com.sy.entity.RdReadtypes;
import com.sy.entity.RdYearmonth;
import com.sy.entity.ReadView;
import com.sy.entity.SyEmp;
import com.sy.entity.UsUser;
import com.sy.mappdao.BeOrderuserMapper;
import com.sy.mappdao.PyBalanceMapper;
import com.sy.mappdao.PyBalancedetailMapper;
import com.sy.mappdao.PyBillMapper;
import com.sy.mappdao.PyBilldetailMapper;
import com.sy.mappdao.PyUserhistoryMapper;
import com.sy.mappdao.RdReadMapper;
import com.sy.mappdao.RdReadtypesMapper;
import com.sy.mappdao.RdTaskMapper;
import com.sy.mappdao.RdYearmonthMapper;
import com.sy.mappdao.UsUserMapper;
import com.sy.projectUtils.rd.TermUtil;

/**
 * @author xulong
 * 抄表数据业务处理层
 */
@Service
public class ReadService {
	@Autowired
	private RdReadMapper rdReadMapper;
	@Autowired
	private BeOrderuserMapper orderUserMapper;
	@Autowired
	private RdYearmonthMapper yearMonthMapper;
	@Autowired
	private RdTaskMapper taskMapper;
	@Autowired
	private RdReadtypesMapper readTypesMapper;
	@Autowired
	private PyBilldetailMapper billDetailMapper;
	@Autowired
	private PyBillMapper billMapper;
	@Autowired
	private UsUserMapper userMapper;
	@Autowired
	private PyUserhistoryMapper historyMapper;
	@Autowired
	private PyBalanceMapper balanceMapper;
	@Autowired
	private PyBalancedetailMapper balanceDetailMapper;
	
	/**
	 * 根据年份和月份查询抄表情况报表并写到前端
	 * @param response
	 * @param read
	 * @throws IOException
	 */
	public void selByYearAndMonth(HttpServletResponse response, RdRead read) throws IOException {
		List<ReadView> list = rdReadMapper.selByYearAndMonth(read);
		response.setContentType("text/html;charset=utf-8");
		String data=new Gson().toJson(list);
		response.getWriter().write(data);
	}
	
	/**
	 * 根据条件分页查询0吨水用户并写到前端
	 * @param response
	 * @param term
	 * @param read
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void selReadByTerm(HttpServletResponse response,TermUtil term,RdRead read) throws IOException{
		List<RdRead> list=rdReadMapper.selReadByTerm(term,read);
		int userCount=selReadByTermUserCount(term,read);
		int count = selReadByTermCount(term, read);
		@SuppressWarnings("rawtypes")
		Map map=new HashMap<String,Object>();
		int pageCount=(count-1)/term.rows+1;
		map.put("pageCount",pageCount>0?pageCount:1);
		map.put("list",list);
		map.put("userCount",userCount);
		mapToJson(response, map);
	}
	
	/**
	 * 根据条件查询0吨位用水量用户总和
	 * @param term
	 * @param read
	 * @return
	 */
	private int selReadByTermUserCount(TermUtil term, RdRead read) {
		int userCount=rdReadMapper.selReadByTermUserCount(term,read);
		return userCount;
	}

	/**
	 * 根据条件分页查询0吨水用户的总页数
	 * @param request
	 * @param term
	 * @param read
	 */
	public int selReadByTermCount(TermUtil term,RdRead read){
		int count=rdReadMapper.selReadByTermCount(term,read);
		return count;
	}
	
	/**
	 * 计数每个月初始化用户的数量并返回前端
	 * @throws IOException 
	 */
	public void loadUserCount(HttpServletResponse response) throws IOException{
		int newUserCount = orderUserMapper.newUserCount();
		int userCount=rdReadMapper.sumCount();
		response.setContentType("text/html;charset=utf-8");
		String countStr=newUserCount+userCount+"";
		response.getWriter().write(countStr);
	}
	
	/**
	 * 将map转换为json并写到前端
	 * @param response
	 * @param map
	 */
	@SuppressWarnings("rawtypes")
	private void mapToJson(HttpServletResponse response,Map map){
		String json = new Gson().toJson(map);
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 初始化抄表月份,抄表数据和抄表任务分配
	 */
	public void initUserRead(HttpServletRequest request) {
		SimpleDateFormat yearSdf=new SimpleDateFormat("yyyy");
		SimpleDateFormat monthSdf=new SimpleDateFormat("M");
    	Date date=new Date();
    	Calendar c=Calendar.getInstance();
    	c.setTime(date);
    	c.add(Calendar.MONTH, -1);
    	Date time = c.getTime();
		initYearMonth(request,date);
		initTask(Integer.parseInt(yearSdf.format(time)),Integer.parseInt(monthSdf.format(time)));
		initRead(Integer.parseInt(yearSdf.format(time)),Integer.parseInt(monthSdf.format(time)));
	}
	
	/**
	 * 初始化抄表数据，以及新用户的抄表数据
	 * @param year
	 * @param month
	 */
	private void initRead(int year,int month){
		rdReadMapper.initRead(year,month);
		rdReadMapper.initNewRead();
	}
	/**
	 * 初始化抄表任务分配，以及新的表册任务分配
	 * @param year
	 * @param month
	 */
	private void initTask(int year,int month){
		taskMapper.initTask(year,month);
		taskMapper.initTaskByNewVolume();
	}
	
	/**
	 * 初始化抄表年月
	 * @param request
	 */
	@SuppressWarnings("deprecation")
	private void initYearMonth(HttpServletRequest request,Date date){
		SimpleDateFormat yearSdf=new SimpleDateFormat("yyyy");
		SimpleDateFormat monthSdf=new SimpleDateFormat("M");
		RdYearmonth yearMonth=new RdYearmonth();
		Date endDate=new Date(yearSdf.format(date)+"/"+monthSdf.format(date)+"/30");
		yearMonth.setInitDate(date);
		yearMonth.setEndDate(endDate);
		yearMonth.setReadYear(Integer.parseInt(yearSdf.format(date)));
		yearMonth.setReadMonth(Integer.parseInt(monthSdf.format(date)));
		yearMonth.setIsCurrent(false);
		SyEmp emp=(SyEmp) request.getSession().getAttribute("empLogin");
		yearMonth.setInitEmpId(emp.getEmpId());
		yearMonthMapper.insertSelective(yearMonth);
		yearMonthMapper.upIsCurrent();
	}
	
	/**
	 * 查询本月是否初始化抄表，并写回结果
	 * @param response
	 * @throws IOException 
	 */
	public void isInit(HttpServletResponse response) throws IOException {
		int count=yearMonthMapper.isInit();
		if(count>0)
			response.getWriter().write("yes");
		else
			response.getWriter().write("no");
	}
	/**
	 * 根据表册ID查询未审核的用户并写到前端用户审核页面
	 * @param response
	 * @param volumeId
	 * @throws IOException 
	 */
	public void selReadByVolumeId(HttpServletResponse response, int volumeId) throws IOException {
		List<RdRead> list=rdReadMapper.selReadByVolumeId(volumeId);
		response.setContentType("text/json;charset=utf-8");
		String data=new Gson().toJson(list);
		response.getWriter().write(data);
	}
	
	/**
	 * 根据用户条件查询数据审核
	 * @param response
	 * @param user
	 * @throws IOException 
	 */
	public void selReadByUser(HttpServletResponse response, UsUser user) throws IOException {
		List<RdRead> list=rdReadMapper.selReadByUser(user);
		response.setContentType("text/json;charset=utf-8");
		String data=new Gson().toJson(list);
		response.getWriter().write(data);
	}
	
	/**
	 * 根据抄表Id进行抄表审核，修改审核状态，添加水费单，添加水费详单，添加用户历史详单，以及销帐处理
	 * @param request 
	 * @param response
	 * @param readId
	 */
	public void readAuditByReadId(HttpServletRequest request, HttpServletResponse response,int readId) {
		RdRead read=rdReadMapper.readAuditByReadId(readId);
		List<RdReadtypes> readTypes = read.getReadTypes();
		UsUser user = read.getUsUser();
		//产生水费单，详单，销账，修改用户余额
		initBill(readTypes,user,read);
		//修改抄表数据为已审核
		upReadAudit(request,read);
			
	}
	
	/**
	 * 修改审核状态，审核人，审核时间
	 * @param request 
	 * @param read
	 */
	private void upReadAudit(HttpServletRequest request, RdRead read) {
		SyEmp emp=(SyEmp)request.getSession().getAttribute("empLogin");
		read.setAudit(false);
		read.setAuditDate(new Date());
		read.setAuditEmpId(emp.getEmpId());
		rdReadMapper.updateByPrimaryKeySelective(read);
	}

	/**
	 * 根据分类用水产生水费单
	 * @param readTypes
	 * @param user
	 * @param read 
	 */
	private void initBill(List<RdReadtypes> readTypes, UsUser user, RdRead read) {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
		String yearMonth = sdf.format(date);
		PyUserhistory userHistory=new PyUserhistory();
		userHistory.setUserno(user.getUserNo());
		userHistory.setTypee(0);
		userHistory.setDatee(new Date());
		userHistory.setPrevalue(read.getPreValue());
		userHistory.setCurvalue(read.getCurValue());
		userHistory.setAmount(read.getAmount());
		PyBill bill=new PyBill();
		bill.setBillNo("SF"+user.getUserNo()+"-"+yearMonth);
		bill.setReadId(read.getId());
		bill.setUserNo(user.getUserNo());
		bill.setCreateDate(date);
		bill.setBalance(false);
		//生成水费单明细
		initBillDetail(bill,readTypes);
		//生成污水费
		initWSF(bill,read);
		//生成资源费
		initZYF(bill,read);
		//查出总水费
		bill.setBillMoney(new BigDecimal(billDetailMapper.selMoneyByBillNo(bill.getBillNo())));
		userHistory.setBillmoney(bill.getBillMoney());
		//判断是否为预存用户，进行销账
		initBalance(user,bill,userHistory);
		//生成水费单
		billMapper.insertSelective(bill);
		//生成用户历史详单
		historyMapper.insertSelective(userHistory);
		//修改用户money
		userMapper.updateByPrimaryKeySelective(user);
		//修改审核状态
		
	}
	
	/**
	 * 销账并添加记录
	 * @param user
	 * @param bill
	 * @param userHistory 
	 */
	private void initBalance(UsUser user, PyBill bill, PyUserhistory userHistory) {
		double userMoney=0;
		if(user.getUserMoney()!=null)
		{
			userMoney =user.getUserMoney().doubleValue();
		}
		double billMoney = bill.getBillMoney().doubleValue();
		double cha=userMoney-billMoney;
		if(userMoney>0){
			//查出水费单明细，根据水费明细插入消账明细
			List<PyBilldetail> details=billDetailMapper.selByBillNo(bill.getBillNo());
			
			PyBalance balance=new PyBalance();
			balance.setUserno(user.getUserNo());
			balance.setBalancedate(new Date());
			balance.setBillno(bill.getBillNo());
			balance.setBillrealmoney1(bill.getBillMoney());
			if(cha>=0)
			{
				bill.setRealMoney(bill.getBillMoney());
				bill.setBalance(true);
				bill.setBalanceDate(new Date());
				balance.setBalancemoney(bill.getBillMoney());
				balance.setBillrealmoney2(new BigDecimal(0));
			}else{
				bill.setRealMoney(new BigDecimal(userMoney));
				bill.setBalance(false);
				balance.setBalancemoney(user.getUserMoney());
				balance.setBillrealmoney2(new BigDecimal(cha*-1));
			}
			balanceMapper.insertSelective(balance);
			//插入销账详细明细
			initBalanceDetail(details,userMoney,balance);
			
		}else{
			bill.setBalance(false);
		}
		userHistory.setUsermoney(new BigDecimal(cha));
		user.setUserMoney(new BigDecimal(cha));

	}

	/**
	 * 产生销账详细明细
	 * @param details
	 * @param userMoney
	 * @param balance 
	 */
	private void initBalanceDetail(List<PyBilldetail> details, double userMoney, PyBalance balance) {
		for(PyBilldetail detail:details){
			double detailMoney=detail.getDetailMoney().doubleValue();
			userMoney-=detailMoney;
			PyBalancedetail balanceDetail=new PyBalancedetail();
			System.out.println(balance.getId()+"}}}}");
			balanceDetail.setParentId(balance.getId());
			balanceDetail.setUserNo(balance.getUserno());
			balanceDetail.setBalanceDate(new Date());
			balanceDetail.setBillNo(balance.getBillno());
			balanceDetail.setBillDetailId(detail.getId());
			balanceDetail.setCostTypeCode(detail.getCostTypeCode());
			balanceDetail.setDetailRealMoney1(detail.getDetailMoney());
			if(userMoney>0)
			{
				//修改消费明细为已结清
				detail.setBalance(true);
				detail.setRealMoney(detail.getDetailMoney());
				detail.setBalanceDate(new Date());
				balanceDetail.setBalanceMoney(detail.getDetailMoney());
				balanceDetail.setDetailRealMoney2(new BigDecimal(0));
				billDetailMapper.updateByPrimaryKeySelective(detail);
				//添加销账详细明细
				balanceDetailMapper.insertSelective(balanceDetail);
			}else{
				if(userMoney*-1<=detailMoney)
				{
					detail.setRealMoney(new BigDecimal(detailMoney-userMoney*-1));
					detail.setBalanceDate(new Date());
					balanceDetail.setBalanceMoney(new BigDecimal(detailMoney-userMoney*-1));
					balanceDetail.setDetailRealMoney2(new BigDecimal(userMoney*-1));
					billDetailMapper.updateByPrimaryKeySelective(detail);
					//添加销账详细明细
					balanceDetailMapper.insertSelective(balanceDetail);
				
				}else{
					break;
				}
			}
		}
		
	}

	/**
	 * 生成资源费
	 * @param bill
	 * @param read
	 */
	private void initZYF(PyBill bill, RdRead read) {
		PyBilldetail billDetail=new PyBilldetail();
		billDetail.setBillNo(bill.getBillNo());
		billDetail.setUserNo(bill.getUserNo());
		billDetail.setCostTypeCode("ZYF");
		billDetail.setAmount(read.getAmount());
		billDetailMapper.insertBillDetail(billDetail);
		
	}

	/**
	 * 生成污水费
	 * @param bill
	 * @param read 
	 */
	private void initWSF(PyBill bill, RdRead read) {
		PyBilldetail billDetail=new PyBilldetail();
		billDetail.setBillNo(bill.getBillNo());
		billDetail.setUserNo(bill.getUserNo());
		billDetail.setCostTypeCode("WSF");
		billDetail.setAmount(read.getAmount());
		billDetailMapper.insertBillDetail(billDetail);
		
	}

	/**
	 * 生成水费单明细
	 * @param readType 
	 * @param bill 
	 * @param readTypes 
	 */
	private void initBillDetail(PyBill bill, List<RdReadtypes> readTypes) {
		for(RdReadtypes readType:readTypes){
			PyBilldetail billDetail=new PyBilldetail();
			billDetail.setBillNo(bill.getBillNo());
			billDetail.setUserNo(bill.getUserNo());
			billDetail.setCostTypeCode(readType.getWaterTypeCode());
			billDetail.setAmount(readType.getAmount());
			billDetailMapper.insertBillDetail(billDetail);
			//是生活用水就加垃圾费
			if(readType.getWaterTypeCode().equalsIgnoreCase("SH"))
			{
				billDetail.setCostTypeCode("LJF");
				billDetailMapper.insertBillDetail(billDetail);
			}
		}
	}
	


	
	

	
}
