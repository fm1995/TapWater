package com.sy.service.sfgl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.sy.dto.SfglDto;
import com.sy.entity.PyPay;
import com.sy.entity.SyEmp;
import com.sy.entity.UsSms;
import com.sy.entity.UsUser;
import com.sy.entity.UsUserExample;
import com.sy.entity.UsUserExample.Criteria;
import com.sy.projectUtils.SfglUtils;
import com.sy.service.parentser.ParentSerI;
import com.sy.service.parentser.UsParentSer;

@Service
public class UsUserService extends UsParentSer implements ParentSerI<UsUser> {

	public void text() {
		List<UsSms> selAll = usSmsMapper.selAll();
		for (UsSms usSms : selAll) {
			System.out.println(usSms.getEmpId());
		}
	}

	@Override
	public List<UsUser> getAll() {
		return usUserMapper.selectByExample(null);
	}

	@Override
	public UsUser selectByPrimaryKey(String id) {
		return usUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(UsUser entity) {
		return usUserMapper.insert(entity);
	}

	@Override
	public int update(UsUser entity) {
		return usUserMapper.updateByPrimaryKey(entity);
	}

	@Override
	public int delete(String id) {
		return usUserMapper.deleteByPrimaryKey(id);
	}

	/**
	 * ��ѯ���е�Ԥ�յ�����
	 * 
	 * @param page
	 * @param rows
	 * @param userMoney
	 * @return
	 */
	public List<UsUser> selectYSList(int page, int rows, Integer userMoney) {
		return usUserMapper.selectYSList((page - 1) * rows, rows, userMoney);
	}

	/**
	 * ��ѯ���е�Ԥ�յ����� ������
	 * 
	 * @param page
	 * @param rows
	 * @param userMoney
	 * @return
	 */
	public int selectYSListCount(int page, int rows, Integer userMoney) {
		return usUserMapper.selectYSListCount((page - 1) * rows, rows,
				userMoney);
	}

	public Map<String, Object> yushou(int page, int rows, Integer userMoney) {
		int total = this.selectYSListCount(page, rows, userMoney);
		List<UsUser> users = selectYSList(page, rows, userMoney);
		Double moneys = usUserMapper.selectYSMonenys((page - 1) * rows, rows,
				userMoney);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", users);
		map.put("moneys", moneys != null ? moneys : 0.0);
		map.put("userMoney", userMoney);
		int pageCount = (int) Math.ceil(total / (rows * 1.0));
		map.put("page", page);
		map.put("pageCount", pageCount);
		return map;
	}

	// ======================�շѴ��� ��ѯ�û�
	public Map<String, Object> selectUser(UsUser user, SfglDto dto , HttpServletRequest request) {
		Integer page = dto.getPage();
		Integer rows = dto.getRows();
		
		String whereStr = (String) request.getSession().getAttribute("whereStr");
		if(dto.getUserMoney()!=null){//userMoneyûʲô����,ֻ�Ǳ�ʾ��ֵ����Ajax��ѯ
			whereStr = SfglUtils.getSqlWhereByUsUser(user);
			System.out.println("���²�ѯ");
		}
		request.getSession().setAttribute("whereStr", whereStr);
		
		System.out.println("whereStr:"+whereStr);
		List<UsUser> users=usUserMapper.selectUserByWhere(whereStr,(page-1)*rows,rows);
		Integer total = usUserMapper.selectUserCountByWhere(whereStr,(page-1)*rows,rows);
		System.out.println(user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("users", users);
		map.put("page", page);
		map.put("rows", rows);
		total=total==null?0:total;
		int pageCount = (int) Math.ceil(total / (rows * 1.0));
		map.put("pageCount", pageCount);
		if(dto.getPageCount()!=null)
			map.put("pageCount", dto.getPageCount());
		System.out.println("users.size():  " + users.size());
		return map;
	}

	/**�û��ɷ�,�ж��û���û�е�½*/
	public void jiaofei(HttpServletRequest request,HttpServletResponse response) throws IOException {
		SyEmp empLogin = (SyEmp) request.getSession().getAttribute("");
		if(empLogin==null)
			response.getOutputStream().print("fail");
		String userNo = request.getParameter("userNo");
		String fapiao = request.getParameter("fapiao");
		String jiaofei = request.getParameter("jiaofei");
		System.out.println("userNo: "+jiaofei+" fapiao:"+fapiao+" jiaofei:"+jiaofei);
		
		PyPay pay =new PyPay();
		pay.setPayMoney(new BigDecimal(jiaofei));
		pay.setInvoice(fapiao);
		pay.setPayDate(new Date());
		pay.setUserNo(userNo);
		pay.setEmpId(empLogin.getEmpId());

		SimpleDateFormat fmt=new SimpleDateFormat("yyyyMM-dd");
		String dateStr = fmt.format(new Date());
		pay.setPayNo("JF"+userNo+"-"+dateStr);
		
		pyPayMapper.insert(pay);
		response.getOutputStream().print("ok");
		
	}
	/**�޸��û����ֻ�,��Ϣ�ֻ��͵�ַ��ֵ*/
	public UsUser updateUserPhoneAndSmsPhone(UsUser user) {
		UsUser usUser = selectByPrimaryKey(user.getUserNo());
		usUser.setPhone(user.getPhone());
		usUser.setSmsPhone(user.getSmsPhone());
		usUser.setAddress(user.getAddress());
		update(usUser);
		return usUser;
	}

}
