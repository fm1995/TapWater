package com.sy.service.sy;

import org.springframework.beans.factory.annotation.Autowired;

import com.sy.mappdao.*;

public class SyParent {
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
	@Autowired 
	protected BeFlowMapper beFlowMapper;
	@Autowired 
	protected UsUserMapper usUserMapper;
}
