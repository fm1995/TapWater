package com.sy.controller.sy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.entity.BeFlow;
import com.sy.entity.SyDept;
import com.sy.service.sy.Be_FlowService;


@Controller
@RequestMapping("/sy")
public class Be_FlowController {
	@Autowired
	private Be_FlowService be_flowService;

	/**
	 * 查询全部的流程
	 */
	@RequestMapping("/queryFlow")
	public String queryFlow(ModelMap map) {
		List<BeFlow> flows = be_flowService.queryFlow();
		List<SyDept> depts = be_flowService.queryDept();
		map.put("flows", flows);
		map.put("depts", depts);
		return "/SY/page/sys_flow.jsp";
	}

	/**
	 * 修改部门所在的流程
	 */
	@RequestMapping("/updateFlow")
	public String updateFlow(BeFlow be, ModelMap map, HttpServletRequest request) {
		String[] parameterValues = request.getParameterValues("id");
		String[] deptIds = request.getParameterValues("deptId");
		for (int i = 0; i < parameterValues.length; i++) {
			be.setId(Integer.parseInt(parameterValues[i]));
			be.setDeptId(Integer.parseInt(deptIds[i]));
			be_flowService.updateFlow(be);
		}
		return queryFlow(map);
	}

}
