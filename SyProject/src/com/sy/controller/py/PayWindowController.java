package com.sy.controller.py;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sy.entity.RdRead;
import com.sy.entity.UsUser;
import com.sy.projectUtils.SfglDto;

/**
 * �����շ�
 * 
 * @author BarryLiu
 *
 */
@Controller
@RequestMapping("/paywindow")
public class PayWindowController extends PyController {

	// ��ѯ�û�,�ڴ����շѵĲ�ѯ�û������һ�β�ѯ������ѯ�����ŵ�session����
	@RequestMapping("/selectUser")
	public String selectUser(HttpServletRequest request,
			HttpServletResponse response, UsUser user, SfglDto dto)
			throws IOException {
		Map<String, Object> map = pyUsUserService
				.selectUser(user, dto, request);
		request.getSession().setAttribute("map", map);
		response.getOutputStream().print("ok");
		return null;
	}

	// �����˴��ڲ�ѯ�û��Ժ�ķ�ҳ��ѯ
	@RequestMapping("/selectUserPage")
	public String selectUserPage(HttpServletRequest request,
			HttpServletResponse response, UsUser user, SfglDto dto)
			throws IOException {
		Map<String, Object> map = pyUsUserService
				.selectUser(user, dto, request);
		request.getSession().setAttribute("map", map);
		return "/SY/page/sys_selectUser.jsp";
	}

	// aJax��ҳ��ѯ��Ʊ
	@RequestMapping("/selectInvoice")
	public String selectInvoice(HttpServletRequest request,
			HttpServletResponse response, SfglDto dto) throws IOException {
		Map<String, Object> map = pyPayService.selectInvoice(dto, request);
		request.getSession().setAttribute("map", map);
		if (map == null)// û���û���½���ܲ�ѯ��Ʊ
			response.getOutputStream().print("fail");
		else
			response.getOutputStream().print("ok");

		return null;
	}

	// aJax��ѯ��Ʊ����id �ŵ�����ȥ
	@RequestMapping("/selectInvoiceByPayNo")
	public String selectInvoiceByPayNo(HttpServletRequest request,
			HttpServletResponse response, String payNo) throws IOException {
		pyPayService.selectInvoiceByPayNo(request, response, payNo);
		return null;
	}

	// ��ҳ��ѯ��Ʊ,
	@RequestMapping("/selectInvoicePage")
	public String selectInvoicePage(HttpServletRequest request,
			HttpServletResponse response, SfglDto dto) throws IOException {
		Map<String, Object> map = pyPayService.selectInvoice(dto, request);
		request.setAttribute("map", map);
		return "/SY/page/pay_window_selectInvoice.jsp";
	}

	// ��ҳ��ѯ�Ժ�ѡ���˽ɷѵı������ѯ��Ʊ
	@RequestMapping("/selectUserByUserNo")
	public String selectUserByUserNo(UsUser user, HttpServletRequest request) {
		pyBillService.selectUser(user, request);
		return "/SY/page/pay_window.jsp";
	}

	// aJax�ɷ�
	@RequestMapping("jiaofei")
	public String jiaofei(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		pyPayService.jiaofei(request, response);
		return null;
	}

	// �޸���ϵ����
	@RequestMapping("updateUserPhoneAndSmsPhone")
	public String updateUserPhoneAndSmsPhone(UsUser user,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println(user);
		user = pyUsUserService.updateUserPhoneAndSmsPhone(user);
		request.setAttribute("user", user);
		response.getOutputStream().print("ok");
		return null;
	}

	// aJax ���� ˮ�ѵı�Ų�ѯˮ�ѵ���ϸ��Ϣ
	@RequestMapping("queryBillDetails")
	public String queryBillDetails(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		pyBillService.selectBillDetails(request, response);
		return null;
	}

	// aJax ���� ˮ�ѵı�Ų�ѯˮ�ѵ���ϸ��Ϣ
	@RequestMapping("queryReadDetails")
	@ResponseBody
	public Map<String, Object> queryReadDetails(String readNo,
			HttpServletResponse response) throws IOException {
		RdRead read = pyBillService.queryReadDetails(readNo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("read", read);
		return map;
	}

	@RequestMapping("changeInvoice")
	public String changeInvoice(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		pyPayService.changeInvoice(request, response);

		return null;
	}
}