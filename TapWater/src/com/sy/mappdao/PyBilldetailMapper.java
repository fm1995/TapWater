package com.sy.mappdao;

import com.sy.entity.PyBilldetail;
import com.sy.entity.PyBilldetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyBilldetailMapper {
    int countByExample(PyBilldetailExample example);

    int deleteByExample(PyBilldetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PyBilldetail record);

    int insertSelective(PyBilldetail record);

    List<PyBilldetail> selectByExample(PyBilldetailExample example);

    PyBilldetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PyBilldetail record, @Param("example") PyBilldetailExample example);

    int updateByExample(@Param("record") PyBilldetail record, @Param("example") PyBilldetailExample example);

    int updateByPrimaryKeySelective(PyBilldetail record);

    int updateByPrimaryKey(PyBilldetail record);
}