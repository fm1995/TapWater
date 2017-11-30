package com.sy.service.us;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.mappdao.*;

@Service
public class UsParent {
	@Autowired
	private UsFormulaMapper usFormulaMapper;
	@Autowired
	private UsMeterMapper usMeterMapper;
	@Autowired
	private UsSmsMapper usSmsMapper;
	@Autowired
	private UsUserMapper usUserMapper;
	@Autowired
	private BeOrderliteMapper orderLiteMapper;
	@Autowired
	private SyEmpMapper empMapper;
	@Autowired
	private SyMeterTypeMapper syMeterTypeMapper;
	
	public SyMeterTypeMapper getSyMeterTypeMapper() {
		return syMeterTypeMapper;
	}

	public void setSyMeterTypeMapper(SyMeterTypeMapper syMeterTypeMapper) {
		this.syMeterTypeMapper = syMeterTypeMapper;
	}

	public SyEmpMapper getEmpMapper() {
		return empMapper;
	}

	public void setEmpMapper(SyEmpMapper empMapper) {
		this.empMapper = empMapper;
	}

	public BeOrderliteMapper getOrderLiteMapper() {
		return orderLiteMapper;
	}

	public void setOrderLiteMapper(BeOrderliteMapper orderLiteMapper) {
		this.orderLiteMapper = orderLiteMapper;
	}

	public UsFormulaMapper getUsFormulaMapper() {
		return usFormulaMapper;
	}

	public void setUsFormulaMapper(UsFormulaMapper usFormulaMapper) {
		this.usFormulaMapper = usFormulaMapper;
	}

	public UsMeterMapper getUsMeterMapper() {
		return usMeterMapper;
	}

	public void setUsMeterMapper(UsMeterMapper usMeterMapper) {
		this.usMeterMapper = usMeterMapper;
	}

	public UsSmsMapper getUsSmsMapper() {
		return usSmsMapper;
	}

	public void setUsSmsMapper(UsSmsMapper usSmsMapper) {
		this.usSmsMapper = usSmsMapper;
	}

	public UsUserMapper getUsUserMapper() {
		return usUserMapper;
	}

	public void setUsUserMapper(UsUserMapper usUserMapper) {
		this.usUserMapper = usUserMapper;
	}

}
