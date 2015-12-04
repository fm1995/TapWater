package com.sy.controller.cbgl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.entity.RdChangemaxvalue;
import com.sy.projectUtils.cbgl.TermUtil;
import com.sy.service.cbgl.ChangeMaxValueService;

/**
 * 最大表码修正记录控制层
 * @author xulong
 */
@Controller
@RequestMapping("/sy/page/maxVlue")
public class ChangeMaxValueController {
	@Autowired
	private ChangeMaxValueService changeMaxValueService;
	
	/**
	 * 根据抄表员和修改时间段查询最大表码修正记录
	 * @param response
	 * @param term
	 * @param chang
	 * @throws IOException 
	 */
	@RequestMapping("/selByTerm")
	public void selByTerm(HttpServletResponse response,TermUtil term,RdChangemaxvalue chang) throws IOException{
		changeMaxValueService.selByTerm(response, term, chang);
	}
}
