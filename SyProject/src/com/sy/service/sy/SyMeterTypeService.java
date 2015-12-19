package com.sy.service.sy;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.SyMeterType;

@Service
public class SyMeterTypeService extends SyParent {
	/**
	 * 添加水类型
	 */
	public void saveMeter(SyMeterType sy) {
		syMeterTypeMapper.insert(sy);
	}

	/**
	 * 查询全部水表型号
	 */
	public List<SyMeterType> queryMeter() {
		return syMeterTypeMapper.selectByExample(null);
	}

	/**
	 * 删除 水类型表
	 */
	public void deleteMeter(int id) {
		syMeterTypeMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 查询单个
	 */
	public SyMeterType queryOneMeter(int id) {
		return syMeterTypeMapper.selectByPrimaryKey(id);
	}

	/**
	 * 修改
	 */
	public void updateMeter(SyMeterType sy) {
		syMeterTypeMapper.updateByPrimaryKey(sy);
	}

	/**
	 * 查询全部的水类型
	 */
	public List<SyMeterType> findAll() {
		List<SyMeterType> list = syMeterTypeMapper.selectAll();
		return list;

	}
}