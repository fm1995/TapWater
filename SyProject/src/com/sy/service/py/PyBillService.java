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

	// 本月应交金额
	public Double sumBillMoney() {
		return ValueVerify.isnull(double.class,
				pyBillMapper.sumMoney("bill_money", null));
	}

	// 本月实交金额
	public Double sumRealMoney() {
		return ValueVerify.isnull(double.class,
				pyBillMapper.sumMoney("real_money", 1));
	}

	// 以月份分组，并查询当前月份应交金额和实交金额总和 ,用List<PyBill>集合保存
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

	// 查询账单明细
	public void selectBillDetails(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String billNo = request.getParameter("billNo");
		
		PyBilldetailExample example = new PyBilldetailExample();
		example.createCriteria().andBillNoEqualTo(billNo);
		List<PyBilldetail> details = pyBilldetailMapper.selectByExample(example);
		
		//查询账单
		StringBuffer sb = new StringBuffer();
		for (PyBilldetail detail : details) {
			sb.append("<tr>");
			sb.append("<td>" + detail.getCostTypeCode() + "</td>");// 费用类型
			sb.append("<td>" + detail.getAmount() + "</td>"); // 水量
			sb.append("<td>" + detail.getPrice() == null ? 0 : detail
					.getPrice() + "</td>"); // 单价

			BigDecimal sum = new BigDecimal(0.0);
			if (detail.getPrice() != null && detail.getAmount() != null)
				sum = detail.getPrice().multiply(
						new BigDecimal(detail.getAmount()));
			sb.append("<td>" + sum + "</td>"); // 小计
			sb.append("<td>" + detail.getRealMoney() + "</td>"); // 实收
			if (detail.getDetailMoney() != null
					&& detail.getRealMoney() != null)
				sb.append("<td>"
						+ detail.getDetailMoney().subtract(
								detail.getRealMoney()) + "</td>"); // 未收
			else
				sb.append("<td>0.0</td>");
			sb.append("</tr>");
		}
		
		response.getOutputStream().print(sb.toString());
	}

	 
	@SuppressWarnings("deprecation")
	public void selectUser(UsUser user, HttpServletRequest request) {
		user = usUserMapper.selectByPrimaryKey(user.getUserNo());
		
		List<PyBill> pyBills = SfglUtils.selPyBills(pyBillMapper,user.getUserNo());	//根据用户的编号查询出他所有的没结清的水费单

		System.out.println("pyBills.size():   " + pyBills.size());
		// 当前用户
		request.setAttribute("user", user);
		// 陈欠账单
		request.setAttribute("pyBills", pyBills);
		// 历史交费记录
		// List<PyPay> pays =
		// pyPayMapper.selectByWhereStrPage(" and emp_id is not null ",0,8);;
		List<PyPay> pays = pyPayMapper.selPayHistoryWhereStrPage(
				" and pay.emp_id is not null ", 0, 8);
		;

		request.setAttribute("pays", pays);
		// request.setAttribute("empNames",empNames);//历史交费记录的收费员名字

		// 用户历史详单
		PyUserhistoryExample htyExample = new PyUserhistoryExample();
		com.sy.entity.PyUserhistoryExample.Criteria criteria2 = htyExample
				.createCriteria();
		Date date = new Date();
		date.setYear(date.getYear() - 1);
		criteria2.andDateeBetween(date, new Date());
//	 	criteria2.andUsernoEqualTo(user.getUserNo());		//有这个条件的话就是查询本人的信息
		List<PyUserhistory> historys = pyUserhistoryMapper
				.selectByExample(htyExample);
		request.setAttribute("historys", historys);
		// 当前时间
		request.setAttribute("currDate", new Date());

		// 催促通知单
		String whereStr = " and  billmoney > paymoney ";    // 要查询本人的   催缴水费通知单 whereStr=" and  billmoney > paymoney and user_no = '+user.getUserNo()+'";
		List<PyUserhistory> jiaofei = pyUserhistoryMapper
				.selectByWhereStr(whereStr);
		BigDecimal sum = new BigDecimal(0);
		for (PyUserhistory hty : jiaofei) { // 算出用户未缴的钱
			BigDecimal weipaymoney = hty.getBillmoney().subtract(
					hty.getPaymoney());
			sum = sum.add(weipaymoney);
			hty.setWeipaymoney(weipaymoney);
		}
		request.setAttribute("jiaofei", jiaofei);
		request.setAttribute("sum", sum); // 一共欠费

	}
	

	/**aJax查询水费详情信息 
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
		
		
		request.getSession().setAttribute("bDetails", bDetails); //抄表数据
		request.getSession().setAttribute("read", read); //抄表数据
		request.getSession().setAttribute("bill", bill); //水费单
		request.getSession().setAttribute("user", user); //用户
		response.getOutputStream().print("ok");
	}
	
	/**aJax查询抄表详情信息 
	 * @throws IOException */
	public void readDetails(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String userNo = request.getParameter("userNo");
		String rid = request.getParameter("rid");
		RdRead read = rdReadMapper.selectByPrimaryKey(Integer.parseInt(rid));//抄表数据
		
		request.getSession().setAttribute("read", read);
		System.out.println(rid);
		System.out.println(read);
		response.getOutputStream().print("ok");
		}
	/**aJax查询表码明细*/
	public RdRead queryReadDetails(String readNo) {
		RdRead read = rdReadMapper.selectByPrimaryKey(Integer.parseInt(readNo));
		return read;
	}
	
	
	
	
	/**
	 * 欠费报表
	 * @param dto
	 * @return
	 */
	public Map<String, Object> reportDebts(SfglDto dto) {
		int page=dto.getPage();
		int rows=dto.getRows();
		List<String> dateMonths = SfglUtils.getDateMonths(6);
	
		initDate(dto, dateMonths);//判断如果起始年月为空就默认最大范围
		
		String whereStr=SfglUtils.convertBillWhere(dto);
		List<PyBill> bills = pyBillMapper.selByWhereStrPage(whereStr, (page-1)*rows, rows);//查询本次页面中的数据
		Double billmoneys =pyBillMapper.sumBillMoneysWhereStr(whereStr);
		Double realmoneys =pyBillMapper.sumRealMoneysWhereStr(whereStr);
		System.out.println("whereStr: "+whereStr);
		Integer total = pyBillMapper.countByWhereStr(whereStr);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bills", bills);
		map.put("dateMonths", dateMonths);//起始年月
		map.put("billmoneys", billmoneys);//总应收水费
		map.put("realmoneys", realmoneys);//总已收水费
		
		
		
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
	/**判断如果起始年月为空就默认最大范围*/
	private void initDate(SfglDto dto, List<String> dateMonths) {
		if(dto.getPayDateBefore()==null)		
		dto.setPayDateBefore(dateMonths.get(5));
		if(dto.getPayDateAfter()==null)
		dto.setPayDateAfter(dateMonths.get(0));
	}

 

}