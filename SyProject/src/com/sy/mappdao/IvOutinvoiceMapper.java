package com.sy.mappdao;

import com.sy.entity.IvOutinvoice;
import com.sy.entity.IvOutinvoiceExample;
import com.sy.integration.iv.OutReturnClass;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IvOutinvoiceMapper {
    int countByExample(IvOutinvoiceExample example);

    int deleteByExample(IvOutinvoiceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IvOutinvoice record);

    int insertSelective(IvOutinvoice record);

    List<IvOutinvoice> selectByExample(IvOutinvoiceExample example);

    IvOutinvoice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IvOutinvoice record, @Param("example") IvOutinvoiceExample example);

    int updateByExample(@Param("record") IvOutinvoice record, @Param("example") IvOutinvoiceExample example);

    int updateByPrimaryKeySelective(IvOutinvoice record);

    int updateByPrimaryKey(IvOutinvoice record);
    
    /*
   	 * 发票管理
   	 * 发票出库查询
   	 * */
       List<OutReturnClass> selectAll(@Param("page") Integer page);
       /*
   	 * 发票管理
   	 * 发票出库总条数查询
   	 * */
       Integer selOutCount();
}