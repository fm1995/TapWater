package com.sy.mappdao;

import com.sy.entity.PyBalance;
import com.sy.entity.PyBalanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyBalanceMapper {
    int countByExample(PyBalanceExample example);

    int deleteByExample(PyBalanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PyBalance record);

    int insertSelective(PyBalance record);

    List<PyBalance> selectByExample(PyBalanceExample example);

    PyBalance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PyBalance record, @Param("example") PyBalanceExample example);

    int updateByExample(@Param("record") PyBalance record, @Param("example") PyBalanceExample example);

    int updateByPrimaryKeySelective(PyBalance record);

    int updateByPrimaryKey(PyBalance record);
}