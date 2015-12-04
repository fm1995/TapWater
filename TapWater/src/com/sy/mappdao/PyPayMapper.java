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
	List<PyPay> selectByWhereStrPage(@Param("whereStr")String whereStr,@Param("start") int start, @Param("page")int page);
}