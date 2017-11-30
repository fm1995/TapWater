package com.sy.mappdao;

import com.sy.entity.IvInvoice;
import com.sy.entity.IvInvoiceExample;
import com.sy.integration.iv.param.ReportUseParam;

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
    
	//合计金额,用发票编号链接交费表，并统计交费表中的交费金额
    Double selInSumMoney(ReportUseParam rup);
    
    //合计张数
    Integer selIvCount(ReportUseParam rup);
    

    //发票总表查询
    List<IvInvoice> selectAll();
    

    //使用张数
    Integer selUsedCount(ReportUseParam rup);
    
    //作废张数
    Integer selInvalidCount(ReportUseParam rup);
    
    //发票使用情况明细表
    List<IvInvoice> selWhereIvPy(ReportUseParam rup);
	
	/**自定义查询语句*/
	List<IvInvoice> selectInvoiceByWhere(@Param("whereStr")String whereStr,@Param("start") int start,@Param("rows") Integer rows);

	Integer selectInvoiceCountByWhere(@Param("whereStr")String whereStr,@Param("start") int start,@Param("rows") Integer rows);

}