package com.sy.integration.iv;

public class PageClass {
	private Integer page, maxPage, pageCount, AllCount;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getAllCount() {
		return AllCount;
	}

	public void setAllCount(Integer allCount) {
		AllCount = allCount;
	}

	@Override
	public String toString() {
		return "Page [page=" + page + ", maxPage=" + maxPage + ", pageCount="
				+ pageCount + ", AllCount=" + AllCount + "]";
	}

}
