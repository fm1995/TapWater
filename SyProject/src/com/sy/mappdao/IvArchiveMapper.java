package com.sy.mappdao;

import com.sy.entity.IvArchive;
import com.sy.entity.IvArchiveExample;
import com.sy.integration.iv.ArchiveReturnClass;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IvArchiveMapper {
    int countByExample(IvArchiveExample example);

    int deleteByExample(IvArchiveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IvArchive record);

    int insertSelective(IvArchive record);

    List<IvArchive> selectByExample(IvArchiveExample example);

    IvArchive selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IvArchive record, @Param("example") IvArchiveExample example);

    int updateByExample(@Param("record") IvArchive record, @Param("example") IvArchiveExample example);

    int updateByPrimaryKeySelective(IvArchive record);

    int updateByPrimaryKey(IvArchive record);
    
    
    /*
  	 * 发票管理
  	 * 发票交票查询
  	 * */
      List<ArchiveReturnClass> selIvArchiveCount(@Param("page") Integer page);
      /*
  	 * 发票管理
  	 * 发票交票总条数查询
  	 * */
      Integer selArchiveCount();
}