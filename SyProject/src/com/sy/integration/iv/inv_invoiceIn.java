package com.sy.integration.iv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.entity.IvIninvoice;
import com.sy.service.iv.IvIninvoiceService;

@Repository
public class inv_invoiceIn {
	@Autowired
	private IvIninvoiceService ivIninvoiceService;
	
	public void inv_invoiceInAdd(IvIninvoice ivIninvoice){
		ivIninvoiceService.addIninvoice(ivIninvoice);
	}
}
