package com.sy.controller.sy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sy.entity.SyCostType;
import com.sy.entity.SySurcharge;
import com.sy.service.sy.SyCostTypeService;
import com.sy.service.sy.SySurchargeService;

@Controller
@SessionAttributes(value = { "ListCost" })
@RequestMapping("/sy")
public class Sy_CostController {
	@Autowired
	private SyCostTypeService syCostTypeService;
	@Autowired
	private SySurchargeService sySurchargeService;

	/**
	 * ��ѯˮ����
	 */
	@RequestMapping("/queryCost")
	public String queryCost(ModelMap map) {
		List<SyCostType> listCost = syCostTypeService.queryCost();
		map.put("ListCost", listCost);
		return "/SY/page/sys_waterType.jsp";
	}

	/**
	 * ���ˮ����
	 */
	@RequestMapping("/saveCost")
	public String saveCost(SyCostType sy, ModelMap map) {
		if (sy != null)
			syCostTypeService.saveCost(sy);
		return queryCost(map);
	}

	/**
	 * ��ѯ����ˮ����
	 */
	@RequestMapping("/queryOneCost")
	public String queryOneCost(HttpServletRequest request, ModelMap map) {
		int id = Integer.parseInt(request.getParameter("id"));
		SyCostType cost = syCostTypeService.queryOneCost(id);
		map.put("cost", cost);
		return "/SY/page/sys_waterType_update.jsp";
	}

	/**
	 * �޸ĵ���ˮ����
	 */
	@RequestMapping("/updateCost")
	public String updateCost(SyCostType sy, ModelMap map) {
		syCostTypeService.updateCost(sy);
		return queryCost(map);
	}

	/**
	 * �޸Ľ�ֹˮ����
	 */
	@RequestMapping("/updateCostDisabled")
	public String updateCostDisabled(ModelMap map, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		syCostTypeService.updateCostDisabled(id);
		return queryCost(map);
	}

	// --------------------
	/**
	 * ��ѯ���ӷ�����
	 */
	@RequestMapping("/querySurcharge")
	public String querySurcharge(ModelMap map) {
		List<SyCostType> surcharge = syCostTypeService.querySurcharge();
		map.put("surcharge", surcharge);
		return "/SY/page/sys_surcharge.jsp";
	}

	/**
	 * ��Ӹ��ӷ�����,��Ӹ��ӷѹ��� һ�Զ� ˮ����
	 */
	@RequestMapping("/saveSurcharge")
	public String saveSurcharge(SyCostType sy, ModelMap map,
			HttpServletRequest request) {
		String name[] = request.getParameterValues("cost");// �õ����еĶ�ѡ��
		int id = syCostTypeService.selectMax() + 1; // �õ���ǰ���ݿ�����ID
		selectDeleteUpdate(sy, name, id);
		if (sy != null)
			syCostTypeService.saveCost(sy);
		return querySurcharge(map);
	}

	/**
	 * ��װˮ���ͺ͸��ӷѵķ���
	 * 
	 * @param sy  ʵ����
	 * @param name ���еĶ�ѡ��
	 * @param id ��ǰid
	 */
	private void selectDeleteUpdate(SyCostType sy, String[] name, int id) {
		String nameCost = "";
		SySurcharge ss = new SySurcharge();
		for (int i = 0; i < name.length; i++) {
			String sp[] = name[i].split("-");
			nameCost += sp[1] + ",";
			ss.setSurchargeId(id);
			ss.setWaterTypeId(Integer.parseInt(sp[0]));// ���sy_surcharge���ӷѹ�����
			sySurchargeService.saveSucharge(ss);
		}
		nameCost = nameCost.substring(0, nameCost.length() - 1);
		sy.setCosttypeSurchargeText(nameCost);
	}

	/**
	 * ��ѯ�������ӷ�����
	 */
	@RequestMapping("/queryOneSurcharge")
	public String queryOneSurcharge(HttpServletRequest request, ModelMap map) {
		int id = Integer.parseInt(request.getParameter("id"));
		SyCostType costType = syCostTypeService.queryOneCost(id);
		String name[] = costType.getCosttypeSurchargeText().split(",");
		map.put("name", name);
		map.put("costType", costType);
		return "/SY/page/sys_surcharge_update.jsp";
	}

	/**
	 * �޸ĸ��ӷ�����
	 */
	@RequestMapping("/updateSurcharge")
	public String updateSurcharge(SyCostType sy, ModelMap map,
			HttpServletRequest request) {
		int id = sy.getCosttypeId();
		String name[] = request.getParameterValues("cost");// �õ����еĶ�ѡ��
		sySurchargeService.deleteSucharge(id);// ���ݸ��ӷ�IDɾ�����ж�Ӧ��ˮ����
		selectDeleteUpdate(sy, name, id);// ��װ����
		syCostTypeService.updateCost(sy);// �޸ĸ��ӷ�
		return querySurcharge(map);
	}

	/**
	 * �޸ĸ��ӷ����͵�״̬, �޸Ľ��õľͻ�ɾ����Ӧ���ӷѹ���
	 */
	@RequestMapping("/updateSurchargeDisabled")
	public String updateSurchargeDisabled(ModelMap map,
			HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		sySurchargeService.deleteSucharge(id);// ���ݸ��ӷ�IDɾ�����ж�Ӧ��ˮ����
		syCostTypeService.updateSurchargeDisabled(id);
		return querySurcharge(map);
	}

}
