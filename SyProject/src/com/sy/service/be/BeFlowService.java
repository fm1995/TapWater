package com.sy.service.be;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sy.entity.BeFlow;
import com.sy.entity.Flow;

@Service
public class BeFlowService extends BeParent{
	
	//��ѯȫ����ҵ������ 
		public List<Map> selBeFlow() {
			List<Map> maps = new ArrayList();
			// ��ȡҵ�����̱����������
			List<BeFlow> list = getBeFlowMapper().selectByExample(null);
			
			/*for (BeFlow beFlow : list) {
				System.out.println(beFlow.toString());
			}*/
			
			
			//���ֲ�ͬ��ҵ���в�ͬ��ҵ������
			Map<Integer,Flow> t1 = new HashMap<Integer,Flow>();
			Map<Integer,Flow> t2 = new HashMap<Integer,Flow>();
			Map<Integer,Flow> t3 = new HashMap<Integer,Flow>();
			Map<Integer,Flow> t4 = new HashMap<Integer,Flow>();
			Map<Integer,Flow> t5 = new HashMap<Integer,Flow>();
			Map<Integer,Flow> t6 = new HashMap<Integer,Flow>();
			Map<Integer,Flow> t7 = new HashMap<Integer,Flow>();
			
			/**
			 * Ϊÿһ��ҵ���������״̬
			 * */
			t1.put(-1,new Flow(-1,"��ֹ"));
			t1.put(0,new Flow(0,"���"));
			
			t2.put(-1,new Flow(-1,"��ֹ"));
			t2.put(0,new Flow(0,"���"));
			
			t3.put(-1,new Flow(-1,"��ֹ"));
			t3.put(0,new Flow(0,"���"));
			
			t4.put(-1,new Flow(-1,"��ֹ"));
			t4.put(0,new Flow(0,"���"));
			
			t5.put(-1,new Flow(-1,"��ֹ"));
			t5.put(0,new Flow(0,"���"));
			
			t6.put(-1,new Flow(-1,"��ֹ"));
			t6.put(0,new Flow(0,"���"));
			
			t7.put(-1,new Flow(-1,"��ֹ"));
			t7.put(0,new Flow(0,"���"));


			//�ӵڶ������ݿ�ʼ����ÿ��������ӵ���Ӧ��ҵ����
			for (int b = 2;b<list.size();b++) {
				BeFlow beFlow = list.get(b);
				if (beFlow.getType1() != null) {
					Flow fw = new Flow();
					fw.setId(beFlow.getType1());
					fw.setStepName(beFlow.getStepName());
					
					t1.put(beFlow.getType1(),fw);
				}
				if (beFlow.getType2() != null) {
					Flow fw = new Flow();
					fw.setId(beFlow.getType2());
					fw.setStepName(beFlow.getStepName());
					t2.put(beFlow.getType2(),fw);
				}
				if (beFlow.getType3() != null) {
					Flow fw = new Flow();
					fw.setId(beFlow.getType3());
					fw.setStepName(beFlow.getStepName());
					t3.put(beFlow.getType3(),fw);
				}
				if (beFlow.getType4() != null) {
					Flow fw = new Flow();
					fw.setId(beFlow.getType4());
					fw.setStepName(beFlow.getStepName());
					t4.put(beFlow.getType4(),fw);
				}
				if (beFlow.getType5() != null) {
					Flow fw = new Flow();
					fw.setId(beFlow.getType5());
					fw.setStepName(beFlow.getStepName());
					t5.put(beFlow.getType5(),fw);
				}
				if (beFlow.getType6() != null) {
					Flow fw = new Flow();
					fw.setId(beFlow.getType6());
					fw.setStepName(beFlow.getStepName());
					t6.put(beFlow.getType6(),fw);
				}
				if (beFlow.getType7() != null) {
					Flow fw = new Flow();
					fw.setId(beFlow.getType7());
					fw.setStepName(beFlow.getStepName());
					t7.put(beFlow.getType7(),fw);
				}
			}
			
			// ��ҵ����ӵ�List�����ڣ��������
			
			maps.add(t1);
			maps.add(t2);
			maps.add(t3);
			maps.add(t4);
			maps.add(t5);
			maps.add(t6);
			maps.add(t7);
						
//			System.out.println(maps.get(4).toString());
			/*	for(int i=0;i<7;i++){
				Map map = maps.get(i);
				System.out.println(maps.get(i).toString());
				System.out.println();
				for(int k=-1;k<map.size();k++){
					System.out.println(map.get(k).toString()+"?");
				}
			}*/
			
			
			return maps;
		}

	
	
	
}