package com.sy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class UsUser {
    private String userNo;

    private String userName;

    private String abc;

    private Date createDate;

    private String address;

    private String phone;

    private String smsPhone;

    private Integer areaId;

    private String userType;

    private String payType;

    private String bankName;

    private String bankNum;

    private String formula;

    private BigDecimal userMoney;

    private Integer meterId;

    private String docNum;

    private String pwd;

    private String contractNum;

    private Date contractDate;

    private Integer volumeId;

    private Integer volumeOrderIndex;

    private Boolean userDisabled;

    
    @Override
	public String toString() {
		return "UsUser [userNo=" + userNo + ", userName=" + userName + ", abc="
				+ abc + ", createDate=" + createDate + ", address=" + address
				+ ", phone=" + phone + ", smsPhone=" + smsPhone + ", areaId="
				+ areaId + ", userType=" + userType + ", payType=" + payType
				+ ", bankName=" + bankName + ", bankNum=" + bankNum
				+ ", formula=" + formula + ", userMoney=" + userMoney
				+ ", meterId=" + meterId + ", docNum=" + docNum + ", pwd="
				+ pwd + ", contractNum=" + contractNum + ", contractDate="
				+ contractDate + ", volumeId=" + volumeId
				+ ", volumeOrderIndex=" + volumeOrderIndex + ", userDisabled="
				+ userDisabled + "]";
	}

	public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc == null ? null : abc.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSmsPhone() {
        return smsPhone;
    }

    public void setSmsPhone(String smsPhone) {
        this.smsPhone = smsPhone == null ? null : smsPhone.trim();
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum == null ? null : bankNum.trim();
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula == null ? null : formula.trim();
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    public Integer getMeterId() {
        return meterId;
    }

    public void setMeterId(Integer meterId) {
        this.meterId = meterId;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum == null ? null : docNum.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum == null ? null : contractNum.trim();
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public Integer getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(Integer volumeId) {
        this.volumeId = volumeId;
    }

    public Integer getVolumeOrderIndex() {
        return volumeOrderIndex;
    }

    public void setVolumeOrderIndex(Integer volumeOrderIndex) {
        this.volumeOrderIndex = volumeOrderIndex;
    }

    public Boolean getUserDisabled() {
        return userDisabled;
    }

    public void setUserDisabled(Boolean userDisabled) {
        this.userDisabled = userDisabled;
    }
}