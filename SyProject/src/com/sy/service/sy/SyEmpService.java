package com.sy.service.sy;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.SyDept;
import com.sy.entity.SyEmp;
import com.sy.entity.SyEmpExample;
import com.sy.integration.iv.EmpReturnClass;

@Service
public class SyEmpService extends SyParent {
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
		return syEmpMapper.selectLogin(sy.getEmpNo(), sy.getEmpPwd());
	}


	/**
	 * ���첽����õ�Ա�������Ƿ����
	 */
	public List<SyEmp> isLogin(String name) {
		SyEmpExample example = new SyEmpExample();
		example.createCriteria().andEmpNoEqualTo(name);
		return syEmpMapper.selectByExample(example);
	}
	
	//��ѯemp����id,name�����ֶ�
    public List<SyEmp> selIvEmp(){
    	return syEmpMapper.selIvEmp();
    }
    
    
    
    
    /**��Ʊ����
     * �շ���Ա��Ʊ��ѯ
	 * @param page 
     * */
    public List<EmpReturnClass> SelEmpIVCount(int page){
    	return syEmpMapper.selEmpIvCount((page-1)*10);
    }
    
    /**��Ʊ����
     * �շ���Ա��Ʊ��ѯ������
     * */
    public int SelEmpIvAllCount(){
    	return syEmpMapper.selEmpIvAllCount();
    }
}