package com.sy.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.entity.SyMeterType;
import com.sy.service.sy.SyMeterTypeService;


@Repository
public class SelSyMeterType {
	@Autowired
	private SyMeterTypeService syMeterTypeService;
	
	//查询所有表径
	public List<SyMeterType> selSyMeterType(){
		return syMeterTypeService.findAll();
	}
	
}
