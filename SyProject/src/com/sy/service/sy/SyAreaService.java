package com.sy.service.sy;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.SyArea;

@Service
public class SyAreaService extends SyParent {
	/**
	 * 添加 抄表辖区
	 * 
	 * @param sy
	 */
	public void saveArea(SyArea sy) {
		syAreaMapper.insert(sy);
	}

	/**
	 * 查询全部抄表辖区
	 * 
	 * @return
	 */
	public List<SyArea> queryArea() {
		return syAreaMapper.selectByExample(null);
	}

	/**
	 * 删除抄表辖区
	 */
	public void deleteArea(int id) {
		syAreaMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 根据主键查询抄表辖区详情
	 * 
	 * @param id
	 * @return
	 */
	public SyArea queryOne(int id) {
		return syAreaMapper.selectByPrimaryKey(id);
	}

	/**
	 * 修改
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