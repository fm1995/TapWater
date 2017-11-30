package com.sy.service.py;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ReadManager;
import org.springframework.stereotype.Service;

import com.sy.entity.PyBill;
import com.sy.entity.PyBillExample;
import com.sy.entity.PyBilldetail;
import com.sy.entity.PyBilldetailExample;
import com.sy.entity.PyPay;
import com.sy.entity.PyUserhistory;
import com.sy.entity.PyUserhistoryExample;
import com.sy.entity.RdRead;
import com.sy.entity.RdVolume;
import com.sy.entity.SyArea;
import com.sy.entity.UsUser;
import com.sy.entity.PyBillExample.Criteria;
import com.sy.projectUtils.SfglDto;
import com.sy.projectUtils.SfglUtils;
import com.sy.projectUtils.ValueVerify;

@Service
public class PyBillService extends PyParent {

	// ����Ӧ�����
	public Double sumBillMoney() {
		return ValueVerify.isnull(double.class,
				pyBillMapper.sumMoney("bill_money", null));
	}

	// ����ʵ�����
	public Double sumRealMoney() {
		return ValueVerify.isnull(double.class,
				pyBillMapper.sumMoney("real_money", 1));
	}

	// ���·ݷ��飬����ѯ��ǰ�·�Ӧ������ʵ������ܺ� ,��List<PyBill>���ϱ���
	public List<PyBill> sumBillReal() {
		List<PyBill> list = pyBillMapper.sumBillReal();
		for (PyBill pb : list) {
			pb.setBillMoney(ValueVerify.isnull(pb.getBillMoney().getClass(),
					pb.getBillMoney()));
			pb.setRealMoney(ValueVerify.isnull(pb.getRealMoney().getClass(),
					pb.getRealMoney()));
		}
		return list;
	}

	// ��ѯ�˵���ϸ
	public void selectBillDetails(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String billNo = request.getParameter("billNo");
		
		PyBilldetailExample example = new PyBilldetailExample();
		example.createCriteria().andBillNoEqualTo(billNo);
		List<PyBilldetail> details = pyBilldetailMapper.selectByExample(example);
		
		//��ѯ�˵�
		StringBuffer sb = new StringBuffer();
		for (PyBilldetail detail : details) {
			sb.append("<tr>");
			sb.append("<td>" + detail.getCostTypeCode() + "</td>");// ��������
			sb.append("<td>" + detail.getAmount() + "</td>"); // ˮ��
			sb.append("<td>" + detail.getPrice() == null ? 0 : detail
					.getPrice() + "</td>"); // ����

			BigDecimal sum = new BigDecimal(0.0);
			if (detail.getPrice() != null && detail.getAmount() != null)
				sum = detail.getPrice().multiply(
						new BigDecimal(detail.getAmount()));
			sb.append("<td>" + sum + "</td>"); // С��
			sb.append("<td>" + detail.getRealMoney() + "</td>"); // ʵ��
			if (detail.getDetailMoney() != null
					&& detail.getRealMoney() != null)
				sb.append("<td>"
						+ detail.getDetailMoney().subtract(
								detail.getRealMoney()) + "</td>"); // δ��
			else
				sb.append("<td>0.0</td>");
			sb.append("</tr>");
		}
		
		response.getOutputStream().print(sb.toString());
	}

	 
	@SuppressWarnings("deprecation")
	public void selectUser(UsUser user, HttpServletRequest request) {
		user = usUserMapper.selectByPrimaryKey(user.getUserNo());
		
		List<PyBill> pyBills = SfglUtils.selPyBills(pyBillMapper,user.getUserNo());	//�����û��ı�Ų�ѯ�������е�û�����ˮ�ѵ�

		System.out.println("pyBills.size():   " + pyBills.size());
		// ��ǰ�û�
		request.setAttribute("user", user);
		// ��Ƿ�˵�
		request.setAttribute("pyBills", pyBills);
		// ��ʷ���Ѽ�¼
		// List<PyPay> pays =
		// pyPayMapper.selectByWhereStrPage(" and emp_id is not null ",0,8);;
		List<PyPay> pays = pyPayMapper.selPayHistoryWhereStrPage(
				" and pay.emp_id is not null ", 0, 8);
		;

		request.setAttribute("pays", pays);
		// request.setAttribute("empNames",empNames);//��ʷ���Ѽ�¼���շ�Ա����

		// �û���ʷ�굥
		PyUserhistoryExample htyExample = new PyUserhistoryExample();
		com.sy.entity.PyUserhistoryExample.Criteria criteria2 = htyExample
				.createCriteria();
		Date date = new Date();
		date.setYear(date.getYear() - 1);
		criteria2.andDateeBetween(date, new Date());
//	 	criteria2.andUsernoEqualTo(user.getUserNo());		//����������Ļ����ǲ�ѯ���˵���Ϣ
		List<PyUserhistory> historys = pyUserhistoryMapper
				.selectByExample(htyExample);
		request.setAttribute("historys", historys);
		// ��ǰʱ��
		request.setAttribute("currDate", new Date());

		// �ߴ�֪ͨ��
		String whereStr = " and  billmoney > paymoney ";    // Ҫ��ѯ���˵�   �߽�ˮ��֪ͨ�� whereStr=" and  billmoney > paymoney and user_no = '+user.getUserNo()+'";
		List<PyUserhistory> jiaofei = pyUserhistoryMapper
				.selectByWhereStr(whereStr);
		BigDecimal sum = new BigDecimal(0);
		for (PyUserhistory hty : jiaofei) { // ����û�δ�ɵ�Ǯ
			BigDecimal weipaymoney = hty.getBillmoney().subtract(
					hty.getPaymoney());
			sum = sum.add(weipaymoney);
			hty.setWeipaymoney(weipaymoney);
		}
		request.setAttribute("jiaofei", jiaofei);
		request.setAttribute("sum", sum); // һ��Ƿ��

	}
	

	/**aJax��ѯˮ��������Ϣ 
	 * @throws IOException */
	public void billDetails(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String billNo = request.getParameter("billNo");
		String userNo = request.getParameter("userNo");
		PyBill bill = pyBillMapper.selectByPrimaryKey(billNo);
		UsUser user = usUserMapper.selectByPrimaryKey(userNo);
		RdRead read = rdReadMapper.selectByPrimaryKey(bill.getReadId());
		
		PyBilldetailExample example=new PyBilldetailExample();
		com.sy.entity.PyBilldetailExample.Criteria criteria = example.createCriteria();
		criteria.andBillNoEqualTo(billNo);
		List<PyBilldetail> bDetails = pyBilldetailMapper.selectByExample(example);
		
		
		request.getSession().setAttribute("bDetails", bDetails); //��������
		request.getSession().setAttribute("read", read); //��������
		request.getSession().setAttribute("bill", bill); //ˮ�ѵ�
		request.getSession().setAttribute("user", user); //�û�
		response.getOutputStream().print("ok");
	}
	
	/**aJax��ѯ����������Ϣ 
	 * @throws IOException */
	public void readDetails(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String userNo = request.getParameter("userNo");
		String rid = request.getParameter("rid");
		RdRead read = rdReadMapper.selectByPrimaryKey(Integer.parseInt(rid));//��������
		
		request.getSession().setAttribute("read", read);
		System.out.println(rid);
		System.out.println(read);
		response.getOutputStream().print("ok");
		}
	/**aJax��ѯ������ϸ*/
	public RdRead queryReadDetails(String readNo) {
		RdRead read = rdReadMapper.selectByPrimaryKey(Integer.parseInt(readNo));
		return read;
	}
	
	
	
	
	/**
	 * Ƿ�ѱ���
	 * @param dto
	 * @return
	 */
	public Map<String, Object> reportDebts(SfglDto dto) {
		int page=dto.getPage();
		int rows=dto.getRows();
		List<String> dateMonths = SfglUtils.getDateMonths(6);
	
		initDate(dto, dateMonths);//�ж������ʼ����Ϊ�վ�Ĭ�����Χ
		
		String whereStr=SfglUtils.convertBillWhere(dto);
		List<PyBill> bills = pyBillMapper.selByWhereStrPage(whereStr, (page-1)*rows, rows);//��ѯ����ҳ���е�����
		Double billmoneys =pyBillMapper.sumBillMoneysWhereStr(whereStr);
		Double realmoneys =pyBillMapper.sumRealMoneysWhereStr(whereStr);
		System.out.println("whereStr: "+whereStr);
		Integer total = pyBillMapper.countByWhereStr(whereStr);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bills", bills);
		map.put("dateMonths", dateMonths);//��ʼ����
		map.put("billmoneys", billmoneys);//��Ӧ��ˮ��
		map.put("realmoneys", realmoneys);//������ˮ��
		
		
		
		List<RdVolume> volumes = rdVolumeMapper.selectByExample(null);
		List<SyArea> areas = syAreaMapper.selectByExample(null);
		map.put("volumes", volumes);
		map.put("areas", areas);
		total = total==null?1:total;
		int pageCount = (int) Math.ceil(total / (rows * 1.0));
		dto.setPage(page);
		dto.setPageCount(pageCount);
		map.put("dto", dto);
		
		return map;
	}
	/**�ж������ʼ����Ϊ�վ�Ĭ�����Χ*/
	private void initDate(SfglDto dto, List<String> dateMonths) {
		if(dto.getPayDateBefore()==null)		
		dto.setPayDateBefore(dateMonths.get(5));
		if(dto.getPayDateAfter()==null)
		dto.setPayDateAfter(dateMonths.get(0));
	}

 

}