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

	// ʹ������
	public Integer selUsedCount(ReportUseParam rup) {
		return getIvInvoiceMapper().selUsedCount(rup);
	}

	// ��������
	public Integer selInvalidCount(ReportUseParam rup) {
		return getIvInvoiceMapper().selInvalidCount(rup);
	}

	// �ϼƽ��,�÷�Ʊ������ӽ��ѱ���ͳ�ƽ��ѱ��еĽ��ѽ��
	public Double selInSumMoney(ReportUseParam rup) {
		return getIvInvoiceMapper().selInSumMoney(rup);
	}

	// �ϼ�����
	public Integer selIvCount(ReportUseParam rup) {
		return getIvInvoiceMapper().selIvCount(rup);
	}

	// ��Ʊʹ�������ѯ����
	public List<IvInvoice> selWhereIvPy(ReportUseParam rup) {
		List<IvInvoice> list = getIvInvoiceMapper().selWhereIvPy(rup);
		// jsp��ȡֵ���ǿյ���֤
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