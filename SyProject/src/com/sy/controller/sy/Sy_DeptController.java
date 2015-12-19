package com.sy.controller.sy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.entity.SyDept;
import com.sy.service.sy.SyDeptService;



@Controller
@RequestMapping("/sy")
public class Sy_DeptController {
	@Autowired
   private SyDeptService syDeptService;
	/**
	 * 添加部门
	 * 
	 * @param sy
	 */
	@RequestMapping("/saveDept")
	public String saveDept(SyDept sy, ModelMap map) {
		if(sy!=null)
			syDeptService.saveDept(sy);
		return queryDept(map);
	}

	/**
	 * 查询全部部门
	 * 
	 * @return
	 */
	@RequestMapping("/queryDept")
	public String queryDept(ModelMap map) {
		List<SyDept> list = syDeptService.queryDept();
		map.put("listDept", list);
		return "/SY/page/sys_dept.jsp";
	}

	/**
	 * 删除部门
	 * 
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteDept")
	public String deleteDept(ModelMap map, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		syDeptService.deleteDept(id);
		return queryDept(map);
	}

	/**
	 * 查询单个部门
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("/queryOneDept")
	public String queryOneDept(HttpServletRequest request, ModelMap map) {
		int id = Integer.parseInt(request.getParameter("deptId"));
		SyDept syDept = syDeptService.queryOneDept(id);
		map.put("syDept", syDept);
		return "/SY/page/sys_dept_update.jsp";
	}

	/**
	 * 修改部门
	 */       
	@RequestMapping("/updateDept")
	public String updateDept(SyDept sy, ModelMap map) {
		if(sy!=null)
			syDeptService.updateDept(sy);
		return queryDept(map);
	}

}
