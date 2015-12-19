package com.sy.service.sy;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.SyEmpAreaPower;
import com.sy.entity.SyEmpAreaPowerExample;

@Service
public class SyEmpAreaPowerService extends SyParent{
	/**
	 * ���Ա��Ͻ��Ȩ��
	 */
	public void saveempAreaPower(SyEmpAreaPower sy) {
		syEmpAreaPowerMapper.insert(sy);
	}
	/**
	 * ����id��ѯԱ������Ӧ��Ͻ��Ȩ��
	 */
	public List<SyEmpAreaPower> queryempAreaPower(int id) {
		SyEmpAreaPowerExample example = new SyEmpAreaPowerExample();
		example.createCriteria().andEmpIdEqualTo(id);
		return syEmpAreaPowerMapper.selectByExample(example);
	}
	/**
	 * ����idɾ��Ա������Ӧ��Ͻ��Ȩ��
	 */
	public void deleteempAreaPower(int id)
	{		SyEmpAreaPowerExample example=new SyEmpAreaPowerExample();
			example.createCriteria().andEmpIdEqualTo(id);
			syEmpAreaPowerMapper.deleteByExample(example);
	}
}