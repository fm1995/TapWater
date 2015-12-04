package com.sy.service.parentser;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.mappdao.PyBillMapper;
import com.sy.mappdao.PyPayMapper;
import com.sy.mappdao.UsFormulaMapper;
import com.sy.mappdao.UsMeterMapper;
import com.sy.mappdao.UsSmsMapper;
import com.sy.mappdao.UsUserMapper;

@Service
public class UsParentSer{
	
	// Us系列
	@Autowired
	protected UsFormulaMapper usFormulaMapper;
	@Autowired
	protected UsMeterMapper usMeterMapper;
	@Autowired
	protected UsSmsMapper usSmsMapper;
	@Autowired
	protected  UsUserMapper usUserMapper;
	@Autowired
	protected  PyBillMapper pyBillMapper;
	@Autowired
	protected  PyPayMapper pyPayMapper;
	
	
 
	
}
