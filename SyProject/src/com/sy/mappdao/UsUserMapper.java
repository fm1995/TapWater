package com.sy.mappdao;

import com.sy.entity.UsMeter;
import com.sy.entity.UsUser;
import com.sy.entity.UsUserExample;
import com.sy.entity.page.Page;
import com.sy.entity.userhelp.UsUserHelpBean;
import com.sy.entity.view.MeterView;
import com.sy.projectUtils.rd.TermUtil;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UsUserMapper {
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
    
    int selNowUserCount();

    /**
     * @author 卿建锋  自定义Interface
     * 
     * version 1.0 
     * 
     * 
     * */
    //条件查询用户
    List<UsUser>queryUsers(UsUser user);
    
    //快捷换表
    int replaceUserByMeter(UsMeter meter);
    //重签协议
    int reSetProtocol(UsUser user);
    
    //销户
    int cancellationUser(UsUser user);
    
    //档案号修改
    int updateDocById(UsUser user);
    
    //验证数据库内是否有相同档案号存在
    String queryDocNumReset(String docNum);
    
    //查询欠费用户信息-【进行分组筛选】
   List<UsUserHelpBean>queryArreasUserData(Page page);
    
    //查询所有的用户信息-【进行分组筛选】
    List<UsUserHelpBean> queryOwnershipUserDate(Page page);
    
    //统计所有的可用用户数量
    int queryTrueUserCount();
    
    //统计欠费的用户
    int queryArreasUserCount();
    
    //快捷换表-【用户查询】
    List<MeterView> queryChangeTable(UsUser user);
    
    
    //========自定义查询语句 BarryLIu
  	List<UsUser> selectYSList(@Param("start")int start,@Param("rows") int rows,@Param("userMoney") Integer userMoney);

  	int selectYSListCount(@Param("start")int start,@Param("rows") int rows,@Param("userMoney") Integer userMoney);
  	
  	Double selectYSMonenys(@Param("start")int start,@Param("rows") int rows,@Param("userMoney") Integer userMoney);

  	List<UsUser> selectUser(@Param("user")UsUser user,@Param("start") Integer start, @Param("rows")Integer rows);

  	List<UsUser> selectUserByWhere(@Param("whereStr")String whereStr, @Param("start") Integer start, @Param("rows")Integer rows);

  	Integer selectUserCountByWhere(@Param("whereStr")String whereStr, @Param("start") Integer start, @Param("rows")Integer rows);
  	
  	List<UsUser> selByTerm(@Param("user")UsUser user,@Param("term") TermUtil term);
  	int selByTermCount(UsUser user);

	void upVolumeId(int volumeId);

	void upVolumeIdToNull(@Param("list")String[] list, @Param("volumeId")String volumeId);

	Integer selMax();

	UsUser selByuserName(@Param("userName")String userName,@Param("phone")String phone);

	int updateUserByUserNo(UsUser user);
}