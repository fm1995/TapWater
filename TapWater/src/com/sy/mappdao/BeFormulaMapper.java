package com.sy.mappdao;

import com.sy.entity.BeFormula;
import com.sy.entity.BeFormulaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeFormulaMapper {
    int countByExample(BeFormulaExample example);

    int deleteByExample(BeFormulaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeFormula record);

    int insertSelective(BeFormula record);

    List<BeFormula> selectByExample(BeFormulaExample example);

    BeFormula selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeFormula record, @Param("example") BeFormulaExample example);

    int updateByExample(@Param("record") BeFormula record, @Param("example") BeFormulaExample example);

    int updateByPrimaryKeySelective(BeFormula record);

    int updateByPrimaryKey(BeFormula record);
}