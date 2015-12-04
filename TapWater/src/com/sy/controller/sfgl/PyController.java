package com.sy.controller.sfgl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sy.service.sfgl.IvInvoiceService;
import com.sy.service.sfgl.PyBalanceService;
import com.sy.service.sfgl.PyBalancedetailService;
import com.sy.service.sfgl.PyBillService;
import com.sy.service.sfgl.PyBilldetailService;
import com.sy.service.sfgl.PyPayService;
import com.sy.service.sfgl.PySumreportService;
import com.sy.service.sfgl.PyUserhistoryService;
import com.sy.service.sfgl.SYCostTypeService;
import com.sy.service.sfgl.UsUserService;

/**
 * 收费管理
 * @author BarryLiu
 *
 */
@Controller
public class PyController {
	
	@Autowired
	protected PyBillService pyBillService;
	@Autowired
	protected PyBalancedetailService pyBalancedetailService;
	@Autowired
	protected PyBalanceService pyBalanceService;
	@Autowired
	protected PyPayService pyPayService;
	@Autowired
	protected PySumreportService pySumreportService;
	@Autowired
	protected PyUserhistoryService pyUserhistoryService;

	
	
	@Autowired
	protected UsUserService usUserService;
	
	@Autowired
	protected SYCostTypeService syCostTypeService;
	
	@Resource(name="ivInvoiceSer")
	protected IvInvoiceService ivInvoiceService;
	
	
	
}
