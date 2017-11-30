package com.sy.projectUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.sy.entity.userhelp.GenerateExcelBean;
import com.sy.entity.userhelp.UsUserHelpBean;


public class GenerateExcelUtility {
	public GenerateExcelUtility(){
		
	}
	//����excel��sheet��
	public void generateExcelTable(GenerateExcelBean exContext)
	{
		try {
			WritableWorkbook book=Workbook.createWorkbook(new File(exContext.getExcelPath()));
			WritableSheet sheet=book.createSheet(exContext.getFileName(), exContext.getSheetIndex());
			generateExcelHead(sheet, exContext.getTitles());
			generateExcelBody(sheet, exContext.getUserBeans());
			book.write();
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*���ɱ�ͷ һ��ֵ*/
	private void generateExcelHead(WritableSheet sheet,String[] titles) throws Exception
	{
		for (int i = 0; i < titles.length; i++) {
			
			Label label=new Label(i,0,titles[i]);
			sheet.addCell(label);
		}
	}
	
	/*����Excel����������*/
	private void generateExcelBody(WritableSheet sheet,List<Object[]> userBeans) throws Exception
	{
		
		for (int i = 0; i < userBeans.size(); i++) {
			for (int j = 0; j < 4; j++) {
				Label label=new Label(j, i+1, (String) userBeans.get(i)[j]);
				sheet.addCell(label);
			}
			
		}
	}
	
	private void newExcelBody(WritableSheet sheet,List<Object[]> userBeans) throws Exception
	{
		
		for (int i = 0; i < userBeans.size(); i++) {
			for (int j = 0; j < 4; j++) {
				Label label=new Label(j, i, (String) userBeans.get(i)[j]);
				sheet.addCell(label);
			}
			
		}
	}
	
	/*ת������*/
	public List<Object[]> converToObjects(List<UsUserHelpBean> userBeans)
	{
		List<Object[]> objs=new LinkedList<Object[]>();
		for (UsUserHelpBean i : userBeans) {
			objs.add(new Object[]{i.getUserNo(),i.getUserName(),i.getSmsPhone(),i.getSendOut()});
		}
		return objs;
	}
	
	
	/*��ȡxls������� ����Ӹ�������*/
	public void readExcelTable(GenerateExcelBean exContext) 
	{
		try {
			Workbook work= Workbook.getWorkbook(new File(exContext.getExcelPath()));
			Sheet newSheet=work.getSheet(0);
			Sheet sheet=work.getSheet(exContext.getFileName());
			Integer rows=newSheet.getRows();
			List<Object[]> objs=new ArrayList<Object[]>();
			for (int i = 0; i < rows; i++) {
				Object[] obj=new Object[4];
				for (int j = 0; j < obj.length; j++) {
					obj[j]=sheet.getCell(j, i).getContents();
				}
				objs.add(obj);
			}
			List<Object[]>userBeans=exContext.getUserBeans();
			for (Object[] objects : userBeans) {
				objs.add(objects);
			}
			userBeans.clear();
			exContext.setUserBeans(objs);
			addExcelTableContext(exContext);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/*����д������-���൱�ĺķ���Դ��*/
	public  void addExcelTableContext(GenerateExcelBean exContext) throws Exception
	{
		WritableWorkbook book=Workbook.createWorkbook(new File(exContext.getExcelPath()));
		WritableSheet sheet=book.createSheet(exContext.getFileName(), exContext.getSheetIndex());
		newExcelBody(sheet, exContext.getUserBeans());
		book.write();
		book.close();
		
	}
	
	
	//����
	/*public static void main(String[] args) {
		List<Object[]> objs=new ArrayList<Object[]>();
		Object[] o1={"s","d","f","g"};
		Object[] o2={"w","e","r","y"};
		objs.add(o1);
		objs.add(o2);
		GenerateExcelBean excelBean=new GenerateExcelBean(new String[]{"�û����","�û�����","���ź���","��������"}, objs);
		excelBean.setExcelPath("F:\\mass.xls");
		excelBean.setFileName("����Ⱥ��");
		excelBean.setSheetIndex(0);
		
		//���Ե���
		GenerateExcelUtility e=new GenerateExcelUtility();
		e.readExcelTable(excelBean);
		//e.generateExcelTable(excelBean);
		
	}*/
		
}
