package com.sy.controller.sy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.entity.SyArea;
import com.sy.entity.SyEmp;
import com.sy.entity.SyEmpAreaPower;
import com.sy.entity.SyEmpMenuPower;
import com.sy.entity.SyMenu;
import com.sy.service.sy.SyAreaService;
import com.sy.service.sy.SyEmpAreaPowerService;
import com.sy.service.sy.SyEmpMenuPowerService;
import com.sy.service.sy.SyEmpService;
import com.sy.service.sy.SyMenuService;

@Controller
@RequestMapping("/sy")
public class Sy_AreaController {
	@Autowired
	private SyAreaService syAreaService;
	@Autowired
	private SyEmpService syEmpService;
	@Autowired
	private SyEmpAreaPowerService syEmpAreaPowerService;
	@Autowired
	private SyEmpMenuPowerService syEmpMenuPowerService;
	@Autowired
	private SyMenuService syMenuService;

	/**
	 * ��� ����Ͻ��
	 */
	@RequestMapping("/saveArea")
	public String saveArea(SyArea sy, ModelMap map) {
		if (sy != null)
			syAreaService.saveArea(sy);
		return queryArea(map);
	}

	/**
	 * ��ѯȫ������Ͻ��
	 * 
	 * @return
	 */
	@RequestMapping("/queryArea")
	public String queryArea(ModelMap map) {
		List<SyArea> list = syAreaService.queryArea();
		map.put("list", list);
		return "/SY/page/sys_area.jsp";
	}

	/**
	 * ɾ������Ͻ��
	 */
	@RequestMapping("/deleteArea")
	public String deleteArea(ModelMap map, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		syAreaService.deleteArea(id);
		return queryArea(map);
	}

	/**
	 * ��ѯ����
	 */
	@RequestMapping("/queryOne")
	public String queryOne(HttpServletRequest request, ModelMap map) {
		int id = Integer.parseInt(request.getParameter("id"));
		SyArea syArea = syAreaService.queryOne(id);
		map.put("syArea", syArea);
		return "/SY/page/sys_area_update.jsp";
	}

	/**
	 * �޸�
	 */
	@RequestMapping("/updateArea")
	public String updateArea(SyArea sy, ModelMap map) {
		syAreaService.updateArea(sy);
		return queryArea(map);
	}

	// --------------------------------------------------------------
	/**
	 * ����ѡ�еĶ�ѡ���ѯԱ����Ӧ������Ƭ��Ȩ��
	 */
	@RequestMapping("/queryEmpAreaPower")
	public String queryEmpAreaPower(ModelMap map, HttpServletRequest request) {
		String empid[] = request.getParameterValues("emp");
		String empName = "";
		List<SyEmpAreaPower> list = null;
		int id = 0;
		if (empid != null) {
			for (int i = 0; i < empid.length; i++) {
				SyEmp emp = syEmpService
						.queryOneEmp(Integer.parseInt(empid[i]));
				id = emp.getEmpId();
				empName += emp.getEmpName() + ",";
			}
			empName = empName.substring(0, empName.length() - 1);
			List<SyArea> lists = syAreaService.queryArea();
			if (empid.length == 1) {
				list = syEmpAreaPowerService.queryempAreaPower(id);
			}
			map.put("empid", empid);
			map.put("li", list);
			map.put("empName", empName);
			map.put("list", lists);
			return "/SY/page/sys_areapower_set.jsp";
		}
		return queryMenupower1(map);
	}

	/**
	 * ����ѡ�еĶ�ѡ���ѯԱ����Ӧ������Ƭ��Ȩ��
	 */
	@RequestMapping("/queryEmpMenuPower")
	public String queryEmpMenuPower(ModelMap map, HttpServletRequest request) {
		String empid[] = request.getParameterValues("emp");
		String empName = "";
		List<SyEmpMenuPower> list = null;
		int id = 0;
		if (empid != null) {
			for (int i = 0; i < empid.length; i++) {
				SyEmp emp = syEmpService
						.queryOneEmp(Integer.parseInt(empid[i]));
				id = emp.getEmpId();
				empName += emp.getEmpName() + ",";
			}
			empName = empName.substring(0, empName.length() - 1);
			List<SyMenu> lists = syMenuService.querySyMenu();
			if (empid.length == 1) {
				list = syEmpMenuPowerService.queryempMenuPower(id);
			}
			map.put("empid", empid);
			map.put("li", list);
			map.put("empName", empName);
			map.put("list", lists);
			return "/SY/page/sys_menupower_set.jsp";
		}
		return queryMenupower2(map);
	}

	/**
	 * ˢ��ҳ��
	 */
	public String queryMenupower1(ModelMap map) {
		List<SyEmp> men = syEmpService.queryEmp_();
		map.put("syEmp", men);
		return "/SY/page/sys_areapower.jsp";
	}

	/**
	 * ˢ��ҳ��
	 */
	public String queryMenupower2(ModelMap map) {
		List<SyEmp> men = syEmpService.queryEmp_();
		map.put("syEmp", men);
		return "/SY/page/sys_menupower.jsp";
	}

}
