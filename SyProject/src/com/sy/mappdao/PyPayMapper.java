package com.sy.mappdao;

import com.sy.entity.PyPay;
import com.sy.entity.PyPayExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PyPayMapper {
    int countByExample(PyPayExample example);

    int deleteByExample(PyPayExample example);

    int deleteByPrimaryKey(String payNo);

    int insert(PyPay record);

    int insertSelective(PyPay record);

    List<PyPay> selectByExample(PyPayExample example);

    PyPay selectByPrimaryKey(String payNo);

    int updateByExampleSelective(@Param("record") PyPay record, @Param("example") PyPayExample example);

    int updateByExample(@Param("record") PyPay record, @Param("example") PyPayExample example);

    int updateByPrimaryKeySelective(PyPay record);

    int updateByPrimaryKey(PyPay record);
    
    /**根据where条件进行分页查询*/
  	List<PyPay> selectByWhereStrPage(@Param("whereStr")String whereStr,@Param("start") int start, @Param("rows")int rows);
  	/**查询历史纪录最多八条*/
  	List<PyPay> selPayHistoryWhereStrPage(@Param("whereStr")String whereStr,@Param("start")int start, @Param("rows")int rows);
  	/**根据不同的情况where条件 查询缴费单的缴费金额的和*/
	Double selPayMoneysWhereStr(@Param("whereStr")String whereStr);
	/**查询符合要求的数据的条数*/
	Integer countByWhere(@Param("whereStr")String whereStr);

	/**收费管理  发票补开作废*/
	List<PyPay> selPayIvUsWhereStrPage(@Param("whereStr")String whereStr,@Param("start") Integer start, @Param("rows")Integer rows);
}