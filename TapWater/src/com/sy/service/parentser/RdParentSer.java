package com.sy.service.parentser;

import org.springframework.beans.factory.annotation.Autowired;

import com.sy.mappdao.*;

public class RdParentSer {
	// RD系列
	@Autowired
	private RdChangemaxvalueMapper rdChangemaxvalueMapper;
	@Autowired
	private RdChangevalueMapper rdChangevalueMapper;
	@Autowired
	private RdReadMapper rdReadMapper;
	@Autowired
	private RdReadtypesMapper rdReadtypesMapper;
	@Autowired
	private RdTaskMapper rdTaskMapper;
	@Autowired
	private RdVolumeMapper rdVolumeMapper;
	@Autowired
	private RdYearmonthMapper rdYearmonthMapper;

	public RdChangemaxvalueMapper getRdChangemaxvalueMapper() {
		return rdChangemaxvalueMapper;
	}

	public void setRdChangemaxvalueMapper(
			RdChangemaxvalueMapper rdChangemaxvalueMapper) {
		this.rdChangemaxvalueMapper = rdChangemaxvalueMapper;
	}

	public RdChangevalueMapper getRdChangevalueMapper() {
		return rdChangevalueMapper;
	}

	public void setRdChangevalueMapper(RdChangevalueMapper rdChangevalueMapper) {
		this.rdChangevalueMapper = rdChangevalueMapper;
	}

	public RdReadMapper getRdReadMapper() {
		return rdReadMapper;
	}

	public void setRdReadMapper(RdReadMapper rdReadMapper) {
		this.rdReadMapper = rdReadMapper;
	}

	public RdReadtypesMapper getRdReadtypesMapper() {
		return rdReadtypesMapper;
	}

	public void setRdReadtypesMapper(RdReadtypesMapper rdReadtypesMapper) {
		this.rdReadtypesMapper = rdReadtypesMapper;
	}

	public RdTaskMapper getRdTaskMapper() {
		return rdTaskMapper;
	}

	public void setRdTaskMapper(RdTaskMapper rdTaskMapper) {
		this.rdTaskMapper = rdTaskMapper;
	}

	public RdVolumeMapper getRdVolumeMapper() {
		return rdVolumeMapper;
	}

	public void setRdVolumeMapper(RdVolumeMapper rdVolumeMapper) {
		this.rdVolumeMapper = rdVolumeMapper;
	}

	public RdYearmonthMapper getRdYearmonthMapper() {
		return rdYearmonthMapper;
	}

	public void setRdYearmonthMapper(RdYearmonthMapper rdYearmonthMapper) {
		this.rdYearmonthMapper = rdYearmonthMapper;
	}

}
