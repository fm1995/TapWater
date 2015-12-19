package com.sy.mappdao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sy.entity.RdRead;
import com.sy.entity.RdReadExample;
import com.sy.entity.ReadView;
import com.sy.entity.SyEmp;
import com.sy.entity.UsUser;
import com.sy.projectUtils.TerUtil;
import com.sy.projectUtils.rd.TermUtil;

public interface RdReadMapper {
    int countByExample(RdReadExample example);

    int deleteByExample(RdReadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RdRead record);

    int insertSelective(RdRead record);

    List<RdRead> selectByExample(RdReadExample example);

    RdRead selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RdRead record, @Param("example") RdReadExample example);

    int updateByExample(@Param("record") RdRead record, @Param("example") RdReadExample example);

    int updateByPrimaryKeySelective(RdRead record);

    int updateByPrimaryKey(RdRead record);
    
    //��ѯ�������ĵ�ˮ��
    Double selReadAmount();
    
    //���ڲ�ѯ����Ӧ����ʵ��
    Integer selReadCount(@Param("enter") Integer enter);
    
    //���¸�����ˮ��  Ҫ���������ˮ���͵Ĵ���
    Double sumTypeAmount(@Param("type") String type);
    
    
    //�Զ����ѯ���BarryLiu 
    /**��ѯ*/
	Integer selectAmountsByYearAndMonth(@Param("ymonth")String ymonth);
	
	List<ReadView> selByYearAndMonth(RdRead read);

	List<RdRead> selReadByTerm(@Param("term")TermUtil term, @Param("read")RdRead read);

	int selReadByTermCount(@Param("term")TermUtil term, @Param("read")RdRead read);

	int selReadByTermUserCount(@Param("term")TermUtil term, @Param("read")RdRead read);
	
	int sumCount();

	void initRead(@Param("year")int year, @Param("month")int month);

	void initNewRead();

	void upRdTask(SyEmp syEmp);

	List<RdRead> queryVolumeDetails(@Param("rdRead") RdRead rdRead,@Param("terUtil") TerUtil tu);

	int queryVolumeDetailsCount(@Param("rdRead") RdRead rdRead,@Param("terUtil") TerUtil tu);

	/**����where�������з�ҳ��ѯ����ļ�¼*/
	List<RdRead> selectByWhereStrPage(@Param("whereStr")String whereStr, @Param("start")Integer start, @Param("rows")int rows);

	List<RdRead> selReadByVolumeId(int volumeId);

	List<RdRead> selReadByUser(UsUser user);

	RdRead readAuditByReadId(int readId);
	
	Double sumAmountByWhere(@Param("whereStr") String whereStr);
}