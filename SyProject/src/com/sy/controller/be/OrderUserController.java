package com.sy.controller.be;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.entity.BeOrderuser;
import com.sy.service.be.BeOrderuserService;

@Controller
@RequestMapping("/beOrderuser")
public class OrderUserController {

	@Autowired
	private BeOrderuserService beOrderuserService;

	private Logger logger = Logger.getLogger(getClass());;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	// 根据OrderNo查询工单用户详情表
	@RequestMapping("/selectByOrderNo2")
	public String selectByOrderNo2(String orderNo, String userName, ModelMap map) {
		List<BeOrderuser> beOrderusers = null;
		if (orderNo != null) {
			beOrderusers = beOrderuserService.selectByOrderNo2(orderNo);
			map.put("beOrderusers", beOrderusers);
			map.put("userName", userName);
		}
		return "/SY/page/be__saveForm.jsp";
	}

	// 根据Order_no修改多个数据
	@RequestMapping("/updateByOrderNo")
	public String updateByOrderNo(String[] docNums, String orderNo,
			int[] userId, ModelMap map, String userName) {
		List<BeOrderuser> beOrderusers = beOrderuserService
				.selectByOrderNo(orderNo);
		for (int i = 0; i < docNums.length; i++) {
			BeOrderuser beOrderuser = beOrderusers.get(i);
			beOrderuser.setDocNum(docNums[i]);
			beOrderuser.setId(userId[i]);
			beOrderuserService.updateByOrderNo(beOrderuser);
		}
		return selectByOrderNo2(orderNo, userName, map);
	}

	@RequestMapping("/selAllOrderuser")
	public String selAllOrderuser(ModelMap map, String page, String orderType1,
			String orderType2, String orderType3, Date date1, Date date2) {
		int page2 = 0;
		if (page != null) {
			page2 = Integer.parseInt(page);
		}
		List<BeOrderuser> orderUsers = beOrderuserService.selAllOrderuser(
				page2 * 10, orderType1, orderType2, orderType3, date1, date2);
		int pageCount = beOrderuserService.selAllOrderuserCount(orderType1,
				orderType2, orderType3, date1, date2);
		Integer moneyCount=beOrderuserService.selAllOrderuserMoney(orderType1,
				orderType2, orderType3, date1, date2);
		if(moneyCount==null)
			map.put("moneyCount",0);
		else
			map.put("moneyCount", moneyCount);
		
		
		map.put("orderUsers", orderUsers);
		map.put("pageCount", pageCount / 10 + 1);
		map.put("page", page2);
		if(orderType1!=null)
			map.put("orderType1", orderType1);
		if(orderType2!=null)
			map.put("orderType2", orderType2);
		if(orderType3!=null)
			map.put("orderType3", orderType3);
		if(date1!=null)
			map.put("date1", date1);
		if(date2!=null)
			map.put("date1", date2);
		return "/SY/page/be_reportMoney.jsp";
	}

}
