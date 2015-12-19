package com.sy.integration.be;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.entity.BeComment;
import com.sy.entity.BeHistory;
import com.sy.entity.BeOrderuser;
import com.sy.service.be.BeCommentService;
import com.sy.service.be.BeFlowService;
import com.sy.service.be.BeHistoryService;
import com.sy.service.be.BeOrderService;
import com.sy.service.be.BeOrderuserService;

//���ݴ����
@Repository
public class BeOrderInfo {
	@Autowired
	protected BeHistoryService historyser;
	@Autowired
	protected BeFlowService flowser;
	@Autowired
	protected BeOrderService orderser;
	@Autowired
	protected BeOrderuserService userser;
	@Autowired
	protected BeCommentService commentser;
	
	//ͨ�������Ų�ѯȫ���ı���Ϣ
	public Map<String,Object> BeOrderInfoShow(String be){
		Map<String,Object> map = new HashMap<String,Object>();
		//��ѯ������ʷ��¼
		map.put("history",historyser.queryByOrdeNo(be));
		
		//��ѯ���е�����
		map.put("flow",flowser.selBeFlow());
		//������������
		map.put("Order",orderser.queryByOrdeNo(be));
		//�����û����
		map.put("OrderUser",userser.queryByOrdeNo(be));
		return map;
	}
	
	//��ѯ����������Ϣ
	public Map<String,Object> BeCommentInfoShow(String be){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("BeComment", commentser.queryByOrdeNo(be));
		return map;
	}
	
	//�޸����� 
	public void updateCom(BeComment bc){
		commentser.updateCom(bc);
	}
	//ɾ������ 
	public void delCom(BeComment bc){
		commentser.delCom(bc);
	}
	
	//������������
	public void addCom(BeComment bc) {
		// TODO Auto-generated method stub
		commentser.addCom(bc);
	}
	
	
}
