package com.sy.entity;

public class BeOrderTable {

	private int orderType;
	private int count;
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public BeOrderTable(int orderType, int count) {
		this.orderType = orderType;
		this.count = count;
	}
	public BeOrderTable() {
	}
	
	
	
}
