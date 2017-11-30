package com.sy.controller.py;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sy.entity.UsUser;

/** 批量收费窗口 */
@Controller
@RequestMapping("/paybatch")
public class PayBatchContrller extends PyController {

	@ResponseBody
	@RequestMapping("/selectUserByUserNo")
	public UsUser selectUserByUserNo(String userNo) {
		UsUser user = pyUsUserService.selectByPrimaryKey(userNo);
		System.out.println(user);
		return user;
	}

	/**
	 * 批量收费
	 * 
	 * @throws IOException
	 */
	@RequestMapping("pays")
	@ResponseBody
	public String pays(HttpServletRequest request) throws IOException {
		String result = pyPayService.pays(request);
		return result;
	}

}
