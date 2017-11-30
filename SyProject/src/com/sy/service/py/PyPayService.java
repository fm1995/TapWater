package com.sy.service.py;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.sy.entity.IvInvoice;
import com.sy.entity.PyBalance;
import com.sy.entity.PyBill;
import com.sy.entity.PyBillExample;
import com.sy.entity.PyBillExample.Criteria;
import com.sy.entity.PyBalancedetail;
import com.sy.entity.PyBilldetail;
import com.sy.entity.PyPay;
import com.sy.entity.PyUserhistory;
import com.sy.entity.RdRead;
import com.sy.entity.RdVolume;
import com.sy.entity.SyEmp;
import com.sy.entity.SyMeterType;
import com.sy.entity.UsMeter;
import com.sy.entity.UsMeterExample;
import com.sy.entity.UsUser;
import com.sy.projectUtils.SfglDto;
import com.sy.projectUtils.SfglUtils;
import com.sy.service.rd.ReadService;

@Service
public class PyPayService extends PyParent{

	/**查询发票如果是未使用就查询*/
	public Map<String, Object> selectInvoice(SfglDto dto,
			HttpServletRequest request) {

		Integer page = dto.getPage();
		Integer rows = dto.getRows();
		
		SyEmp empLogin = (SyEmp) request.getSession().getAttribute("empLogin");
		if(empLogin==null){//用户没有登陆查不到发票
			return null;
		}
		Integer empId = empLogin.getEmpId();
		String whereStr=" and emp_id = "+empId +" and use_date is null ";
		List<IvInvoice> invoices=ivInvoiceMapper.selectInvoiceByWhere(whereStr,(page-1)*rows,rows);
		Integer total = ivInvoiceMapper.selectInvoiceCountByWhere(whereStr,(page-1)*rows,rows);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("invoices", invoices);
		map.put("page", page);
		map.put("rows", rows);
		total=total==null?0:total;
		int pageCount = (int) Math.ceil(total / (rows * 1.0));
		map.put("pageCount", pageCount);
		if(dto.getPageCount()!=null)
			map.put("pageCount", dto.getPageCount());
		System.out.println("invoices.size() :  " + invoices.size());
		
		
		return map;
		
	}
	/**根据编号讲交费单的查询放到域中去
	 * @throws IOException */
	public void selectInvoiceByPayNo(HttpServletRequest request,
			HttpServletResponse response, String payNo) throws IOException {
		PyPay pay = pyPayMapper.selectByPrimaryKey(payNo);
		if(pay==null)//没有用户登陆不能查询发票
			response.getOutputStream().print("fail");
		else
			response.getOutputStream().print("ok");
		
		selInvoice(request, pay);
	}
	/**根据缴费单查询它的具体信息*/
	private void selInvoice(HttpServletRequest request, PyPay pay) {
		if(pay.getEmpId()!=null)
			pay.setEmp(syEmpMapper.selectByPrimaryKey(pay.getEmpId()));
		if(pay.getUserNo()!=null)
			pay.setUser(usUserMapper.selectByPrimaryKey(pay.getUserNo()));
		if(pay.getInvoice()!=null)
			pay.setIvInvoice(ivInvoiceMapper.selectByPrimaryKey(pay.getInvoice()));
		request.getSession().setAttribute("pay", pay);
	}
	
	/**发票补开  ,1.判断新发票可不可以用,2:让原发票失效,3,账单号改为新发票,4,新发票标记为以用
	 * @throws IOException */
	public void changeInvoice(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ServletOutputStream out = response.getOutputStream();
		String invoiceNo=request.getParameter("invoice");
		String payNo=request.getParameter("payNo");
		String oldinvoice=request.getParameter("oldinvoice");
		 
		System.out.println("old: "+oldinvoice+" new:"+invoiceNo+" payno:"+payNo);
		if(testInvoice(out, invoiceNo)){//发票可用
			failOldInvoice(oldinvoice);//设原发票失效
			updateToNewInvoice(invoiceNo, payNo);//改为新的发票
			updateNewInvoice(invoiceNo);//4,新发票标记为以用
			
			out.print("ok");
			System.out.println("修改成功");
		 }
	}
	/**4,新发票标记为以用*/
	private void updateNewInvoice(String invoiceNo) {
		IvInvoice newIv = ivInvoiceMapper.selectByPrimaryKey(invoiceNo);
		newIv.setUsed(true);
		newIv.setUseDate(new Date());
		ivInvoiceMapper.updateByPrimaryKey(newIv);
	}
	/**3,账单号改为新发票*/
	private void updateToNewInvoice(String invoiceNo, String payNo) {
		PyPay pay = pyPayMapper.selectByPrimaryKey(payNo);
		pay.setInvoice(invoiceNo);
		pyPayMapper.updateByPrimaryKey(pay);
	}
	/**2:让原发票失效*/
	private void failOldInvoice(String oldinvoice) {
		IvInvoice oldIv = ivInvoiceMapper.selectByPrimaryKey(oldinvoice);
		 oldIv.setInvalid(true);
		 oldIv.setInvalidDate(new Date());
		 ivInvoiceMapper.updateByPrimaryKey(oldIv);
	}
	/**1.判断新发票可不可以用,*/
	private Boolean testInvoice(ServletOutputStream out, String invoiceNo)
			throws IOException {
		IvInvoice invoice = ivInvoiceMapper.selectByPrimaryKey(invoiceNo);
		if(invoice==null){// 没有这个发票
			out.print("noinvoice"); 
			return false;
		}
		if(invoice.getUseDate()!= null){// 发票 发票已经使用
			out.print("usedinvoice");
			return false;
		}
		return true;
	}

	/**根据用户的编号 分页查询交费的账单
	 * @throws IOException */
	public void selectPaysPageByUserNo(HttpServletRequest request,
			HttpServletResponse response, SfglDto dto, String userNo) throws IOException {
		if(userNo==null)
			return ;
		String whereStr = " and user_no = '"+userNo+"'";
		List<PyPay> pays = pyPayMapper.selectByWhereStrPage(whereStr, (dto.getPage()-1)*dto.getRows(), dto.getRows());
		StringBuffer sb=new StringBuffer();
		for (PyPay pay : pays) {
			sb.append("<tr>");
			System.out.println(pay);
			sb.append("<td></td>");
			
			sb.append("</tr>");
		}
		System.out.println(sb.toString());
		response.getOutputStream().print(sb.toString());
	}
	/**用户缴费,判断用户有没有登陆*/
	public void jiaofei(HttpServletRequest request,HttpServletResponse response) throws IOException {
 //收费前判断可不可以收费
		String userNo = request.getParameter("userNo");
		String fapiao = request.getParameter("fapiao");
		String jiaofei = request.getParameter("jiaofei");
		System.out.println("userNo: "+userNo+" fapiao:"+fapiao+" jiaofei:"+jiaofei);
		UsUser user = usUserMapper.selectByPrimaryKey(userNo);
		SyEmp empLogin = (SyEmp) request.getSession().getAttribute("empLogin");
		if(empLogin==null){  //如果用户没有登陆   失败
			response.getOutputStream().print("fail");
			return ;
		}
		//如果发票不可用 失败   failfp
		if(!isTrueFapiao(fapiao,empLogin.getEmpId()))
		{	response.getOutputStream().print("failfp");
			return;
		}
		
		
		
		//交费后给用户的钱剩余的钱发生改变
		  updUserMoney(jiaofei, user);
//正式收费
		
		PyPay pyPay= insertPay(userNo, fapiao, jiaofei, empLogin);//1.添加一条缴费记录到 pyPay表 (交费单)
		selInvoice(request,pyPay);
		
		updateIvInvoice(fapiao);					 //3.发票已经用过 改变发票状态
		insertUserHistory(userNo, fapiao, jiaofei);	 //2.添加一条记录交费,一条水费(水费到销账里面去添加)  到 py_userHistory 历史记录表中 (交费记录)
		
		//销账操作销账后自己更新用户的金额
		xiaoZhang(user, user.getUserMoney(), pyPay);
		 
		//
		
		response.getOutputStream().print("ok");
	}
	/***销账操作*/
	private void xiaoZhang( UsUser user,BigDecimal currUserMoney, PyPay pyPay) {
		List<PyBill> bills = SfglUtils.selPyBills(pyBillMapper, user.getUserNo());//根据用户的编号查询出他所有的没结清的水费单  销账
		System.out.println("一共欠的账单数量：bills.size()="+bills.size());
			for (PyBill pyBill : bills) {
				if(currUserMoney.compareTo(new BigDecimal("0"))==1){//用户还有钱 就进去销账   水水费单就 销账
					//插入到销账记录中
					
					RdRead read = rdReadMapper.selectByPrimaryKey(pyBill.getReadId());//生成	用户历史详单
					PyUserhistory userHistory=new PyUserhistory();
					userHistory.setUserno(user.getUserNo());
					userHistory.setTypee(0);
					userHistory.setDatee(new Date());
					userHistory.setPrevalue(read.getPreValue());
					userHistory.setCurvalue(read.getCurValue());
					userHistory.setAmount(read.getAmount());
					userHistory.setOrderno(pyBill.getBillNo());//水费单到历史纪录
					
					//销账
					initBalance(user,pyBill,userHistory,pyPay,currUserMoney);
					
					
					//生成用户历史详单
					pyUserhistoryMapper.insertSelective(userHistory);
					//修改用户money
					usUserMapper.updateByPrimaryKeySelective(user);
					
					
					
					}
				}
	}
	
	/**销账并添加记录*/
	private void initBalance(UsUser user, PyBill bill,
			PyUserhistory userHistory,PyPay pyPay,BigDecimal currUserMoney) {
			
		if(currUserMoney.compareTo(new BigDecimal("0"))==1){//用户还有钱 就进去销账   水水费单就 销账
			PyBalance balance=new PyBalance();
			balance.setUserno(user.getUserNo());
			balance.setBalancedate(new Date());
			balance.setBillno(bill.getBillNo());
			balance.setBillrealmoney1(bill.getBillMoney());
			balance.setBalancemoney(bill.getBillMoney()); //销账金额
			currUserMoney=currUserMoney.subtract(bill.getBillMoney());  //改变 用户剩余的钱的值
			balance.setBillrealmoney2(currUserMoney);
			balance.setPayno(pyPay.getPayNo());
//			balance.setPayusemoney1(pyPay.getUseMoney());
//			balance.setPayusemoney2(pyPay.getUseMoney());
			pyBalanceMapper.insert(balance);
			if(bill.getBillMoney().compareTo(currUserMoney)==-1)	//大于可以交完
			{
				bill.setRealMoney(bill.getBillMoney());
				bill.setBalance(true);
				bill.setBalanceDate(new Date());
				balance.setBalancemoney(bill.getBillMoney());
				balance.setBillrealmoney2(new BigDecimal(0));
			}else{
				bill.setRealMoney(currUserMoney);
				bill.setBalance(false);
				balance.setBalancemoney(user.getUserMoney());
				balance.setBillrealmoney2(currUserMoney.multiply(new BigDecimal("-1")));
			}
			pyBalanceMapper.insertSelective(balance);
			
			//查出水费单明细，根据水费明细插入消账明细
			List<PyBilldetail> details=pyBilldetailMapper.selByBillNo(bill.getBillNo());
			//插入销账详细明细
			initBalanceDetail(details,currUserMoney,balance);
			
		}else{
			bill.setBalance(false);
		}
		userHistory.setUsermoney(currUserMoney);
		user.setUserMoney(currUserMoney);
		pyBillMapper.updateByPrimaryKeySelective(bill);
	}
	/***产生销账详细明细*/
	private void initBalanceDetail(List<PyBilldetail> details,
			BigDecimal currUserMoney, PyBalance balance) {
		Double userMoney=currUserMoney.doubleValue();
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
				pyBilldetailMapper.updateByPrimaryKeySelective(detail);
				//添加销账详细明细
				pyBalancedetailMapper.insertSelective(balanceDetail);
			}else{
				if(userMoney*-1<=detailMoney)
				{
					detail.setRealMoney(new BigDecimal(detailMoney-userMoney*-1));
					detail.setBalanceDate(new Date());
					balanceDetail.setBalanceMoney(new BigDecimal(detailMoney-userMoney*-1));
					balanceDetail.setDetailRealMoney2(new BigDecimal(userMoney*-1));
					pyBilldetailMapper.updateByPrimaryKeySelective(detail);
					//添加销账详细明细
					pyBalancedetailMapper.insertSelective(balanceDetail);
				
				}else{
					break;
				}
			}
		}
		
		currUserMoney=new BigDecimal(userMoney);
	}
	/**
	 * 交费后给用户的钱剩余的钱发生改变
	 * @param jiaofei
	 * @param user
	 * @return 交费后用户的钱
	 */
	private BigDecimal updUserMoney(String jiaofei, UsUser user) {
		BigDecimal currUserMoney = user.getUserMoney().add(new BigDecimal(jiaofei));
		user.setUserMoney(currUserMoney);
		usUserMapper.updateByPrimaryKey(user);
		return currUserMoney;
	}

	/**发票已经用过 改变发票时间*/
	private void updateIvInvoice(String fapiao) {
		IvInvoice invoice = ivInvoiceMapper.selectByPrimaryKey(fapiao);
		invoice.setUsed(true);
		invoice.setUseDate(new Date());
		ivInvoiceMapper.updateByPrimaryKey(invoice);
	}

	/**添加一条缴费记录到   pyPay表*/
	private PyPay insertPay(String userNo, String fapiao, String jiaofei,
			SyEmp empLogin) {
		PyPay pay =new PyPay();
		pay.setPayMoney(new BigDecimal(jiaofei));
		pay.setInvoice(fapiao);
		pay.setPayDate(new Date());
		pay.setUserNo(userNo);
		pay.setPayType("坐收");
		pay.setEmpId(empLogin.getEmpId());
		
		SimpleDateFormat fmt=new SimpleDateFormat("yyyyMM-dd");
		String dateStr = fmt.format(new Date());
		pay.setPayNo("JF"+fapiao+"-"+dateStr);
		  pyPayMapper.insert(pay); //缴费
		return pay;
	}

	/**添加一条记录交费到   py_userHistory 历史记录表中*/
	private void insertUserHistory( String userNo,
			String fapiao, String jiaofei) throws IOException {
		PyUserhistory record =new PyUserhistory();
		record.setUserno(userNo);
		SimpleDateFormat fmt=new SimpleDateFormat("yyyyMM-dd");
		String dateStr = fmt.format(new Date());
		record.setOrderno("JF"+fapiao+"-"+dateStr);
		record.setTypee(1);
		record.setDatee(new Date());
		record.setPaymoney(new BigDecimal(jiaofei));
		
		BigDecimal userMoney = usUserMapper.selectByPrimaryKey(userNo).getUserMoney(); //用户余额
		if(userMoney==null)
			userMoney=new BigDecimal("0");
		record.setUsermoney(userMoney.add(new BigDecimal(jiaofei)));
		
		pyUserhistoryMapper.insert(record);
	}
	/**判断是不是真实的发票*/
	private Boolean isTrueFapiao(String fapiao,Integer emp_id) {
		String whereStr =" and invoice_no = "+fapiao+" and emp_id = "+emp_id;
		List<IvInvoice> list = ivInvoiceMapper.selectInvoiceByWhere(whereStr, 0, 10);
		if(list.size()==0)
			return false;
		else
			return true;
	}
 
	/**查询用户详情，1.查询用户,2，查询用户表册，3.查询用户水表*/
	public void selectUserAndDetails(String userNo, HttpServletRequest request) {
		if(userNo!=null){
			UsUser user = usUserMapper.selectByPrimaryKey(userNo);//1查询用户
			RdVolume volume =null;
			if(user==null)
				return;
			if(user.getVolumeId()!=null)//查询用户表册
				volume= rdVolumeMapper.selectByPrimaryKey(user.getVolumeId());
			UsMeter meter = null;
			SyMeterType meterType=null;
			if(user.getMeterId()!=null) //查询用户水表所属的口径
				meterType=syMeterTypeMapper.selectByPrimaryKey(user.getMeterId());
			
			UsMeterExample example =new UsMeterExample();
			example.createCriteria().andUserNoEqualTo(userNo);
			List<UsMeter> meters= usMeterMapper.selectByExample(example); //用户水表
			if(meters.size()>0)
				meter=meters.get(0);
		
			request.setAttribute("user", user);
			request.setAttribute("volume", volume);
			request.setAttribute("meter", meter);
			request.setAttribute("meterType", meterType);
			
			//水价信息
			
			String formula = user.getFormula();
			if(formula != null){
				String[] mula = SfglUtils.toSplit(formula);
			}
			
			//抄表信息
			String whereStr =" and user_no = '"+userNo+"'";
			List<RdRead> reads= rdReadMapper.selectByWhereStrPage(whereStr,0,7);
			request.setAttribute("reads", reads);
			//水费单记录
			List<PyBill> bills=pyBillMapper.selectByWhereStrPage(whereStr,0,7);
			request.setAttribute("bills", bills);
			//收费单记录
			List<PyPay> pays = pyPayMapper.selPayHistoryWhereStrPage(whereStr, 0, 7);
			request.setAttribute("pays", pays);
			
			
			
		}	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**批量收费   
	 * 1.分别收费
	 * 2.
	 * @throws IOException */
	public String pays(HttpServletRequest request) throws IOException {
		String unos = request.getParameter("unos");
		String paymones = request.getParameter("paymones");
		String moneys = request.getParameter("moneys");
		String fapiao = request.getParameter("fapiao");
		
		
		SyEmp empLogin = (SyEmp) request.getSession().getAttribute("empLogin");
		if(empLogin==null)  //如果用户没有登陆   失败
			return "fail";
		//如果发票不可用 失败   failfp
		if(!isTrueFapiao(fapiao,empLogin.getEmpId()))
			return "failfp";
		
		
		System.out.println("unos:"+unos);
		System.out.println("paymones:"+paymones);
		System.out.println("moneys:"+moneys);
		System.out.println("fapiao:"+fapiao);
		
		String []nos=SfglUtils.toConvertString(unos);
		String[] pmones = SfglUtils.toConvertString(paymones);
		for (int i = 0; i < nos.length; i++) {
			String cfapiao=fapiao+"-0"+i;
			//添加一条记录到交费单
			PyPay pay = insertPay(nos[i], cfapiao, pmones[i], empLogin);
			//添加一条记录到缴费历史记录
			insertUserHistory( nos[i], cfapiao, pmones[i]);
			//给这个用户销账
			UsUser user = usUserMapper.selectByPrimaryKey(nos[i]);
			if(user.getUserMoney()==null)
				user.setUserMoney(new BigDecimal("0"));
			xiaoZhang(user,user.getUserMoney(), pay);
			
		}
		// 将发票改为已用
		updateIvInvoice(fapiao);
		return "ok";
	}
	
	/**
	 * 收费情况报表  
	 * @param dto 条件赛选的数据
	 * @return 返回到jsp 页面的数据
	 */
	public Map<String, Object> reportPay(SfglDto dto) {
		System.out.println(dto);
		
		Integer rows = dto.getRows();
		Integer page = dto.getPage();
		String whereStr=SfglUtils.converPayWhere(dto);
		System.out.println("whereStr:" +whereStr);
		List<PyPay> pays = pyPayMapper.selPayHistoryWhereStrPage(whereStr, (page-1)*rows, rows);
		Double moneys=pyPayMapper.selPayMoneysWhereStr(whereStr);
		for (int i = 0; i < pays.size(); i++) {		//如果已用金额为null 就设定为0.00
			if(pays.get(i).getUseMoney()==null)
				pays.get(i).setUseMoney(new BigDecimal(0.00));
		}
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("emps", syEmpMapper.selectSyEmp(13)); //所有收费人员
		map.put("pays", pays); 						  //当前页面的收费情况报表数据
		map.put("moneys", moneys==null?0.0:moneys);   //当前页面的收费情况报表数据
		
		Integer total = pyPayMapper.countByWhere(whereStr); //
		total=total==null?1:total;
		int pageCount = (int) Math.ceil(total / (rows * 1.0));
		dto.setPage(page);
		dto.setPageCount(pageCount);
		map.put("dto", dto);   //当前页面的数据放回用于回显与分页
		
		return map;
	}
	
	
	
/**发票补开作废*/
	public void invoiceReprint(HttpServletRequest request, ModelMap map,SfglDto dto) {
		List<IvInvoice> invoices = ivInvoiceMapper.selectByExample(null);
		String whereStr=converIvPayWhere(dto);
		List<PyPay> pays=pyPayMapper.selPayIvUsWhereStrPage(whereStr,null,null);
		System.out.println("whereStr:"+whereStr);
		map.put("pays", pays);
		map.put("invoices", invoices);
		map.put("dto", dto);
		map.put("emps", syEmpMapper.selectSyEmp(13));//所有的收费人员
	}
	/**
	 * 
	 * @param dto
	 * @return
	 */
	private String converIvPayWhere(SfglDto dto) {
		if(dto==null)
			return null;
		StringBuffer sb=new StringBuffer("");
		
		if(dto.getEmpId()!=null)
			sb.append(" and py.emp_id = "+dto.getEmpId());
		if(dto.getInvoiceNo()!=null && !"".equals(dto.getInvoiceNo()))
			sb.append(" and iv.invoice_no like '%"+dto.getInvoiceNo()+"%'");
		if(dto.getDate()!=null && !"".equals(dto.getDate()))
			sb.append("  and to_days(iv.use_date) = to_days('"+dto.getDate()+"') ");
		return sb.toString();
	}
	/**根据发票的主键找发票*/
	public IvInvoice selectInvoiceByNo(String invoiceNo) {
		IvInvoice invoice = ivInvoiceMapper.selectByPrimaryKey(invoiceNo);
		if(invoice.getEmpId()!=null)
			invoice.setEmp(syEmpMapper.selectByPrimaryKey(invoice.getEmpId()));
		return invoice;
	}
	/**让发票作废  */
	public void invoiceDisable(String invoiceNo) {
		IvInvoice invoice = ivInvoiceMapper.selectByPrimaryKey(invoiceNo);
		Date date = new Date();
		invoice.setUsed(true);
		invoice.setUseDate(date);
		invoice.setInvalid(true);
		invoice.setInvalidDate(date);
		ivInvoiceMapper.updateByPrimaryKey(invoice);
	}
	
	
	
}