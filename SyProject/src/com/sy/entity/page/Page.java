package com.sy.entity.page;

public class Page {
	private Integer pageSize;   //页面显示数据条数
	
	private Integer pageNumber;  //显示第?页数据
	
	private Integer pageCount;   //总数据条数
	
	private Integer pageNum;     //显示计算页数

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Page() {
		
	}
	

	public Page(Integer pageSize, Integer pageNumber, Integer pageCount) {
	
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		this.pageCount = pageCount;
	}
	public Page(Integer pageSize, Integer pageNumber) {
		
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	
	

}
