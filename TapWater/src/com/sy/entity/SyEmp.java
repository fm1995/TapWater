package com.sy.entity;

public class SyEmp {
    private Integer empId;

    private String empName;

    private String empNo;

    private String empPwd;

    private Integer deptId;

    private String empRemark;

    private Boolean empDisabled;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo == null ? null : empNo.trim();
    }

    public String getEmpPwd() {
        return empPwd;
    }

    public void setEmpPwd(String empPwd) {
        this.empPwd = empPwd == null ? null : empPwd.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getEmpRemark() {
        return empRemark;
    }

    public void setEmpRemark(String empRemark) {
        this.empRemark = empRemark == null ? null : empRemark.trim();
    }

    public Boolean getEmpDisabled() {
        return empDisabled;
    }

    public void setEmpDisabled(Boolean empDisabled) {
        this.empDisabled = empDisabled;
    }
}