package com.sy.service.py;

import org.springframework.beans.factory.annotation.Autowired;

import com.sy.mappdao.*;

public class PyParent {
	@Autowired
	protected PyBalancedetailMapper pyBalancedetailMapper;
	@Autowired
	protected PyBalanceMapper pyBalanceMapper;
	@Autowired
	protected PyBilldetailMapper pyBilldetailMapper;
	@Autowired
	protected PyBillMapper pyBillMapper;
	@Autowired
	protected PyPayMapper pyPayMapper;
	@Autowired
	protected PySumreportMapper pySumreportMapper;
	@Autowired
	protected PyUserhistoryMapper pyUserhistoryMapper;
	
	@Autowired
	protected SyCostTypeMapper syCostTypeMapper;
	@Autowired
	protected RdReadMapper rdReadMapper;
	@Autowired
	protected IvInvoiceMapper ivInvoiceMapper;
	@Autowired
	protected SyEmpMapper syEmpMapper;
	@Autowired
	protected RdVolumeMapper rdVolumeMapper;
	@Autowired
	protected SyMeterTypeMapper syMeterTypeMapper;
	@Autowired
	protected UsUserMapper usUserMapper;
	@Autowired
	protected UsMeterMapper usMeterMapper;
	@Autowired
	protected SyAreaMapper syAreaMapper;
	@Autowired
	protected SySurchargeMapper sySurchargeMapper;
	
	
	
}
