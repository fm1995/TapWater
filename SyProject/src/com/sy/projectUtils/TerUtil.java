package com.sy.projectUtils;


public class TerUtil {
	
	private Integer pageSize;
	private Integer start;
	
	private Integer meterAge;	//	����
	
	private String startDate;	//�������--����ʼ����
	
	private String endDate;	//�������--����������
	
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getMeterAge() {
		return meterAge;
	}
	public void setMeterAge(Integer meterAge) {
		this.meterAge = meterAge;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "termUtil [pageSize=" + pageSize + ", start=" + start
				+ ", meterAge=" + meterAge + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
}
