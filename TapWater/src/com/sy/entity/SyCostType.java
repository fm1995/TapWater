package com.sy.entity;

import java.math.BigDecimal;

public class SyCostType {
    private Integer costtypeId;

    private Integer costtypeKind;

    private String costtypeCode;

    private String costTypeName;

    private String costtypeFullName;

    private BigDecimal costtypePrice;

    private String costtypeSurchargeText;

    private String costtypeRemark;

    private Boolean costtypeDisabled;

    public Integer getCosttypeId() {
        return costtypeId;
    }

    public void setCosttypeId(Integer costtypeId) {
        this.costtypeId = costtypeId;
    }

    public Integer getCosttypeKind() {
        return costtypeKind;
    }

    public void setCosttypeKind(Integer costtypeKind) {
        this.costtypeKind = costtypeKind;
    }

    public String getCosttypeCode() {
        return costtypeCode;
    }

    public void setCosttypeCode(String costtypeCode) {
        this.costtypeCode = costtypeCode == null ? null : costtypeCode.trim();
    }

    public String getCostTypeName() {
        return costTypeName;
    }

    public void setCostTypeName(String costTypeName) {
        this.costTypeName = costTypeName == null ? null : costTypeName.trim();
    }

    public String getCosttypeFullName() {
        return costtypeFullName;
    }

    public void setCosttypeFullName(String costtypeFullName) {
        this.costtypeFullName = costtypeFullName == null ? null : costtypeFullName.trim();
    }

    public BigDecimal getCosttypePrice() {
        return costtypePrice;
    }

    public void setCosttypePrice(BigDecimal costtypePrice) {
        this.costtypePrice = costtypePrice;
    }

    public String getCosttypeSurchargeText() {
        return costtypeSurchargeText;
    }

    public void setCosttypeSurchargeText(String costtypeSurchargeText) {
        this.costtypeSurchargeText = costtypeSurchargeText == null ? null : costtypeSurchargeText.trim();
    }

    public String getCosttypeRemark() {
        return costtypeRemark;
    }

    public void setCosttypeRemark(String costtypeRemark) {
        this.costtypeRemark = costtypeRemark == null ? null : costtypeRemark.trim();
    }

    public Boolean getCosttypeDisabled() {
        return costtypeDisabled;
    }

    public void setCosttypeDisabled(Boolean costtypeDisabled) {
        this.costtypeDisabled = costtypeDisabled;
    }
}