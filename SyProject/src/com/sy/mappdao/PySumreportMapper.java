package com.sy.mappdao;

import com.sy.entity.PySumreport;
import com.sy.entity.PySumreportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PySumreportMapper {
    int countByExample(PySumreportExample example);

    int deleteByExample(PySumreportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PySumreport record);

    int insertSelective(PySumreport record);

    List<PySumreport> selectByExample(PySumreportExample example);

    PySumreport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PySumreport record, @Param("example") PySumreportExample example);

    int updateByExample(@Param("record") PySumreport record, @Param("example") PySumreportExample example);

    int updateByPrimaryKeySelective(PySumreport record);

    int updateByPrimaryKey(PySumreport record);
    
    // 自定义查询语句
    List<PySumreport> selectAmountPrice(@Param("year")String year,@Param("month")String month);
    
}