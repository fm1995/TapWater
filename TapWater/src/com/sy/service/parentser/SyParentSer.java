package com.sy.service.parentser;

import org.springframework.beans.factory.annotation.Autowired;

import com.sy.mappdao.*;

public class SyParentSer {
	// Sy系列
	@Autowired
	protected SyAreaMapper syAreaMapper;
	@Autowired
	protected SyCostTypeMapper syCostTypeMapper;
	@Autowired
	protected SyDeptMapper syDeptMapper;
	@Autowired
	protected SyEmpAreaPowerMapper syEmpAreaPowerMapper;
	@Autowired
	protected SyEmpMapper syEmpMapper;
	@Autowired
	protected SyEmpMenuPowerMapper syEmpMenuPowerMapper;
	@Autowired
	protected SyMenuMapper syMenuMapper;
	@Autowired
	protected SyMeterTypeMapper syMeterTypeMapper;
	@Autowired
	protected SySurchargeMapper sySurchargeMapper;


}
