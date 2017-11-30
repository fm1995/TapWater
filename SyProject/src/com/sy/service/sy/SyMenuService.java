package com.sy.service.sy;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.SyMenu;
/*
 * 查询所有的菜单列表
 */
@Service
public class SyMenuService extends SyParent {
	public List<SyMenu> querySyMenu() {
		return syMenuMapper.selectSyMenu();
	}
}