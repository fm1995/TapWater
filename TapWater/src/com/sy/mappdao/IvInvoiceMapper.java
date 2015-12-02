package com.sy.mappdao;

import com.sy.entity.IvInvoice;
import com.sy.entity.IvInvoiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IvInvoiceMapper {
    int countByExample(IvInvoiceExample example);

    int deleteByExample(IvInvoiceExample example);

    int deleteByPrimaryKey(String invoiceNo);

    int insert(IvInvoice record);

    int insertSelective(IvInvoice record);

    List<IvInvoice> selectByExample(IvInvoiceExample example);

    IvInvoice selectByPrimaryKey(String invoiceNo);

    int updateByExampleSelective(@Param("record") IvInvoice record, @Param("example") IvInvoiceExample example);

    int updateByExample(@Param("record") IvInvoice record, @Param("example") IvInvoiceExample example);

    int updateByPrimaryKeySelective(IvInvoice record);

    int updateByPrimaryKey(IvInvoice record);
}