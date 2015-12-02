package com.sy.mappdao;

import com.sy.entity.UsSms;
import com.sy.entity.UsSmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsSmsMapper {
    int countByExample(UsSmsExample example);

    int deleteByExample(UsSmsExample example);

    int deleteByPrimaryKey(Integer smsId);

    int insert(UsSms record);

    int insertSelective(UsSms record);

    List<UsSms> selectByExample(UsSmsExample example);

    UsSms selectByPrimaryKey(Integer smsId);

    int updateByExampleSelective(@Param("record") UsSms record, @Param("example") UsSmsExample example);

    int updateByExample(@Param("record") UsSms record, @Param("example") UsSmsExample example);

    int updateByPrimaryKeySelective(UsSms record);

    int updateByPrimaryKey(UsSms record);

    List<UsSms> selAll();
    
}