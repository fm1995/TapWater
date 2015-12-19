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

//数据处理层
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
	
	//通过工单号查询全部的表单信息
	public Map<String,Object> BeOrderInfoShow(String be){
		Map<String,Object> map = new HashMap<String,Object>();
		//查询流程历史记录
		map.put("history",historyser.queryByOrdeNo(be));
		
		//查询所有的流程
		map.put("flow",flowser.selBeFlow());
		//工单数据数据
		map.put("Order",orderser.queryByOrdeNo(be));
		//工单用户详表
		map.put("OrderUser",userser.queryByOrdeNo(be));
		return map;
	}
	
	//查询工单附加信息
	public Map<String,Object> BeCommentInfoShow(String be){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("BeComment", commentser.queryByOrdeNo(be));
		return map;
	}
	
	//修改留言 
	public void updateCom(BeComment bc){
		commentser.updateCom(bc);
	}
	//删除留言 
	public void delCom(BeComment bc){
		commentser.delCom(bc);
	}
	
	//新增附加留言
	public void addCom(BeComment bc) {
		// TODO Auto-generated method stub
		commentser.addCom(bc);
	}
	
	
}
