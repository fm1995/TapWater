package com.sy.service.parentser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.mappdao.*;

@Service
public class PyParentSer {
	// Py系列
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
	
	
	

}
