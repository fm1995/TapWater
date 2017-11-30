package com.sy.integration.iv;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.controller.iv.invInvoiceManage;
import com.sy.service.iv.IvIninvoiceService;

@Repository
public class inv_invoiceManage {
		@Autowired
		private IvIninvoiceService ivIninvoiceService;
		
		
		
		
		public Map<String, Object> inv_invoiceManageShow(PageClass page) {
			Map<String, Object> map=new HashMap<String, Object>();
			page.setAllCount(ivIninvoiceService.selAllCount());
			//用最大数据条数/每页最大条数得出最大页数
			page.setPageCount((page.getAllCount()-1)/2+1);
			map.put("pageClass", page);
			map.put("ivInvoices", ivIninvoiceService.selectCount(page.getPage()));
			return map;
		}
}
