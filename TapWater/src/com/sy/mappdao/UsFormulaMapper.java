package com.sy.mappdao;

import com.sy.entity.UsFormula;
import com.sy.entity.UsFormulaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsFormulaMapper {
    int countByExample(UsFormulaExample example);

    int deleteByExample(UsFormulaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UsFormula record);

    int insertSelective(UsFormula record);

    List<UsFormula> selectByExample(UsFormulaExample example);

    UsFormula selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UsFormula record, @Param("example") UsFormulaExample example);

    int updateByExample(@Param("record") UsFormula record, @Param("example") UsFormulaExample example);

    int updateByPrimaryKeySelective(UsFormula record);

    int updateByPrimaryKey(UsFormula record);
}