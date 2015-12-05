package com.sy.controller.sfgl;

import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.dto.SfglDto;

/**
 * 数据报表
 * @author BarryLiu
 */
@Controller
@RequestMapping("/report")
public class ReportController extends PyController{
	
	//用户预收情况报表
	@RequestMapping("/yushou")
	public String yushou(SfglDto report,HttpServletRequest request){
		Map<String, Object> map = usUserService.yushou(report.getPage(), report.getRows(), report.getUserMoney());
		request.setAttribute("map", map);
		return "/sy/page/pay_reportBalance.jsp";
	}
	
	//各类用水统计总表
	@RequestMapping("/tongji")
	public String tongji(HttpServletRequest request){
		System.out.println("tongji...");
		Map<String,Object> map = syCostTypeService.tongji();
		request.setAttribute("map", map);
		
		return "/sy/page/pay_reportWaterType.jsp";
	}
	
	//月资金回收情况报表 
	@RequestMapping("/monthRecycle")
	public String monthRecycle(HttpServletRequest request,String month) throws ParseException{
		
		Map<String,Object> map = syCostTypeService.monthRecycle(month);
		request.setAttribute("map", map);
		return "/sy/page/pay_reportMonthRecycle.jsp";
	}
	
}
