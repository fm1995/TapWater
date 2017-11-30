package com.sy.service.sy;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.SyEmpAreaPower;
import com.sy.entity.SyEmpAreaPowerExample;

@Service
public class SyEmpAreaPowerService extends SyParent{
	/**
	 * 添加员工辖区权限
	 */
	public void saveempAreaPower(SyEmpAreaPower sy) {
		syEmpAreaPowerMapper.insert(sy);
	}
	/**
	 * 根据id查询员工所对应的辖区权限
	 */
	public List<SyEmpAreaPower> queryempAreaPower(int id) {
		SyEmpAreaPowerExample example = new SyEmpAreaPowerExample();
		example.createCriteria().andEmpIdEqualTo(id);
		return syEmpAreaPowerMapper.selectByExample(example);
	}
	/**
	 * 根据id删除员工所对应的辖区权限
	 */
	public void deleteempAreaPower(int id)
	{		SyEmpAreaPowerExample example=new SyEmpAreaPowerExample();
			example.createCriteria().andEmpIdEqualTo(id);
			syEmpAreaPowerMapper.deleteByExample(example);
	}
}