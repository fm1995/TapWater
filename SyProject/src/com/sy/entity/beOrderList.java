package com.sy.entity;

import java.util.ArrayList;
import java.util.List;

public class beOrderList {

	private List<BeOrderTable> list =new ArrayList<BeOrderTable>();
	
	public beOrderList(){
		list.add(new BeOrderTable(1,0));
		list.add(new BeOrderTable(2,0));
		list.add(new BeOrderTable(3,0));
		list.add(new BeOrderTable(4,0));
		list.add(new BeOrderTable(5,0));
		list.add(new BeOrderTable(6,0));
		list.add(new BeOrderTable(7,0));
	}

	public List<BeOrderTable> getList() {
		return list;
	}

	public void setList(List<BeOrderTable> list) {
		this.list = list;
	}
	
	
	
}
