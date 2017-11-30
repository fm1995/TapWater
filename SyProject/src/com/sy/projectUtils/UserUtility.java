package com.sy.projectUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sy.entity.BeOrderlite;
import com.sy.entity.UsFormula;
import com.sy.entity.UsUser;
import com.sy.entity.page.Page;
import com.sy.entity.userhelp.OrderLite;
import com.sy.entity.userhelp.UsUserHelpBean;
import com.sy.entity.view.MeterView;

/**
 * @author �佨��  �û�����
 * 
 * version 1.0
 * */
public class UserUtility {
	//ת����ѯ�����ֶ�ֵ
	public UsUser convertToUser(UsUser user){
		user.setAbc("%"+user.getAbc()+"%");
		user.setAddress("%"+user.getAddress()+"%");
		user.setPhone( "%"+user.getPhone()+"%");
		user.setUserName("%"+user.getUserName()+"%");
		return user;
	}
	
	//�û��������Э�顶--��ת����--��������� -��author - �佨�桿
	public  List<UsFormula> userConvertToUsFormula(UsUser user){
		//׼������װUsFormat���Ͷ���
		List<UsFormula> formulas=new ArrayList<UsFormula>();
		
		//׼������
		UsFormula formula=null;
		
		//ת���������ֵ
		String str=new UserUtility().formatStr(user.getFormula());
		
		//ת�����и��ַ��� ������"]"�и
		String[] formatFormula=str.split("]");
		for (int i = 0; i < formatFormula.length; i++) {
			//�ٶ��и��ַ��� ������":"�и
			
			formula=new UsFormula();
			formula.setUserNo(user.getUserNo());
			String[] usFormula=formatFormula[i].split(":");
			formula.setWaterTypeCode(usFormula[0]);
			formula.setAllotText(usFormula[1]);
			if(usFormula[1].endsWith("%")){
				formula.setAllotType(1);
				formula.setAllotValue(Integer.parseInt(usFormula[1].substring(0, usFormula[1].length()-1)));
			}else if(usFormula[1].endsWith("*")){
				formula.setAllotType(2);
			}else{
				formula.setAllotType(0);
				formula.setAllotValue(Integer.parseInt(usFormula[1]));
			}
		

			//��Ӷ���
			formulas.add(formula);
		}
		
		return formulas;
		
		
	}
	
	//��������ַ���ת��-��author �佨�桿
	public String formatStr(String string){
		String formulaStr="";
		char [] ch=string.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if(ch[i]=='['){
				continue;
			}
			formulaStr+=ch[i];
		}
		return formulaStr;
	}
	
	//��ӿ�ݲ�����������
	public BeOrderlite convertTo(UsUser user,BeOrderlite orderLite){
		orderLite.setDatee(new Date());
		orderLite.setUserNo(user.getUserNo());
		orderLite.setUserName(user.getUserName());
		return orderLite;
	}
	
	/*ת����ݲ�����ͼbean*/
	public OrderLite converToBeOrderLite(OrderLite orderLite,Page page){
		if(orderLite.getOrderType()==0)
		{
			orderLite.setOrderType(null);
		}
		if(orderLite.getEmpNo()==0)
		{
			orderLite.setEmpNo(null);
		}
		
		Date startTime=new UserUtility().converToTime(orderLite.getStratDatee());
		Date stopTime=new UserUtility().converToTime(orderLite.getStopDatee());
		if(orderLite.getStratDatee()!=null)
		{
			orderLite.setStratTime(startTime);
		}else{
			orderLite.setStratTime(null);
		}
		if(orderLite.getStopDatee()!=null)
		{
			orderLite.setStopTime(stopTime);
		}else{
			orderLite.setStopTime(null);
		}
		orderLite.setPage(new UserUtility().converToPage(page));		
		return orderLite;
	}
	/*�����ҳ��*/
	public Page converToPage(Page page){
		
	
		Integer pageNumber=(page.getPageNumber()-1)*page.getPageSize();
		Integer pageSize=page.getPageSize()+pageNumber;
		page.setPageNum(page.getPageNumber());
		page.setPageSize(pageSize);
		page.setPageNumber(pageNumber);
		return page;
	}
	/*�ַ���ת��ʱ��*/
	private Date converToTime(String strTime){
		Date strDate=null;
		SimpleDateFormat format=new SimpleDateFormat("yy-MM-dd");
		try {
			 strDate=format.parse(strTime);
		} catch (ParseException e) {
			
		}
		return strDate;
	}
	/*ʱ��ת���ַ���*/
	public String converToString(Date time){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(time);
		
	}
	/*��ݲ�������ת����ʾ*/
	public String convertToOrderType(Integer orderType){
		String type="";
		if(orderType==1){
			type="�»�";
		}else if(orderType==2){
			type="�ֻ�";
		}else if(orderType==3){
			type="����";
		}else if(orderType==4){
			type="����";
		}else if(orderType==5){
			type="����";
		}else if(orderType==6){
			type="��ǩ";
		}else if(orderType==7){
			type="����";
		}else{
			type="ʧ�ܵĲ�����¼";
		}
		return type;
	}
	//��ʼ��Stringֵ
	public String isNull(String str){
		if(str==null){
			str="";
		}
		return str;
	}
	//������ʾ��page��Ϣ
	public Page changPage(Page page)
	{
		Page pageNoe=new Page();
		pageNoe.setPageNumber(page.getPageNum());
		pageNoe.setPageCount(page.getPageCount());
		Integer count=0;
		Integer shang=pageNoe.getPageCount()/10;
		if(shang==0)
		{
			if(page.getPageNumber()==0)
			{
				count+=1;
			}else{
				count=page.getPageNumber();
			}
		}else if(shang>0)
		{
			count=shang+1;
		}else{
		
			count=page.getPageNumber()+1;
		}
		pageNoe.setPageNum(count);
		return pageNoe;
	}
	//����Ⱥ������ת��
	public List<UsUserHelpBean> converToUsUserHelpBean(List<UsUserHelpBean> userBeans,UsUserHelpBean userBean)
	{
		String sendOut=userBean.getSendOut();
		int stratIndex=sendOut.indexOf("{",0);
		int stopIndex=sendOut.indexOf("}",0);
		String displayValue= sendOut.substring(stratIndex, stopIndex+1);
		String generateStr=generateArr(sendOut, stratIndex, stopIndex);
		for (UsUserHelpBean usUserHelpBean : userBeans) {
			if(displayValue.equals("{�û�����}"))
			{
				usUserHelpBean.setSendOut(
						userBean.getSendOut().replace(
								displayValue,usUserHelpBean.getUserName().trim()));
			}else{
				usUserHelpBean.setSendOut(
						userBean.getSendOut().replace(
								displayValue,usUserHelpBean.getUserMoney().toString().trim()));
			}
			if(generateStr!=null&&generateStr!="")
			{
				usUserHelpBean.setSendOut(
						usUserHelpBean.getSendOut().replace(
								generateStr,usUserHelpBean.getUserMoney().toString().trim()));
			}
		}
		return userBeans;
		
	}
	//����Ⱥ��-������ʾ
	private String generateArr(String sendOut,Integer startIndex,Integer stopIndex)
	{
		int beginIndex=sendOut.indexOf("{",startIndex+1);
		int endIndex=sendOut.indexOf("}",stopIndex+1);
		String displayValue="";
		if(beginIndex<endIndex){
			displayValue =sendOut.substring(beginIndex, endIndex+1);
		}
		return displayValue;
	}
	
	/*meterˮ��beanת��view��ͼ*/
	public List<MeterView> converToMeterView(List<MeterView> meterView)
	{
		for (MeterView meterView2 : meterView) {
			if(meterView2.getMeter().getMeterTypeId() != null)
			{
				switch (meterView2.getMeter().getMeterTypeId()) {
				case 1:
					meterView2.setMeterType("DN10");
					break;
				case 2:
					meterView2.setMeterType("DN15");		
					break;
				case 3:
					meterView2.setMeterType("DN20");
					break;
				case 4:
					meterView2.setMeterType("DN40");
					break;
				case 5:
					meterView2.setMeterType("DN80");
					break;
				case 6:
					meterView2.setMeterType("DN100");
					break;
				case 7:
					meterView2.setMeterType("DN200");
					break;
				case 8:
					meterView2.setMeterType("DN500");
					break;
	
				default:
					meterView2.setMeterType("DN1000");
					break;
				}
				
				String meterNo=meterView2.getMeter().getMeterNo().substring(meterView2.getMeter().getMeterNo().length()-2);
				String meterNewNo=meterView2.getMeter().getMeterNo().substring(0,meterView2.getMeter().getMeterNo().length()-2);
				Integer meterId=Integer.parseInt(meterNo)+1;
				if(meterId>0&&meterId<10)
				{
					meterView2.getMeter().setMeterNo(meterNewNo+"0"+meterId);
				}else{
					meterView2.getMeter().setMeterNo(meterNewNo+meterId);
				}
			}
		}
		
		return meterView;
	}

	
	
}
