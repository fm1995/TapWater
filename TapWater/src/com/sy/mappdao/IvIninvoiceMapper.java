package com.sy.mappdao;

import com.sy.entity.IvIninvoice;
import com.sy.entity.IvIninvoiceExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IvIninvoiceMapper {
    int countByExample(IvIninvoiceExample example);

    int deleteByExample(IvIninvoiceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IvIninvoice record);

    int insertSelective(IvIninvoice record);

    List<IvIninvoice> selectByExample(IvIninvoiceExample example);

    IvIninvoice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IvIninvoice record, @Param("example") IvIninvoiceExample example);

    int updateByExample(@Param("record") IvIninvoice record, @Param("example") IvIninvoiceExample example);

    int updateByPrimaryKeySelective(IvIninvoice record);

    int updateByPrimaryKey(IvIninvoice record);

    
}