package com.sy.service.be;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.entity.BeHistory;
import com.sy.entity.Flow;
import com.sy.projectUtils.ValueVerify;

@Service
public class BeHistoryService extends BeParent{
	//注解注入，如果不注入改类的方法无法取值 
	@Autowired	private BeFlowService flowSer;

	public BeFlowService getFlowSer() {
		return flowSer;
	}

	public void setFlowSer(BeFlowService flowSer) {
		this.flowSer = flowSer;
	}



	//	返回工单的历史记录
	public List<BeHistory> queryByOrdeNo(String be){
		List<BeHistory> list = getBeHistoryMapper().queryByOrderNo(be);
		String name = "";
		//流程
		for (BeHistory beHistory : list) {
			//通过调用FlowService内的方法将对应的流程步骤查询出来。
			Integer type = beHistory.getOrder().getOrderType();
			List<Map> selBeFlow = flowSer.selBeFlow();
			Map map = selBeFlow.get(type-1);
			Flow flow = (Flow) map.get(beHistory.getStepId());
			//将步骤名称赋值给Bestory内的StepName属性，直接在jsp页面引用
  			beHistory.setStepName(flow.getStepName());
		}
		System.out.println();
		System.out.println(list.size());
		return ValueVerify.isnull(List.class,list);
	}
	
}