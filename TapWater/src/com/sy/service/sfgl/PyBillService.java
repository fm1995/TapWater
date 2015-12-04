package com.sy.service.sfgl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.sy.entity.PyBill;
import com.sy.entity.PyBillExample;
import com.sy.entity.PyBillExample.Criteria;
import com.sy.entity.PyPay;
import com.sy.entity.PyPayExample;
import com.sy.entity.UsUser;
import com.sy.projectUtils.ValueVerify;

@Service
public class PyBillService extends PyParent {

	public void selectUser(UsUser user, HttpServletRequest request) {
		user = usUserMapper.selectByPrimaryKey(user.getUserNo());

		PyBillExample example = new PyBillExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNoEqualTo(user.getUserNo());
		criteria.andBalanceEqualTo(false);
		List<PyBill> pyBills = pyBillMapper.selectByExample(example);
		
		System.out.println("pyBills.size():   "+pyBills.size());
		//当前用户
		request.setAttribute("user", user);
		//陈欠账单
		request.setAttribute("pyBills", pyBills);
		//历史交费记录
		List<PyPay> pays = pyPayMapper.selectByWhereStrPage(" and emp_id is not null ",1,8);;
		request.setAttribute("pays",pays);
		
		
		
	}

}