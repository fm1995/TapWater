package com.sy.service.sfgl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sy.entity.UsSms;
import com.sy.entity.UsUser;
import com.sy.entity.UsUserExample;
import com.sy.entity.UsUserExample.Criteria;
import com.sy.service.parentser.ParentSerI;
import com.sy.service.parentser.UsParentSer;

@Service
public class UsUserService extends UsParentSer implements ParentSerI<UsUser> {

	public void text() {
		List<UsSms> selAll = usSmsMapper.selAll();
		for (UsSms usSms : selAll) {
			System.out.println(usSms.getEmpId());
		}
	}

	@Override
	public List<UsUser> getAll() {
		return usUserMapper.selectByExample(null);
	}

	@Override
	public UsUser selectByPrimaryKey(String id) {
		return usUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(UsUser entity) {
		return usUserMapper.insert(entity);
	}

	@Override
	public int update(UsUser entity) {
		return usUserMapper.updateByPrimaryKey(entity);
	}

	@Override
	public int delete(String id) {
		return usUserMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 查询所有的预收的数据
	 * 
	 * @param page
	 * @param rows
	 * @param userMoney
	 * @return
	 */
	public List<UsUser> selectYSList(int page, int rows, Integer userMoney) {
		return usUserMapper.selectYSList((page - 1) * rows, rows, userMoney);
	}

	/**
	 * 查询所有的预收的数据 的数量
	 * 
	 * @param page
	 * @param rows
	 * @param userMoney
	 * @return
	 */
	public int selectYSListCount(int page, int rows, Integer userMoney) {
		return usUserMapper.selectYSListCount((page - 1) * rows, rows,
				userMoney);
	}

	public Map<String, Object> yushou(int page, int rows, Integer userMoney) {
		int total = this.selectYSListCount(page, rows, userMoney);
		List<UsUser> users = selectYSList(page, rows, userMoney);
		Double moneys = usUserMapper.selectYSMonenys((page - 1) * rows, rows,
				userMoney);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", users);
		map.put("moneys", moneys != null ? moneys : 0.0);
		map.put("userMoney", userMoney);
		int pageCount = (int) Math.ceil(total / (rows * 1.0));
		map.put("page", page);
		map.put("pageCount", pageCount);
		return map;
	}

	// ======================收费窗口 查询用户
	public Map<String, Object> selectUser(UsUser user, Integer page,
			Integer rows) {

		UsUserExample example = new UsUserExample();
		Criteria criteria = example.createCriteria();

		if (user.getUserNo() != null && !"".equals(user.getUserNo().trim()))
			criteria.andUserNoLike("%"+user.getUserNo()+"%");
		if (user.getAbc() != null && !"".equals(user.getAbc().trim()))
			criteria.andAbcLike("%"+user.getAbc()+"%");
		if (user.getPhone() != null && !"".equals(user.getPhone().trim()))
			criteria.andPhoneLike("%"+user.getPhone()+"%");
		if (user.getSmsPhone() != null && !"".equals(user.getSmsPhone().trim()))
			criteria.andSmsPhoneLike("%"+user.getSmsPhone()+"%");
		if (user.getDocNum() != null && !"".equals(user.getDocNum().trim()))
			criteria.andDocNumLike("%"+user.getDocNum()+"%");
		if (user.getUserName() != null && !"".equals(user.getUserName().trim()))
			criteria.andUserNameLike("%"+user.getUserName()+"%");
		if (user.getAddress() != null && !"".equals(user.getAddress().trim()))
			criteria.andAddressLike("%"+user.getAddress()+"%");

		List<UsUser> users = usUserMapper.selectByExample(example);

		System.out.println(user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("users", users);
		System.out.println("users.size():  " + users.size());
		return map;
	}

}
