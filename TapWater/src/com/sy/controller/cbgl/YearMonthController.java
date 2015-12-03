package com.sy.controller.cbgl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.sy.entity.RdYearmonth;
import com.sy.service.cbgl.YearMonthService;

/**
 * @author xulong
 * �������¿�����
 */
@Controller
@RequestMapping("/sy/page/YearMonth")
public class YearMonthController {
	@Autowired
	private YearMonthService yearMonthService;
	
	/**
	 * ��ѯ���г�������
	 */
	@RequestMapping("/selAll")
	public void selAll(HttpServletResponse response) throws IOException{
		yearMonthService.selAll(response);
	}
}
