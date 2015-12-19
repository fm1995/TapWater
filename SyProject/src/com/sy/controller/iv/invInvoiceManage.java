package com.sy.controller.iv;

import java.util.Date;

public class invInvoiceManage {
	private Integer invoiceType;

    private String startNo;

    private String endNo;

    private Integer counts;
    
    private Integer outInvoice;
    
    private Integer notOutInvoice;
    
    private Integer used;
    
    private Integer invalid;
    
    private Integer isUsed;
    
    private Integer archived;
    
    private Integer isArchived;
    
    private Date inDate;

    private String empName;

	public Integer getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
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

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public Integer getOutInvoice() {
		return outInvoice;
	}

	public void setOutInvoice(Integer outInvoice) {
		this.outInvoice = outInvoice;
	}

	public Integer getNotOutInvoice() {
		return notOutInvoice;
	}

	public void setNotOutInvoice(Integer notOutInvoice) {
		this.notOutInvoice = notOutInvoice;
	}

	public Integer getUsed() {
		return used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

	public Integer getInvalid() {
		return invalid;
	}

	public void setInvalid(Integer invalid) {
		this.invalid = invalid;
	}

	public Integer getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(Integer isUsed) {
		this.isUsed = isUsed;
	}

	public Integer getArchived() {
		return archived;
	}

	public void setArchived(Integer archived) {
		this.archived = archived;
	}

	public Integer getIsArchived() {
		return isArchived;
	}

	public void setIsArchived(Integer isArchived) {
		this.isArchived = isArchived;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	
    
}
