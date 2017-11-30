package com.sy.service.sy;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.SyEmpMenuPower;
import com.sy.entity.SyEmpMenuPowerExample;

@Service
public class SyEmpMenuPowerService extends SyParent{
	/**
	 * ����id��ѯԱ������Ӧ�Ĳ˵�Ȩ��
	 */
	public List<SyEmpMenuPower> queryempMenuPower(int id) {
		SyEmpMenuPowerExample example = new SyEmpMenuPowerExample();
		example.createCriteria().andEmpIdEqualTo(id);
		return syEmpMenuPowerMapper.selectByExample(example);
	}

	/**
	 * ����idɾ��Ա������Ӧ�Ĳ˵�Ȩ��
	 */
	public void deleteEmpMenuPower(int id) {
		SyEmpMenuPowerExample example = new SyEmpMenuPowerExample();
		example.createCriteria().andEmpIdEqualTo(id);
		syEmpMenuPowerMapper.deleteByExample(example);
	}
	/**
	 * ���Ա���˵�Ȩ��
	 */
	public void saveEmpMenuPower(SyEmpMenuPower sy) {
		syEmpMenuPowerMapper.insert(sy);
	}
	/**
	 * ��ѯ��½���û�����Ӧ�Ĳ˵�Ȩ����ʾ��ҳ��
	 */
	public List<SyEmpMenuPower> queryMenu(int id)
	{
		return syEmpMenuPowerMapper.selectMenu(id);
	}

}