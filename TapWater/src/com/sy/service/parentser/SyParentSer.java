package com.sy.service.parentser;

import org.springframework.beans.factory.annotation.Autowired;

import com.sy.mappdao.*;

public class SyParentSer {
	// Sy系列
	@Autowired
	private SyAreaMapper syAreaMapper;
	@Autowired
	private SyCostTypeMapper syCostTypeMapper;
	@Autowired
	private SyDeptMapper syDeptMapper;
	@Autowired
	private SyEmpAreaPowerMapper syEmpAreaPowerMapper;
	@Autowired
	private SyEmpMapper syEmpMapper;
	@Autowired
	private SyEmpMenuPowerMapper syEmpMenuPowerMapper;
	@Autowired
	private SyMenuMapper syMenuMapper;
	@Autowired
	private SyMeterTypeMapper syMeterTypeMapper;
	@Autowired
	private SySurchargeMapper sySurchargeMapper;

	public SyAreaMapper getSyAreaMapper() {
		return syAreaMapper;
	}

	public void setSyAreaMapper(SyAreaMapper syAreaMapper) {
		this.syAreaMapper = syAreaMapper;
	}

	public SyCostTypeMapper getSyCostTypeMapper() {
		return syCostTypeMapper;
	}

	public void setSyCostTypeMapper(SyCostTypeMapper syCostTypeMapper) {
		this.syCostTypeMapper = syCostTypeMapper;
	}

	public SyDeptMapper getSyDeptMapper() {
		return syDeptMapper;
	}

	public void setSyDeptMapper(SyDeptMapper syDeptMapper) {
		this.syDeptMapper = syDeptMapper;
	}

	public SyEmpAreaPowerMapper getSyEmpAreaPowerMapper() {
		return syEmpAreaPowerMapper;
	}

	public void setSyEmpAreaPowerMapper(
			SyEmpAreaPowerMapper syEmpAreaPowerMapper) {
		this.syEmpAreaPowerMapper = syEmpAreaPowerMapper;
	}

	public SyEmpMapper getSyEmpMapper() {
		return syEmpMapper;
	}

	public void setSyEmpMapper(SyEmpMapper syEmpMapper) {
		this.syEmpMapper = syEmpMapper;
	}

	public SyEmpMenuPowerMapper getSyEmpMenuPowerMapper() {
		return syEmpMenuPowerMapper;
	}

	public void setSyEmpMenuPowerMapper(
			SyEmpMenuPowerMapper syEmpMenuPowerMapper) {
		this.syEmpMenuPowerMapper = syEmpMenuPowerMapper;
	}

	public SyMenuMapper getSyMenuMapper() {
		return syMenuMapper;
	}

	public void setSyMenuMapper(SyMenuMapper syMenuMapper) {
		this.syMenuMapper = syMenuMapper;
	}

	public SyMeterTypeMapper getSyMeterTypeMapper() {
		return syMeterTypeMapper;
	}

	public void setSyMeterTypeMapper(SyMeterTypeMapper syMeterTypeMapper) {
		this.syMeterTypeMapper = syMeterTypeMapper;
	}

	public SySurchargeMapper getSySurchargeMapper() {
		return sySurchargeMapper;
	}

	public void setSySurchargeMapper(SySurchargeMapper sySurchargeMapper) {
		this.sySurchargeMapper = sySurchargeMapper;
	}

}
