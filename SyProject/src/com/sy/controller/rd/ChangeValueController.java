package com.sy.controller.rd;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.entity.RdChangevalue;
import com.sy.projectUtils.rd.TermUtil;
import com.sy.service.rd.ChangeValueService;

/**
 * �������������Ʋ�
 * @author xulong
 */
@Controller
@RequestMapping("/SY/page/changValue")
public class ChangeValueController {
	@Autowired
	private ChangeValueService changeValueService;
	
	/**
	 * ��������ʱ��������˲�ѯ
	 * @param response
	 * @param term
	 * @param chang
	 */
	@RequestMapping("/selByTerm")
	public void selByTerm(HttpServletResponse response,TermUtil term,RdChangevalue chang){
		changeValueService.selByTerm(response, term, chang);
	}
}
