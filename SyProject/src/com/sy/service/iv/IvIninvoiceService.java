package com.sy.service.iv;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.controller.iv.invInvoiceManage;
import com.sy.entity.IvIninvoice;
import com.sy.entity.IvInvoice;

@Service
public class IvIninvoiceService extends IvParent{
	
	//��Ʊ�ܱ��ѯ
	public List<invInvoiceManage> selectCount(Integer start){
		return getIvIninvoiceMapper().selectCount((start-1)*2);
	}
	
	//����������
	public Integer selAllCount(){
		return getIvIninvoiceMapper().selAllCount();
	}
	
	//������
	public void addIninvoice(IvIninvoice ivIninvoice){
		int ivin = getIvIninvoiceMapper().insertSelective(ivIninvoice);
		//����ܱ�
		if(ivin>0){
			Integer valueOf = Integer.valueOf(ivIninvoice.getStartNo());
			for (int i = 0; i < ivIninvoice.getCounts(); i++) {
				getIvInvoiceMapper().insertSelective(new IvInvoice(String.valueOf(valueOf), ivIninvoice.getInvoiceType(), 0, ivIninvoice.getId(), 0, 0, false, false, false));
				valueOf++;
			}
		}
	}
}