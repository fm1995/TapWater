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
	
	//查询全部的业务流程 
		public List<Map> selBeFlow() {
			List<Map> maps = new ArrayList();
			// 获取业务流程表的所有数据
			List<BeFlow> list = getBeFlowMapper().selectByExample(null);
			
			/*for (BeFlow beFlow : list) {
				System.out.println(beFlow.toString());
			}*/
			
			
			//七种不同的业务，有不同的业务流程
			Map<Integer,Flow> t1 = new HashMap<Integer,Flow>();
			Map<Integer,Flow> t2 = new HashMap<Integer,Flow>();
			Map<Integer,Flow> t3 = new HashMap<Integer,Flow>();
			Map<Integer,Flow> t4 = new HashMap<Integer,Flow>();
			Map<Integer,Flow> t5 = new HashMap<Integer,Flow>();
			Map<Integer,Flow> t6 = new HashMap<Integer,Flow>();
			Map<Integer,Flow> t7 = new HashMap<Integer,Flow>();
			
			/**
			 * 为每一个业务流程添加状态
			 * */
			t1.put(-1,new Flow(-1,"终止"));
			t1.put(0,new Flow(0,"完成"));
			
			t2.put(-1,new Flow(-1,"终止"));
			t2.put(0,new Flow(0,"完成"));
			
			t3.put(-1,new Flow(-1,"终止"));
			t3.put(0,new Flow(0,"完成"));
			
			t4.put(-1,new Flow(-1,"终止"));
			t4.put(0,new Flow(0,"完成"));
			
			t5.put(-1,new Flow(-1,"终止"));
			t5.put(0,new Flow(0,"完成"));
			
			t6.put(-1,new Flow(-1,"终止"));
			t6.put(0,new Flow(0,"完成"));
			
			t7.put(-1,new Flow(-1,"终止"));
			t7.put(0,new Flow(0,"完成"));


			//从第二条数据开始，将每个流程添加到相应的业务内
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
			
			// 将业务添加到List集合内，方便调用
			
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