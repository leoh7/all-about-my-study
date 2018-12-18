package wiring.auto;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AutoWiringTest {

	public static void main(String[] args) throws PerformanceException {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("wiring/auto/ApplicationContext.xml");
		Performer lee = (Performer) ctx.getBean("lee");
		lee.perform();
		
		Performer singer = (Performer) ctx.getBean("singer");
		singer.perform();
	}
}
