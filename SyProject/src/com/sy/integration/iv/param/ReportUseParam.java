package com.sy.integration.iv.param;

//发票使用情况查询条件封装类
public class ReportUseParam {
	// 收费员ID
	private Integer empId;
	// 发票号码(开始)
	private String startNo;
	// 发票号码(结束)
	private String endNo;
	// 使用日期(开始)
	private String useDateStart;
	// 使用时间(结束)
	private String useDateEnd;
	// 是否使用
	private Integer isUsed;
	// 是否作废
//	private Integer isInvalid;
	// 是否交票
	private Integer isArchived;
	// 发票类型
	private Integer invoiceType;
	// 用户编码
	private String userNo;
	// 分页--起始条数
	private Integer page;
	// 分页--最大条数
	private Integer maxPage;
	// 分页--总条数
	private Integer maxCount;
	// 分页--总页数
	private Integer pageCount;

	public Integer getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(Integer maxCount) {
		this.maxCount = maxCount;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		if (page != null)
			this.page = page;
		else
			this.page = 0;
	}

	public Integer getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(Integer maxPage) {
		if (maxPage != null)
			this.maxPage = maxPage;
		else
			this.maxPage = 12;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getStartNo() {
		return startNo;
	}

	public void setStartNo(String startNo) {
		this.startNo = startNo;
	}

	public String getEndNo() {
		return endNo;
	}

	public void setEndNo(String endNo) {
		this.endNo = endNo;
	}

	public String getUseDateStart() {
		return useDateStart;
	}

	public void setUseDateStart(String useDateStart) {
		this.useDateStart = useDateStart;
	}

	public String getUseDateEnd() {
		return useDateEnd;
	}

	public void setUseDateEnd(String useDateEnd) {
		this.useDateEnd = useDateEnd;
	}

	public Integer getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public Integer getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(Integer isUsed) {
		this.isUsed = isUsed;
	}

//	public Integer getIsInvalid() {
//		return isInvalid;
//	}
//
//	public void setIsInvalid(Integer isInvalid) {
//		this.isInvalid = isInvalid;
//	}

	public Integer getIsArchived() {
		return isArchived;
	}

	public void setIsArchived(Integer isArchived) {
		this.isArchived = isArchived;
	}

	@Override
	public String toString() {
		return "ReportUseParam [empId=" + empId + ", startNo=" + startNo
				+ ", endNo=" + endNo + ", useDateStart=" + useDateStart
				+ ", useDateEnd=" + useDateEnd + ", isUsed=" + isUsed
				+ ", isArchived=" + isArchived + ", invoiceType=" + invoiceType
				+ ", userNo=" + userNo + ", page=" + page + ", maxPage="
				+ maxPage + ", maxCount=" + maxCount + ", pageCount="
				+ pageCount + "]";
	}

}
