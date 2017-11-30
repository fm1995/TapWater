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

//��Ʊʹ�������ѯ
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

	// ȥjspʱ��������
	public List<SyEmp> toJsp() {
		return getSyEmpService().selIvEmp();
	}

	//��Ʊ�����������ѯ
	public List<KeyCount> whereAll(ReportUseParam rup) {
		List<KeyCount> list=new ArrayList<KeyCount>();
		if(rup.getStartNo()!=""&&rup.getStartNo()!=null)
			list.add(new KeyCount("��ʼ���", rup.getStartNo()));
		if(rup.getEndNo()!=""&&rup.getEndNo()!=null)
			list.add(new KeyCount("�������", rup.getEndNo()));
		if(rup.getUseDateStart()!="")
			list.add(new KeyCount("��ʼʱ��", rup.getUseDateStart()));
		if(rup.getUseDateEnd()!="")
			list.add(new KeyCount("����ʱ��", rup.getUseDateEnd()));
		
		list.add(new KeyCount("�ϼ�����", ValueVerify.isnull(ivInvoiceService.selIvCount(rup).getClass(), ivInvoiceService.selIvCount(rup))));
		list.add(new KeyCount("��������", ValueVerify.isnull(ivInvoiceService.selInvalidCount(rup).getClass(), ivInvoiceService.selInvalidCount(rup))));
		list.add(new KeyCount("ʹ������",ValueVerify.isnull(ivInvoiceService.selUsedCount(rup).getClass(), ivInvoiceService.selUsedCount(rup))));
		list.add(new KeyCount("�ϼƽ��", ValueVerify.isnull(ivInvoiceService.selInvalidCount(rup).getClass(), ivInvoiceService.selInSumMoney(rup))+".00Ԫ"));
		return list;
	}
}
