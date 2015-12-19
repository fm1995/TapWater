package com.sy.controller.py;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sy.service.py.PyBalanceService;
import com.sy.service.py.PyBalancedetailService;
import com.sy.service.py.PyBillService;
import com.sy.service.py.PyBilldetailService;
import com.sy.service.py.PyPayService;
import com.sy.service.py.PySYCostTypeService;
import com.sy.service.py.PySumreportService;
import com.sy.service.py.PyUsUserService;
import com.sy.service.py.PyUserhistoryService;

/**
 * 收费管理
 * @author BarryLiu
 *
 */
@Controller
public class PyController {
	
	@Autowired
	protected PyBalancedetailService PyBalancedetailService;
	@Autowired
	protected PyBalanceService pyBalanceService;
	@Autowired
	protected PyBilldetailService pyBilldetailService;
	@Autowired
	protected PyBalancedetailService pyBalancedetailService;
	@Autowired
	protected PyBillService pyBillService;
	@Autowired
	protected PySumreportService pySumreportService;
 
	@Autowired
	protected PyPayService pyPayService;
	@Autowired
	protected PySYCostTypeService pySYCostTypeService;
	 
	@Autowired
	protected PyUserhistoryService pyUserhistoryService;
	@Autowired
	protected PyUsUserService pyUsUserService;
 
	 
	 
	 
	
	
	
}
