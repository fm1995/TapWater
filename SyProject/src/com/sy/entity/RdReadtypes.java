package com.sy.entity;

public class RdReadtypes {
    private Integer id;

    private Integer readId;

    private String userNo;

    private String waterTypeCode;

    private String allotText;

    private Integer amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReadId() {
        return readId;
    }

    public void setReadId(Integer readId) {
        this.readId = readId;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getWaterTypeCode() {
        return waterTypeCode;
    }

    public void setWaterTypeCode(String waterTypeCode) {
        this.waterTypeCode = waterTypeCode == null ? null : waterTypeCode.trim();
    }

    public String getAllotText() {
        return allotText;
    }

    public void setAllotText(String allotText) {
        this.allotText = allotText == null ? null : allotText.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

	@Override
	public String toString() {
		return "RdReadtypes [id=" + id + ", readId=" + readId + ", userNo="
				+ userNo + ", waterTypeCode=" + waterTypeCode + ", allotText="
				+ allotText + ", amount=" + amount + "]";
	}
}