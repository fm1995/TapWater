package com.sy.dto;

import java.util.List;

import com.sy.entity.UsUser;

/**
 * 收费管理中为报表携带 数据
 * @author BarryLiu
 *
 */
public class SfglDto {
	
	
	private Integer page =1;
	private Integer rows =5;
	
	
	private Integer userMoney;
	
	@Override
	public String toString() {
		return "Report [page=" + page + ", rows=" + rows + ", userMoney="
				+ userMoney + "]";
	}

	public Integer getUserMoney() {
		return userMoney;
	}

	public void setUserMoney(Integer userMoney) {
		this.userMoney = userMoney;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	
}
