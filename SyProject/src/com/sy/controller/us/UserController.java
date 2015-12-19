package com.sy.controller.us;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sy.entity.BeOrderlite;
import com.sy.entity.SyEmp;
import com.sy.entity.SyMeterType;
import com.sy.entity.UsMeter;
import com.sy.entity.UsUser;
import com.sy.entity.page.Page;
import com.sy.entity.userhelp.OrderLite;
import com.sy.entity.userhelp.UsUserHelpBean;
import com.sy.entity.view.MeterView;
import com.sy.projectUtils.UserUtility;
import com.sy.service.us.UsUserService;

/*
 * @author 卿建锋 user_controller 用户 
 * */

@Controller
@RequestMapping(value = "/controller")
public class UserController {

	// 注入 user用户服务层
	@Autowired
	private UsUserService userService;

	// 快捷重签 -【条件查询用户】
	@RequestMapping("/queryUsUser")
	@ResponseBody
	public List<UsUser> queryUsUsers(HttpServletResponse response, UsUser user)
			throws IOException {

		return userService.queryUsUsers(user);

	}

	// 快捷重签-【重签协议】
	@RequestMapping(value = "/updateFormulaForUsUser")
	@ResponseBody
	public Integer updateFormulaForUsUser(HttpServletRequest request,
			UsUser user, Integer orderType, String description) {

		BeOrderlite orderLite = new BeOrderlite();
		orderLite.setOrderType(orderType);
		orderLite.setDescription(description);

		int num = userService.updateProtocol(request, user, orderLite);

		return num;
	}

	// 快捷销户-【注销用户】
	@RequestMapping(value = "/updataUserAndCancellation")
	@ResponseBody
	public Integer updataUserAndCancellation(HttpServletRequest request,
			UsUser user, Integer orderType, String description) {

		BeOrderlite orderLite = new BeOrderlite();
		orderLite.setOrderType(orderType);
		orderLite.setDescription(description);
		int num = userService.addUserByCancellation(request, user, orderLite);
		return num;
	}

	/* 快捷操作记录-【绑定操作员工】 */
	@RequestMapping(value = "/queryEmpAll")
	@ResponseBody
	public List<SyEmp> queryEmpAll() {
		return userService.queryEmpAll();

	}

	/* 快捷操作记录-【按照条件筛选条件匹配的快捷操作记录显示】 */
	@RequestMapping(value = "/queryBeOrderLites")
	@ResponseBody
	public List<BeOrderlite> queryBeOrderLitesByParemter(OrderLite orderLite,
			Page page) {
		List<BeOrderlite> orderLites = userService
				.queryOrderliteByParameter(new UserUtility()
						.converToBeOrderLite(orderLite, page));
		return orderLites;
	}

	/* 显示登录的员工信息 */
	@RequestMapping(value = "/getSyEmpNo")
	@ResponseBody
	public SyEmp getSyEmp(HttpServletRequest request) {
		SyEmp emp = (SyEmp) request.getSession().getAttribute("empLogin");
		return emp;
	}

	// 验证数据库内是否存在相同的档案号
	@RequestMapping(value = "/queryDocByDocnum")
	@ResponseBody
	public String queryDocByDocnum(UsUser user) {
		return userService.queryDocNumByDocnum(user.getDocNum());
	}

	/* 修改档案号 */
	@RequestMapping(value = "/updateDoc")
	@ResponseBody
	public Integer updateDoc(UsUser user) {
		return userService.updateDocById(user);
	}

	/* 短信群发-【随机生成发送序号】 */
	@RequestMapping(value = "/generateContext")
	@ResponseBody
	public Integer generateContext() {
		Random r = new Random();
		return r.nextInt(5);

	}

	/* 查询只给欠费用户发送的用户数据 */
	@RequestMapping(value = "/queryUserDate")
	@ResponseBody
	public List<UsUserHelpBean> queryMassUserData(UsUserHelpBean userBean) {

		return userService.queryMassUserData(userBean);
	}

	/* 群发的短信生成Excel报表存档-【新建并且存档】 */
	@RequestMapping(value = "/generateTableExcel")
	public void generateTableExcel(UsUserHelpBean userBean) {
		userService.generateExcelTable(userBean);
	}

	/* 群发的短信生成Excel报表存档-【在原来的文件里面新添加内容并且存档】 */
	@RequestMapping(value = "/addTableExcel")
	public void addTableExcel(UsUserHelpBean userBean) {
		userService.addExcelTable(userBean);
	}

	/* 快捷换表-【条件查询用户信息】 */
	@RequestMapping(value = "/queryChangeTable")
	@ResponseBody
	public List<MeterView> queryChangeTable(UsUser user) {
		return userService.queryChangeTable(user);

	}

	/* 快捷换表-【换表处理】 */
	@RequestMapping(value = "/replaceMeter")
	@ResponseBody
	public Integer replaceMeter(HttpServletRequest request, UsMeter meter,
			String userName) {
		return userService.updateMeter(request, meter, userName);
	}

	/* 快捷换表-【填充水表类型】 */
	@RequestMapping(value = "/fillMeterType")
	@ResponseBody
	public List<SyMeterType> fillMeterType() {
		return userService.bindingMeterType();
	}

	// @author mankey

	@RequestMapping("/monkeyProduct")
	public String monkeyProduct(UsUser user, HttpServletRequest req) {
		Integer update = userService.monkeyUpdate(user, req);
		if (update > 0)
			return "hello";
		else
			return null;
	}

	// @author 刘莹
	// 快捷过户
	@RequestMapping(value = "/updateUser")
	public void updateUser(HttpServletRequest request, UsUser user) {
		userService.updateUserByUserNo(user, request);
	}

}
