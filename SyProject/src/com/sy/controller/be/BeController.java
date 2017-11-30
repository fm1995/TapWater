package com.sy.controller.be;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sy.entity.BeOrder;
import com.sy.entity.BeOrderuser;
import com.sy.entity.SyMeterType;
import com.sy.integration.SelSyMeterType;
import com.sy.service.be.BeOrderService;
import com.sy.service.be.BeOrderuserService;

@Controller
@RequestMapping("/beorder")
public class BeController{
	@Autowired
	private SelSyMeterType selSyMeterType;
	@Autowired
	BeOrderService beOrderService;
	@Autowired
	BeOrderuserService beOrderUserService;
	
	
	//异步查询表径
	@ResponseBody
	@RequestMapping("/selSyMeterType")
	public List<SyMeterType> selSyMeterType(){
		return selSyMeterType.selSyMeterType();
	}
//1.新户	
	//创建新户
	@RequestMapping("/save")
	public String save(BeOrder order){
		order.setOrderNo(beOrderService.selMaxNo(order.getOrderNo()));
		beOrderService.save(order);
		return "/SY/page/be/be_request1.jsp";
	}
	
	//Be_OrderUser工单详细表添加新用户>be_request1.jsp
	@RequestMapping("/insert")
	public String saveOrderUser(BeOrderuser orderUser){
		orderUser.setOrderNo(beOrderService.selNextNO(orderUser.getOrderNo()));
//		System.out.println(orderUser.getOrderNo());
		beOrderUserService.save(orderUser);
		return "/SY/page/be/be_request1.jsp";
	}
	//查询Be_Order业扩表当前新用户最晚的一个ID
	@RequestMapping("/selectId")
	public String selectId(){
		return "/SY/page/be/be_request1.jsp";
	}	
	
	
//2.分户	
	
//分户创建新用户be_request2.jsp
	@RequestMapping("/save2")
	public String saveTwo(BeOrder order){
		order.setOrderNo(beOrderService.selMaxNo(order.getOrderNo()));
		beOrderService.save(order);
		return "/SY/page/be/be_request2.jsp";
	}
//Be_OrderUser工单详细表添加新用户>be_request2.jsp	
	@RequestMapping("/insert2")
	public String saveOrderUser2(BeOrderuser orderUser){
		orderUser.setOrderNo(beOrderService.selNextNO(orderUser.getOrderNo()));
		beOrderUserService.save(orderUser);
		return "/SY/page/be/be_request2.jsp";
	}
	//查询Be_Order业扩表当前新用户最晚的一个ID
	@RequestMapping("/selectId2")
	public String selectId2(){
		return "/SY/page/be/be_request2.jsp";
	}	
//查询原用户信息be_request2.jsp
	@RequestMapping("/findOrder")
	@ResponseBody
	public BeOrder findOrder(HttpServletRequest request,HttpServletResponse response) throws IOException{
		BeOrder order = beOrderService.findById(request.getParameter("orid"));
		if(order!=null){
			return order;
		}
		return null;
	}
	
//过户
	//添加过户be_request3.jsp
	@RequestMapping("/request3")
	public String saveRequest3(BeOrder order){
		order.setOrderNo(beOrderService.selMaxNo(order.getOrderNo()));
		beOrderService.save(order);
		return "/SY/page/be/be_request3.jsp";
	}
	
//代扣
	@RequestMapping("/request4")
	public String saveRequest4(BeOrder order){
		order.setOrderNo(beOrderService.selMaxNo(order.getOrderNo()));
		beOrderService.save(order);
		return "/SY/page/be/be_request4.jsp";
	}
//换表
	@RequestMapping("/request5")
	public String saveRequest5(BeOrder order){
		order.setOrderNo(beOrderService.selMaxNo(order.getOrderNo()));
		beOrderService.save(order);
		return "/SY/page/be/be_request5.jsp";
	}
//重签
	@RequestMapping("/request6")
	public String saveRequest6(BeOrder order){
		order.setOrderNo(beOrderService.selMaxNo(order.getOrderNo()));
		beOrderService.save(order);
		return "/SY/page/be/be_request6.jsp";
	}
//销户
	@RequestMapping("/request7")
	public String saveRequest7(BeOrder order){
		order.setOrderNo(beOrderService.selMaxNo(order.getOrderNo()));
		beOrderService.save(order);
		return "/SY/page/be/be_request7.jsp";
	}
}
