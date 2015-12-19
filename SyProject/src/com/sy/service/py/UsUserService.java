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

@Service("userService")
public class UsUserService extends UsParent implements ParentSerI<UsUser> {


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
		
		System.out.println("whereStr:"+whereStr);
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
	/**窗口收,缴费*/
	public void jiaofei(HttpServletRequest request) {
		
		String userNo = request.getParameter("userNo");
		String fapiao = request.getParameter("fapiao");
		String jiaofei = request.getParameter("jiaofei");
		System.out.println("userNo: "+userNo+" fapiao:"+fapiao+" jiaofei:"+jiaofei);
		
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

}
