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
	 * 查询水类型
	 */
	@RequestMapping("/queryCost")
	public String queryCost(ModelMap map) {
		List<SyCostType> listCost = syCostTypeService.queryCost();
		map.put("ListCost", listCost);
		return "/SY/page/sys_waterType.jsp";
	}

	/**
	 * 添加水类型
	 */
	@RequestMapping("/saveCost")
	public String saveCost(SyCostType sy, ModelMap map) {
		if (sy != null)
			syCostTypeService.saveCost(sy);
		return queryCost(map);
	}

	/**
	 * 查询单个水类型
	 */
	@RequestMapping("/queryOneCost")
	public String queryOneCost(HttpServletRequest request, ModelMap map) {
		int id = Integer.parseInt(request.getParameter("id"));
		SyCostType cost = syCostTypeService.queryOneCost(id);
		map.put("cost", cost);
		return "/SY/page/sys_waterType_update.jsp";
	}

	/**
	 * 修改单个水类型
	 */
	@RequestMapping("/updateCost")
	public String updateCost(SyCostType sy, ModelMap map) {
		syCostTypeService.updateCost(sy);
		return queryCost(map);
	}

	/**
	 * 修改禁止水类型
	 */
	@RequestMapping("/updateCostDisabled")
	public String updateCostDisabled(ModelMap map, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		syCostTypeService.updateCostDisabled(id);
		return queryCost(map);
	}

	// --------------------
	/**
	 * 查询附加费类型
	 */
	@RequestMapping("/querySurcharge")
	public String querySurcharge(ModelMap map) {
		List<SyCostType> surcharge = syCostTypeService.querySurcharge();
		map.put("surcharge", surcharge);
		return "/SY/page/sys_surcharge.jsp";
	}

	/**
	 * 添加附加费类型,添加附加费关联 一对多 水类型
	 */
	@RequestMapping("/saveSurcharge")
	public String saveSurcharge(SyCostType sy, ModelMap map,
			HttpServletRequest request) {
		String name[] = request.getParameterValues("cost");// 得到所有的多选框
		int id = syCostTypeService.selectMax() + 1; // 得到当前数据库最大的ID
		selectDeleteUpdate(sy, name, id);
		if (sy != null)
			syCostTypeService.saveCost(sy);
		return querySurcharge(map);
	}

	/**
	 * 封装水类型和附加费的方法
	 * 
	 * @param sy  实体类
	 * @param name 所有的多选框
	 * @param id 当前id
	 */
	private void selectDeleteUpdate(SyCostType sy, String[] name, int id) {
		String nameCost = "";
		SySurcharge ss = new SySurcharge();
		for (int i = 0; i < name.length; i++) {
			String sp[] = name[i].split("-");
			nameCost += sp[1] + ",";
			ss.setSurchargeId(id);
			ss.setWaterTypeId(Integer.parseInt(sp[0]));// 添加sy_surcharge附加费关联表
			sySurchargeService.saveSucharge(ss);
		}
		nameCost = nameCost.substring(0, nameCost.length() - 1);
		sy.setCosttypeSurchargeText(nameCost);
	}

	/**
	 * 查询单个附加费类型
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
	 * 修改附加费类型
	 */
	@RequestMapping("/updateSurcharge")
	public String updateSurcharge(SyCostType sy, ModelMap map,
			HttpServletRequest request) {
		int id = sy.getCosttypeId();
		String name[] = request.getParameterValues("cost");// 得到所有的多选框
		sySurchargeService.deleteSucharge(id);// 根据附加费ID删除所有对应的水类型
		selectDeleteUpdate(sy, name, id);// 封装方法
		syCostTypeService.updateCost(sy);// 修改附加费
		return querySurcharge(map);
	}

	/**
	 * 修改附加费类型的状态, 修改禁用的就会删除对应附加费关联
	 */
	@RequestMapping("/updateSurchargeDisabled")
	public String updateSurchargeDisabled(ModelMap map,
			HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		sySurchargeService.deleteSucharge(id);// 根据附加费ID删除所有对应的水类型
		syCostTypeService.updateSurchargeDisabled(id);
		return querySurcharge(map);
	}

}
