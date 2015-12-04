package com.sy.service.sfgl;

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
	protected UsUserMapper usUserMapper;
	
}
