package com.sy.service.iv;

import org.springframework.beans.factory.annotation.Autowired;

import com.sy.mappdao.*;

public class IvParent {
	@Autowired
	private IvArchiveMapper ivArchiveMapper;
	@Autowired
	private IvIninvoiceMapper ivIninvoiceMapper;
	@Autowired
	private IvInvoiceMapper ivInvoiceMapper;
	@Autowired
	private IvOutinvoiceMapper ivOutinvoiceMapper;

	public IvArchiveMapper getIvArchiveMapper() {
		return ivArchiveMapper;
	}

	public void setIvArchiveMapper(IvArchiveMapper ivArchiveMapper) {
		this.ivArchiveMapper = ivArchiveMapper;
	}

	public IvIninvoiceMapper getIvIninvoiceMapper() {
		return ivIninvoiceMapper;
	}

	public void setIvIninvoiceMapper(IvIninvoiceMapper ivIninvoiceMapper) {
		this.ivIninvoiceMapper = ivIninvoiceMapper;
	}

	public IvInvoiceMapper getIvInvoiceMapper() {
		return ivInvoiceMapper;
	}

	public void setIvInvoiceMapper(IvInvoiceMapper ivInvoiceMapper) {
		this.ivInvoiceMapper = ivInvoiceMapper;
	}

	public IvOutinvoiceMapper getIvOutinvoiceMapper() {
		return ivOutinvoiceMapper;
	}

	public void setIvOutinvoiceMapper(IvOutinvoiceMapper ivOutinvoiceMapper) {
		this.ivOutinvoiceMapper = ivOutinvoiceMapper;
	}

}
