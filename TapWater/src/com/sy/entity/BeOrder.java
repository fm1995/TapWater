package com.sy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class BeOrder {
    private String orderNo;

    private Integer orderType;

    private Integer stepId;

    private Integer createEmp;

    private Date createDate;

    private Integer completeEmp;

    private Date completeDate;

    private Integer lasteditEmp;

    private Date lasteditDate;

    private String userName;

    private String userType;

    private String address;

    private String linkMan;

    private String phone;

    private String useTarget;

    private Integer houseHeight;

    private Integer maxAmount;

    private Integer meterTypeId;

    private Integer meterCount;

    private String userRemark;

    private String payType;

    private String bankCompany;

    private String bankNum;

    private String oldUserNo;

    private String oldUserName;

    private String oldUserPhone;

    private String oldUserAddr;

    private String oldMeter;

    private Integer auditEmpId;

    private String auditMessage;

    private BigDecimal projectMoney;

    private BigDecimal realMoney;

    private Date payDate;

    private Date projectDate1;

    private Date projectDate2;

    private Integer areaId;

    private String abortCause;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getStepId() {
        return stepId;
    }

    public void setStepId(Integer stepId) {
        this.stepId = stepId;
    }

    public Integer getCreateEmp() {
        return createEmp;
    }

    public void setCreateEmp(Integer createEmp) {
        this.createEmp = createEmp;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCompleteEmp() {
        return completeEmp;
    }

    public void setCompleteEmp(Integer completeEmp) {
        this.completeEmp = completeEmp;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public Integer getLasteditEmp() {
        return lasteditEmp;
    }

    public void setLasteditEmp(Integer lasteditEmp) {
        this.lasteditEmp = lasteditEmp;
    }

    public Date getLasteditDate() {
        return lasteditDate;
    }

    public void setLasteditDate(Date lasteditDate) {
        this.lasteditDate = lasteditDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getUseTarget() {
        return useTarget;
    }

    public void setUseTarget(String useTarget) {
        this.useTarget = useTarget == null ? null : useTarget.trim();
    }

    public Integer getHouseHeight() {
        return houseHeight;
    }

    public void setHouseHeight(Integer houseHeight) {
        this.houseHeight = houseHeight;
    }

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Integer getMeterTypeId() {
        return meterTypeId;
    }

    public void setMeterTypeId(Integer meterTypeId) {
        this.meterTypeId = meterTypeId;
    }

    public Integer getMeterCount() {
        return meterCount;
    }

    public void setMeterCount(Integer meterCount) {
        this.meterCount = meterCount;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark == null ? null : userRemark.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getBankCompany() {
        return bankCompany;
    }

    public void setBankCompany(String bankCompany) {
        this.bankCompany = bankCompany == null ? null : bankCompany.trim();
    }

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum == null ? null : bankNum.trim();
    }

    public String getOldUserNo() {
        return oldUserNo;
    }

    public void setOldUserNo(String oldUserNo) {
        this.oldUserNo = oldUserNo == null ? null : oldUserNo.trim();
    }

    public String getOldUserName() {
        return oldUserName;
    }

    public void setOldUserName(String oldUserName) {
        this.oldUserName = oldUserName == null ? null : oldUserName.trim();
    }

    public String getOldUserPhone() {
        return oldUserPhone;
    }

    public void setOldUserPhone(String oldUserPhone) {
        this.oldUserPhone = oldUserPhone == null ? null : oldUserPhone.trim();
    }

    public String getOldUserAddr() {
        return oldUserAddr;
    }

    public void setOldUserAddr(String oldUserAddr) {
        this.oldUserAddr = oldUserAddr == null ? null : oldUserAddr.trim();
    }

    public String getOldMeter() {
        return oldMeter;
    }

    public void setOldMeter(String oldMeter) {
        this.oldMeter = oldMeter == null ? null : oldMeter.trim();
    }

    public Integer getAuditEmpId() {
        return auditEmpId;
    }

    public void setAuditEmpId(Integer auditEmpId) {
        this.auditEmpId = auditEmpId;
    }

    public String getAuditMessage() {
        return auditMessage;
    }

    public void setAuditMessage(String auditMessage) {
        this.auditMessage = auditMessage == null ? null : auditMessage.trim();
    }

    public BigDecimal getProjectMoney() {
        return projectMoney;
    }

    public void setProjectMoney(BigDecimal projectMoney) {
        this.projectMoney = projectMoney;
    }

    public BigDecimal getRealMoney() {
        return realMoney;
    }

    public void setRealMoney(BigDecimal realMoney) {
        this.realMoney = realMoney;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getProjectDate1() {
        return projectDate1;
    }

    public void setProjectDate1(Date projectDate1) {
        this.projectDate1 = projectDate1;
    }

    public Date getProjectDate2() {
        return projectDate2;
    }

    public void setProjectDate2(Date projectDate2) {
        this.projectDate2 = projectDate2;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAbortCause() {
        return abortCause;
    }

    public void setAbortCause(String abortCause) {
        this.abortCause = abortCause == null ? null : abortCause.trim();
    }
}