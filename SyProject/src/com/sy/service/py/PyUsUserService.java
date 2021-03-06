package com.sy.service.py;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.sy.entity.UsUser;
import com.sy.projectUtils.SfglDto;
import com.sy.projectUtils.SfglUtils;
import com.sy.service.us.UsParent;

@Service
public class PyUsUserService extends UsParent implements ParentSerI<UsUser> {


	@Override
	public List<UsUser> getAll() {
		return getUsUserMapper().selectByExample(null);
	}

	@Override
	public UsUser selectByPrimaryKey(String id) {
		return getUsUserMapper().selectByPrimaryKey(id);
	}

	@Override
	public int insert(UsUser entity) {
		return getUsUserMapper().insert(entity);
	}

	@Override
	public int update(UsUser entity) {
		return getUsUserMapper().updateByPrimaryKey(entity);
	}

	@Override
	public int delete(String id) {
		return getUsUserMapper().deleteByPrimaryKey(id);
	}

	 
	// ======================收费窗口 查询用户
	public Map<String, Object> selectUser(UsUser user, SfglDto dto , HttpServletRequest request) {
		Integer page = dto.getPage();
		Integer rows = dto.getRows();
		
		String whereStr = (String) request.getSession().getAttribute("whereStr");
		if(dto.getUserMoney()!=null){//userMoney没什么意义,只是表示有值就是Ajax查询
			whereStr = SfglUtils.getSqlWhereByUsUser(user);
			System.out.println("重新查询");
		}
		request.getSession().setAttribute("whereStr", whereStr);
		
		System.out.println("whereStr:"+whereStr+" page:"+page+" rows:"+rows);
		//List<UsUser> users = usUserMapper.selectByExample(example);
		//List<UsUser> users=usUserMapper.selectUser(user,(page-1)*rows,rows);
		List<UsUser> users=getUsUserMapper().selectUserByWhere(whereStr,(page-1)*rows,rows);
		Integer total = getUsUserMapper().selectUserCountByWhere(whereStr,(page-1)*rows,rows);
		System.out.println(user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("users", users);
		map.put("page", page);
		map.put("rows", rows);
		total=total==null?0:total;
		int pageCount = (int) Math.ceil(total / (rows * 1.0));
		map.put("pageCount", pageCount);
		if(dto.getPageCount()!=null)
			map.put("pageCount", dto.getPageCount());
		System.out.println("users.size():  " + users.size());
		return map;
	}
	/**修改用户的手机,短息手机和地址的值*/
	public UsUser updateUserPhoneAndSmsPhone(UsUser user) {
		UsUser usUser = selectByPrimaryKey(user.getUserNo());
		usUser.setPhone(user.getPhone());
		usUser.setSmsPhone(user.getSmsPhone());
		usUser.setAddress(user.getAddress());
		update(usUser);
		return usUser;
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
		return getUsUserMapper().selectYSList((page - 1) * rows, rows, userMoney);
	}

	/**
	 * 查询所有的预收的数据 的数量
	 * 
	 * @param page
	 * @param rows
	 * @param userMoney
	 * @return
	 */
	public Integer selectYSListCount(int page, int rows, Integer userMoney) {
		return getUsUserMapper().selectYSListCount((page - 1) * rows, rows,
				userMoney);
	}
	/**查询用户预收情况报表  
	 * */
	public Map<String, Object> yushou(int page, int rows, Integer userMoney) {
		System.out.println("this:"+this+" page:"+page+" rows:"+rows+" userMoney:"+userMoney);
		
		Integer total = selectYSListCount(1, rows, userMoney);//查询出一共有多少条数据
		List<UsUser> users = selectYSList(page, rows, userMoney);//查询当前页面的数据
		//查询总预收金额
		Double moneys = getUsUserMapper().selectYSMonenys((page - 1) * rows, rows,
				userMoney);
		
		//放到Map 容器里面返回jsp 页面
		Map<String, Object> map = new HashMap<String, Object>();
		total=total!= null ? total : 0;
		map.put("total", total);
		map.put("rows", users);
		map.put("moneys", moneys != null ? moneys : 0.0);
		map.put("userMoney", userMoney);
		int pageCount = (int) Math.ceil(total / (rows * 1.0));
		map.put("page", page);
		map.put("pageCount", pageCount);
		return map;
	}
}
