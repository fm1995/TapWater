package com.sy.entity;

public class SyDept {
    private Integer deptId;

    private String deptName;

    private String deptRemark;

    private Boolean deptDisabled;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDeptRemark() {
        return deptRemark;
    }

    public void setDeptRemark(String deptRemark) {
        this.deptRemark = deptRemark == null ? null : deptRemark.trim();
    }

    public Boolean getDeptDisabled() {
        return deptDisabled;
    }

    public void setDeptDisabled(Boolean deptDisabled) {
        this.deptDisabled = deptDisabled;
    }
}