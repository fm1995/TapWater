package com.sy.service.iv;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.integration.iv.ArchiveReturnClass;

@Service
public class IvArchiveService extends IvParent{
	 /**��Ʊ����
     * ��Ʊ��Ʊ�����ѯ
	 * @param page 
     * */
    public List<ArchiveReturnClass> selIvArchiveCount(int page){
    	return getIvArchiveMapper().selIvArchiveCount((page-1)*5);

    }
    
    /**��Ʊ����
     * ��Ʊ��Ʊ�����ѯ������
     * */
    public int selArchiveCount(){
    	return getIvArchiveMapper().selArchiveCount();
    }
}