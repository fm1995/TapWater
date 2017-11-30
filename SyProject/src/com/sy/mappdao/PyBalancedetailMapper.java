package com.sy.mappdao;

import com.sy.entity.PyBalancedetail;
import com.sy.entity.PyBalancedetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyBalancedetailMapper {
    int countByExample(PyBalancedetailExample example);

    int deleteByExample(PyBalancedetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PyBalancedetail record);

    int insertSelective(PyBalancedetail record);

    List<PyBalancedetail> selectByExample(PyBalancedetailExample example);

    PyBalancedetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PyBalancedetail record, @Param("example") PyBalancedetailExample example);

    int updateByExample(@Param("record") PyBalancedetail record, @Param("example") PyBalancedetailExample example);

    int updateByPrimaryKeySelective(PyBalancedetail record);

    int updateByPrimaryKey(PyBalancedetail record);
}