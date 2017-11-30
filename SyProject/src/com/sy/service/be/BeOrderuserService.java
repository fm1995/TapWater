package com.sy.service.be;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.BeOrderuser;
import com.sy.projectUtils.ValueVerify;

@Service
public class BeOrderuserService extends BeParent {

	// 閿熸枻鎷疯鍏ㄩ敓鏂ゆ嫹閿熶茎鐧告嫹閿熸枻鎷烽敓鐭紮鎷烽敓鏂ゆ嫹閿熸枻鎷�
	@SuppressWarnings("unchecked")
	public List<BeOrderuser> queryByOrdeNo(String be) {
		return ValueVerify.isnull(List.class, getBeOrderuserMapper()
				.queryByOrdeNo(be));
	}

	public List<BeOrderuser> selectByOrderNo(String orderNo) {
		return getBeOrderuserMapper().selectByOrderNo(orderNo);
	}

	public void updateByOrderNo(BeOrderuser beOrderuser) {
		getBeOrderuserMapper().updateByPrimaryKey(beOrderuser);

	}

	public List<BeOrderuser> selAllOrderuser(int i, String orderType1,
			String orderType2, String orderType3, Date date1, Date date2) {
		return getBeOrderuserMapper().selAllOrderuser(orderType1, orderType2,
				orderType3, date1, date2, i);
	}

	public int selAllOrderuserCount(String orderType1, String orderType2,
			String orderType3, Date date1, Date date2) {
		return getBeOrderuserMapper().selAllOrderuserCount(orderType1,
				orderType2, orderType3, date1, date2);
	}

	// Be_OrderUser鐞涖劍鍧婇崝鐘虫煀閹达拷
	public void save(BeOrderuser record) {
		getBeOrderuserMapper().insertSelective(record);
	}

	public Integer selAllOrderuserMoney(String orderType1, String orderType2,
			String orderType3, Date date1, Date date2) {
		return getBeOrderuserMapper().selAllOrderuserMoney(orderType1,
				orderType2, orderType3, date1, date2);
	}

	public List<BeOrderuser> selectByOrderNo2(String orderNo) {
		return getBeOrderuserMapper().selectByOrderNo2(orderNo);

	}
}