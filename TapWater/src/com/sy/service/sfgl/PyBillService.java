package com.sy.service.sfgl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sy.entity.PyBill;
import com.sy.entity.PyBillExample;
import com.sy.entity.PyBillExample.Criteria;
import com.sy.entity.PyBilldetail;
import com.sy.entity.PyBilldetailExample;
import com.sy.entity.PyPay;
import com.sy.entity.PyPayExample;
import com.sy.entity.PyUserhistory;
import com.sy.entity.PyUserhistoryExample;
import com.sy.entity.UsUser;
import com.sy.projectUtils.ValueVerify;

@Service
public class PyBillService extends PyParent {

	@SuppressWarnings("deprecation")
	public void selectUser(UsUser user, HttpServletRequest request) {
		user = usUserMapper.selectByPrimaryKey(user.getUserNo());

		PyBillExample example = new PyBillExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNoEqualTo(user.getUserNo());
		criteria.andBalanceEqualTo(false);
		List<PyBill> pyBills = pyBillMapper.selectByExample(example);
		
		System.out.println("pyBills.size():   "+pyBills.size());
		//当前用户
		request.setAttribute("user", user);
		//陈欠账单
		request.setAttribute("pyBills", pyBills);
		//历史交费记录
		//List<PyPay> pays = pyPayMapper.selectByWhereStrPage(" and emp_id is not null ",0,8);;
		List<PyPay> pays = pyPayMapper.selPayHistoryWhereStrPage(" and pay.emp_id is not null ",0,8);;
		 
		request.setAttribute("pays",pays);
//		request.setAttribute("empNames",empNames);//历史交费记录的收费员名字
		
		//用户历史详单
		PyUserhistoryExample htyExample =new PyUserhistoryExample();
		com.sy.entity.PyUserhistoryExample.Criteria criteria2 = htyExample.createCriteria();
		Date date =new Date();
		date.setYear(date.getYear()-1);
		criteria2.andDateeBetween(date, new Date());
		List<PyUserhistory> historys = pyUserhistoryMapper.selectByExample(htyExample);
		request.setAttribute("historys", historys);
		//当前时间
		request.setAttribute("currDate", new Date());

		
	}

	//查询账单明细
	public void selectBillDetails(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String billNo = request.getParameter("billNo");
		PyBilldetailExample example =new PyBilldetailExample();
		example.createCriteria().andBillNoEqualTo(billNo);
		List<PyBilldetail> details = pyBilldetailMapper.selectByExample(example);
		StringBuffer sb=new StringBuffer();
		for (PyBilldetail detail : details) {
			sb.append("<tr>");
			sb.append("<td>"+detail.getCostTypeCode()+"</td>");//费用类型
			sb.append("<td>"+detail.getAmount()+"</td>");	//水量
			sb.append("<td>"+detail.getPrice()==null?0:detail.getPrice()+"</td>");	//单价
			
			BigDecimal sum=new BigDecimal(0.0);
			if(detail.getPrice()!=null&&detail.getAmount()!=null)
				sum=detail.getPrice().multiply(new BigDecimal(detail.getAmount()));
			sb.append("<td>"+sum+"</td>"); //小计
			sb.append("<td>"+detail.getRealMoney()+"</td>");	//实收
			if(detail.getDetailMoney()!=null &&detail.getRealMoney() !=null )
				sb.append("<td>"+detail.getDetailMoney().subtract(detail.getRealMoney())+"</td>");	//未收
			else
				sb.append("<td>0.0</td>");
			sb.append("</tr>");
		}
		System.out.println(sb.toString());
		response.getOutputStream().print(sb.toString());
	}

	


}