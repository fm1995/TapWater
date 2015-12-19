package com.sy.integration.iv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.entity.IvInvoice;
import com.sy.entity.SyEmp;
import com.sy.integration.iv.param.ReportUseParam;
import com.sy.service.iv.IvInvoiceService;
import com.sy.service.py.PyPayService;
import com.sy.service.sy.SyEmpService;

//发票使用情况查询
@Repository
public class InvInvoiceReportUse1 {
	@Autowired
	private PyPayService payService;
	@Autowired
	private IvInvoiceService invoiceService;
	@Autowired
	private SyEmpService syEmpService;

	public PyPayService getPayService() {
		return payService;
	}

	public void setPayService(PyPayService payService) {
		this.payService = payService;
	}

	public IvInvoiceService getInvoiceService() {
		return invoiceService;
	}

	public void setInvoiceService(IvInvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	public SyEmpService getSyEmpService() {
		return syEmpService;
	}

	public void setSyEmpService(SyEmpService syEmpService) {
		this.syEmpService = syEmpService;
	}

	// 去jsp时带的数据
	public List<SyEmp> toJsp() {
		return getSyEmpService().selIvEmp();
	}

	//发票使用情况明细表
	public Map<String, Object> invInvoiceReportUse1(ReportUseParam rup){
		//保存当前页数的初始值
		Integer pa = rup.getPage();
		//分页逻辑(设置下一页的开始条数)
		rup.setPage((rup.getPage()-1)*rup.getMaxPage());
		//页面显示数据
		Map<String, Object> map=new HashMap<String, Object>();
		List<IvInvoice> list = getInvoiceService().selWhereIvPy(rup);
		map.put("whereIvPy", list);
		map.put("usedCount", getInvoiceService().selUsedCount(rup));
		map.put("invalidCount", getInvoiceService().selInvalidCount(rup));
		map.put("sumMoney", getInvoiceService().selInSumMoney(rup));
		
		//总条数
		rup.setMaxCount(getInvoiceService().selIvCount(rup));
		//还原开始页数
		rup.setPage(pa);
		//总页数(总条数-1/每页最大条数+1)
		rup.setPageCount((rup.getMaxCount()-1)/rup.getMaxPage()+1);
		//保留分页数据
		map.put("rup", rup);
		return map;
	}
	
}
