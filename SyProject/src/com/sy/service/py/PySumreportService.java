package com.sy.service.py;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.sy.entity.PySumreport;
import com.sy.entity.PySumreportExample;
import com.sy.entity.PySumreportExample.Criteria;
import com.sy.entity.RdRead;
import com.sy.entity.RdReadExample;
import com.sy.entity.SyCostType;
import com.sy.entity.SyCostTypeExample;
import com.sy.entity.SySurcharge;
import com.sy.projectUtils.SfglDto;
import com.sy.projectUtils.SfglUtils;

/**
 * 各类用水统计总表 
 * @author BarryLiu
 *
 */
@Service
public class PySumreportService extends PyParent{

	//================查询各类用水统计总表  
	public Map<String, Object> tongji(SfglDto dto) throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<PySumreport> datas =null;//页面要显示的数据
		if(dto.getTypee()==0){	//按统计年月查询
			map.put("months",  SfglUtils.getDateMonths(12));
				if(dto.getyMonth()==null&&!"".equals(dto.getyMonth()))
					return map;
				String ymonth = dto.getyMonth();
				String yearStr = ymonth.substring(0, 4);
				String monthStr = ymonth.substring(4, 6);
				 datas = selDateByYearOrYmonth(dto, yearStr,
						monthStr);
				 System.out.println(datas.size()+" year:"+yearStr+" month:"+monthStr);
			}else if(dto.getTypee()==1){//按统计年份查询
				map.put("year", new Date().getYear()+1900);
				if(dto.getYear()==null)
					return map;
				String year = dto.getYear();
				 datas = selDateByYearOrYmonth(dto,year,null);
			}
		
		 System.out.println(dto);
		map.put("datas", datas);
		map.put("dto", dto);
		
		 return map;
	}

	/**
	 * 查询出    各类用水统计总表的数据  (如果monthStr==null 并且 dto.getTypee==1 就是按年查询)
	 * @param dto
	 * @param yearStr
	 * @param monthStr
	 * @return
	 */
	private List<PySumreport> selDateByYearOrYmonth(SfglDto dto,
			String yearStr, String monthStr) {
		PySumreportExample example =new PySumreportExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andTypeeEqualTo(dto.getTypee());
		if(yearStr!=null&&!"".equals(yearStr))
		criteria.andReportYearEqualTo(Integer.parseInt(yearStr));
		if(monthStr!=null&&!"".equals(monthStr))
			criteria.andReportMonthEqualTo(Integer.parseInt(monthStr));
		List<PySumreport> datas = pySumreportMapper.selectByExample(example);
		return datas;
	}

	
	
	/**
	 * 各类用水统计总表 计算选中的月份
	 * @param dto
	 * @return
	 */
	public Map<String, Object> tongjiJisuan(SfglDto dto) {
		
		Integer year=null,month=null;	//得到要计算什么
		if(dto.getTypee()==0){ //计算年月
			String ymonth = dto.getyMonth();
			System.out.println(ymonth);
			  year = Integer.valueOf(ymonth.substring(0, 4));
			  month = Integer.valueOf(ymonth.substring(4, 6));
		}else if(dto.getTypee()==1){//计算年份
 			System.out.println(dto.getYear());
			year=Integer.valueOf(dto.getYear());
		}
		//计算之前将要计算的在缓存中删除
		delOldData(dto,year,month);
		//重新计算
		insertDateByYearOrYmonth(dto,year,month);
		return null;
	}
	
	private void delOldData(SfglDto dto, Integer year, Integer month) {
		PySumreportExample example=new PySumreportExample();
		Criteria criteria = example.createCriteria();
		criteria.andReportYearEqualTo(year);
		criteria.andTypeeEqualTo(dto.getTypee());
		if(month!=null && month!=0)
			criteria.andReportMonthEqualTo(month);
		pySumreportMapper.deleteByExample(example);
	}

	/**根据条件计算出【各类用水统计总表 】 插入到py_sumreport表中 */
	private void insertDateByYearOrYmonth(SfglDto dto,  Integer year,
			Integer month) {
		//查询方式出所有的正常用水到统计表中,此时还没有计算出占比和水量,综合水价
		List<PySumreport> reports = selCostTypeToSumReport(year, month);
	
		
		List<PySumreport> curScts = testSurReport(reports); //计算出附加费的信息
		
		Integer amounts=0;
		Double sums=0.0;
		for (PySumreport pySumreport : reports) { 				 //求出基本水类 并算出总的
			
			Integer amount = Integer.valueOf(pySumreport.getC2());
			Double price  = Double.valueOf(pySumreport.getC3());
			Double sum=amount*price;
			pySumreport.setC4(String.format("%.2f", sum));
			amounts+=amount;  //得到合计水量
			sums+=sum;
		}
		for (PySumreport pySumreport : reports) {				//算出占比
			
			DecimalFormat df1 = new DecimalFormat("0.0%");
			Double c2 = Double.valueOf(pySumreport.getC2());
			Double back=c2/amounts;
			String c5=df1.format(back.isNaN()?0.0:back);
			
			pySumreport.setC2(pySumreport.getC2()+"吨");		//给他们加上单位
			pySumreport.setC3(pySumreport.getC3()+"元/吨");
			pySumreport.setC4(pySumreport.getC4()+"元");
			
			pySumreport.setC5(c5);
		}
		
		
		 
		
		PySumreport report =new PySumreport();//第7行 ,计算合计水量
		report.setC1(" 合计水量 ");
		report.setC2(amounts+"吨");
		report.setC3("合计水费");
		report.setC4(sums+"元");
		reports.add(report);
		
		report =new PySumreport();			//第八行 ,平均水量
		if(dto.getTypee()==0)
			report.setC1("本月综合水价");
		else  
			report.setC1("本年综合水价");
		String c2Str = String.format("%.2f", sums/amounts);
		if(c2Str.equals("NaN"))//如果不是数字代表 sums或amounts为0
			report.setC2("0.0"+"元/吨");
		else
			report.setC2(c2Str+"元/吨");
		reports.add(report);
		
		reports.add(new PySumreport()); 	//第九行为空
		
		reports.addAll(curScts);			//添加附加费
		
		
		
		report =new PySumreport();
		reports.add(report);				//换行
		int countRead = countRead(year, month,null);//本月(年)应抄数量
		int countReal = countRead(year, month,true);//本月(年)实抄数量
		report =new PySumreport();
		report.setC1("本月应抄户数");
		report.setC2(countRead+"户");
		report.setC3("本月实抄户数");
		report.setC4(countReal+"户");
		reports.add(report);
		
		report =new PySumreport();
		report.setC1(" 抄表率 ");
		String cbl = String.format("%.2f",countReal/(countRead*1.0) );
		if(cbl.equals("NaN"))//如果不是数字代表 sums或amounts为0
			report.setC2("0.0"+"%");
		else
			report.setC2(cbl+"%");
		report.setC3("报停用户总数");
//		report.setC4("户");		//
		reports.add(report);
		
		
		report =new PySumreport();	
		report.setC1("本月水厂出水量");
//		report.setC2("");
		report.setC3("本月抄回水量");
		String whereStr=initWhereStr(year,month,null);
		Double sumAmounts = rdReadMapper.sumAmountByWhere(whereStr);
		sumAmounts=sumAmounts==null?0:sumAmounts;
		report.setC4(sumAmounts+"吨");
		reports.add(report);
		
		report = new PySumreport();
		report.setC1(" 抄回率 ");
		report.setC2("%");
		reports.add(report);
		
		initPort(dto, year, month, reports);//设置公共属性打印并且插入数据
	}
	/** 查询方式出所有的正常用水到统计表中,此时还没有计算出占比和水量,综合水价 */
	private List<PySumreport> selCostTypeToSumReport(Integer year, Integer month) {
		String yearStr=null;
		if(year!=null &&  year!= 0)
			yearStr=" and ( rd.read_year ='"+year+"' or rd.read_year is null ) ";
		String monthStr=null;
		if(month!=null && month!=0 )
			monthStr=" and ( rd.read_month = '"+month+"' or rd.read_month is null)";
		System.out.println("year:"+year+" month:"+month);
		List<PySumreport> reports = pySumreportMapper.selectAmountPrice(yearStr, monthStr);
		return reports;
	}
	/**计算出附加费的信息*/
	private List<PySumreport> testSurReport(List<PySumreport> reports) {
		List<SyCostType> scts = syCostTypeMapper.selectSurcharge(null);//所有附加费
		List<SySurcharge> sscs = sySurchargeMapper.selectByExample(null);
		List<PySumreport> curScts=new ArrayList<PySumreport>();//存放计算出的附加费信息
		Double surSums=0.0; //计算附加费总应收
		for (SyCostType sct : scts) {
			Double sum=0.0;
			PySumreport curReport=new PySumreport();
			for (PySumreport report : reports) {
				if(report.getC5()==null)
					break;
				for (SySurcharge sySurcharge : sscs) {
					if(sct.getCosttypeId()==sySurcharge.getSurchargeId()&& sySurcharge.getWaterTypeId()==Integer.valueOf(report.getC5())){
						sum+=Integer.valueOf(report.getC2());
					}
				}
			}
			Double result=sct.getCosttypePrice().doubleValue()*sum;
			
			curReport.setC1(sct.getCostTypeName());
			curReport.setC2(result+"元");
			curScts.add(curReport);
			surSums+=sum;
		}
		PySumreport surReport = curScts.get(curScts.size()-1);//最后一条附加费   为其添加总应收
		surReport.setC3("总应收 ");
		surReport.setC4(surSums+"元");
		
		return curScts;
	}
	private String initWhereStr(Integer year, Integer month, Boolean enter) {
		StringBuffer sb=new StringBuffer("");
		if(year!=null)
			sb.append(" and  read_year = "+year);
		if(month!=null)
			sb.append(" and read_month="+month);
		if(enter!=null){
			if(enter)
				sb.append("  and enter="+0);
			else
				sb.append("  and enter="+1);
		}
				
		return sb.toString();
	}

	/**
	 * 本月(年)应抄户数
	 * @param year 年   
	 * @param month 月  null 就查询年
	 * @param enter 已抄    null所有 ，false未抄，true 已抄
	 * @return
	 */
	private int countRead(Integer year, Integer month,Boolean enter) {
		RdReadExample example =new RdReadExample();
		com.sy.entity.RdReadExample.Criteria criteria = example.createCriteria();
		if(year!=null)
			criteria.andReadYearEqualTo(year);
		if(month!=null)
			criteria.andReadMonthEqualTo(month);
		if(enter !=null)
			criteria.andEnterEqualTo(enter);
		int count = rdReadMapper.countByExample(example );
		return count;
	}
	
	/**设置公共属性打印并且插入数据*/
	private void initPort(SfglDto dto, Integer year, Integer month,
			List<PySumreport> reports) {
		for (int i = 0; i < reports.size(); i++) {
			PySumreport port = reports.get(i);		//设置公共属性打印插入
			port.setLineNo(i+1);
			port.setReportMonth(month);
			port.setReportYear(year);
			port.setTypee(dto.getTypee());
			
			System.out.println(port);
			pySumreportMapper.insert(port);
		}
	}
}