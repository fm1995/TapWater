package com.sy.controller.sfgl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
	protected UsUserService usUserService;
	
	@Autowired
	protected SYCostTypeService syCostTypeService;
	
}
