package com.sy.controller.iv;

import org.springframework.beans.factory.annotation.Autowired;

import com.sy.integration.iv.InvInvoiceReportEmp;
import com.sy.integration.iv.InvInvoiceReportOut;
import com.sy.integration.iv.InvInvoiceReportUse;
import com.sy.integration.iv.InvInvoiceReportUse1;
import com.sy.integration.iv.InvlnvoiceReportArchive;
import com.sy.integration.iv.WorkSpace;
import com.sy.integration.iv.inv_invoiceIn;
import com.sy.integration.iv.inv_invoiceManage;

public class IvParent {
	@Autowired
	private WorkSpace workSpace;
	
	@Autowired
	private inv_invoiceManage IvInvoice;
	
	@Autowired
	private inv_invoiceIn IvIninvoice;
	

	public inv_invoiceIn getIvIninvoice() {
		return IvIninvoice;
	}

	public void setIninvoice(inv_invoiceIn Ivininvoice) {
		IvIninvoice = Ivininvoice;
	}

	public inv_invoiceManage getIvInvoice() {
		return IvInvoice;
	}

	public void setIvInvoice(inv_invoiceManage ivInvoice) {
		IvInvoice = ivInvoice;
	}

	public WorkSpace getWorkSpace() {
		return workSpace;
	}

	public void setWorkSpace(WorkSpace workSpace) {
		this.workSpace = workSpace;
	}

	@Autowired
	private InvInvoiceReportUse invInvoiceReportUse;

	public InvInvoiceReportUse getInvInvoiceReportUse() {
		return invInvoiceReportUse;
	}

	public void setInvInvoiceReportUse(InvInvoiceReportUse invInvoiceReportUse) {
		this.invInvoiceReportUse = invInvoiceReportUse;
	}

	@Autowired
	private InvInvoiceReportUse1 invInvoiceReportUse1;

	public InvInvoiceReportUse1 getInvInvoiceReportUse1() {
		return invInvoiceReportUse1;
	}

	public void setInvInvoiceReportUse1(
			InvInvoiceReportUse1 invInvoiceReportUse1) {
		this.invInvoiceReportUse1 = invInvoiceReportUse1;
	}

	@Autowired
	private InvInvoiceReportOut invInvoiceReportOut;

	public InvInvoiceReportOut getInvInvoiceReportOut() {
		return invInvoiceReportOut;
	}

	public void setInvInvoiceReportOut(InvInvoiceReportOut invInvoiceReportOut) {
		this.invInvoiceReportOut = invInvoiceReportOut;
	}
	
	@Autowired
	private InvInvoiceReportEmp invInvoiceReportEmp;

	public InvInvoiceReportEmp getInvInvoiceReportEmp() {
		return invInvoiceReportEmp;
	}

	public void setInvInvoiceReportEmp(InvInvoiceReportEmp invInvoiceReportEmp) {
		this.invInvoiceReportEmp = invInvoiceReportEmp;
	}
	
	@Autowired
	private InvlnvoiceReportArchive invlnvoiceReportArchive;

	public InvlnvoiceReportArchive getInvlnvoiceReportArchive() {
		return invlnvoiceReportArchive;
	}

	public void setInvlnvoiceReportArchive(
			InvlnvoiceReportArchive invlnvoiceReportArchive) {
		this.invlnvoiceReportArchive = invlnvoiceReportArchive;
	}
	
}
