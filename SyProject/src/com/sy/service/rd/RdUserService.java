package com.sy.service.rd;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sy.entity.UsUser;
import com.sy.mappdao.UsUserMapper;
import com.sy.projectUtils.rd.TermUtil;

/**
 * �û���ҵ�����
 * @author xulong
 */
@Service
public class RdUserService {
	@Autowired
	private UsUserMapper userMapper;
	
	/**
	 * ���ݱ��id��ѯ�û������� ��д��ǰ��ҳ��
	 * @param response
	 * @param term 
	 */
	public void selByTerm(HttpServletResponse response,UsUser user, TermUtil term){
		System.out.println(term.getRows()+"........"+term.getStartIndex());
		List<UsUser> users = userMapper.selByTerm(user,term);
		int count = userMapper.selByTermCount(user);
		Map map=new HashMap<String, Object>();
		map.put("users", users);
		map.put("count",count);
		map.put("pageCount", (count-1)/term.getRows()+1);
		mapToJson(response,map);
	}
	
	/**
	 * ��mapת��Ϊjson��д��ǰ��
	 * @param response
	 * @param map
	 */
	@SuppressWarnings("rawtypes")
	private void mapToJson(HttpServletResponse response,Map map){
		String json = new Gson().toJson(map);
		response.setContentType("text/json;charset=utf-8");
		try {
			System.out.println(json);
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���û����idΪ��id���û��ı��Id�޸�Ϊ��
	 * @param volumeId
	 */
	public void UpVolumeId(int volumeId){
		userMapper.upVolumeId(volumeId);
	}

	public void upVolumeIdToNull(HttpServletResponse response, String userNos,String volumeId) throws IOException {
		String[] arr = userNos.split(":");
		userMapper.upVolumeIdToNull(arr,volumeId);
		response.getWriter().write("1");
	}

	public void upUserVolumeIndex(UsUser user) {
		userMapper.updateByPrimaryKeySelective(user);	
	}
}
