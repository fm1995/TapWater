package com.sy.integration.iv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.entity.SyEmp;
import com.sy.integration.iv.param.KeyCount;
import com.sy.integration.iv.param.ReportUseParam;
import com.sy.projectUtils.ValueVerify;
import com.sy.service.iv.*;
import com.sy.service.sy.SyEmpService;

//发票使用情况查询
@Repository
public class InvInvoiceReportUse {
	@Autowired
	private IvIninvoiceService ivIninvoiceService;
	@Autowired
	private IvInvoiceService ivInvoiceService;
	@Autowired
	private SyEmpService syEmpService;

	public SyEmpService getSyEmpService() {
		return syEmpService;
	}

	public void setSyEmpService(SyEmpService syEmpService) {
		this.syEmpService = syEmpService;
	}

	public IvIninvoiceService getIvIninvoiceService() {
		return ivIninvoiceService;
	}

	public void setIvIninvoiceService(IvIninvoiceService ivIninvoiceService) {
		this.ivIninvoiceService = ivIninvoiceService;
	}

	public IvInvoiceService getIvInvoiceService() {
		return ivInvoiceService;
	}

	public void setIvInvoiceService(IvInvoiceService ivInvoiceService) {
		this.ivInvoiceService = ivInvoiceService;
	}

	// 去jsp时带的数据
	public List<SyEmp> toJsp() {
		return getSyEmpService().selIvEmp();
	}

	//发票多条件情况查询
	public List<KeyCount> whereAll(ReportUseParam rup) {
		List<KeyCount> list=new ArrayList<KeyCount>();
		if(rup.getStartNo()!=""&&rup.getStartNo()!=null)
			list.add(new KeyCount("开始编号", rup.getStartNo()));
		if(rup.getEndNo()!=""&&rup.getEndNo()!=null)
			list.add(new KeyCount("结束编号", rup.getEndNo()));
		if(rup.getUseDateStart()!="")
			list.add(new KeyCount("开始时间", rup.getUseDateStart()));
		if(rup.getUseDateEnd()!="")
			list.add(new KeyCount("结束时间", rup.getUseDateEnd()));
		
		list.add(new KeyCount("合计张数", ValueVerify.isnull(ivInvoiceService.selIvCount(rup).getClass(), ivInvoiceService.selIvCount(rup))));
		list.add(new KeyCount("作废张数", ValueVerify.isnull(ivInvoiceService.selInvalidCount(rup).getClass(), ivInvoiceService.selInvalidCount(rup))));
		list.add(new KeyCount("使用张数",ValueVerify.isnull(ivInvoiceService.selUsedCount(rup).getClass(), ivInvoiceService.selUsedCount(rup))));
		list.add(new KeyCount("合计金额", ValueVerify.isnull(ivInvoiceService.selInvalidCount(rup).getClass(), ivInvoiceService.selInSumMoney(rup))+".00元"));
		return list;
	}
}
