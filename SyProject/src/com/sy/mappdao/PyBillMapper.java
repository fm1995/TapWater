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
    
    //本月实交金额和应交金额的共用方法,应交金额统计，传入列名。实交金额统计，传入列名和结清状态 
    Double sumMoney(@Param("column") String column,@Param("balance") Integer balance);
    
    //以月份分组，并查询当前月份应交金额和实交金额总和 ,用List<PyBill>集合保存
    List<PyBill> sumBillReal();
    
    
    
    /**
     * 自定义查询语句
     */
    /**查询实收*/
	Double selectBillMoneysByCreateTime(@Param("ymonth")String ymonth);

	/**查询应收收*/
	Double selectRealMoneysByCreateTime(@Param("ymonth")String ymonth);
	/**根据where条件  欠费表*/
	List<PyBill> selectByWhereStrPage(@Param("whereStr")String whereStr, @Param("start")int start, @Param("rows")int rows);
	/**根据where条件  查询 欠费表,用户表,抄表表  三表连查*/
	List<PyBill> selByWhereStrPage(@Param("whereStr")String whereStr, @Param("start")int start, @Param("rows")int rows);
	/**根据where条件  查询所有的数据的数量和*/
	Integer countByWhereStr(@Param("whereStr")String whereStr);
	/**根据where条件 查询总的应收金额*/
	Double sumBillMoneysWhereStr(@Param("whereStr")String whereStr);
	/**根据where条件 查询总的实收金额*/
	Double sumRealMoneysWhereStr(@Param("whereStr")String whereStr);
}