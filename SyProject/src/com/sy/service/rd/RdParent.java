package com.sy.service.rd;

import org.springframework.beans.factory.annotation.Autowired;

import com.sy.entity.UsMeter;
import com.sy.mappdao.*;

public class RdParent {
	@Autowired
	protected RdChangemaxvalueMapper rdChangemaxvalueMapper;
	@Autowired
	protected RdChangevalueMapper rdChangevalueMapper;
	@Autowired
	protected RdReadMapper rdReadMapper;
	@Autowired
	protected RdReadtypesMapper rdReadtypesMapper;
	@Autowired
	protected RdTaskMapper rdTaskMapper;
	@Autowired
	protected RdVolumeMapper rdVolumeMapper;
	@Autowired
	protected RdYearmonthMapper rdYearmonthMapper;
	@Autowired
	protected UsMeterMapper usMeterMapper;

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

	public UsMeterMapper getUsMeterMapper() {
		return usMeterMapper;
	}

	public void setUsMeterMapper(UsMeterMapper usMeterMapper) {
		this.usMeterMapper = usMeterMapper;
	}

	

}
