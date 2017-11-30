package com.sy.integration.iv;

import java.sql.Date;

	/**发票管理
	 * 发票出库封装类
	 * 
	 *
	 */
public class OutReturnClass {
	private Integer id, counts, usedCount, invalidCount, archivedCount,
			notUsedCount, notArchivedCount;
	private String startNo, endNo, outName, yongName;
	private Date outDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public Integer getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(Integer usedCount) {
		this.usedCount = usedCount;
	}

	public Integer getInvalidCount() {
		return invalidCount;
	}

	public void setInvalidCount(Integer invalidCount) {
		this.invalidCount = invalidCount;
	}

	public Integer getArchivedCount() {
		return archivedCount;
	}

	public void setArchivedCount(Integer archivedCount) {
		this.archivedCount = archivedCount;
	}

	public Integer getNotUsedCount() {
		return notUsedCount;
	}

	public void setNotUsedCount(Integer notUsedCount) {
		this.notUsedCount = notUsedCount;
	}

	public Integer getNotArchivedCount() {
		return notArchivedCount;
	}

	public void setNotArchivedCount(Integer notArchivedCount) {
		this.notArchivedCount = notArchivedCount;
	}

	public String getStartNo() {
		return startNo;
	}

	public void setStartNo(String startNo) {
		this.startNo = startNo;
	}

	public String getEndNo() {
		return endNo;
	}

	public void setEndNo(String endNo) {
		this.endNo = endNo;
	}

	public String getOutName() {
		return outName;
	}

	public void setOutName(String outName) {
		this.outName = outName;
	}

	public String getYongName() {
		return yongName;
	}

	public void setYongName(String yongName) {
		this.yongName = yongName;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	@Override
	public String toString() {
		return "OutReturnClass [id=" + id + ", counts=" + counts
				+ ", usedCount=" + usedCount + ", invalidCount=" + invalidCount
				+ ", archivedCount=" + archivedCount + ", notUsedCount="
				+ notUsedCount + ", notArchivedCount=" + notArchivedCount
				+ ", startNo=" + startNo + ", endNo=" + endNo + ", outName="
				+ outName + ", yongName=" + yongName + ", outDate=" + outDate
				+ "]";
	}

}
