package com.sy.controller.rd;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.entity.RdChangevalue;
import com.sy.projectUtils.rd.TermUtil;
import com.sy.service.rd.ChangeValueService;

/**
 * 底码码修正控制层
 * @author xulong
 */
@Controller
@RequestMapping("/SY/page/changValue")
public class ChangeValueController {
	@Autowired
	private ChangeValueService changeValueService;
	
	/**
	 * 根据修正时间和修正人查询
	 * @param response
	 * @param term
	 * @param chang
	 */
	@RequestMapping("/selByTerm")
	public void selByTerm(HttpServletResponse response,TermUtil term,RdChangevalue chang){
		changeValueService.selByTerm(response, term, chang);
	}
}
