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
 * ��������ҵ�����
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
	 * ������ݺ��·ݲ�ѯ�����������д��ǰ��
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
	 * ����������ҳ��ѯ0��ˮ�û���д��ǰ��
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
	 * ����������ѯ0��λ��ˮ���û��ܺ�
	 * @param term
	 * @param read
	 * @return
	 */
	private int selReadByTermUserCount(TermUtil term, RdRead read) {
		int userCount=rdReadMapper.selReadByTermUserCount(term,read);
		return userCount;
	}

	/**
	 * ����������ҳ��ѯ0��ˮ�û�����ҳ��
	 * @param request
	 * @param term
	 * @param read
	 */
	public int selReadByTermCount(TermUtil term,RdRead read){
		int count=rdReadMapper.selReadByTermCount(term,read);
		return count;
	}
	
	/**
	 * ����ÿ���³�ʼ���û�������������ǰ��
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
	 * ��mapת��Ϊjson��д��ǰ��
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
	 * ��ʼ�������·�,�������ݺͳ����������
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
	 * ��ʼ���������ݣ��Լ����û��ĳ�������
	 * @param year
	 * @param month
	 */
	private void initRead(int year,int month){
		rdReadMapper.initRead(year,month);
		rdReadMapper.initNewRead();
	}
	/**
	 * ��ʼ������������䣬�Լ��µı���������
	 * @param year
	 * @param month
	 */
	private void initTask(int year,int month){
		taskMapper.initTask(year,month);
		taskMapper.initTaskByNewVolume();
	}
	
	/**
	 * ��ʼ����������
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
	 * ��ѯ�����Ƿ��ʼ��������д�ؽ��
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
	 * ���ݱ��ID��ѯδ��˵��û���д��ǰ���û����ҳ��
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
	 * �����û�������ѯ�������
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
	 * ���ݳ���Id���г�����ˣ��޸����״̬�����ˮ�ѵ������ˮ���굥������û���ʷ�굥���Լ����ʴ���
	 * @param request 
	 * @param response
	 * @param readId
	 */
	public void readAuditByReadId(HttpServletRequest request, HttpServletResponse response,int readId) {
		RdRead read=rdReadMapper.readAuditByReadId(readId);
		List<RdReadtypes> readTypes = read.getReadTypes();
		UsUser user = read.getUsUser();
		//����ˮ�ѵ����굥�����ˣ��޸��û����
		initBill(readTypes,user,read);
		//�޸ĳ�������Ϊ�����
		upReadAudit(request,read);
			
	}
	
	/**
	 * �޸����״̬������ˣ����ʱ��
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
	 * ���ݷ�����ˮ����ˮ�ѵ�
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
		//����ˮ�ѵ���ϸ
		initBillDetail(bill,readTypes);
		//������ˮ��
		initWSF(bill,read);
		//������Դ��
		initZYF(bill,read);
		//�����ˮ��
		bill.setBillMoney(new BigDecimal(billDetailMapper.selMoneyByBillNo(bill.getBillNo())));
		userHistory.setBillmoney(bill.getBillMoney());
		//�ж��Ƿ�ΪԤ���û�����������
		initBalance(user,bill,userHistory);
		//����ˮ�ѵ�
		billMapper.insertSelective(bill);
		//�����û���ʷ�굥
		historyMapper.insertSelective(userHistory);
		//�޸��û�money
		userMapper.updateByPrimaryKeySelective(user);
		//�޸����״̬
		
	}
	
	/**
	 * ���˲���Ӽ�¼
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
			//���ˮ�ѵ���ϸ������ˮ����ϸ����������ϸ
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
			//����������ϸ��ϸ
			initBalanceDetail(details,userMoney,balance);
			
		}else{
			bill.setBalance(false);
		}
		userHistory.setUsermoney(new BigDecimal(cha));
		user.setUserMoney(new BigDecimal(cha));

	}

	/**
	 * ����������ϸ��ϸ
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
				//�޸�������ϸΪ�ѽ���
				detail.setBalance(true);
				detail.setRealMoney(detail.getDetailMoney());
				detail.setBalanceDate(new Date());
				balanceDetail.setBalanceMoney(detail.getDetailMoney());
				balanceDetail.setDetailRealMoney2(new BigDecimal(0));
				billDetailMapper.updateByPrimaryKeySelective(detail);
				//���������ϸ��ϸ
				balanceDetailMapper.insertSelective(balanceDetail);
			}else{
				if(userMoney*-1<=detailMoney)
				{
					detail.setRealMoney(new BigDecimal(detailMoney-userMoney*-1));
					detail.setBalanceDate(new Date());
					balanceDetail.setBalanceMoney(new BigDecimal(detailMoney-userMoney*-1));
					balanceDetail.setDetailRealMoney2(new BigDecimal(userMoney*-1));
					billDetailMapper.updateByPrimaryKeySelective(detail);
					//���������ϸ��ϸ
					balanceDetailMapper.insertSelective(balanceDetail);
				
				}else{
					break;
				}
			}
		}
		
	}

	/**
	 * ������Դ��
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
	 * ������ˮ��
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
	 * ����ˮ�ѵ���ϸ
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
			//��������ˮ�ͼ�������
			if(readType.getWaterTypeCode().equalsIgnoreCase("SH"))
			{
				billDetail.setCostTypeCode("LJF");
				billDetailMapper.insertBillDetail(billDetail);
			}
		}
	}
	


	
	

	
}
