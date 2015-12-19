package com.sy.controller.rd;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.service.rd.LoadService;

/**
 * ҳ����ؿ��Ʋ�
 * 
 * @author xulong
 */
@Controller
@RequestMapping("/SY/page/load")
public class LoadController {
	@Autowired
	private LoadService loadService;

	/**
	 * �������е�Ͻ�� ��� �ͳ������µ�ҳ��
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
	 * ��ѯ���г����Ա��
	 * 
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/selByRdEmp")
	public void selByRdEmp(HttpServletResponse response) throws IOException {
		loadService.selByRdEmp(response);
	}
}
