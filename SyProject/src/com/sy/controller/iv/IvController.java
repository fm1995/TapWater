package com.sy.controller.iv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sy.entity.IvIninvoice;
import com.sy.integration.iv.PageClass;
import com.sy.integration.iv.param.KeyCount;
import com.sy.integration.iv.param.ReportUseParam;

@Controller
@RequestMapping("/iv")
public class IvController extends IvParent {

	// չʾ��ҳ����
	@RequestMapping("/workSpceShow")
	public String IndexShow(Map<String, Object> model) {
		model.put("showDate", getWorkSpace().workSpaceShow());
		return "/SY/workspace.jsp";
	}

	// ��Ʊ�ܱ�
	@RequestMapping("/inv_invoiceManage")
	public String selectAll(Map<String, Object> model, HttpServletRequest req) {
		PageClass pageClass = new PageClass();
		if (req.getParameter("page") != null)
			pageClass.setPage(Integer.valueOf(req.getParameter("page")));
		else
			pageClass.setPage(1);
		model.put("data", getIvInvoice().inv_invoiceManageShow(pageClass));
		// String format = new SimpleDateFormat("yyyy��MM��dd��").format(new
		// Date());
		return "/SY/page/inv_invoiceManage.jsp";
	}

	// ��Ʊ���
	@RequestMapping("/inv_invoiceIn")
	public String addIvin(IvIninvoice ivIninvoice, HttpServletRequest req)
			throws ParseException {
		String date = req.getParameter("dateIn");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = dateFormat.parse(date);
		ivIninvoice.setInDate(dt);
		getIvIninvoice().inv_invoiceInAdd(ivIninvoice);
		return "/iv/inv_invoiceManage";
	}

	// ������ȥ��Ʊʹ�������ѯҳ��
	@RequestMapping("/toInvInvoiceReportUse")
	public String toInvInvoiceReportUse(Map<String, Object> model) {
		model.put("toJsp", getInvInvoiceReportUse().toJsp());
		return "/SY/page/inv_invoiceReportUse.jsp";
	}

	// �첽�ύ��Ʊʹ�������ѯ
	@ResponseBody
	@RequestMapping("/invInvoiceReportUse")
	public List<KeyCount> invInvoiceReportUse(ReportUseParam rup) {
		return getInvInvoiceReportUse().whereAll(rup);
	}

	// ������ȥ��Ʊʹ�������ϸ�����
	@RequestMapping("/toInvInvoiceReportUse1")
	public String toInvInvoiceReportUse1(Map<String, Object> model) {
		model.put("toJsp", getInvInvoiceReportUse().toJsp());
		return "/SY/page/inv_invoiceReportUse1.jsp";
	}

	// �첽�ύ��Ʊʹ�������ϸ��
	@ResponseBody
	@RequestMapping("/InvInvoiceReportUse1")
	public Map<String, Object> invInvoiceReportUse1(ReportUseParam rup) {
		return getInvInvoiceReportUse1().invInvoiceReportUse1(rup);
	}

	
	//��Ʊ���������ѯ
	@RequestMapping("/outSelectAll")
	public String selectALL(Map<String,Object> model,PageClass pageClass) {
		model.put("data", getInvInvoiceReportOut().invInvoiceReportOut(pageClass));
		return "/SY/page/inv_invoiceReportOut.jsp";
	}
		
	//�շ���Ա��Ʊ��ѯ
	@RequestMapping("/empSelectAll")
	public String EmpselectAll(Map<String,Object> model,PageClass pageClass)
	{
		model.put("list",getInvInvoiceReportEmp().invInvoiceReportEmp(pageClass));
		return "/SY/page/inv_invoiceReportEmp.jsp";
	}
		
		
	//��Ʊ��Ʊ�����ѯ
	@RequestMapping("/archiveSelect")
	public String archiveSelect(Map<String, Object> model,PageClass pageClass)
	{
		model.put("list", getInvlnvoiceReportArchive().invInvoiceReportArchive(pageClass));
		return "/SY/page/inv_invoiceReportArchive.jsp";
	}
	
}
