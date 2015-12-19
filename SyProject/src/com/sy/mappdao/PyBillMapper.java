package com.sy.mappdao;

import com.sy.entity.PyBill;
import com.sy.entity.PyBillExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PyBillMapper {
    int countByExample(PyBillExample example);

    int deleteByExample(PyBillExample example);

    int deleteByPrimaryKey(String billNo);

    int insert(PyBill record);

    int insertSelective(PyBill record);

    List<PyBill> selectByExample(PyBillExample example);

    PyBill selectByPrimaryKey(String billNo);

    int updateByExampleSelective(@Param("record") PyBill record, @Param("example") PyBillExample example);

    int updateByExample(@Param("record") PyBill record, @Param("example") PyBillExample example);

    int updateByPrimaryKeySelective(PyBill record);

    int updateByPrimaryKey(PyBill record);
    
    //����ʵ������Ӧ�����Ĺ��÷���,Ӧ�����ͳ�ƣ�����������ʵ�����ͳ�ƣ����������ͽ���״̬ 
    Double sumMoney(@Param("column") String column,@Param("balance") Integer balance);
    
    //���·ݷ��飬����ѯ��ǰ�·�Ӧ������ʵ������ܺ� ,��List<PyBill>���ϱ���
    List<PyBill> sumBillReal();
    
    
    
    /**
     * �Զ����ѯ���
     */
    /**��ѯʵ��*/
	Double selectBillMoneysByCreateTime(@Param("ymonth")String ymonth);

	/**��ѯӦ����*/
	Double selectRealMoneysByCreateTime(@Param("ymonth")String ymonth);
	/**����where����  Ƿ�ѱ�*/
	List<PyBill> selectByWhereStrPage(@Param("whereStr")String whereStr, @Param("start")int start, @Param("rows")int rows);
	/**����where����  ��ѯ Ƿ�ѱ�,�û���,�����  ��������*/
	List<PyBill> selByWhereStrPage(@Param("whereStr")String whereStr, @Param("start")int start, @Param("rows")int rows);
	/**����where����  ��ѯ���е����ݵ�������*/
	Integer countByWhereStr(@Param("whereStr")String whereStr);
	/**����where���� ��ѯ�ܵ�Ӧ�ս��*/
	Double sumBillMoneysWhereStr(@Param("whereStr")String whereStr);
	/**����where���� ��ѯ�ܵ�ʵ�ս��*/
	Double sumRealMoneysWhereStr(@Param("whereStr")String whereStr);
}