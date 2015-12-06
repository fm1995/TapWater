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

	/**���ݱ�Ž����ѵ��Ĳ�ѯ�ŵ�����ȥ
	 * @throws IOException */
	public void selectInvoiceByPayNo(HttpServletRequest request,
			HttpServletResponse response, String payNo) throws IOException {
		PyPay pay = pyPayMapper.selectByPrimaryKey(payNo);
		if(pay==null)//û���û���½���ܲ�ѯ��Ʊ
			response.getOutputStream().print("fail");
		else
			response.getOutputStream().print("ok");
		SyEmp  sfEmp= syEmpMapper.selectByPrimaryKey(pay.getEmpId());
		request.getSession().setAttribute("sfEmp", sfEmp);
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
   
}