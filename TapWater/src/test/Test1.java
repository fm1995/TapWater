package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sy.mappdao.UsUserMapper;
import com.sy.service.parentser.UsParentSer;

public class Test1 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext cxt=new ClassPathXmlApplicationContext("spring-mvccore.xml");
		
		//test1(cxt);
		UsParentSer servicep = (UsParentSer) cxt.getBean("usParentSer");
		System.out.println("++"+servicep);
		UsParentSer service = (UsParentSer) cxt.getBean("usUserService");
		System.out.println(service);
		
		
	}

	private static void test1(ClassPathXmlApplicationContext cxt) {
		UsUserMapper mapper = (UsUserMapper) cxt.getBean("usUserMapper");
		System.out.println(mapper);
		int page=1,rows=5;
		int count = mapper.selectYSListCount((page - 1) * rows, rows, 200);
		System.out.println(count);
	}
}
