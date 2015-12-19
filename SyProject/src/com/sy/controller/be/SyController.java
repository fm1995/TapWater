package com.sy.controller.be;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.entity.SyMeterType;
import com.sy.service.sy.SyMeterTypeService;

@Controller
@RequestMapping("/symetertype")
public class SyController {
	@Autowired
	//查询表径
	SyMeterTypeService syMeterTypeService;
	@RequestMapping("/find")
	public String findAll(Map<String,Object> model){
		List<SyMeterType> list=syMeterTypeService.findAll();
		System.out.println(list.size());
		model.put("list", list);
		return "/SY/page/be/be_request1.jsp";
	}
	//过户查询表径
	@RequestMapping("/find2")
	public String findAll2(Map<String,Object> model){
		List<SyMeterType> list=syMeterTypeService.findAll();
		System.out.println(list.size());
		model.put("list", list);
		return "/SY/page/be/be_request2.jsp";
	}
	
	
	
}
