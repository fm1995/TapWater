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
/**
 * 
 * @author BarryLiu
 *
 */
@Controller
@RequestMapping("/paywindow")
public class PayWindowController extends PyController{
	
	//查询用户,在窗口收费的查询用户里面第一次查询并将查询条件放到session域中
	@RequestMapping("/selectUser")
	public String selectUser(HttpServletRequest request,HttpServletResponse response,UsUser user,SfglDto dto) throws IOException{
		Map<String, Object> map = usUserService.selectUser(user,dto,request);
		request.getSession().setAttribute("map", map);
		response.getOutputStream().print("ok");
		return null;
	}
	//进入了窗口查询用户以后的分页查询
	@RequestMapping("/selectUserPage")
	public String selectUserPage(HttpServletRequest request,HttpServletResponse response,UsUser user,SfglDto dto) throws IOException{
		Map<String, Object> map = usUserService.selectUser(user,dto,request);
		request.getSession().setAttribute("map", map);
		return "/sy/page/sys_selectUser.jsp";
	}
	//分页查询以后选择了缴费的编号来查询用户
	@RequestMapping("/selectUserByUserNo")
	public String selectUserByUserNo(UsUser user,HttpServletRequest request){
		user= usUserService.selectByPrimaryKey(user.getUserNo());
		request.setAttribute("user", user);
		return "/sy/page/pay_window.jsp";
	}
	
	@RequestMapping("jiaofei")
	public String jiaofei(HttpServletRequest request,HttpServletResponse response){
		usUserService.jiaofei(request);
		return null;
	}
	//跳到用户详情页面去执行用户详情操作
	@RequestMapping("yonghuxiangqing")
	public String yonghuxiangqing(String userNo){
		System.out.println("跳到用户详情页面去");
		
		return "/sy/page/user_search1.jsp";
	}

	//修改
	@RequestMapping("updateUserPhoneAndSmsPhone")
	public String updateUserPhoneAndSmsPhone(UsUser user,HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println(user);
		user =usUserService.updateUserPhoneAndSmsPhone(user);
		request.setAttribute("user", user);
		response.getOutputStream().print("ok");
		 return null;
	}
}
