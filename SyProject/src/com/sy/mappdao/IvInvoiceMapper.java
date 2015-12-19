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
    
	//�ϼƽ��,�÷�Ʊ������ӽ��ѱ���ͳ�ƽ��ѱ��еĽ��ѽ��
    Double selInSumMoney(ReportUseParam rup);
    
    //�ϼ�����
    Integer selIvCount(ReportUseParam rup);
    

    //��Ʊ�ܱ��ѯ
    List<IvInvoice> selectAll();
    

    //ʹ������
    Integer selUsedCount(ReportUseParam rup);
    
    //��������
    Integer selInvalidCount(ReportUseParam rup);
    
    //��Ʊʹ�������ϸ��
    List<IvInvoice> selWhereIvPy(ReportUseParam rup);
	
	/**�Զ����ѯ���*/
	List<IvInvoice> selectInvoiceByWhere(@Param("whereStr")String whereStr,@Param("start") int start,@Param("rows") Integer rows);

	Integer selectInvoiceCountByWhere(@Param("whereStr")String whereStr,@Param("start") int start,@Param("rows") Integer rows);

}