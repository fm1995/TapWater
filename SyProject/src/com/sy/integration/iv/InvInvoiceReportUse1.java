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

//��Ʊʹ�������ѯ
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

	// ȥjspʱ��������
	public List<SyEmp> toJsp() {
		return getSyEmpService().selIvEmp();
	}

	//��Ʊʹ�������ϸ��
	public Map<String, Object> invInvoiceReportUse1(ReportUseParam rup){
		//���浱ǰҳ���ĳ�ʼֵ
		Integer pa = rup.getPage();
		//��ҳ�߼�(������һҳ�Ŀ�ʼ����)
		rup.setPage((rup.getPage()-1)*rup.getMaxPage());
		//ҳ����ʾ����
		Map<String, Object> map=new HashMap<String, Object>();
		List<IvInvoice> list = getInvoiceService().selWhereIvPy(rup);
		map.put("whereIvPy", list);
		map.put("usedCount", getInvoiceService().selUsedCount(rup));
		map.put("invalidCount", getInvoiceService().selInvalidCount(rup));
		map.put("sumMoney", getInvoiceService().selInSumMoney(rup));
		
		//������
		rup.setMaxCount(getInvoiceService().selIvCount(rup));
		//��ԭ��ʼҳ��
		rup.setPage(pa);
		//��ҳ��(������-1/ÿҳ�������+1)
		rup.setPageCount((rup.getMaxCount()-1)/rup.getMaxPage()+1);
		//������ҳ����
		map.put("rup", rup);
		return map;
	}
	
}
