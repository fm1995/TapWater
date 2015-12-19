package com.sy.controller.sfgl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.dto.SfglDto;
import com.sy.entity.UsUser;

@Controller
@RequestMapping("paydetails")
public class PayWindowDetailsController extends PyController{
		//跳到用户详情页面去执行用户详情操作
		@RequestMapping("yonghuxiangqing")
		public String yonghuxiangqing(String userNo,HttpServletRequest request){
			usUserService.selectUserAndDetails(userNo,request);
			return "/SY/page/user_search1.jsp";
		}
		
		@RequestMapping("ajaxLoadPays")
		public String ajaxLoadPays(String userNo,SfglDto dto,HttpServletRequest request,HttpServletResponse response) throws IOException{
			pyPayService.selectPaysPageByUserNo(request,response,dto,userNo);
			return null;
		}
		//分页查询以后选择了缴费的编号来查询发票
		@RequestMapping("/selectUserByUserNo")
		public String selectUserByUserNo(UsUser user,HttpServletRequest request){
			pyBillService.selectUser(user,request);
			return "/SY/page/user_search1.jsp";
		}
}
