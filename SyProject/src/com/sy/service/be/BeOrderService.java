package com.sy.service.be;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.entity.BeOrder;
import com.sy.entity.SyEmp;
import com.sy.projectUtils.ValueVerify;
import com.sy.service.sy.SyEmpService;

@Service
public class BeOrderService extends BeParent {
	@Autowired
	private SyEmpService empser;
	
	public SyEmpService getEmpser() {
		return empser;
	}

	public void setEmpser(SyEmpService empser) {
		this.empser = empser;
	}

	// ��ҳ��ʾ�Ĵ��?�� use_target�ʹ����洦���Ĺ�������
	public List<BeOrder> waitBe() {
		return getBeOrderMapper().waitBe();
	}
	
	public BeOrder queryByOrdeNo(String be) {
		// TODO Auto-generated method stub
		BeOrder bo = getBeOrderMapper().queryByOrdeNo(be);
		System.out.println(bo.toString());
		SyEmp syEmp = empser.queryOneEmp(bo.getAuditEmpId());
		bo.setAuditEmpName(syEmp.getEmpName());
		return ValueVerify.isnull(BeOrder.class,bo);
	}
	
	// 新户
	public void save(BeOrder record) {
		getBeOrderMapper().insertSelective(record);
	}
	//获得当前类型最晚的id
	public String selMaxNo(String type) {
		BeOrder no = getBeOrderMapper().selMaxNo(type);
		String value="";
		for (String str : new Date(System.currentTimeMillis()).toString().split("-")) {
			value+=str;
		}
		String orderno=type+value;
		if(no!=null){
			//获得当前类型最晚的id并制造下一个id
			if(no.getOrderNo().substring(0,9).equals(orderno.substring(0, 9))){
				//本月的累加
				Integer valueOf = Integer.valueOf(no.getOrderNo().substring(10))+1;
				String vaOf=valueOf+"";
				String up="";
				for (int i = 0; i < (4-vaOf.length()); i++) {
					up+="0";
				}
				orderno+=(up+vaOf);
				//把当前int转换成字符串，并用"0"在前面补充缺少位数，满足4位
				
			}else{
				//刷新了月份
				orderno+="0001";
			}
		}else{
			//插入当前类的第一条数据时
			orderno+="0001";
		}
		return orderno;
	}
	
	public String selNextNO(String type){
		return getBeOrderMapper().selMaxNo(type).getOrderNo();
	}
	
//根据ID查询原用户信息be_request2.jsp
	public BeOrder findById(String orderNo){
		BeOrder beorder=getBeOrderMapper().selectByPrimaryKey(orderNo);
		return beorder;
	}
	
}