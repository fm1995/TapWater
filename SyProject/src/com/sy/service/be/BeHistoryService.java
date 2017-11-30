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
	//ע��ע�룬�����ע�����ķ����޷�ȡֵ 
	@Autowired	private BeFlowService flowSer;

	public BeFlowService getFlowSer() {
		return flowSer;
	}

	public void setFlowSer(BeFlowService flowSer) {
		this.flowSer = flowSer;
	}



	//	���ع�������ʷ��¼
	public List<BeHistory> queryByOrdeNo(String be){
		List<BeHistory> list = getBeHistoryMapper().queryByOrderNo(be);
		String name = "";
		//����
		for (BeHistory beHistory : list) {
			//ͨ������FlowService�ڵķ�������Ӧ�����̲����ѯ������
			Integer type = beHistory.getOrder().getOrderType();
			List<Map> selBeFlow = flowSer.selBeFlow();
			Map map = selBeFlow.get(type-1);
			Flow flow = (Flow) map.get(beHistory.getStepId());
			//���������Ƹ�ֵ��Bestory�ڵ�StepName���ԣ�ֱ����jspҳ������
  			beHistory.setStepName(flow.getStepName());
		}
		System.out.println();
		System.out.println(list.size());
		return ValueVerify.isnull(List.class,list);
	}
	
}