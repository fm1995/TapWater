package com.sy.controller.rd;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.service.rd.YearMonthService;

/**
 * @author xulong 抄表年月控制类
 */
@Controller
@RequestMapping("/SY/page/YearMonth")
public class YearMonthController {
	@Autowired
	private YearMonthService yearMonthService;

	/**
	 * 查询所有抄表年月
	 */
	@RequestMapping("/selAll")
	public void selAll(HttpServletResponse response) throws IOException {
		yearMonthService.selAll(response);
	}

	/**
	 * 查询所有抄表年月关联员工表
	 * 
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/selAllAndEmp")
	public void selAllAndEmp(HttpServletResponse response) throws IOException {
		yearMonthService.selAllAndEmp(response);
	}
}
