package com.sy.service.sfgl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.sy.dto.SfglDto;
import com.sy.entity.IvInvoice;
import com.sy.entity.IvInvoiceExample;
import com.sy.entity.IvInvoiceExample.Criteria;
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
   
}