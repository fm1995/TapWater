package com.sy.controller.sy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.entity.SyEmp;
import com.sy.entity.SyEmpAreaPower;
import com.sy.service.sy.SyEmpAreaPowerService;
import com.sy.service.sy.SyEmpService;



@Controller
@RequestMapping("/sy")
public class Sy_EmpAreaPowerController {
	@Autowired
	private SyEmpAreaPowerService syEmpAreaPowerService;
	@Autowired
	private SyEmpService syEmpService;
	/**
	 * ˢ��ҳ��
	 */
	public String queryMenupower(ModelMap map) {
		List<SyEmp> men = syEmpService.queryEmp_();
		map.put("syEmp", men);
		return "/SY/page/sys_areapower.jsp";
	}
	

	/**
	 * ���Ա����Ƭ��Ȩ��һ�Զ�
	 */
	@RequestMapping("/saveempAreaPower")
	public String saveempAreaPower(SyEmpAreaPower sy, HttpServletRequest request,ModelMap map) {
		String[] eid = request.getParameterValues("empid");
		String[] areaId = request.getParameterValues("areaid");
		if (eid.length == 1) {
			syEmpAreaPowerService.deleteempAreaPower(Integer.parseInt(eid[0]));
			sy.setEmpId(Integer.parseInt(eid[0]));
			for (int i = 0; i < areaId.length; i++) {
				sy.setAreaId(Integer.parseInt(areaId[i]));
				syEmpAreaPowerService.saveempAreaPower(sy);
			}
		} else {
			for (int j = 0; j < eid.length; j++) {
				syEmpAreaPowerService.deleteempAreaPower(Integer
						.parseInt(eid[j]));
				for (int i = 0; i < areaId.length; i++) {
					sy.setAreaId(Integer.parseInt(areaId[i]));
					sy.setEmpId(Integer.parseInt(eid[j]));
					syEmpAreaPowerService.saveempAreaPower(sy);
				}
			}
		} 
		return queryMenupower(map);
	}

}
