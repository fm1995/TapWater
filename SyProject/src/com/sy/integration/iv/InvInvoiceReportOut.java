package com.sy.integration.iv;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.service.iv.IvOutinvoiceService;
	/**发票管理
	 * 发票出库查询
	 *
	 */
@Repository
public class InvInvoiceReportOut {
	@Autowired
	private IvOutinvoiceService ivOutinvoiceService;

	public IvOutinvoiceService getIvOutinvoiceService() {
		return ivOutinvoiceService;
	}

	public void setIvOutinvoiceService(IvOutinvoiceService ivOutinvoiceService) {
		this.ivOutinvoiceService = ivOutinvoiceService;
	}

	
	public Map<String, Object> invInvoiceReportOut(PageClass page) {
		if (page == null)
			page = new PageClass();
		if (page.getPage() == null)
			page.setPage(1);
		page.setAllCount(getIvOutinvoiceService().selOutCount());
		page.setPageCount((page.getAllCount()-1)/10+1);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageClass", page);
		map.put("outs", getIvOutinvoiceService().selectAll(page.getPage()));
		return map;
	}
}
