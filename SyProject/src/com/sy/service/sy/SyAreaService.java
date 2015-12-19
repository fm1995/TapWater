package com.sy.service.sy;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.SyArea;

@Service
public class SyAreaService extends SyParent {
	/**
	 * ��� ����Ͻ��
	 * 
	 * @param sy
	 */
	public void saveArea(SyArea sy) {
		syAreaMapper.insert(sy);
	}

	/**
	 * ��ѯȫ������Ͻ��
	 * 
	 * @return
	 */
	public List<SyArea> queryArea() {
		return syAreaMapper.selectByExample(null);
	}

	/**
	 * ɾ������Ͻ��
	 */
	public void deleteArea(int id) {
		syAreaMapper.deleteByPrimaryKey(id);
	}

	/**
	 * ����������ѯ����Ͻ������
	 * 
	 * @param id
	 * @return
	 */
	public SyArea queryOne(int id) {
		return syAreaMapper.selectByPrimaryKey(id);
	}

	/**
	 * �޸�
	 */
	public void updateArea(SyArea sy) {
		syAreaMapper.updateByPrimaryKey(sy);
	}

	public String selByAreaName(Integer areaId) {
		StringBuilder sb = new StringBuilder();
		if (areaId == null) {
			sb.append("XX");
		} else {
			sb.append(String.valueOf(areaId));
		}
		Integer userNo=usUserMapper.selMax()+1;
		
		sb.append(String.valueOf(userNo));
		return sb.toString();
	}

}