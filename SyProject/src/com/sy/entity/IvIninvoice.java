package com.sy.entity;

import java.util.Date;

public class IvIninvoice {
    private Integer id;

    private Integer invoiceType;

    private String startNo;

    private String endNo;

    private Integer counts;

    private Date inDate;

    private Integer inEmpId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        this.startNo = startNo == null ? null : startNo.trim();
    }

    public String getEndNo() {
        return endNo;
    }

    public void setEndNo(String endNo) {
        this.endNo = endNo == null ? null : endNo.trim();
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Integer getInEmpId() {
        return inEmpId;
    }

    public void setInEmpId(Integer inEmpId) {
        this.inEmpId = inEmpId;
    }
}