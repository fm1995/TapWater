package com.sy.mappdao;

import com.sy.entity.PyUserhistory;
import com.sy.entity.PyUserhistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyUserhistoryMapper {
    int countByExample(PyUserhistoryExample example);

    int deleteByExample(PyUserhistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PyUserhistory record);

    int insertSelective(PyUserhistory record);

    List<PyUserhistory> selectByExample(PyUserhistoryExample example);

    PyUserhistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PyUserhistory record, @Param("example") PyUserhistoryExample example);

    int updateByExample(@Param("record") PyUserhistory record, @Param("example") PyUserhistoryExample example);

    int updateByPrimaryKeySelective(PyUserhistory record);

    int updateByPrimaryKey(PyUserhistory record);
}