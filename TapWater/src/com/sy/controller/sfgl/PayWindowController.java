package com.sy.controller.sfgl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.dto.SfglDto;
import com.sy.entity.UsUser;

@Controller
@RequestMapping("/paywindow")
public class PayWindowController extends PyController{
	
	@RequestMapping("/selectUser")
	public String selectUser(HttpServletRequest request,HttpServletResponse response,UsUser user,SfglDto dto) throws IOException{
		System.out.println("分页的数据："+dto);
		Map<String, Object> map = usUserService.selectUser(user,dto.getPage(),dto.getRows());
		request.getSession().setAttribute("map", map);
		response.getOutputStream().print("ok");
		return null;
	}
	@RequestMapping("/selectUserByUserNo")
	public String selectUserByUserNo(UsUser user,ModelMap map){
		user= usUserService.selectByPrimaryKey(user.getUserNo());
		map.put("user", user);
		return "/sy/page/pay_window.jsp";
	}

}
