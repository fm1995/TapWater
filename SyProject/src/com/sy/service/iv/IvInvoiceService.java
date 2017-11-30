package com.sy.service.iv;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.IvInvoice;
import com.sy.entity.PyPay;
import com.sy.entity.SyEmp;
import com.sy.entity.UsUser;
import com.sy.integration.iv.param.ReportUseParam;
import com.sy.projectUtils.ValueVerify;

@Service
public class IvInvoiceService extends IvParent {

	// 使用张数
	public Integer selUsedCount(ReportUseParam rup) {
		return getIvInvoiceMapper().selUsedCount(rup);
	}

	// 作废张数
	public Integer selInvalidCount(ReportUseParam rup) {
		return getIvInvoiceMapper().selInvalidCount(rup);
	}

	// 合计金额,用发票编号链接交费表，并统计交费表中的交费金额
	public Double selInSumMoney(ReportUseParam rup) {
		return getIvInvoiceMapper().selInSumMoney(rup);
	}

	// 合计张数
	public Integer selIvCount(ReportUseParam rup) {
		return getIvInvoiceMapper().selIvCount(rup);
	}

	// 发票使用情况查询集合
	public List<IvInvoice> selWhereIvPy(ReportUseParam rup) {
		List<IvInvoice> list = getIvInvoiceMapper().selWhereIvPy(rup);
		// jsp获取值做非空的验证
		for (IvInvoice iv : list) {
			iv.setUsed(ValueVerify.isnull(Boolean.class, iv.getUsed()));
			iv.setInvalid(ValueVerify.isnull(Boolean.class, iv.getInvalid()));
			iv.setInvoiceNo(ValueVerify.isnull(String.class, iv.getInvoiceNo()));
			iv.setInvoiceType(ValueVerify.isnull(Integer.class,
					iv.getInvoiceType()));
			if (iv.getEmp() == null)
				iv.setEmp(new SyEmp());
			iv.getEmp().setEmpName(
					ValueVerify.isnull(String.class, iv.getEmp().getEmpName()));
			if (iv.getPay() == null)
				iv.setPay(new PyPay());
			iv.getPay().setPayNo(
					ValueVerify.isnull(String.class, iv.getPay().getPayNo()));
			iv.getPay().setPayMoney(
					ValueVerify.isnull(BigDecimal.class, iv.getPay()
							.getPayMoney()));
			if (iv.getPay().getUser() == null)
				iv.getPay().setUser(new UsUser());
			iv.getPay()
					.getUser()
					.setUserName(
							ValueVerify.isnull(String.class, iv.getPay()
									.getUser().getUserName()));
		}

		return list;
	}

}