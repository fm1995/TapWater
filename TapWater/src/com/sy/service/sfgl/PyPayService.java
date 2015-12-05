package com.sy.service.sfgl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.sy.entity.PyPay;
import com.sy.entity.SyEmp;

@Service
public class PyPayService extends PyParent{

	/**根据编号讲交费单的查询放到域中去
	 * @throws IOException */
	public void selectInvoiceByPayNo(HttpServletRequest request,
			HttpServletResponse response, String payNo) throws IOException {
		PyPay pay = pyPayMapper.selectByPrimaryKey(payNo);
		if(pay==null)//没有用户登陆不能查询发票
			response.getOutputStream().print("fail");
		else
			response.getOutputStream().print("ok");
		SyEmp  sfEmp= syEmpMapper.selectByPrimaryKey(pay.getEmpId());
		request.getSession().setAttribute("sfEmp", sfEmp);
		request.getSession().setAttribute("pay", pay);
	}
   
}