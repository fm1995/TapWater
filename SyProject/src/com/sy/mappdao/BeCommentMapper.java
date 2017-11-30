package com.sy.mappdao;

import com.sy.entity.BeComment;
import com.sy.entity.BeCommentExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BeCommentMapper {
    int countByExample(BeCommentExample example);

    int deleteByExample(BeCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeComment record);

    int insertSelective(BeComment record);

    List<BeComment> selectByExample(BeCommentExample example);

    BeComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeComment record, @Param("example") BeCommentExample example);

    int updateByExample(@Param("record") BeComment record, @Param("example") BeCommentExample example);

    int updateByPrimaryKeySelective(BeComment record);

    int updateByPrimaryKey(BeComment record);
    
    List<BeComment> queryByOrdeNo(@Param("be") String be);

    //–ﬁ∏ƒ¡Ù—‘
	int updateCom(@Param("bc") BeComment bc);

	//…æ≥˝¡Ù—‘
	int delCom(@Param("bc") BeComment bc);
}