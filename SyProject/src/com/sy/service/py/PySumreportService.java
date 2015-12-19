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
 * ������ˮͳ���ܱ� 
 * @author BarryLiu
 *
 */
@Service
public class PySumreportService extends PyParent{

	//================��ѯ������ˮͳ���ܱ�  
	public Map<String, Object> tongji(SfglDto dto) throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<PySumreport> datas =null;//ҳ��Ҫ��ʾ������
		if(dto.getTypee()==0){	//��ͳ�����²�ѯ
			map.put("months",  SfglUtils.getDateMonths(12));
				if(dto.getyMonth()==null&&!"".equals(dto.getyMonth()))
					return map;
				String ymonth = dto.getyMonth();
				String yearStr = ymonth.substring(0, 4);
				String monthStr = ymonth.substring(4, 6);
				 datas = selDateByYearOrYmonth(dto, yearStr,
						monthStr);
				 System.out.println(datas.size()+" year:"+yearStr+" month:"+monthStr);
			}else if(dto.getTypee()==1){//��ͳ����ݲ�ѯ
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
	 * ��ѯ��    ������ˮͳ���ܱ������  (���monthStr==null ���� dto.getTypee==1 ���ǰ����ѯ)
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
	 * ������ˮͳ���ܱ� ����ѡ�е��·�
	 * @param dto
	 * @return
	 */
	public Map<String, Object> tongjiJisuan(SfglDto dto) {
		
		Integer year=null,month=null;	//�õ�Ҫ����ʲô
		if(dto.getTypee()==0){ //��������
			String ymonth = dto.getyMonth();
			System.out.println(ymonth);
			  year = Integer.valueOf(ymonth.substring(0, 4));
			  month = Integer.valueOf(ymonth.substring(4, 6));
		}else if(dto.getTypee()==1){//�������
 			System.out.println(dto.getYear());
			year=Integer.valueOf(dto.getYear());
		}
		//����֮ǰ��Ҫ������ڻ�����ɾ��
		delOldData(dto,year,month);
		//���¼���
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

	/**���������������������ˮͳ���ܱ� �� ���뵽py_sumreport���� */
	private void insertDateByYearOrYmonth(SfglDto dto,  Integer year,
			Integer month) {
		//��ѯ��ʽ�����е�������ˮ��ͳ�Ʊ���,��ʱ��û�м����ռ�Ⱥ�ˮ��,�ۺ�ˮ��
		List<PySumreport> reports = selCostTypeToSumReport(year, month);
	
		
		List<PySumreport> curScts = testSurReport(reports); //��������ӷѵ���Ϣ
		
		Integer amounts=0;
		Double sums=0.0;
		for (PySumreport pySumreport : reports) { 				 //�������ˮ�� ������ܵ�
			
			Integer amount = Integer.valueOf(pySumreport.getC2());
			Double price  = Double.valueOf(pySumreport.getC3());
			Double sum=amount*price;
			pySumreport.setC4(String.format("%.2f", sum));
			amounts+=amount;  //�õ��ϼ�ˮ��
			sums+=sum;
		}
		for (PySumreport pySumreport : reports) {				//���ռ��
			
			DecimalFormat df1 = new DecimalFormat("0.0%");
			Double c2 = Double.valueOf(pySumreport.getC2());
			Double back=c2/amounts;
			String c5=df1.format(back.isNaN()?0.0:back);
			
			pySumreport.setC2(pySumreport.getC2()+"��");		//�����Ǽ��ϵ�λ
			pySumreport.setC3(pySumreport.getC3()+"Ԫ/��");
			pySumreport.setC4(pySumreport.getC4()+"Ԫ");
			
			pySumreport.setC5(c5);
		}
		
		
		 
		
		PySumreport report =new PySumreport();//��7�� ,����ϼ�ˮ��
		report.setC1(" �ϼ�ˮ�� ");
		report.setC2(amounts+"��");
		report.setC3("�ϼ�ˮ��");
		report.setC4(sums+"Ԫ");
		reports.add(report);
		
		report =new PySumreport();			//�ڰ��� ,ƽ��ˮ��
		if(dto.getTypee()==0)
			report.setC1("�����ۺ�ˮ��");
		else  
			report.setC1("�����ۺ�ˮ��");
		String c2Str = String.format("%.2f", sums/amounts);
		if(c2Str.equals("NaN"))//����������ִ��� sums��amountsΪ0
			report.setC2("0.0"+"Ԫ/��");
		else
			report.setC2(c2Str+"Ԫ/��");
		reports.add(report);
		
		reports.add(new PySumreport()); 	//�ھ���Ϊ��
		
		reports.addAll(curScts);			//��Ӹ��ӷ�
		
		
		
		report =new PySumreport();
		reports.add(report);				//����
		int countRead = countRead(year, month,null);//����(��)Ӧ������
		int countReal = countRead(year, month,true);//����(��)ʵ������
		report =new PySumreport();
		report.setC1("����Ӧ������");
		report.setC2(countRead+"��");
		report.setC3("����ʵ������");
		report.setC4(countReal+"��");
		reports.add(report);
		
		report =new PySumreport();
		report.setC1(" ������ ");
		String cbl = String.format("%.2f",countReal/(countRead*1.0) );
		if(cbl.equals("NaN"))//����������ִ��� sums��amountsΪ0
			report.setC2("0.0"+"%");
		else
			report.setC2(cbl+"%");
		report.setC3("��ͣ�û�����");
//		report.setC4("��");		//
		reports.add(report);
		
		
		report =new PySumreport();	
		report.setC1("����ˮ����ˮ��");
//		report.setC2("");
		report.setC3("���³���ˮ��");
		String whereStr=initWhereStr(year,month,null);
		Double sumAmounts = rdReadMapper.sumAmountByWhere(whereStr);
		sumAmounts=sumAmounts==null?0:sumAmounts;
		report.setC4(sumAmounts+"��");
		reports.add(report);
		
		report = new PySumreport();
		report.setC1(" ������ ");
		report.setC2("%");
		reports.add(report);
		
		initPort(dto, year, month, reports);//���ù������Դ�ӡ���Ҳ�������
	}
	/** ��ѯ��ʽ�����е�������ˮ��ͳ�Ʊ���,��ʱ��û�м����ռ�Ⱥ�ˮ��,�ۺ�ˮ�� */
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
	/**��������ӷѵ���Ϣ*/
	private List<PySumreport> testSurReport(List<PySumreport> reports) {
		List<SyCostType> scts = syCostTypeMapper.selectSurcharge(null);//���и��ӷ�
		List<SySurcharge> sscs = sySurchargeMapper.selectByExample(null);
		List<PySumreport> curScts=new ArrayList<PySumreport>();//��ż�����ĸ��ӷ���Ϣ
		Double surSums=0.0; //���㸽�ӷ���Ӧ��
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
			curReport.setC2(result+"Ԫ");
			curScts.add(curReport);
			surSums+=sum;
		}
		PySumreport surReport = curScts.get(curScts.size()-1);//���һ�����ӷ�   Ϊ�������Ӧ��
		surReport.setC3("��Ӧ�� ");
		surReport.setC4(surSums+"Ԫ");
		
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
	 * ����(��)Ӧ������
	 * @param year ��   
	 * @param month ��  null �Ͳ�ѯ��
	 * @param enter �ѳ�    null���� ��falseδ����true �ѳ�
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
	
	/**���ù������Դ�ӡ���Ҳ�������*/
	private void initPort(SfglDto dto, Integer year, Integer month,
			List<PySumreport> reports) {
		for (int i = 0; i < reports.size(); i++) {
			PySumreport port = reports.get(i);		//���ù������Դ�ӡ����
			port.setLineNo(i+1);
			port.setReportMonth(month);
			port.setReportYear(year);
			port.setTypee(dto.getTypee());
			
			System.out.println(port);
			pySumreportMapper.insert(port);
		}
	}
}