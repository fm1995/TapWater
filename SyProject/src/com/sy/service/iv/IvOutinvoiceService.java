package com.sy.service.iv;


import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.integration.iv.OutReturnClass;

@Service
public class IvOutinvoiceService extends IvParent{
	 /**发票管理
     * 发票出库情况查询
	 * @param page 
     * */
    public List<OutReturnClass> selectAll(Integer page){
    	return getIvOutinvoiceMapper().selectAll((page-1)*10);
    }
    
    
    /**发票管理
     * 发票出库情况查询总条数
     * */
    public Integer selOutCount(){
    	return getIvOutinvoiceMapper().selOutCount();
    }
}