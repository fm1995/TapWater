package com.sy.entity;

import java.util.Date;

public class IvInvoice {
    private String invoiceNo;

    private Integer invoiceType;

    private Integer empId;

    private Integer inId;

    private Integer outId;

    private Integer archiveId;

    private Boolean used;

    private Date useDate;

    private Boolean invalid;

    private Date invalidDate;

    private Boolean archived;

    private Date archiveDate;


	public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
    }

    public Integer getOutId() {
        return outId;
    }

    public void setOutId(Integer outId) {
        this.outId = outId;
    }

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public Boolean getInvalid() {
        return invalid;
    }

    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
    }

    public Date getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(Date invalidDate) {
        this.invalidDate = invalidDate;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Date getArchiveDate() {
        return archiveDate;
    }

    public void setArchiveDate(Date archiveDate) {
        this.archiveDate = archiveDate;
    }


	public IvInvoice() {
	}

	public IvInvoice(String invoiceNo, Integer invoiceType, Integer empId,
			Integer inId, Integer outId, Integer archiveId, Boolean used,
			Boolean invalid,  Boolean archived) {
		this.invoiceNo = invoiceNo;
		this.invoiceType = invoiceType;
		this.empId = empId;
		this.inId = inId;
		this.outId = outId;
		this.archiveId = archiveId;
		this.used = used;
		this.invalid = invalid;
		this.archived = archived;
	}
    
 // 关联PyPay表
 	private PyPay pay;

 	public PyPay getPay() {
 		return pay;
 	}

 	public void setPay(PyPay pay) {
 		this.pay = pay;
 	}

 	// 关联emp表
 	private SyEmp emp;

 	public SyEmp getEmp() {
 		return emp;
 	}

 	public void setEmp(SyEmp emp) {
 		this.emp = emp;
 	}
 	
 	@Override
 	public String toString() {
 		return "IvInvoice [invoiceNo=" + invoiceNo + ", invoiceType="
 				+ invoiceType + ", empId=" + empId + ", inId=" + inId
 				+ ", outId=" + outId + ", archiveId=" + archiveId + ", used="
 				+ used + ", useDate=" + useDate + ", invalid=" + invalid
 				+ ", invalidDate=" + invalidDate + ", archived=" + archived
 				+ ", archiveDate=" + archiveDate + "]";
 	}

}