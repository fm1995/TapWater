package com.sy.service.iv;


import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.integration.iv.OutReturnClass;

@Service
public class IvOutinvoiceService extends IvParent{
	 /**��Ʊ����
     * ��Ʊ���������ѯ
	 * @param page 
     * */
    public List<OutReturnClass> selectAll(Integer page){
    	return getIvOutinvoiceMapper().selectAll((page-1)*10);
    }
    
    
    /**��Ʊ����
     * ��Ʊ���������ѯ������
     * */
    public Integer selOutCount(){
    	return getIvOutinvoiceMapper().selOutCount();
    }
}