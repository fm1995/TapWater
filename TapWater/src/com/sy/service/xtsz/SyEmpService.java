package com.sy.service.xtsz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.SyDept;
import com.sy.entity.SyEmp;
import com.sy.service.parentser.SyParentSer;

@Service
public class SyEmpService extends SyParentSer{
	/**
	 * ��ѯ���еĲ��ű�
	 */
	public List<SyDept> queryEmp() {
		return syDeptMapper.selectByExample(null);
	}

	/**
	 * ��ѯԱ�����е� ��Ϣ
	 * 
	 * @return
	 */
	public List<SyEmp> queryEmp_() {
		return syEmpMapper.selectAll();
	}

	/**
	 * ���Ա��
	 */
	public void saveEmp(SyEmp sy) {
		syEmpMapper.insert(sy);
	}

	/**
	 * ɾ��Ա��
	 */
	public void deleteEmp(int id) {
		syEmpMapper.deleteByPrimaryKey(id);
	}

	/**
	 * ����ID��ѯ������Ϣ
	 */
	public SyEmp queryOneEmp(int id) {
		return syEmpMapper.selectByPrimaryKey(id);
	}

	/**
	 * �޸�Ա����Ϣ
	 */
	public void updateEmp(SyEmp sy) {
		syEmpMapper.updateByPrimaryKey(sy);
		
	}
	public void updateEmpLogin(SyEmp sy) {
		syEmpMapper.updateByPrimaryKeySelective(sy);
	}
	
	/**
	 * �õ����ŵ�ID��ѯԱ����Ϣ
	 * 
	 * @return
	 */
	public List<SyEmp> querySyEmp(int id) {
		return syEmpMapper.selectSyEmp(id);
	}

	// -----------------
	/**
	 * ��½�ж�
	 */
	public SyEmp queryLogin(SyEmp sy) {
		return  syEmpMapper.selectLogin(sy.getEmpNo(),sy.getEmpPwd());
	}
}