package com.sy.service.sy;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.SyEmpMenuPower;
import com.sy.entity.SyEmpMenuPowerExample;

@Service
public class SyEmpMenuPowerService extends SyParent{
	/**
	 * 根据id查询员工所对应的菜单权限
	 */
	public List<SyEmpMenuPower> queryempMenuPower(int id) {
		SyEmpMenuPowerExample example = new SyEmpMenuPowerExample();
		example.createCriteria().andEmpIdEqualTo(id);
		return syEmpMenuPowerMapper.selectByExample(example);
	}

	/**
	 * 根据id删除员工所对应的菜单权限
	 */
	public void deleteEmpMenuPower(int id) {
		SyEmpMenuPowerExample example = new SyEmpMenuPowerExample();
		example.createCriteria().andEmpIdEqualTo(id);
		syEmpMenuPowerMapper.deleteByExample(example);
	}
	/**
	 * 添加员工菜单权限
	 */
	public void saveEmpMenuPower(SyEmpMenuPower sy) {
		syEmpMenuPowerMapper.insert(sy);
	}
	/**
	 * 查询登陆的用户名对应的菜单权限显示主页面
	 */
	public List<SyEmpMenuPower> queryMenu(int id)
	{
		return syEmpMenuPowerMapper.selectMenu(id);
	}

}