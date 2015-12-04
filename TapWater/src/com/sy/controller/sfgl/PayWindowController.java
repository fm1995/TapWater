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
	
	//��ѯ�û�,�ڴ����շѵĲ�ѯ�û������һ�β�ѯ������ѯ�����ŵ�session����
	@RequestMapping("/selectUser")
	public String selectUser(HttpServletRequest request,HttpServletResponse response,UsUser user,SfglDto dto) throws IOException{
		Map<String, Object> map = usUserService.selectUser(user,dto,request);
		request.getSession().setAttribute("map", map);
		response.getOutputStream().print("ok");
		return null;
	}
	//�����˴��ڲ�ѯ�û��Ժ�ķ�ҳ��ѯ
	@RequestMapping("/selectUserPage")
	public String selectUserPage(HttpServletRequest request,HttpServletResponse response,UsUser user,SfglDto dto) throws IOException{
		Map<String, Object> map = usUserService.selectUser(user,dto,request);
		request.getSession().setAttribute("map", map);
		return "/sy/page/sys_selectUser.jsp";
	}
	//��ҳ��ѯ�Ժ�ѡ���˽ɷѵı������ѯ�û�
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
	//�����û�����ҳ��ȥִ���û��������
	@RequestMapping("yonghuxiangqing")
	public String yonghuxiangqing(String userNo){
		System.out.println("�����û�����ҳ��ȥ");
		
		return "/sy/page/user_search1.jsp";
	}

	//�޸�
	@RequestMapping("updateUserPhoneAndSmsPhone")
	public String updateUserPhoneAndSmsPhone(UsUser user,HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println(user);
		user =usUserService.updateUserPhoneAndSmsPhone(user);
		request.setAttribute("user", user);
		response.getOutputStream().print("ok");
		 return null;
	}
}
