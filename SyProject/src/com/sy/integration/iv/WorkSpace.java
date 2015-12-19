package com.sy.integration.iv;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.service.be.BeOrderService;
import com.sy.service.py.PyBillService;
import com.sy.service.rd.RdReadService;
import com.sy.service.us.UsUserService;


//������ҳ����չʾ
@Repository
public class WorkSpace {
	@Autowired
	private UsUserService usUserService;
	@Autowired
	private RdReadService rdReadService;
	@Autowired
	private PyBillService pyBillService;
	@Autowired
	private BeOrderService beOrderService;

	public UsUserService getUsUserService() {
		return usUserService;
	}

	public void setUsUserService(UsUserService usUserService) {
		this.usUserService = usUserService;
	}

	public RdReadService getRdReadService() {
		return rdReadService;
	}

	public void setRdReadService(RdReadService rdReadService) {
		this.rdReadService = rdReadService;
	}

	public PyBillService getPyBillService() {
		return pyBillService;
	}

	public void setPyBillService(PyBillService pyBillService) {
		this.pyBillService = pyBillService;
	}
	
	

	// ��ҳ��Ҫ��ʾ������
	public BeOrderService getBeOrderService() {
		return beOrderService;
	}

	public void setBeOrderService(BeOrderService beOrderService) {
		this.beOrderService = beOrderService;
	}

	public Map<String, Object> workSpaceShow() {
		Map<String, Object> map = new HashMap<String, Object>();
		//����ע���û�
		map.put("nextUserCount", usUserService.selNowUserCount());
		// ����Ӧ������
		map.put("rdShouldCount", rdReadService.selReadCount(null));
		// ����ʵ������
		map.put("rdRealityCount", rdReadService.selReadCount(1));
		Double readAmout=rdReadService.selReadAmount();
		//���µ�ˮ��
		map.put("readAmount", readAmout);
		//����Ӧ��ˮ��
		map.put("SumBillMoney", pyBillService.sumBillMoney());
		//����ʵ��ˮ��
		map.put("SumRealMoney", pyBillService.sumRealMoney());
		
		//��ˮ����ͳ��
		//1,������ˮ
		map.put("SHCount", rdReadService.sumTypeAmount("SH"));
		//2,��ҵ��ˮ
		map.put("SYCount", rdReadService.sumTypeAmount("SY"));
		//3,��ҵ��ˮ
		map.put("GYCount", rdReadService.sumTypeAmount("GY"));
		//4,������ˮ
		map.put("XZCount", rdReadService.sumTypeAmount("XZ"));
		//5,������ˮ
		map.put("JQCount", rdReadService.sumTypeAmount("JQ"));
		//6,������ˮ
		map.put("TZCount", rdReadService.sumTypeAmount("TZ"));
		
		//�շ����ͳ��ͼ��
		//�����б����ж��pyBill�࣬���������ֶ�
		//billNo����������·�ʱ��,
		//BillMoney������ǵ�ǰ�·��µ�Ӧ�������ܺ�,
		//RealMoney������ǵ�ǰ�·��µ�ʵ�������ܺ�,
		map.put("sumBillReal", pyBillService.sumBillReal());
		
		//��������
		map.put("waitBe", beOrderService.waitBe());
		
		return map;
	}
	
	
}
