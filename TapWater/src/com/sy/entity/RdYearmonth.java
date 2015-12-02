package com.sy.entity;

import java.util.Date;

public class RdYearmonth {
    private Integer id;

    private Integer readYear;

    private Integer readMonth;

    private Boolean isCurrent;

    private Integer initEmpId;

    private Date initDate;

    private Date endDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReadYear() {
        return readYear;
    }

    public void setReadYear(Integer readYear) {
        this.readYear = readYear;
    }

    public Integer getReadMonth() {
        return readMonth;
    }

    public void setReadMonth(Integer readMonth) {
        this.readMonth = readMonth;
    }

    public Boolean getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(Boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public Integer getInitEmpId() {
        return initEmpId;
    }

    public void setInitEmpId(Integer initEmpId) {
        this.initEmpId = initEmpId;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}