package com.sy.mappdao;

import com.sy.entity.PyPay;
import com.sy.entity.PyPayExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PyPayMapper {
    int countByExample(PyPayExample example);

    int deleteByExample(PyPayExample example);

    int deleteByPrimaryKey(String payNo);

    int insert(PyPay record);

    int insertSelective(PyPay record);

    List<PyPay> selectByExample(PyPayExample example);

    PyPay selectByPrimaryKey(String payNo);

    int updateByExampleSelective(@Param("record") PyPay record, @Param("example") PyPayExample example);

    int updateByExample(@Param("record") PyPay record, @Param("example") PyPayExample example);

    int updateByPrimaryKeySelective(PyPay record);

    int updateByPrimaryKey(PyPay record);
    
    /**����where�������з�ҳ��ѯ*/
  	List<PyPay> selectByWhereStrPage(@Param("whereStr")String whereStr,@Param("start") int start, @Param("rows")int rows);
  	/**��ѯ��ʷ��¼������*/
  	List<PyPay> selPayHistoryWhereStrPage(@Param("whereStr")String whereStr,@Param("start")int start, @Param("rows")int rows);
  	/**���ݲ�ͬ�����where���� ��ѯ�ɷѵ��Ľɷѽ��ĺ�*/
	Double selPayMoneysWhereStr(@Param("whereStr")String whereStr);
	/**��ѯ����Ҫ������ݵ�����*/
	Integer countByWhere(@Param("whereStr")String whereStr);

	/**�շѹ���  ��Ʊ��������*/
	List<PyPay> selPayIvUsWhereStrPage(@Param("whereStr")String whereStr,@Param("start") Integer start, @Param("rows")Integer rows);
}