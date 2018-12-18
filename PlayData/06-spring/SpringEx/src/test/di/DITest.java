package test.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {

	public static void main(String[] args) throws PerformanceException {
		// TODO DI - main
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("test/di/ApplicationContext.xml");
		
		Performer band = (Performer) ctx.getBean("band");
		band.perform();
		
		ctx.close();
	}

}
