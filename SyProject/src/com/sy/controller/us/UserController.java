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
 * @author �佨�� user_controller �û� 
 * */

@Controller
@RequestMapping(value = "/controller")
public class UserController {

	// ע�� user�û������
	@Autowired
	private UsUserService userService;

	// �����ǩ -��������ѯ�û���
	@RequestMapping("/queryUsUser")
	@ResponseBody
	public List<UsUser> queryUsUsers(HttpServletResponse response, UsUser user)
			throws IOException {

		return userService.queryUsUsers(user);

	}

	// �����ǩ-����ǩЭ�顿
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

	// �������-��ע���û���
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

	/* ��ݲ�����¼-���󶨲���Ա���� */
	@RequestMapping(value = "/queryEmpAll")
	@ResponseBody
	public List<SyEmp> queryEmpAll() {
		return userService.queryEmpAll();

	}

	/* ��ݲ�����¼-����������ɸѡ����ƥ��Ŀ�ݲ�����¼��ʾ�� */
	@RequestMapping(value = "/queryBeOrderLites")
	@ResponseBody
	public List<BeOrderlite> queryBeOrderLitesByParemter(OrderLite orderLite,
			Page page) {
		List<BeOrderlite> orderLites = userService
				.queryOrderliteByParameter(new UserUtility()
						.converToBeOrderLite(orderLite, page));
		return orderLites;
	}

	/* ��ʾ��¼��Ա����Ϣ */
	@RequestMapping(value = "/getSyEmpNo")
	@ResponseBody
	public SyEmp getSyEmp(HttpServletRequest request) {
		SyEmp emp = (SyEmp) request.getSession().getAttribute("empLogin");
		return emp;
	}

	// ��֤���ݿ����Ƿ������ͬ�ĵ�����
	@RequestMapping(value = "/queryDocByDocnum")
	@ResponseBody
	public String queryDocByDocnum(UsUser user) {
		return userService.queryDocNumByDocnum(user.getDocNum());
	}

	/* �޸ĵ����� */
	@RequestMapping(value = "/updateDoc")
	@ResponseBody
	public Integer updateDoc(UsUser user) {
		return userService.updateDocById(user);
	}

	/* ����Ⱥ��-��������ɷ�����š� */
	@RequestMapping(value = "/generateContext")
	@ResponseBody
	public Integer generateContext() {
		Random r = new Random();
		return r.nextInt(5);

	}

	/* ��ѯֻ��Ƿ���û����͵��û����� */
	@RequestMapping(value = "/queryUserDate")
	@ResponseBody
	public List<UsUserHelpBean> queryMassUserData(UsUserHelpBean userBean) {

		return userService.queryMassUserData(userBean);
	}

	/* Ⱥ���Ķ�������Excel����浵-���½����Ҵ浵�� */
	@RequestMapping(value = "/generateTableExcel")
	public void generateTableExcel(UsUserHelpBean userBean) {
		userService.generateExcelTable(userBean);
	}

	/* Ⱥ���Ķ�������Excel����浵-����ԭ�����ļ�������������ݲ��Ҵ浵�� */
	@RequestMapping(value = "/addTableExcel")
	public void addTableExcel(UsUserHelpBean userBean) {
		userService.addExcelTable(userBean);
	}

	/* ��ݻ���-��������ѯ�û���Ϣ�� */
	@RequestMapping(value = "/queryChangeTable")
	@ResponseBody
	public List<MeterView> queryChangeTable(UsUser user) {
		return userService.queryChangeTable(user);

	}

	/* ��ݻ���-�������� */
	@RequestMapping(value = "/replaceMeter")
	@ResponseBody
	public Integer replaceMeter(HttpServletRequest request, UsMeter meter,
			String userName) {
		return userService.updateMeter(request, meter, userName);
	}

	/* ��ݻ���-�����ˮ�����͡� */
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

	// @author ��Ө
	// ��ݹ���
	@RequestMapping(value = "/updateUser")
	public void updateUser(HttpServletRequest request, UsUser user) {
		userService.updateUserByUserNo(user, request);
	}

}
