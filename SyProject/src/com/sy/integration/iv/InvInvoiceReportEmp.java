package com.sy.integration.iv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.service.sy.SyEmpService;

	/**发票管理
	 * 收费人员发票查询
	 *
	 */
@Repository
public class InvInvoiceReportEmp {
	@Autowired
	private SyEmpService syEmpService;

	public SyEmpService getSyEmpService() {
		return syEmpService;
	}

	public void setSyEmpService(SyEmpService syEmpService) {
		this.syEmpService = syEmpService;
	}
	
	public Map<String,	Object> invInvoiceReportEmp(PageClass page){
		if(page==null)
			page=new PageClass();
		if(page.getPage()==null)
			page.setPage(1);
		
		Map<String,	Object> map=new HashMap<String, Object>();
		page.setAllCount(getSyEmpService().SelEmpIvAllCount());
		page.setPageCount((page.getAllCount()-1)/10+1);
		
		map.put("pageClass", page);
		map.put("selEmpIV", getSyEmpService().SelEmpIVCount(page.getPage()));
		return map;
	}
	
}
