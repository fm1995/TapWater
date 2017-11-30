package com.sy.service.be;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sy.entity.BeOrder;
import com.sy.entity.BeOrderTable;
import com.sy.mappdao.BeOrderMapper;

@Service
public class OrderService {

	@Autowired
	private BeOrderMapper beOrderMapper;

	// 根据各种条件查询
	public List<BeOrder> selectByStep(int stepId, int page) {
		return beOrderMapper.selByStep(stepId, page);
	}

	public int selectCount1(int stepId) {
		return beOrderMapper.selByCount1(stepId);
	}

	public BeOrder selectByOrderno(String orderNo) {
		return beOrderMapper.selectByOrderNo(orderNo);
	}

	public BeOrder selectByOrderno2(String orderNo) {
		return beOrderMapper.selectByPrimaryKey(orderNo);
	}

	public void updateOrder(BeOrder beOrder) {
		beOrderMapper.updateByPrimaryKey(beOrder);
	}

	public List<BeOrder> selectByRe(int stepId, int orderType, String orderNo,
			String userName, int page) {
		return beOrderMapper
				.selByRe(stepId, orderType, orderNo, userName, page);
	}

	public int selectCount3(int stepId, int orderType, String orderNo,
			String userName) {
		return beOrderMapper.selByCount3(stepId, orderType, orderNo, userName);
	}

	public List<BeOrderTable> selGroup(int i) {
		return beOrderMapper.selGroup(i);
	}

	public int selGroupCount(int i) {
		return beOrderMapper.selGroupCount(i);
	}


}
