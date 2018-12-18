package wiring.scan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentScanTest {
	public static void main(String[] args) throws PerformanceException {
		ClassPathXmlApplicationContext ctx = 
			new ClassPathXmlApplicationContext("wiring/scan/ApplicationContext.xml");
		
		Performer actor = (Performer) ctx.getBean("actor");
		actor.perform();
		
		Performer singer = (Performer) ctx.getBean("singer");
		singer.perform();
		
		ctx.close();
	}
}
