package com.sy.service.be;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.BeComment;
import com.sy.projectUtils.ValueVerify;

@Service
public class BeCommentService extends BeParent{
	
	
	//查询全部的工单附加信息
		public List<BeComment> queryByOrdeNo(String be){
			return ValueVerify.isnull(List.class,getBeCommentMapper().queryByOrdeNo(be));
		}

		public void updateCom(BeComment bc) {
			// TODO Auto-generated method stub
			ValueVerify.isnull(null, getBeCommentMapper().updateByPrimaryKeySelective(bc));
		}

		public void delCom(BeComment bc) {
			// TODO Auto-generated method stub
			ValueVerify.isnull(null, getBeCommentMapper().deleteByPrimaryKey(bc.getId()));
		}

		public void addCom(BeComment bc) {
			// TODO Auto-generated method stub
			ValueVerify.isnull(null, getBeCommentMapper().insert(bc));
		}

	
}