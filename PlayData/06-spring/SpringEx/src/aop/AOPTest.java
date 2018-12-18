package aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

	public static void main(String[] args) throws PerformanceException {
		// TODO AOP - main
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("aop/ApplicationContext.xml");
		
		
		Performer lee = (Performer) ctx.getBean("lee");
		lee.perform();
		
		Performer singer = (Performer) ctx.getBean("singer");
		singer.perform();
		
		System.out.println("\n");
		Think volunteer = (Think) ctx.getBean("volunteer");
		volunteer.thinking("짜장면");
		
		ctx.close();
	}

}
