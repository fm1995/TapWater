package com.sy.controller.sy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.entity.SyMeterType;
import com.sy.service.sy.SyMeterTypeService;



@Controller
@RequestMapping("/sy")
public class Sy_MeterController {
	@Autowired
	private SyMeterTypeService syMeterTypeService;

	/**
	 * ���ˮ���ͺ�
	 */
	@RequestMapping("/saveMeter")
	public String saveMeter(SyMeterType sy, ModelMap map) {
		if (sy != null)
			syMeterTypeService.saveMeter(sy);
		return queryMeter(map);
	}
	/**
	 * ��ѯȫ��ˮ���ͺ�
	 */
	@RequestMapping("/queryMeter")
	public String queryMeter(ModelMap map) {
		List<SyMeterType> list =syMeterTypeService.queryMeter();
		map.put("list", list);
		return "/SY/page/sys_meterType.jsp";
	}
	/**
	 * ɾ��ˮ���ͺ�
	 */
	@RequestMapping("/deleteMeter")
	public String deleteArea(ModelMap map, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		syMeterTypeService.deleteMeter(id);
		return queryMeter(map);
	}

	/**
	 * ��ѯ����
	 */
	@RequestMapping("/queryOneMeter")
	public String queryOneMeter(HttpServletRequest request, ModelMap map) {
		int id = Integer.parseInt(request.getParameter("typeId"));
		SyMeterType syMeter = syMeterTypeService.queryOneMeter(id);
		map.put("syMeter", syMeter);
		return "/SY/page/sys_meterType_update.jsp";
	}

	/**
	 * �޸�
	 */
	@RequestMapping("/updateMeter")
	public String updateMeter(SyMeterType sy, ModelMap map) {
		if (sy != null)
			syMeterTypeService.updateMeter(sy);
		return queryMeter(map);
	}

}
