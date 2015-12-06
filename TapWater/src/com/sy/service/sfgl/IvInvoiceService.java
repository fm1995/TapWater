package com.sy.service.sfgl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.sy.dto.SfglDto;
import com.sy.entity.IvIninvoice;
import com.sy.entity.IvInvoice;
import com.sy.entity.SyEmp;
import com.sy.entity.UsUser;
import com.sy.projectUtils.SfglUtils;
import com.sy.service.parentser.IvParentSer;
import com.sy.service.parentser.ParentSerI;

@Service("ivInvoiceSer")
public class IvInvoiceService extends IvParentSer implements ParentSerI<IvInvoice>{

	@Override
	public List<IvInvoice> getAll() {
		return getIvInvoiceMapper().selectByExample(null);
	}
	@Override
	public IvInvoice selectByPrimaryKey(String id) {

		return getIvInvoiceMapper().selectByPrimaryKey(id);
	}

	@Override
	public int insert(IvInvoice entity) {
		return getIvInvoiceMapper().insert(entity);
	}

	@Override
	public int update(IvInvoice entity) {
		return getIvInvoiceMapper().updateByPrimaryKey(entity);
	}
	@Override
	public int delete(String id) {
		return getIvInvoiceMapper().deleteByPrimaryKey(id);
	}
	/**查询发票如果是未使用就查询*/
	public Map<String, Object> selectInvoice(SfglDto dto,
			HttpServletRequest request) {

		Integer page = dto.getPage();
		Integer rows = dto.getRows();
		
		SyEmp empLogin = (SyEmp) request.getSession().getAttribute("empLogin");
		if(empLogin==null){//用户没有登陆查不到发票
			return null;
		}
		Integer empId = empLogin.getEmpId();
		String whereStr=" and emp_id = "+empId +" and use_date is null ";
		List<IvInvoice> invoices=getIvInvoiceMapper().selectInvoiceByWhere(whereStr,(page-1)*rows,rows);
		Integer total = getIvInvoiceMapper().selectInvoiceCountByWhere(whereStr,(page-1)*rows,rows);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("invoices", invoices);
		map.put("page", page);
		map.put("rows", rows);
		total=total==null?0:total;
		int pageCount = (int) Math.ceil(total / (rows * 1.0));
		map.put("pageCount", pageCount);
		if(dto.getPageCount()!=null)
			map.put("pageCount", dto.getPageCount());
		System.out.println("invoices.size() :  " + invoices.size());
		
		
		return map;
		
	}
	
	
	
}
