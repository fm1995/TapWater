package com.sy.entity;

import java.util.Date;

public class IvArchive {
    private Integer id;

    private Integer empId;

    private Integer inId;

    private String startNo;

    private String endNo;

    private Integer counts;

    private Date archiveDate;

    private Integer archiveEmpId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getArchiveDate() {
        return archiveDate;
    }

    public void setArchiveDate(Date archiveDate) {
        this.archiveDate = archiveDate;
    }

    public Integer getArchiveEmpId() {
        return archiveEmpId;
    }

    public void setArchiveEmpId(Integer archiveEmpId) {
        this.archiveEmpId = archiveEmpId;
    }
}