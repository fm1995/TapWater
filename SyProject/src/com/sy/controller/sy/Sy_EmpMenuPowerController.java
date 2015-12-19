package com.sy.controller.sy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.entity.SyEmp;
import com.sy.entity.SyEmpMenuPower;
import com.sy.service.sy.SyEmpMenuPowerService;
import com.sy.service.sy.SyEmpService;

@Controller
@RequestMapping("/sy")
public class Sy_EmpMenuPowerController {

	@Autowired
	private SyEmpMenuPowerService syEmpMenuPowerService;
	@Autowired
	private SyEmpService syEmpService;

	/**
	 * 添加员工与菜单权限一对多
	 */
	@RequestMapping("/saveSyMenuPower")
	public String saveEmpMenuPower(SyEmpMenuPower sy,
			HttpServletRequest request, ModelMap map) {
		String[] eid = request.getParameterValues("empid");
		String[] menuId = request.getParameterValues("menuid");
		if (eid.length == 1) {
			syEmpMenuPowerService.deleteEmpMenuPower(Integer.parseInt(eid[0]));
			sy.setEmpId(Integer.parseInt(eid[0]));
			for (int i = 0; i < menuId.length; i++) {
				sy.setMenuId(Integer.parseInt(menuId[i]));
				syEmpMenuPowerService.saveEmpMenuPower(sy);
			}
		} else {
			for (int j = 0; j < eid.length; j++) {
				syEmpMenuPowerService.deleteEmpMenuPower(Integer
						.parseInt(eid[j]));
				for (int i = 0; i < menuId.length; i++) {
					sy.setMenuId(Integer.parseInt(menuId[i]));
					sy.setEmpId(Integer.parseInt(eid[j]));
					syEmpMenuPowerService.saveEmpMenuPower(sy);
				}
			}
		}
		return queryMenupower(map);
	}

	/**
	 * 刷新页面
	 */
	public String queryMenupower(ModelMap map) {
		List<SyEmp> men = syEmpService.queryEmp_();
		map.put("syEmp", men);
		return "/SY/page/sys_menupower.jsp";
	}
}
