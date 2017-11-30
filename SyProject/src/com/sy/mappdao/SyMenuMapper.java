package com.sy.mappdao;

import com.sy.entity.SyMenu;
import com.sy.entity.SyMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyMenuMapper {
    int countByExample(SyMenuExample example);

    int deleteByExample(SyMenuExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(SyMenu record);

    int insertSelective(SyMenu record);

    List<SyMenu> selectByExample(SyMenuExample example);

    SyMenu selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") SyMenu record, @Param("example") SyMenuExample example);

    int updateByExample(@Param("record") SyMenu record, @Param("example") SyMenuExample example);

    int updateByPrimaryKeySelective(SyMenu record);

    int updateByPrimaryKey(SyMenu record);
    
//    ×Ô¶¨Òå
    List<SyMenu> selectSyMenu();
    
}