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
 * 窗口收费
 * 
 * @author BarryLiu
 *
 */
@Controller
@RequestMapping("/paywindow")
public class PayWindowController extends PyController {

	// 查询用户,在窗口收费的查询用户里面第一次查询并将查询条件放到session域中
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

	// 进入了窗口查询用户以后的分页查询
	@RequestMapping("/selectUserPage")
	public String selectUserPage(HttpServletRequest request,
			HttpServletResponse response, UsUser user, SfglDto dto)
			throws IOException {
		Map<String, Object> map = pyUsUserService
				.selectUser(user, dto, request);
		request.getSession().setAttribute("map", map);
		return "/SY/page/sys_selectUser.jsp";
	}

	// aJax分页查询发票
	@RequestMapping("/selectInvoice")
	public String selectInvoice(HttpServletRequest request,
			HttpServletResponse response, SfglDto dto) throws IOException {
		Map<String, Object> map = pyPayService.selectInvoice(dto, request);
		request.getSession().setAttribute("map", map);
		if (map == null)// 没有用户登陆不能查询发票
			response.getOutputStream().print("fail");
		else
			response.getOutputStream().print("ok");

		return null;
	}

	// aJax查询发票跟据id 放到域中去
	@RequestMapping("/selectInvoiceByPayNo")
	public String selectInvoiceByPayNo(HttpServletRequest request,
			HttpServletResponse response, String payNo) throws IOException {
		pyPayService.selectInvoiceByPayNo(request, response, payNo);
		return null;
	}

	// 分页查询发票,
	@RequestMapping("/selectInvoicePage")
	public String selectInvoicePage(HttpServletRequest request,
			HttpServletResponse response, SfglDto dto) throws IOException {
		Map<String, Object> map = pyPayService.selectInvoice(dto, request);
		request.setAttribute("map", map);
		return "/SY/page/pay_window_selectInvoice.jsp";
	}

	// 分页查询以后选择了缴费的编号来查询发票
	@RequestMapping("/selectUserByUserNo")
	public String selectUserByUserNo(UsUser user, HttpServletRequest request) {
		pyBillService.selectUser(user, request);
		return "/SY/page/pay_window.jsp";
	}

	// aJax缴费
	@RequestMapping("jiaofei")
	public String jiaofei(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		pyPayService.jiaofei(request, response);
		return null;
	}

	// 修改联系资料
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

	// aJax 根据 水费的编号查询水费的详细信息
	@RequestMapping("queryBillDetails")
	public String queryBillDetails(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		pyBillService.selectBillDetails(request, response);
		return null;
	}

	// aJax 根据 水费的编号查询水费的详细信息
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
