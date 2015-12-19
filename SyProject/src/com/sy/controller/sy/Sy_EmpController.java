package com.sy.controller.sy;

import java.io.IOException;
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
import com.sy.entity.SyEmpMenuPower;
import com.sy.service.sy.SyEmpMenuPowerService;
import com.sy.service.sy.SyEmpService;

@Controller
@SessionAttributes(value = { "syDept", "empLogin", "listMenu" })
@RequestMapping("/sy")
public class Sy_EmpController {
	@Autowired
	private SyEmpService syEmpService;
	@Autowired
	private SyEmpMenuPowerService syEmpMenuPowerService;

	/**
	 * ��ѯȫ���Ĳ��ŵ���Ϣ
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
	 * ���ݲ��ŵ�ID ����ѯԱ������Ϣ
	 */
	@RequestMapping("/querySyEmp")
	public String querySyEmp(ModelMap map, HttpServletRequest request) {
		men(map, request);
		return "/SY/page/sys_emp.jsp";
	}

	/**
	 * ���Ա����Ϣ
	 */
	@RequestMapping("/saveEmp")
	public String saveEmp(SyEmp sy, ModelMap map) {
		syEmpService.saveEmp(sy);
		return queryEmp(map);
	}

	/**
	 * ����Ա����idɾ��
	 */
	@RequestMapping("/deleteEmp")
	public String deleteEmp(HttpServletRequest request, ModelMap map) {
		int id = Integer.parseInt(request.getParameter("empId"));
		syEmpService.deleteEmp(id);
		return queryEmp(map);
	}

	@RequestMapping("/queryOneEmp")
	/**
	 * ����ID��ѯ����Ա������Ϣ
	 */
	public String queryOneEmap(HttpServletRequest request, ModelMap map) {
		int id = Integer.parseInt(request.getParameter("empId"));
		SyEmp emp = syEmpService.queryOneEmp(id);
		map.put("emp", emp);
		return "/SY/page/sys_emp_update.jsp";
	}

	/**
	 * �޸�ָ����Ա����Ϣ
	 */
	@RequestMapping("/updateEmp")
	public String updateEmp(SyEmp sy, ModelMap map) {
		syEmpService.updateEmp(sy);
		return queryEmp(map);
	}

	/**
	 * ��ѯȫ��Ա�����ò˵�Ȩ��
	 */
	@RequestMapping("/queryMenupower")
	public String queryMenupower(ModelMap map) {
		List<SyEmp> men = syEmpService.queryEmp_();
		map.put("syEmp", men);
		return "/SY/page/sys_menupower.jsp";
	}

	/**
	 * ���ݲ��ŵ�ID��ѯ��Ӧ��Ա�����ò˵�Ȩ��
	 */
	@RequestMapping("/querySyMenupower")
	public String querySyMenupower(ModelMap map, HttpServletRequest request) {
		men(map, request);
		return "/SY/page/sys_menupower.jsp";
	}

	/**
	 * ��װ���ݲ��ŵ�ID��ѯ��Ӧ��Ա�����ò˵�Ȩ��
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
	 * ���ݲ��ŵ�ID��ѯ��Ӧ��Ա������Ƭ��Ȩ��
	 */
	@RequestMapping("/querySyAreapower")
	public String querySyAreapower(ModelMap map, HttpServletRequest request) {
		men(map, request);
		return "/SY/page/sys_areapower.jsp";
	}

	/**
	 * ��ѯȫ��Ա��Ƭ��Ȩ��
	 */
	@RequestMapping("/queryAreapower")
	public String queryAreapower(ModelMap map, HttpServletRequest request) {
		List<SyEmp> men = syEmpService.queryEmp_();
		map.put("syEmp", men);
		return "/SY/page/sys_areapower.jsp";
	}

	// --------
	/**
	 * ��½��֤
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/queryLogin")
	public String queryLogin(SyEmp sy, ModelMap map,
			HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		sy.setEmpNo(request.getParameter("user"));
		sy.setEmpPwd(request.getParameter("password"));
		SyEmp empLogin = syEmpService.queryLogin(sy);
		if (empLogin != null) {
			List<SyEmpMenuPower> listMenu = syEmpMenuPowerService
					.queryMenu(empLogin.getEmpId());
			map.put("listMenu", listMenu);
			map.put("empLogin", empLogin);
			response.getWriter().write("true");
			return null;
		} else {
			response.getWriter().write("false");
			return null;
		}

	}

	/**
	 * �޸�����
	 */
	@RequestMapping("/updateLogin")
	public String updateLogin(SyEmp sy)
			throws Exception {
		syEmpService.updateEmpLogin(sy);
		return "/SY/login.jsp";
	}

	/**
	 * ���첽����õ�Ա�������Ƿ����
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/isLogin")
	public String isLogin(HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		String name = request.getParameter("name");
		List<SyEmp> login = syEmpService.isLogin(name);
		if (login.size() > 0)
			response.getWriter().write("true");
		else
			response.getWriter().write("false");
		return null;
	}
}
