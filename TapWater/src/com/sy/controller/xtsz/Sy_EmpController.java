package com.sy.controller.xtsz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sy.entity.SyDept;
import com.sy.entity.SyEmp;
import com.sy.service.xtsz.SyEmpService;



@Controller
@SessionAttributes(value = { "syDept", "empLogin" })

@RequestMapping("empctl")
public class Sy_EmpController {
	@Autowired
	private SyEmpService syEmpService;

	/**
	 * 查询全部的部门的信息
	 */
	@RequestMapping("/queryEmp")
	public String queryEmp(ModelMap map) {
		List<SyDept> syDept = syEmpService.queryEmp();
		List<SyEmp> syEmp = syEmpService.queryEmp_();
		map.put("syDept", syDept);
		map.put("syEmp", syEmp);
		return "/SY/page/sys_emp.jsp";
	}

	/**
	 * 根据部门的ID 来查询员工的信息
	 */
	@RequestMapping("/querySyEmp")
	public String querySyEmp(ModelMap map, HttpServletRequest request) {
		men(map, request);
		return "/SY/page/sys_emp.jsp";
	}
	/**
	 * 添加员工信息
	 */
	@RequestMapping("/saveEmp")
	public String saveEmp(SyEmp sy, ModelMap map) {
		syEmpService.saveEmp(sy);
		return queryEmp(map);
	}


	/**
	 * 根据员工的id删除
	 */
	@RequestMapping("/deleteEmp")
	public String deleteEmp(HttpServletRequest request, ModelMap map) {
		int id = Integer.parseInt(request.getParameter("empId"));
		syEmpService.deleteEmp(id);
		return queryEmp(map);
	}

	@RequestMapping("/queryOneEmp")
	/**
	 * 根据ID查询单个员工的信息
	 */
	public String queryOneEmap(HttpServletRequest request, ModelMap map) {
		int id = Integer.parseInt(request.getParameter("empId"));
		SyEmp emp = syEmpService.queryOneEmp(id);
		map.put("emp", emp);
		return "SY/page/sys_emp_update.jsp";
	}
	/**
	 * 修改指定的员工信息
	 */
	@RequestMapping("/updateEmp")
	public String updateEmp(SyEmp sy, ModelMap map) {
		syEmpService.updateEmp(sy);
		return queryEmp(map);
	}

	/**
	 * 查询全部员工设置菜单权限
	 */
	@RequestMapping("/queryMenupower")
	public String queryMenupower(ModelMap map) {
		List<SyEmp> men = syEmpService.queryEmp_();
		map.put("syEmp", men);
		return "/SY/page/sys_menupower.jsp";
	}


	/**
	 * 根据部门的ID查询对应的员工设置菜单权限
	 */
	@RequestMapping("/querySyMenupower")
	public String querySyMenupower(ModelMap map, HttpServletRequest request) {
		men(map, request);
		return "/SY/page/sys_menupower.jsp";
	}
	/**
	 * 封装根据部门的ID查询对应的员工设置菜单权限
	 * 
	 * @param map
	 * @param request
	 */
	private void men(ModelMap map, HttpServletRequest request) {
		List<SyEmp> syEmp = null;
		int empId = Integer.parseInt(request.getParameter("empId"));
		if (empId == 0)
			syEmp = syEmpService.queryEmp_();
		else
			syEmp = syEmpService.querySyEmp(empId);
		map.put("syEmp", syEmp);
		map.put("empId", empId);
	}
	/**
	 * 根据部门的ID查询对应的员工设置片区权限
	 */
	@RequestMapping("/querySyAreapower")
	public String querySyAreapower(ModelMap map, HttpServletRequest request) {
		men(map, request);
		return "/SY/page/sys_areapower.jsp";
	}
	/**
	 * 查询全部员工片区权限
	 */
	@RequestMapping("/queryAreapower")
	public String queryAreapower(ModelMap map, HttpServletRequest request) {
		List<SyEmp> men = syEmpService.queryEmp_();
		map.put("syEmp", men);
		return "/SY/page/sys_areapower.jsp";
	}

	// --------
	/**
	 * 登陆验证
	 * @throws Exception 
	 */
	@RequestMapping("/queryLogin")
	public String queryLogin(SyEmp sy, ModelMap map) throws Exception {
		SyEmp empLogin = syEmpService.queryLogin(sy);
		if (empLogin != null) {
			map.put("empLogin",empLogin);
			return "/sy/workspace.jsp";
		} else {
			return "/sy/login.jsp";
		}

	}
	/**
	 * 修改密码
	 */
	@RequestMapping("/updateLogin")
	public String updateLogin(SyEmp sy,ModelMap map) throws Exception
	{    System.out.println(sy.getEmpId());
		syEmpService.updateEmpLogin(sy);
		return queryLogin(sy,map);
	}
}
