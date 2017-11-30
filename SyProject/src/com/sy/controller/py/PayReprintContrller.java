package com.sy.controller.py;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.entity.IvInvoice;
import com.sy.projectUtils.SfglDto;

/**
 * 发票补开作废
 * @author BarryLiu
 *
 */
@Controller
@RequestMapping("payprint")
public class PayReprintContrller extends PyController{
	/**发票补开作废*/
	@RequestMapping("/invoiceReprint")
	public String invoiceReprint(HttpServletRequest request,ModelMap map,SfglDto dto){
		pyPayService.invoiceReprint(request,map,dto);
		return "/SY/page/pay_invoiceReprint.jsp";
	}
	
	/**跳到页面发票作废*/
	@RequestMapping("ReprintDisable")
	public String ReprintDisable(String invoiceNo,ModelMap map){
		IvInvoice ivInvoice = pyPayService.selectInvoiceByNo(invoiceNo);
		map.put("ivInvoice", ivInvoice);
		return "/SY/page/pay_invoiceReprint_disable.jsp";
	}
	/**发票作废*/
	@RequestMapping("disable")
	public String disable(String invoiceNo,ModelMap map){
		 pyPayService.invoiceDisable(invoiceNo);
		return "/SY/page/pay_invoiceReprint_disable.jsp";
	}
	
}
