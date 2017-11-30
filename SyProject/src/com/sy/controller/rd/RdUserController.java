package com.sy.controller.rd;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.entity.UsUser;
import com.sy.projectUtils.rd.TermUtil;
import com.sy.service.rd.RdUserService;

/**
 * �û�����Ʋ�
 * 
 * @author xulong
 */

@Controller
@RequestMapping("/SY/page/userVolume")
public class RdUserController {
	@Autowired
	private RdUserService userService;

	/**
	 * ���ݱ��id��ѯ�û�������
	 * 
	 * @param response
	 * @param request
	 * @param user
	 * @throws IOException
	 */
	@RequestMapping("/selByTerm")
	public void selByTerm(HttpServletResponse response,
			HttpServletRequest request, UsUser user,TermUtil term) throws IOException {
		userService.selByTerm(response, user,term);
	}

	/**
	 * �Ѷ���û��޸�Ϊδ����
	 * 
	 * @param userNos
	 * @throws IOException
	 */
	@RequestMapping("/upVolumeIdToNull")
	public void upVolumeIdToNull(HttpServletResponse response, String userNos,
			String volumeId) throws IOException {
		userService.upVolumeIdToNull(response, userNos, volumeId);
	}
	
	/**
	 * �����û�����޸ı���е����
	 * @param response
	 * @param user
	 */
	@RequestMapping("/upUserVolumeIndex")
	public void upUserVolumeIndex(HttpServletResponse response,UsUser user){
		userService.upUserVolumeIndex(user);
	}

}
