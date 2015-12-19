package com.sy.entity;

public class PySumreport {
    private Integer id;

    private Integer typee;

    private Integer reportYear;

    private Integer reportMonth;

    private Integer lineNo;

    private String c1;

    private String c2;

    private String c3;

    private String c4;

    private String c5;

    
    @Override
	public String toString() {
		return "PySumreport [id=" + id + ", typee=" + typee + ", reportYear="
				+ reportYear + ", reportMonth=" + reportMonth + ", lineNo="
				+ lineNo + ", c1=" + c1 + ", c2=" + c2 + ", c3=" + c3 + ", c4="
				+ c4 + ", c5=" + c5 + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypee() {
        return typee;
    }

    public void setTypee(Integer typee) {
        this.typee = typee;
    }

    public Integer getReportYear() {
        return reportYear;
    }

    public void setReportYear(Integer reportYear) {
        this.reportYear = reportYear;
    }

    public Integer getReportMonth() {
        return reportMonth;
    }

    public void setReportMonth(Integer reportMonth) {
        this.reportMonth = reportMonth;
    }

    public Integer getLineNo() {
        return lineNo;
    }

    public void setLineNo(Integer lineNo) {
        this.lineNo = lineNo;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1 == null ? null : c1.trim();
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2 == null ? null : c2.trim();
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3 == null ? null : c3.trim();
    }

    public String getC4() {
        return c4;
    }

    public void setC4(String c4) {
        this.c4 = c4 == null ? null : c4.trim();
    }

    public String getC5() {
        return c5;
    }

    public void setC5(String c5) {
        this.c5 = c5 == null ? null : c5.trim();
    }
}