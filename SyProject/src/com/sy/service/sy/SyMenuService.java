package com.sy.service.sy;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.SyMenu;
/*
 * ��ѯ���еĲ˵��б�
 */
@Service
public class SyMenuService extends SyParent {
	public List<SyMenu> querySyMenu() {
		return syMenuMapper.selectSyMenu();
	}
}