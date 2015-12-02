package com.sy.mappdao;

import com.sy.entity.RdVolume;
import com.sy.entity.RdVolumeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RdVolumeMapper {
    int countByExample(RdVolumeExample example);

    int deleteByExample(RdVolumeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RdVolume record);

    int insertSelective(RdVolume record);

    List<RdVolume> selectByExample(RdVolumeExample example);

    RdVolume selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RdVolume record, @Param("example") RdVolumeExample example);

    int updateByExample(@Param("record") RdVolume record, @Param("example") RdVolumeExample example);

    int updateByPrimaryKeySelective(RdVolume record);

    int updateByPrimaryKey(RdVolume record);
}