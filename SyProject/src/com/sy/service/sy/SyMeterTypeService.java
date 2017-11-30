package com.sy.service.sy;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.SyMeterType;

@Service
public class SyMeterTypeService extends SyParent {
	/**
	 * ���ˮ����
	 */
	public void saveMeter(SyMeterType sy) {
		syMeterTypeMapper.insert(sy);
	}

	/**
	 * ��ѯȫ��ˮ���ͺ�
	 */
	public List<SyMeterType> queryMeter() {
		return syMeterTypeMapper.selectByExample(null);
	}

	/**
	 * ɾ�� ˮ���ͱ�
	 */
	public void deleteMeter(int id) {
		syMeterTypeMapper.deleteByPrimaryKey(id);
	}

	/**
	 * ��ѯ����
	 */
	public SyMeterType queryOneMeter(int id) {
		return syMeterTypeMapper.selectByPrimaryKey(id);
	}

	/**
	 * �޸�
	 */
	public void updateMeter(SyMeterType sy) {
		syMeterTypeMapper.updateByPrimaryKey(sy);
	}

	/**
	 * ��ѯȫ����ˮ����
	 */
	public List<SyMeterType> findAll() {
		List<SyMeterType> list = syMeterTypeMapper.selectAll();
		return list;

	}
}