package com.sy.mappdao;

import com.sy.entity.UsUser;
import com.sy.entity.UsUserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UsUserMapper{
    int countByExample(UsUserExample example);

    int deleteByExample(UsUserExample example);

    int deleteByPrimaryKey(String userNo);

    int insert(UsUser record);

    int insertSelective(UsUser record);

    List<UsUser> selectByExample(UsUserExample example);

    UsUser selectByPrimaryKey(String userNo);

    int updateByExampleSelective(@Param("record") UsUser record, @Param("example") UsUserExample example);

    int updateByExample(@Param("record") UsUser record, @Param("example") UsUserExample example);

    int updateByPrimaryKeySelective(UsUser record);

    int updateByPrimaryKey(UsUser record);

    //==========================自定义查询语句
	List<UsUser> selectYSList(@Param("start")int start,@Param("rows") int rows,@Param("userMoney") Integer userMoney);

	int selectYSListCount(@Param("start")int start,@Param("rows") int rows,@Param("userMoney") Integer userMoney);
	
	Double selectYSMonenys(@Param("start")int start,@Param("rows") int rows,@Param("userMoney") Integer userMoney);
}