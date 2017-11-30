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

	/**��ѯ��Ʊ�����δʹ�þͲ�ѯ*/
	public Map<String, Object> selectInvoice(SfglDto dto,
			HttpServletRequest request) {

		Integer page = dto.getPage();
		Integer rows = dto.getRows();
		
		SyEmp empLogin = (SyEmp) request.getSession().getAttribute("empLogin");
		if(empLogin==null){//�û�û�е�½�鲻����Ʊ
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
	/**���ݱ�Ž����ѵ��Ĳ�ѯ�ŵ�����ȥ
	 * @throws IOException */
	public void selectInvoiceByPayNo(HttpServletRequest request,
			HttpServletResponse response, String payNo) throws IOException {
		PyPay pay = pyPayMapper.selectByPrimaryKey(payNo);
		if(pay==null)//û���û���½���ܲ�ѯ��Ʊ
			response.getOutputStream().print("fail");
		else
			response.getOutputStream().print("ok");
		
		selInvoice(request, pay);
	}
	/**���ݽɷѵ���ѯ���ľ�����Ϣ*/
	private void selInvoice(HttpServletRequest request, PyPay pay) {
		if(pay.getEmpId()!=null)
			pay.setEmp(syEmpMapper.selectByPrimaryKey(pay.getEmpId()));
		if(pay.getUserNo()!=null)
			pay.setUser(usUserMapper.selectByPrimaryKey(pay.getUserNo()));
		if(pay.getInvoice()!=null)
			pay.setIvInvoice(ivInvoiceMapper.selectByPrimaryKey(pay.getInvoice()));
		request.getSession().setAttribute("pay", pay);
	}
	
	/**��Ʊ����  ,1.�ж��·�Ʊ�ɲ�������,2:��ԭ��ƱʧЧ,3,�˵��Ÿ�Ϊ�·�Ʊ,4,�·�Ʊ���Ϊ����
	 * @throws IOException */
	public void changeInvoice(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ServletOutputStream out = response.getOutputStream();
		String invoiceNo=request.getParameter("invoice");
		String payNo=request.getParameter("payNo");
		String oldinvoice=request.getParameter("oldinvoice");
		 
		System.out.println("old: "+oldinvoice+" new:"+invoiceNo+" payno:"+payNo);
		if(testInvoice(out, invoiceNo)){//��Ʊ����
			failOldInvoice(oldinvoice);//��ԭ��ƱʧЧ
			updateToNewInvoice(invoiceNo, payNo);//��Ϊ�µķ�Ʊ
			updateNewInvoice(invoiceNo);//4,�·�Ʊ���Ϊ����
			
			out.print("ok");
			System.out.println("�޸ĳɹ�");
		 }
	}
	/**4,�·�Ʊ���Ϊ����*/
	private void updateNewInvoice(String invoiceNo) {
		IvInvoice newIv = ivInvoiceMapper.selectByPrimaryKey(invoiceNo);
		newIv.setUsed(true);
		newIv.setUseDate(new Date());
		ivInvoiceMapper.updateByPrimaryKey(newIv);
	}
	/**3,�˵��Ÿ�Ϊ�·�Ʊ*/
	private void updateToNewInvoice(String invoiceNo, String payNo) {
		PyPay pay = pyPayMapper.selectByPrimaryKey(payNo);
		pay.setInvoice(invoiceNo);
		pyPayMapper.updateByPrimaryKey(pay);
	}
	/**2:��ԭ��ƱʧЧ*/
	private void failOldInvoice(String oldinvoice) {
		IvInvoice oldIv = ivInvoiceMapper.selectByPrimaryKey(oldinvoice);
		 oldIv.setInvalid(true);
		 oldIv.setInvalidDate(new Date());
		 ivInvoiceMapper.updateByPrimaryKey(oldIv);
	}
	/**1.�ж��·�Ʊ�ɲ�������,*/
	private Boolean testInvoice(ServletOutputStream out, String invoiceNo)
			throws IOException {
		IvInvoice invoice = ivInvoiceMapper.selectByPrimaryKey(invoiceNo);
		if(invoice==null){// û�������Ʊ
			out.print("noinvoice"); 
			return false;
		}
		if(invoice.getUseDate()!= null){// ��Ʊ ��Ʊ�Ѿ�ʹ��
			out.print("usedinvoice");
			return false;
		}
		return true;
	}

	/**�����û��ı�� ��ҳ��ѯ���ѵ��˵�
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
	/**�û��ɷ�,�ж��û���û�е�½*/
	public void jiaofei(HttpServletRequest request,HttpServletResponse response) throws IOException {
 //�շ�ǰ�жϿɲ������շ�
		String userNo = request.getParameter("userNo");
		String fapiao = request.getParameter("fapiao");
		String jiaofei = request.getParameter("jiaofei");
		System.out.println("userNo: "+userNo+" fapiao:"+fapiao+" jiaofei:"+jiaofei);
		UsUser user = usUserMapper.selectByPrimaryKey(userNo);
		SyEmp empLogin = (SyEmp) request.getSession().getAttribute("empLogin");
		if(empLogin==null){  //����û�û�е�½   ʧ��
			response.getOutputStream().print("fail");
			return ;
		}
		//�����Ʊ������ ʧ��   failfp
		if(!isTrueFapiao(fapiao,empLogin.getEmpId()))
		{	response.getOutputStream().print("failfp");
			return;
		}
		
		
		
		//���Ѻ���û���Ǯʣ���Ǯ�����ı�
		  updUserMoney(jiaofei, user);
//��ʽ�շ�
		
		PyPay pyPay= insertPay(userNo, fapiao, jiaofei, empLogin);//1.���һ���ɷѼ�¼�� pyPay�� (���ѵ�)
		selInvoice(request,pyPay);
		
		updateIvInvoice(fapiao);					 //3.��Ʊ�Ѿ��ù� �ı䷢Ʊ״̬
		insertUserHistory(userNo, fapiao, jiaofei);	 //2.���һ����¼����,һ��ˮ��(ˮ�ѵ���������ȥ���)  �� py_userHistory ��ʷ��¼���� (���Ѽ�¼)
		
		//���˲������˺��Լ������û��Ľ��
		xiaoZhang(user, user.getUserMoney(), pyPay);
		 
		//
		
		response.getOutputStream().print("ok");
	}
	/***���˲���*/
	private void xiaoZhang( UsUser user,BigDecimal currUserMoney, PyPay pyPay) {
		List<PyBill> bills = SfglUtils.selPyBills(pyBillMapper, user.getUserNo());//�����û��ı�Ų�ѯ�������е�û�����ˮ�ѵ�  ����
		System.out.println("һ��Ƿ���˵�������bills.size()="+bills.size());
			for (PyBill pyBill : bills) {
				if(currUserMoney.compareTo(new BigDecimal("0"))==1){//�û�����Ǯ �ͽ�ȥ����   ˮˮ�ѵ��� ����
					//���뵽���˼�¼��
					
					RdRead read = rdReadMapper.selectByPrimaryKey(pyBill.getReadId());//����	�û���ʷ�굥
					PyUserhistory userHistory=new PyUserhistory();
					userHistory.setUserno(user.getUserNo());
					userHistory.setTypee(0);
					userHistory.setDatee(new Date());
					userHistory.setPrevalue(read.getPreValue());
					userHistory.setCurvalue(read.getCurValue());
					userHistory.setAmount(read.getAmount());
					userHistory.setOrderno(pyBill.getBillNo());//ˮ�ѵ�����ʷ��¼
					
					//����
					initBalance(user,pyBill,userHistory,pyPay,currUserMoney);
					
					
					//�����û���ʷ�굥
					pyUserhistoryMapper.insertSelective(userHistory);
					//�޸��û�money
					usUserMapper.updateByPrimaryKeySelective(user);
					
					
					
					}
				}
	}
	
	/**���˲���Ӽ�¼*/
	private void initBalance(UsUser user, PyBill bill,
			PyUserhistory userHistory,PyPay pyPay,BigDecimal currUserMoney) {
			
		if(currUserMoney.compareTo(new BigDecimal("0"))==1){//�û�����Ǯ �ͽ�ȥ����   ˮˮ�ѵ��� ����
			PyBalance balance=new PyBalance();
			balance.setUserno(user.getUserNo());
			balance.setBalancedate(new Date());
			balance.setBillno(bill.getBillNo());
			balance.setBillrealmoney1(bill.getBillMoney());
			balance.setBalancemoney(bill.getBillMoney()); //���˽��
			currUserMoney=currUserMoney.subtract(bill.getBillMoney());  //�ı� �û�ʣ���Ǯ��ֵ
			balance.setBillrealmoney2(currUserMoney);
			balance.setPayno(pyPay.getPayNo());
//			balance.setPayusemoney1(pyPay.getUseMoney());
//			balance.setPayusemoney2(pyPay.getUseMoney());
			pyBalanceMapper.insert(balance);
			if(bill.getBillMoney().compareTo(currUserMoney)==-1)	//���ڿ��Խ���
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
			
			//���ˮ�ѵ���ϸ������ˮ����ϸ����������ϸ
			List<PyBilldetail> details=pyBilldetailMapper.selByBillNo(bill.getBillNo());
			//����������ϸ��ϸ
			initBalanceDetail(details,currUserMoney,balance);
			
		}else{
			bill.setBalance(false);
		}
		userHistory.setUsermoney(currUserMoney);
		user.setUserMoney(currUserMoney);
		pyBillMapper.updateByPrimaryKeySelective(bill);
	}
	/***����������ϸ��ϸ*/
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
				//�޸�������ϸΪ�ѽ���
				detail.setBalance(true);
				detail.setRealMoney(detail.getDetailMoney());
				detail.setBalanceDate(new Date());
				balanceDetail.setBalanceMoney(detail.getDetailMoney());
				balanceDetail.setDetailRealMoney2(new BigDecimal(0));
				pyBilldetailMapper.updateByPrimaryKeySelective(detail);
				//���������ϸ��ϸ
				pyBalancedetailMapper.insertSelective(balanceDetail);
			}else{
				if(userMoney*-1<=detailMoney)
				{
					detail.setRealMoney(new BigDecimal(detailMoney-userMoney*-1));
					detail.setBalanceDate(new Date());
					balanceDetail.setBalanceMoney(new BigDecimal(detailMoney-userMoney*-1));
					balanceDetail.setDetailRealMoney2(new BigDecimal(userMoney*-1));
					pyBilldetailMapper.updateByPrimaryKeySelective(detail);
					//���������ϸ��ϸ
					pyBalancedetailMapper.insertSelective(balanceDetail);
				
				}else{
					break;
				}
			}
		}
		
		currUserMoney=new BigDecimal(userMoney);
	}
	/**
	 * ���Ѻ���û���Ǯʣ���Ǯ�����ı�
	 * @param jiaofei
	 * @param user
	 * @return ���Ѻ��û���Ǯ
	 */
	private BigDecimal updUserMoney(String jiaofei, UsUser user) {
		BigDecimal currUserMoney = user.getUserMoney().add(new BigDecimal(jiaofei));
		user.setUserMoney(currUserMoney);
		usUserMapper.updateByPrimaryKey(user);
		return currUserMoney;
	}

	/**��Ʊ�Ѿ��ù� �ı䷢Ʊʱ��*/
	private void updateIvInvoice(String fapiao) {
		IvInvoice invoice = ivInvoiceMapper.selectByPrimaryKey(fapiao);
		invoice.setUsed(true);
		invoice.setUseDate(new Date());
		ivInvoiceMapper.updateByPrimaryKey(invoice);
	}

	/**���һ���ɷѼ�¼��   pyPay��*/
	private PyPay insertPay(String userNo, String fapiao, String jiaofei,
			SyEmp empLogin) {
		PyPay pay =new PyPay();
		pay.setPayMoney(new BigDecimal(jiaofei));
		pay.setInvoice(fapiao);
		pay.setPayDate(new Date());
		pay.setUserNo(userNo);
		pay.setPayType("����");
		pay.setEmpId(empLogin.getEmpId());
		
		SimpleDateFormat fmt=new SimpleDateFormat("yyyyMM-dd");
		String dateStr = fmt.format(new Date());
		pay.setPayNo("JF"+fapiao+"-"+dateStr);
		  pyPayMapper.insert(pay); //�ɷ�
		return pay;
	}

	/**���һ����¼���ѵ�   py_userHistory ��ʷ��¼����*/
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
		
		BigDecimal userMoney = usUserMapper.selectByPrimaryKey(userNo).getUserMoney(); //�û����
		if(userMoney==null)
			userMoney=new BigDecimal("0");
		record.setUsermoney(userMoney.add(new BigDecimal(jiaofei)));
		
		pyUserhistoryMapper.insert(record);
	}
	/**�ж��ǲ�����ʵ�ķ�Ʊ*/
	private Boolean isTrueFapiao(String fapiao,Integer emp_id) {
		String whereStr =" and invoice_no = "+fapiao+" and emp_id = "+emp_id;
		List<IvInvoice> list = ivInvoiceMapper.selectInvoiceByWhere(whereStr, 0, 10);
		if(list.size()==0)
			return false;
		else
			return true;
	}
 
	/**��ѯ�û����飬1.��ѯ�û�,2����ѯ�û���ᣬ3.��ѯ�û�ˮ��*/
	public void selectUserAndDetails(String userNo, HttpServletRequest request) {
		if(userNo!=null){
			UsUser user = usUserMapper.selectByPrimaryKey(userNo);//1��ѯ�û�
			RdVolume volume =null;
			if(user==null)
				return;
			if(user.getVolumeId()!=null)//��ѯ�û����
				volume= rdVolumeMapper.selectByPrimaryKey(user.getVolumeId());
			UsMeter meter = null;
			SyMeterType meterType=null;
			if(user.getMeterId()!=null) //��ѯ�û�ˮ�������Ŀھ�
				meterType=syMeterTypeMapper.selectByPrimaryKey(user.getMeterId());
			
			UsMeterExample example =new UsMeterExample();
			example.createCriteria().andUserNoEqualTo(userNo);
			List<UsMeter> meters= usMeterMapper.selectByExample(example); //�û�ˮ��
			if(meters.size()>0)
				meter=meters.get(0);
		
			request.setAttribute("user", user);
			request.setAttribute("volume", volume);
			request.setAttribute("meter", meter);
			request.setAttribute("meterType", meterType);
			
			//ˮ����Ϣ
			
			String formula = user.getFormula();
			if(formula != null){
				String[] mula = SfglUtils.toSplit(formula);
			}
			
			//������Ϣ
			String whereStr =" and user_no = '"+userNo+"'";
			List<RdRead> reads= rdReadMapper.selectByWhereStrPage(whereStr,0,7);
			request.setAttribute("reads", reads);
			//ˮ�ѵ���¼
			List<PyBill> bills=pyBillMapper.selectByWhereStrPage(whereStr,0,7);
			request.setAttribute("bills", bills);
			//�շѵ���¼
			List<PyPay> pays = pyPayMapper.selPayHistoryWhereStrPage(whereStr, 0, 7);
			request.setAttribute("pays", pays);
			
			
			
		}	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**�����շ�   
	 * 1.�ֱ��շ�
	 * 2.
	 * @throws IOException */
	public String pays(HttpServletRequest request) throws IOException {
		String unos = request.getParameter("unos");
		String paymones = request.getParameter("paymones");
		String moneys = request.getParameter("moneys");
		String fapiao = request.getParameter("fapiao");
		
		
		SyEmp empLogin = (SyEmp) request.getSession().getAttribute("empLogin");
		if(empLogin==null)  //����û�û�е�½   ʧ��
			return "fail";
		//�����Ʊ������ ʧ��   failfp
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
			//���һ����¼�����ѵ�
			PyPay pay = insertPay(nos[i], cfapiao, pmones[i], empLogin);
			//���һ����¼���ɷ���ʷ��¼
			insertUserHistory( nos[i], cfapiao, pmones[i]);
			//������û�����
			UsUser user = usUserMapper.selectByPrimaryKey(nos[i]);
			if(user.getUserMoney()==null)
				user.setUserMoney(new BigDecimal("0"));
			xiaoZhang(user,user.getUserMoney(), pay);
			
		}
		// ����Ʊ��Ϊ����
		updateIvInvoice(fapiao);
		return "ok";
	}
	
	/**
	 * �շ��������  
	 * @param dto ������ѡ������
	 * @return ���ص�jsp ҳ�������
	 */
	public Map<String, Object> reportPay(SfglDto dto) {
		System.out.println(dto);
		
		Integer rows = dto.getRows();
		Integer page = dto.getPage();
		String whereStr=SfglUtils.converPayWhere(dto);
		System.out.println("whereStr:" +whereStr);
		List<PyPay> pays = pyPayMapper.selPayHistoryWhereStrPage(whereStr, (page-1)*rows, rows);
		Double moneys=pyPayMapper.selPayMoneysWhereStr(whereStr);
		for (int i = 0; i < pays.size(); i++) {		//������ý��Ϊnull ���趨Ϊ0.00
			if(pays.get(i).getUseMoney()==null)
				pays.get(i).setUseMoney(new BigDecimal(0.00));
		}
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("emps", syEmpMapper.selectSyEmp(13)); //�����շ���Ա
		map.put("pays", pays); 						  //��ǰҳ����շ������������
		map.put("moneys", moneys==null?0.0:moneys);   //��ǰҳ����շ������������
		
		Integer total = pyPayMapper.countByWhere(whereStr); //
		total=total==null?1:total;
		int pageCount = (int) Math.ceil(total / (rows * 1.0));
		dto.setPage(page);
		dto.setPageCount(pageCount);
		map.put("dto", dto);   //��ǰҳ������ݷŻ����ڻ������ҳ
		
		return map;
	}
	
	
	
/**��Ʊ��������*/
	public void invoiceReprint(HttpServletRequest request, ModelMap map,SfglDto dto) {
		List<IvInvoice> invoices = ivInvoiceMapper.selectByExample(null);
		String whereStr=converIvPayWhere(dto);
		List<PyPay> pays=pyPayMapper.selPayIvUsWhereStrPage(whereStr,null,null);
		System.out.println("whereStr:"+whereStr);
		map.put("pays", pays);
		map.put("invoices", invoices);
		map.put("dto", dto);
		map.put("emps", syEmpMapper.selectSyEmp(13));//���е��շ���Ա
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
	/**���ݷ�Ʊ�������ҷ�Ʊ*/
	public IvInvoice selectInvoiceByNo(String invoiceNo) {
		IvInvoice invoice = ivInvoiceMapper.selectByPrimaryKey(invoiceNo);
		if(invoice.getEmpId()!=null)
			invoice.setEmp(syEmpMapper.selectByPrimaryKey(invoice.getEmpId()));
		return invoice;
	}
	/**�÷�Ʊ����  */
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