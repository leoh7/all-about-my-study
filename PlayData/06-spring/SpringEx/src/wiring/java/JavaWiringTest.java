package wiring.java;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaWiringTest {

	public static void main(String[] args) throws PerformanceException {
		// TODO JavaWiring - Main
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("wiring/java/ApplicationContext.xml");
			
			Performer actor = (Performer) ctx.getBean("actor");
			actor.perform();
			
			Performer singer = (Performer) ctx.getBean("singer");
			singer.perform();
			
			ctx.close();
	}

}
