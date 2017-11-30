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
    
    //查询本月消耗的水量
    Double selReadAmount();
    
    //用于查询本月应抄和实抄
    Integer selReadCount(@Param("enter") Integer enter);
    
    //本月各类型水量  要求传入代表用水类型的代码
    Double sumTypeAmount(@Param("type") String type);
    
    
    //自定义查询语句BarryLiu 
    /**查询*/
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

	/**根据where条件进行分页查询抄表的记录*/
	List<RdRead> selectByWhereStrPage(@Param("whereStr")String whereStr, @Param("start")Integer start, @Param("rows")int rows);

	List<RdRead> selReadByVolumeId(int volumeId);

	List<RdRead> selReadByUser(UsUser user);

	RdRead readAuditByReadId(int readId);
	
	Double sumAmountByWhere(@Param("whereStr") String whereStr);
}