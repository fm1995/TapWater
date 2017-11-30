package com.sy.controller.py;

import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sy.projectUtils.SfglDto;

/**
 * 数据报表
 * 
 * @author BarryLiu
 */
@Controller
@RequestMapping("/report")
public class ReportController extends PyController {

	// 用户预收情况报表
	@RequestMapping("/yushou")
	public String yushou(SfglDto report, HttpServletRequest request) {
		Map<String, Object> map = pyUsUserService.yushou(report.getPage(),
				report.getRows(), report.getUserMoney());
		request.setAttribute("map", map);
		return "/SY/page/pay_reportBalance.jsp";
	}

	// 月资金回收情况报表
	@RequestMapping("/monthRecycle")
	public String monthRecycle(HttpServletRequest request, String month)
			throws ParseException {

		Map<String, Object> map = pySYCostTypeService.monthRecycle(month);
		request.setAttribute("map", map);
		return "/SY/page/pay_reportMonthRecycle.jsp";
	}

	// 收费情况报表
	@RequestMapping("/reportPay")
	public String reportPay(HttpServletRequest request, SfglDto dto)
			throws ParseException {
		Map<String, Object> map = pyPayService.reportPay(dto);
		request.setAttribute("map", map);

		return "/SY/page/pay_reportPay.jsp";
	}

	// 欠费报表
	@RequestMapping("/reportDebts")
	public String reportDebts(HttpServletRequest request, SfglDto dto)
			throws ParseException {
		// String[] volumes = request.getParameterValues("volume");
		Map<String, Object> map = pyBillService.reportDebts(dto);
		request.setAttribute("map", map);
		return "/SY/page/pay_reportDebts.jsp";
	}

	// 各类用水统计总表 查询该时间的数据
	@RequestMapping("/tongji")
	public String tongji(HttpServletRequest request, SfglDto dto)
			throws ParseException {
		Map<String, Object> map = pySumreportService.tongji(dto);
		request.setAttribute("map", map);
		if (dto.getTypee() == 0)
			return "/SY/page/pay_reportWaterType.jsp";
		else
			return "/SY/page/pay_reportWaterType1.jsp";
	}

	// 各类用水统计总表 计算该时间的数据
	@RequestMapping("/tongjiJisuan")
	@ResponseBody
	public String tongjiJisuan(HttpServletRequest request, SfglDto dto)
			throws ParseException {
		Map<String, Object> map = pySumreportService.tongjiJisuan(dto);
		request.setAttribute("map", map);

		return "ok";
	}
}
