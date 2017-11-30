package com.sy.integration.iv;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.service.be.BeOrderService;
import com.sy.service.py.PyBillService;
import com.sy.service.rd.RdReadService;
import com.sy.service.us.UsUserService;


//用于首页数据展示
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
	
	

	// 首页需要显示的数据
	public BeOrderService getBeOrderService() {
		return beOrderService;
	}

	public void setBeOrderService(BeOrderService beOrderService) {
		this.beOrderService = beOrderService;
	}

	public Map<String, Object> workSpaceShow() {
		Map<String, Object> map = new HashMap<String, Object>();
		//本月注册用户
		map.put("nextUserCount", usUserService.selNowUserCount());
		// 本月应抄表数
		map.put("rdShouldCount", rdReadService.selReadCount(null));
		// 本月实抄表数
		map.put("rdRealityCount", rdReadService.selReadCount(1));
		Double readAmout=rdReadService.selReadAmount();
		//本月的水量
		map.put("readAmount", readAmout);
		//本月应收水费
		map.put("SumBillMoney", pyBillService.sumBillMoney());
		//本月实收水费
		map.put("SumRealMoney", pyBillService.sumRealMoney());
		
		//用水类型统计
		//1,生活用水
		map.put("SHCount", rdReadService.sumTypeAmount("SH"));
		//2,商业用水
		map.put("SYCount", rdReadService.sumTypeAmount("SY"));
		//3,工业用水
		map.put("GYCount", rdReadService.sumTypeAmount("GY"));
		//4,行政用水
		map.put("XZCount", rdReadService.sumTypeAmount("XZ"));
		//5,军区用水
		map.put("JQCount", rdReadService.sumTypeAmount("JQ"));
		//6,特种用水
		map.put("TZCount", rdReadService.sumTypeAmount("TZ"));
		
		//收费情况统计图表
		//集合中保存有多个pyBill类，类中三个字段
		//billNo保存分组后的月份时间,
		//BillMoney保存的是当前月份下的应交金额的总和,
		//RealMoney保存的是当前月份下的实交金额的总和,
		map.put("sumBillReal", pyBillService.sumBillReal());
		
		//待处理工单
		map.put("waitBe", beOrderService.waitBe());
		
		return map;
	}
	
	
}
