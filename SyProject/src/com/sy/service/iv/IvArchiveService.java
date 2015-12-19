package com.sy.service.iv;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.integration.iv.ArchiveReturnClass;

@Service
public class IvArchiveService extends IvParent{
	 /**发票管理
     * 发票交票情况查询
	 * @param page 
     * */
    public List<ArchiveReturnClass> selIvArchiveCount(int page){
    	return getIvArchiveMapper().selIvArchiveCount((page-1)*5);

    }
    
    /**发票管理
     * 发票交票情况查询总条数
     * */
    public int selArchiveCount(){
    	return getIvArchiveMapper().selArchiveCount();
    }
}