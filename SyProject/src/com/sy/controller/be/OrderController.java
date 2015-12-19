package com.sy.controller.be;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sy.entity.BeComment;
import com.sy.entity.BeOrder;
import com.sy.entity.BeOrderTable;
import com.sy.entity.BeOrderuser;
import com.sy.entity.UsUser;
import com.sy.entity.beOrderList;
import com.sy.projectUtils.StringUtils;
import com.sy.integration.be.BeOrderInfo;
import com.sy.service.be.BeOrderuserService;
import com.sy.service.be.OrderService;
import com.sy.service.sy.SyAreaService;
import com.sy.service.us.UsUserService;

@Controller
@RequestMapping("/beOrder")
public class OrderController {

	@Autowired
	private BeOrderInfo be;

	public BeOrderInfo getBe() {
		return be;
	}

	public void setBe(BeOrderInfo be) {
		this.be = be;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private SyAreaService syAreaService;

	@Autowired
	private UsUserService usUserService;
	
	@Autowired
	private BeOrderuserService beOrderuserService;
	private Logger logger = Logger.getLogger(getClass());

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	// 根据传过来的STEPID查询工单信息
	@RequestMapping("/selectByStep")
	public String selectByStep(int stepId, String page, String userName,
			String orderNo, int orderType, ModelMap map) {
		List<BeOrder> beOrders = null;
		int pageCount = 0;
		int page2 = 0;
		if (page != null) {
			page2 = Integer.parseInt(page);
			beOrders = orderService.selectByRe(stepId, orderType, orderNo,
					userName, page2 * 10);
		} else {
			beOrders = orderService.selectByRe(stepId, orderType, orderNo,
					userName, 0);
		}
		if (beOrders != null) {
			map.put("beOrders", beOrders);
			map.put("page", page2);
		}
		if (stepId == -2) {
			pageCount = orderService.selectCount3(stepId, orderType, orderNo,
					userName) / 10 + 1;
			map.put("count", pageCount);
			map.put("stepId", stepId);
			map.put("orderType", orderType);
			map.put("orderNo", orderNo);
			map.put("userName", userName);
			return "/SY/page/be_order.jsp";
		} else {
			pageCount = orderService.selectCount1(stepId) / 10 + 1;
			map.put("count", pageCount);
			return "/SY/page/be__audit.jsp";
		}
	}

	// 根据工单编号查询单个工单
	@RequestMapping("/selectByOrderno")
	@ResponseBody
	public BeOrder selectByOrderno(String orderNo, HttpServletResponse response)
			throws IOException {
		BeOrder beOrder = null;
		if (orderNo != null)
			beOrder = orderService.selectByOrderno(orderNo);
		logger.debug(beOrder);
		return beOrder;
	}

	// 通过工单编号查询工单--
	@RequestMapping("/queryByOrderno")
	public String showInfo(ModelMap map, String orderNo) {
		System.out.println("showInfo");
		map.put("orderInfo", getBe().BeOrderInfoShow(orderNo));
		// 工单附加信息
		map.put("beComment", getBe().BeCommentInfoShow(orderNo));
		return "/SY/page/be_orderInfo.jsp";
	}

	// 修改附加信息
	@RequestMapping("/updateCom")
	public void updateComment(ModelMap map, HttpServletResponse response,
			BeComment bc) throws IOException {
		getBe().updateCom(bc);
		// 刷新工单附加信息
		map.put("beComment", getBe().BeCommentInfoShow(bc.getOrderNo()));

		// showInfo(map,bc.getOrderNo());
	}

	// 删除附加信息
	@RequestMapping("/delCom")
	public void delComment(ModelMap map, HttpServletResponse response,
			BeComment bc) throws IOException {
		getBe().delCom(bc);
		// 刷新工单附加信息
		map.put("beComment", getBe().BeCommentInfoShow(bc.getOrderNo()));
	}

	// 添加附加信息
	@RequestMapping("/addCom")
	public void addComment(ModelMap map, HttpServletResponse response,
			BeComment bc) {
		System.out.println("                     addComment");
		Date date = new Date(System.currentTimeMillis());
		bc.setDatee(date);
		System.out.println();
		System.out.println(bc.toString());
		getBe().addCom(bc);
		// 刷新工单附加信息
		map.put("beComment", getBe().BeCommentInfoShow(bc.getOrderNo()));
	}

	// 发送JSON字符串
	public void sendClient(String jsonStr, HttpServletResponse response)
			throws IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jsonStr);
	}

	// 根据工单编号更改工单
	@RequestMapping("/updateOrder")
	public String updateOrder(String orderNo, String abortCause, ModelMap map) {
		BeOrder beOrder = null;
		if (orderNo != null)
			beOrder = orderService.selectByOrderno2(orderNo);
		beOrder.setStepId(-1);
		beOrder.setAbortCause(abortCause);
		orderService.updateOrder(beOrder);
		return selectByStep(-2, null, null, null, 0, map);
	}

	// 通水停水-发送
	// 根据工单编号更改STEPID
	@RequestMapping("/updateOrder2")
	public String updateOrder(String orderNo, ModelMap map) {
		BeOrder beOrder = null;
		if (orderNo != null)
			beOrder = orderService.selectByOrderno2(orderNo);
		beOrder.setStepId(beOrder.getStepId() + 1);
		orderService.updateOrder(beOrder);
		return selectByStep(7, null, null, null, 0, map);
	}

	// 通水停水-撤回
	// 根据工单编号更改STEPID
	@RequestMapping("/updateOrder3")
	public String updateOrder2(String orderNo, ModelMap map) {
		BeOrder beOrder = null;
		if (orderNo != null)
			beOrder = orderService.selectByOrderno2(orderNo);
		// 判断工单类型
		int orderType = beOrder.getOrderType();
		if (orderType == 1 || orderType == 2 || orderType == 5)
			beOrder.setStepId(beOrder.getStepId() - 1);
		else
			beOrder.setStepId(beOrder.getStepId() - 3);
		orderService.updateOrder(beOrder);
		return selectByStep(7, null, null, null, 0, map);
	}

	// 档案存档-发送
	@RequestMapping("/updateOrder4")
	public String updateOrder4(String[] docNums1, String orderNo1,
			int[] userId1, ModelMap map) {
		List<BeOrderuser> beOrderusers = beOrderuserService
				.selectByOrderNo(orderNo1);
		for (int i = 0; i<docNums1.length; i++) {
			BeOrderuser beOrderuser = beOrderusers.get(i);
			beOrderuser.setDocNum(docNums1[i]);
			beOrderuser.setOrderNo(orderNo1);
			beOrderuser.setId(userId1[i]);
			beOrderuserService.updateByOrderNo(beOrderuser);
		}
		BeOrder beOrder = null;
		if (orderNo1 != null){
			beOrder = orderService.selectByOrderno2(orderNo1);
		}
		beOrder.setStepId(0);
		beOrder.setCompleteDate(new Date());
		if(beOrderusers!=null){
		for (BeOrderuser beOrderuser : beOrderusers) {
			if(beOrderuser.getBeOrder().getOrderType()==1){
				UsUser user=new UsUser();
				user.setAbc(StringUtils.convertToSpell(beOrderuser.getUserName(), "1"));
				user.setUserNo(CreateNo(Integer.valueOf(beOrderuser.getBeOrder().getAreaId())));
				user.setUserName(beOrderuser.getUserName());
				user.setCreateDate(new Date());
				user.setAddress(beOrderuser.getBeOrder().getAddress());
				user.setPhone(beOrderuser.getBeOrder().getPhone());
				user.setSmsPhone(beOrderuser.getSmsPhone());
				user.setAreaId(beOrderuser.getBeOrder().getAreaId());
				user.setUserType(beOrderuser.getBeOrder().getUserType());
				user.setPayType(beOrderuser.getBeOrder().getPayType());
				user.setBankName(beOrderuser.getBeOrder().getBankCompany());
				user.setBankNum(beOrderuser.getBeOrder().getBankNum());
				user.setFormula(beOrderuser.getFormula());
				user.setUserMoney(beOrderuser.getRealMoney());
				user.setMeterId(beOrderuser.getMeterTypeId());
				user.setDocNum(beOrderuser.getDocNum());
				user.setPwd("123");
				user.setContractNum(beOrderuser.getContractNum());
				user.setContractDate(new Date());
				user.setUserDisabled(true);
				usUserService.insert(user);
			}else if(beOrderuser.getBeOrder().getOrderType()==2){
				UsUser user=new UsUser();
				user.setAbc(StringUtils.convertToSpell(beOrderuser.getUserName(), "1"));
				user.setUserNo(CreateNo(Integer.valueOf(beOrderuser.getBeOrder().getAreaId())));
				user.setUserName(beOrderuser.getUserName());
				user.setCreateDate(new Date());
				user.setAddress(beOrderuser.getBeOrder().getAddress());
				user.setPhone(beOrderuser.getBeOrder().getPhone());
				user.setSmsPhone(beOrderuser.getSmsPhone());
				user.setAreaId(beOrderuser.getBeOrder().getAreaId());
				user.setUserType(beOrderuser.getBeOrder().getUserType());
				user.setPayType(beOrderuser.getBeOrder().getPayType());
				user.setBankName(beOrderuser.getBeOrder().getBankCompany());
				user.setBankNum(beOrderuser.getBeOrder().getBankNum());
				user.setFormula(beOrderuser.getFormula());
				user.setUserMoney(beOrderuser.getRealMoney());
				user.setMeterId(beOrderuser.getMeterTypeId());
				user.setDocNum(beOrderuser.getDocNum());
				user.setPwd("123");
				user.setContractNum(beOrderuser.getContractNum());
				user.setContractDate(new Date());
				user.setUserDisabled(true);
				usUserService.insert(user);
			}else if(beOrderuser.getBeOrder().getOrderType()==3){
				UsUser user=new UsUser();
				user.setAbc(StringUtils.convertToSpell(beOrderuser.getUserName(), "1"));
				user.setUserNo(CreateNo(Integer.valueOf(beOrderuser.getBeOrder().getAreaId())));
				user.setUserName(beOrderuser.getUserName());
				user.setCreateDate(new Date());
				user.setAddress(beOrderuser.getBeOrder().getAddress());
				user.setPhone(beOrderuser.getBeOrder().getPhone());
				user.setSmsPhone(beOrderuser.getSmsPhone());
				user.setAreaId(beOrderuser.getBeOrder().getAreaId());
				user.setUserType(beOrderuser.getBeOrder().getUserType());
				user.setPayType(beOrderuser.getBeOrder().getPayType());
				user.setBankName(beOrderuser.getBeOrder().getBankCompany());
				user.setBankNum(beOrderuser.getBeOrder().getBankNum());
				user.setFormula(beOrderuser.getFormula());
				user.setUserMoney(beOrderuser.getRealMoney());
				user.setMeterId(beOrderuser.getMeterTypeId());
				user.setDocNum(beOrderuser.getDocNum());
				user.setPwd("123");
				user.setContractNum(beOrderuser.getContractNum());
				user.setContractDate(new Date());
				user.setUserDisabled(true);
				usUserService.insert(user);
			}else if(beOrderuser.getBeOrder().getOrderType()==4){
				UsUser user=usUserService.selByuserName(beOrder.getUserName(),beOrder.getPhone());
				user.setPayType(beOrderuser.getBeOrder().getPayType());
				user.setBankName(beOrderuser.getBeOrder().getBankCompany());
				user.setBankNum(beOrderuser.getBeOrder().getBankNum());
				user.setDocNum(beOrderuser.getDocNum());
				usUserService.update(user);
			}else if(beOrderuser.getBeOrder().getOrderType()==5){
				UsUser user=usUserService.selByuserName(beOrder.getUserName(),beOrder.getPhone());
				user.setPayType(beOrderuser.getBeOrder().getPayType());
				user.setBankName(beOrderuser.getBeOrder().getBankCompany());
				user.setBankNum(beOrderuser.getBeOrder().getBankNum());
				user.setMeterId(beOrderuser.getMeterTypeId());
				user.setDocNum(beOrderuser.getDocNum());
				usUserService.update(user);
			}else if(beOrderuser.getBeOrder().getOrderType()==6){
				UsUser user=usUserService.selByuserName(beOrder.getUserName(),beOrder.getPhone());
				user.setAbc(StringUtils.convertToSpell(beOrderuser.getUserName(), "1"));
				user.setUserName(beOrderuser.getUserName());
				user.setCreateDate(new Date());
				user.setAddress(beOrderuser.getBeOrder().getAddress());
				user.setPhone(beOrderuser.getBeOrder().getPhone());
				user.setSmsPhone(beOrderuser.getSmsPhone());
				user.setAreaId(beOrderuser.getBeOrder().getAreaId());
				user.setUserType(beOrderuser.getBeOrder().getUserType());
				user.setPayType(beOrderuser.getBeOrder().getPayType());
				user.setBankName(beOrderuser.getBeOrder().getBankCompany());
				user.setBankNum(beOrderuser.getBeOrder().getBankNum());
				user.setFormula(beOrderuser.getFormula());
				user.setUserMoney(beOrderuser.getRealMoney());
				user.setMeterId(beOrderuser.getMeterTypeId());
				user.setDocNum(beOrderuser.getDocNum());
				user.setPwd("123");
				user.setContractNum(beOrderuser.getContractNum());
				user.setContractDate(new Date());
				user.setUserDisabled(true);
				usUserService.update(user);
			}else {
				UsUser user=usUserService.selByuserName(beOrder.getUserName(),beOrder.getPhone());
				user.setUserDisabled(false);
				usUserService.update(user);
			}
		}
		}
		
		orderService.updateOrder(beOrder);
		return selectByStep(8, null, null, null, 0, map);
	}
	
	//生成用户USERNO逻辑
	public String CreateNo(Integer areaId){
		String userNo=syAreaService.selByAreaName(areaId);
		return userNo;
	}
	
	

	// 档案存档-撤回
	@RequestMapping("/updateOrder5")
	public String updateOrder5(String orderNo, ModelMap map) {
		BeOrder beOrder = null;
		if (orderNo != null)
			beOrder = orderService.selectByOrderno2(orderNo);
		// 判断工单类型
		int orderType = beOrder.getOrderType();
		if (orderType == 1 || orderType == 2 || orderType == 5
				|| orderType == 7) {
			beOrder.setStepId(beOrder.getStepId() - 1);
		} else if (orderType == 3 || orderType == 4) {
			beOrder.setStepId(beOrder.getStepId() - 6);
		} else {
			beOrder.setStepId(beOrder.getStepId() - 3);
		}
		orderService.updateOrder(beOrder);
		return selectByStep(8, null, null, null, 0, map);
	}

	@RequestMapping("/selGroup")
	public String selGroup(ModelMap map) {
		List<BeOrderTable> stepId1 = orderService.selGroup(1);
		int stepIdCount1 = orderService.selGroupCount(1);
		beOrderList list1 = new beOrderList();
		for (BeOrderTable beOrderTable : list1.getList()) {
			for (int i = 0; i < stepId1.size(); i++) {
				if (stepId1.get(i).getOrderType() == beOrderTable
						.getOrderType()) {
					beOrderTable.setCount(stepId1.get(i).getCount());
				}
			}
		}
		List<BeOrderTable> stepId2 = orderService.selGroup(2);
		int stepIdCount2 = orderService.selGroupCount(2);
		beOrderList list2 = new beOrderList();
		for (BeOrderTable beOrderTable : list2.getList()) {
			for (int i = 0; i < stepId2.size(); i++) {
				if (stepId2.get(i).getOrderType() == beOrderTable
						.getOrderType()) {
					beOrderTable.setCount(stepId2.get(i).getCount());
				}
			}
		}

		List<BeOrderTable> stepId3 = orderService.selGroup(3);
		int stepIdCount3 = orderService.selGroupCount(3);
		beOrderList list3 = new beOrderList();
		for (BeOrderTable beOrderTable : list3.getList()) {
			for (int i = 0; i < stepId3.size(); i++) {
				if (stepId3.get(i).getOrderType() == beOrderTable
						.getOrderType()) {
					beOrderTable.setCount(stepId3.get(i).getCount());
				}
			}
		}

		List<BeOrderTable> stepId4 = orderService.selGroup(4);
		int stepIdCount4 = orderService.selGroupCount(4);
		beOrderList list4 = new beOrderList();
		for (BeOrderTable beOrderTable : list4.getList()) {
			for (int i = 0; i < stepId4.size(); i++) {
				if (stepId4.get(i).getOrderType() == beOrderTable
						.getOrderType()) {
					beOrderTable.setCount(stepId4.get(i).getCount());
				}
			}
		}

		List<BeOrderTable> stepId5 = orderService.selGroup(5);
		int stepIdCount5 = orderService.selGroupCount(5);

		beOrderList list5 = new beOrderList();
		for (BeOrderTable beOrderTable : list5.getList()) {
			for (int i = 0; i < stepId5.size(); i++) {
				if (stepId5.get(i).getOrderType() == beOrderTable
						.getOrderType()) {
					beOrderTable.setCount(stepId5.get(i).getCount());
				}
			}
		}

		List<BeOrderTable> stepId6 = orderService.selGroup(6);
		int stepIdCount6 = orderService.selGroupCount(6);
		beOrderList list6 = new beOrderList();
		for (BeOrderTable beOrderTable : list6.getList()) {
			for (int i = 0; i < stepId6.size(); i++) {
				if (stepId6.get(i).getOrderType() == beOrderTable
						.getOrderType()) {
					beOrderTable.setCount(stepId6.get(i).getCount());
				}
			}
		}

		List<BeOrderTable> stepId7 = orderService.selGroup(7);
		int stepIdCount7 = orderService.selGroupCount(7);
		beOrderList list7 = new beOrderList();
		for (BeOrderTable beOrderTable : list7.getList()) {
			for (int i = 0; i < stepId7.size(); i++) {
				if (stepId7.get(i).getOrderType() == beOrderTable
						.getOrderType()) {
					beOrderTable.setCount(stepId7.get(i).getCount());
				}
			}
		}

		List<BeOrderTable> stepId8 = orderService.selGroup(8);
		int stepIdCount8 = orderService.selGroupCount(8);
		beOrderList list8 = new beOrderList();
		for (BeOrderTable beOrderTable : list8.getList()) {
			for (int i = 0; i < stepId8.size(); i++) {
				if (stepId8.get(i).getOrderType() == beOrderTable
						.getOrderType()) {
					beOrderTable.setCount(stepId8.get(i).getCount());
				}
			}
		}

		List<BeOrderTable> stepId0 = orderService.selGroup(0);
		int stepIdCount0 = orderService.selGroupCount(0);
		beOrderList list0 = new beOrderList();
		for (BeOrderTable beOrderTable : list0.getList()) {
			for (int i = 0; i < stepId0.size(); i++) {
				if (stepId0.get(i).getOrderType() == beOrderTable
						.getOrderType()) {
					beOrderTable.setCount(stepId0.get(i).getCount());
				}
			}
		}

		List<BeOrderTable> stepId9 = orderService.selGroup(-1);
		int stepIdCount9 = orderService.selGroupCount(-1);
		beOrderList list9 = new beOrderList();
		for (BeOrderTable beOrderTable : list9.getList()) {
			for (int i = 0; i < stepId9.size(); i++) {
				if (stepId9.get(i).getOrderType() == beOrderTable
						.getOrderType()) {
					beOrderTable.setCount(stepId9.get(i).getCount());
				}
			}
		}

		beOrderList list10 = new beOrderList();
		list10.getList()
				.get(0)
				.setCount(
						list1.getList().get(0).getCount()
								+ list2.getList().get(0).getCount()
								+ list3.getList().get(0).getCount()
								+ list4.getList().get(0).getCount()
								+ list5.getList().get(0).getCount()
								+ list6.getList().get(0).getCount()
								+ list7.getList().get(0).getCount()
								+ list8.getList().get(0).getCount());
		list10.getList()
				.get(1)
				.setCount(
						list1.getList().get(1).getCount()
								+ list2.getList().get(1).getCount()
								+ list3.getList().get(1).getCount()
								+ list4.getList().get(1).getCount()
								+ list5.getList().get(1).getCount()
								+ list6.getList().get(1).getCount()
								+ list7.getList().get(1).getCount()
								+ list8.getList().get(1).getCount());
		list10.getList()
				.get(2)
				.setCount(
						list1.getList().get(2).getCount()
								+ list2.getList().get(2).getCount()
								+ list3.getList().get(2).getCount()
								+ list4.getList().get(2).getCount()
								+ list5.getList().get(2).getCount()
								+ list6.getList().get(2).getCount()
								+ list7.getList().get(2).getCount()
								+ list8.getList().get(2).getCount());
		list10.getList()
				.get(3)
				.setCount(
						list1.getList().get(3).getCount()
								+ list2.getList().get(3).getCount()
								+ list3.getList().get(3).getCount()
								+ list4.getList().get(3).getCount()
								+ list5.getList().get(3).getCount()
								+ list6.getList().get(3).getCount()
								+ list7.getList().get(3).getCount()
								+ list8.getList().get(3).getCount());
		list10.getList()
				.get(4)
				.setCount(
						list1.getList().get(4).getCount()
								+ list2.getList().get(4).getCount()
								+ list3.getList().get(4).getCount()
								+ list4.getList().get(4).getCount()
								+ list5.getList().get(4).getCount()
								+ list6.getList().get(4).getCount()
								+ list7.getList().get(4).getCount()
								+ list8.getList().get(4).getCount());
		list10.getList()
				.get(5)
				.setCount(
						list1.getList().get(5).getCount()
								+ list2.getList().get(5).getCount()
								+ list3.getList().get(5).getCount()
								+ list4.getList().get(5).getCount()
								+ list5.getList().get(5).getCount()
								+ list6.getList().get(5).getCount()
								+ list7.getList().get(5).getCount()
								+ list8.getList().get(5).getCount());
		list10.getList()
				.get(6)
				.setCount(
						list1.getList().get(6).getCount()
								+ list2.getList().get(6).getCount()
								+ list3.getList().get(6).getCount()
								+ list4.getList().get(6).getCount()
								+ list5.getList().get(6).getCount()
								+ list6.getList().get(6).getCount()
								+ list7.getList().get(6).getCount()
								+ list8.getList().get(6).getCount());
		int stepIdCount10 = stepIdCount1 + stepIdCount2 + stepIdCount3
				+ stepIdCount4 + stepIdCount5 + stepIdCount6 + stepIdCount7
				+ stepIdCount8;

		ArrayList<Object[]> stepList = new ArrayList<Object[]>();
		stepList.add(new Object[] { "01用户申请", list1.getList(), stepIdCount1 });
		stepList.add(new Object[] { "02初步审核", list2.getList(), stepIdCount2 });
		stepList.add(new Object[] { "03交施工费", list3.getList(), stepIdCount3 });
		stepList.add(new Object[] { "04水费清算", list4.getList(), stepIdCount4 });
		stepList.add(new Object[] { "05供水协议", list5.getList(), stepIdCount5 });
		stepList.add(new Object[] { "06施工竣工", list6.getList(), stepIdCount6 });
		stepList.add(new Object[] { "07通水停水", list7.getList(), stepIdCount7 });
		stepList.add(new Object[] { "08档案存档", list8.getList(), stepIdCount8 });
		stepList.add(new Object[] { "待办总数", list10.getList(), stepIdCount10 });
		stepList.add(new Object[] { "工单完成", list0.getList(), stepIdCount0 });
		stepList.add(new Object[] { "工单终止", list9.getList(), stepIdCount9 });
		map.put("stepList", stepList);
		return "/SY/page/be_reportProgress.jsp";
	}

}
