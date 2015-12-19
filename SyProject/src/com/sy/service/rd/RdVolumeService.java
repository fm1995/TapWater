package com.sy.service.rd;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sy.entity.RdVolume;

@Service
public class RdVolumeService extends RdParent{

	//	查询某个表册的详细信息
	public void queryRdVolume(RdVolume rdVolume, HttpServletResponse resp) {
		RdVolume rv=rdVolumeMapper.queryRdVolume(rdVolume);
		String json = new Gson().toJson(rv);
		sendToClient(json, resp);
	}
	
	//	将后台的数据传输到前段
	private void sendToClient(String data,HttpServletResponse resp){
		try {
			resp.setContentType("text/json;charset=utf-8");
			resp.getWriter().write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}