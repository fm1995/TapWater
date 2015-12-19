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
     * @author �佨��  �Զ���Interface
     * 
     * version 1.0 
     * 
     * 
     * */
    //������ѯ�û�
    List<UsUser>queryUsers(UsUser user);
    
    //��ݻ���
    int replaceUserByMeter(UsMeter meter);
    //��ǩЭ��
    int reSetProtocol(UsUser user);
    
    //����
    int cancellationUser(UsUser user);
    
    //�������޸�
    int updateDocById(UsUser user);
    
    //��֤���ݿ����Ƿ�����ͬ�����Ŵ���
    String queryDocNumReset(String docNum);
    
    //��ѯǷ���û���Ϣ-�����з���ɸѡ��
   List<UsUserHelpBean>queryArreasUserData(Page page);
    
    //��ѯ���е��û���Ϣ-�����з���ɸѡ��
    List<UsUserHelpBean> queryOwnershipUserDate(Page page);
    
    //ͳ�����еĿ����û�����
    int queryTrueUserCount();
    
    //ͳ��Ƿ�ѵ��û�
    int queryArreasUserCount();
    
    //��ݻ���-���û���ѯ��
    List<MeterView> queryChangeTable(UsUser user);
    
    
    //========�Զ����ѯ��� BarryLIu
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