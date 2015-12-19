package com.sy.service.rd;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.google.gson.Gson;
import com.sy.entity.RdVolume;
import com.sy.entity.VolumeView;
import com.sy.mappdao.RdVolumeMapper;
import com.sy.mappdao.UsUserMapper;

/**
 * ���ҵ�����
 * @author xulong
 */
@Service
public class VolumeService {
	@Autowired
	private RdVolumeMapper rdVolumeMapper;
	
	/**
	 * ��ѯ���б�� ��д����ӽ����ǰ��ҳ��
	 * @param map
	 */
	public void selAll(ModelMap map){
		List<RdVolume> list=rdVolumeMapper.selAll();
		map.put("volumes", list);
	}
	
	/**
	 * ��ӱ��
	 * @param response
	 * @param volume
	 * @throws IOException
	 */
	public void add(HttpServletResponse response, RdVolume volume) throws IOException{
		int num =rdVolumeMapper.insertSelective(volume);
		String message="��ӱ��ɹ���";
		if(num<1)
			message="��ӱ��ʧ�ܣ�";
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(message);	
	}
	
	/**
	 * ����Idɾ�����
	 * @param response
	 * @param volumeId
	 */
	public void delById(HttpServletResponse response,int volumeId){
		rdVolumeMapper.deleteByPrimaryKey(volumeId);
	}
	
	/**
	 * ���ݱ��id��ѯ��Ტд��ǰ��ҳ��
	 * @param response
	 * @param volumeId
	 * @return
	 * @throws IOException 
	 */
	public void selById(HttpServletResponse response, int volumeId) throws IOException {
		RdVolume volume=rdVolumeMapper.selectByPrimaryKey(volumeId);
		response.setContentType("text/json;charset=utf-8");
		String data=new Gson().toJson(volume);
		response.getWriter().write(data);
	}

	/**
	 * ����id�޸ı�Ტд�ؽ����ǰ��ҳ��
	 * @param response
	 * @param volume
	 * @throws IOException 
	 */
	public void upById(HttpServletResponse response, RdVolume volume) throws IOException {
		int num = rdVolumeMapper.updateByPrimaryKeySelective(volume);
		String message="�޸ı��ɹ���������ҳ��";
		if(num<1)
			message="�޸ı��ʧ�ܣ�������ҳ��";
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(message);
	}
	
	/**
	 * ��ѯ��ǰ��������ݵ���д��ǰ��ҳ��
	 * @param response
	 * @throws IOException 
	 */
	public void selByAuditPage(HttpServletResponse response) throws IOException {
		List<VolumeView> list=rdVolumeMapper.selByAuditPage();
		response.setContentType("text/json;charset=utf-8");
		String data=new Gson().toJson(list);
		response.getWriter().write(data);
	}
	
	/**
	 * ���ݱ�����Ʋ�ѯ�Ƿ���ڴ��û��������ؽ��
	 * @param response
	 * @param volumeName
	 * @throws IOException 
	 */
	public void selByVolumeName(HttpServletResponse response, String volumeName) throws IOException {
		int count=rdVolumeMapper.selByVolumeName(volumeName);
		if(count>0)
			response.getWriter().write("1");
		else
			response.getWriter().write("0");
		
	}
	
	
	
	
	
}
