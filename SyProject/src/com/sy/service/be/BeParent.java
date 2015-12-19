package com.sy.service.be;

import org.springframework.beans.factory.annotation.Autowired;

import com.sy.mappdao.*;

public class BeParent {
	@Autowired
	private BeCommentMapper beCommentMapper;
	@Autowired
	private BeFlowMapper beFlowMapper;
	@Autowired
	private BeFormulaMapper beFormulaMapper;
	@Autowired
	private BeHistoryMapper beHistoryMapper;
	@Autowired
	private BeOrderliteMapper beOrderliteMapper;
	@Autowired
	private BeOrderMapper beOrderMapper;
	@Autowired
	private BeOrderuserMapper beOrderuserMapper;

	public BeCommentMapper getBeCommentMapper() {
		return beCommentMapper;
	}

	public void setBeCommentMapper(BeCommentMapper beCommentMapper) {
		this.beCommentMapper = beCommentMapper;
	}

	public BeFlowMapper getBeFlowMapper() {
		return beFlowMapper;
	}

	public void setBeFlowMapper(BeFlowMapper beFlowMapper) {
		this.beFlowMapper = beFlowMapper;
	}

	public BeFormulaMapper getBeFormulaMapper() {
		return beFormulaMapper;
	}

	public void setBeFormulaMapper(BeFormulaMapper beFormulaMapper) {
		this.beFormulaMapper = beFormulaMapper;
	}

	public BeHistoryMapper getBeHistoryMapper() {
		return beHistoryMapper;
	}

	public void setBeHistoryMapper(BeHistoryMapper beHistoryMapper) {
		this.beHistoryMapper = beHistoryMapper;
	}

	public BeOrderliteMapper getBeOrderliteMapper() {
		return beOrderliteMapper;
	}

	public void setBeOrderliteMapper(BeOrderliteMapper beOrderliteMapper) {
		this.beOrderliteMapper = beOrderliteMapper;
	}

	public BeOrderMapper getBeOrderMapper() {
		return beOrderMapper;
	}

	public void setBeOrderMapper(BeOrderMapper beOrderMapper) {
		this.beOrderMapper = beOrderMapper;
	}

	public BeOrderuserMapper getBeOrderuserMapper() {
		return beOrderuserMapper;
	}

	public void setBeOrderuserMapper(BeOrderuserMapper beOrderuserMapper) {
		this.beOrderuserMapper = beOrderuserMapper;
	}

}
