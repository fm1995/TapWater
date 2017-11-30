package com.sy.controller.rd;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.service.rd.LoadService;

/**
 * 页面加载控制层
 * 
 * @author xulong
 */
@Controller
@RequestMapping("/SY/page/load")
public class LoadController {
	@Autowired
	private LoadService loadService;

	/**
	 * 加载所有的辖区 表册 和抄表年月到页面
	 * 
	 * @param map
	 * @throws IOException
	 */
	@RequestMapping("/selAllAreaAndVolume")
	public void selAllAreaAndVolume(HttpServletResponse response)
			throws IOException {
		loadService.selAllAreaAndVolume(response);
	}

	/**
	 * 查询所有抄表班员工
	 * 
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/selByRdEmp")
	public void selByRdEmp(HttpServletResponse response) throws IOException {
		loadService.selByRdEmp(response);
	}
}
