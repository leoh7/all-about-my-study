package wiring.anno;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {

	public static void main(String[] args) throws PerformanceException {
		ClassPathXmlApplicationContext ctx 
			= new ClassPathXmlApplicationContext("wiring/anno/ApplicationContext.xml");
		
		Performer lee = (Performer) ctx.getBean("lee");
		lee.perform();
		
		Performer singer = (Performer) ctx.getBean("singer");
		singer.perform();
	
		Performer two = (Performer) ctx.getBean("two");
		two.perform();
	}
}
