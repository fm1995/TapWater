package com.sy.entity.userhelp;

import java.util.List;

import com.sy.entity.userhelp.UsUserHelpBean;

public class GenerateExcelBean {
	
	private String excelPath;
	
	private String fileName;
	
	private Integer sheetIndex;
	
	private String[] titles={"用户编码","用户姓名","短信号码","发送内容"};
	
	private List<Object []> userBeans;
	
	
	
	public String getExcelPath() {
		return excelPath;
	}

	public void setExcelPath(String excelPath) {
		this.excelPath = excelPath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getSheetIndex() {
		return sheetIndex;
	}

	public void setSheetIndex(Integer sheetIndex) {
		this.sheetIndex = sheetIndex;
	}

	public GenerateExcelBean(String[] titles, List<Object []> userBeans) {
	
		this.titles = titles;
		this.userBeans = userBeans;
	}

	public GenerateExcelBean() {
	}

	public String[] getTitles() {
		return titles;
	}

	public void setTitles(String[] titles) {
		this.titles = titles;
	}

	public List<Object[]> getUserBeans() {
		return userBeans;
	}

	public void setUserBeans(List<Object[]> userBeans) {
		this.userBeans = userBeans;
	}
	
	
	
	

}
