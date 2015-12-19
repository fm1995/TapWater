package com.sy.entity;

public class BeFlow {
    private Integer id;

    private String stepName;

    private Integer deptId;

    private Integer type1;

    private Integer type2;

    private Integer type3;

    private Integer type4;

    private Integer type5;

    private Integer type6;

    private Integer type7;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName == null ? null : stepName.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getType1() {
        return type1;
    }

    public void setType1(Integer type1) {
        this.type1 = type1;
    }

    public Integer getType2() {
        return type2;
    }

    public void setType2(Integer type2) {
        this.type2 = type2;
    }

    public Integer getType3() {
        return type3;
    }

    public void setType3(Integer type3) {
        this.type3 = type3;
    }

    public Integer getType4() {
        return type4;
    }

    public void setType4(Integer type4) {
        this.type4 = type4;
    }

    public Integer getType5() {
        return type5;
    }

    public void setType5(Integer type5) {
        this.type5 = type5;
    }

    public Integer getType6() {
        return type6;
    }

    public void setType6(Integer type6) {
        this.type6 = type6;
    }

    public Integer getType7() {
        return type7;
    }

    public void setType7(Integer type7) {
        this.type7 = type7;
    }

	@Override
	public String toString() {
		return "BeFlow [id=" + id + ", stepName=" + stepName + ", deptId="
				+ deptId + ", type1=" + type1 + ", type2=" + type2 + ", type3="
				+ type3 + ", type4=" + type4 + ", type5=" + type5 + ", type6="
				+ type6 + ", type7=" + type7 + "]";
	}
    
    
}