package com.sy.integration.iv;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.service.iv.IvArchiveService;
import com.sy.service.sy.SyEmpService;


/**发票管理s
 * 
 * 发票交票情况查询
 *
 */
@Repository
public class InvlnvoiceReportArchive {
	@Autowired
	private IvArchiveService archiveService;

	public IvArchiveService getArchiveService() {
		return archiveService;
	}

	public void setArchiveService(IvArchiveService archiveService) {
		this.archiveService = archiveService;
	}

	public Map<String,	Object> invInvoiceReportArchive(PageClass page){
		if(page==null)
			page=new PageClass();
		if(page.getPage()==null)
			page.setPage(1);
		
		Map<String,	Object> map=new HashMap<String, Object>();
		page.setAllCount(getArchiveService().selArchiveCount());
		page.setPageCount((page.getAllCount()-1)/5+1);
		
		map.put("pageClass", page);
		map.put("selArchive", getArchiveService().selIvArchiveCount(page.getPage()));
		return map;
	}

}
