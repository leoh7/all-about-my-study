package aopanno;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MindReader implements Magician {
	@Pointcut("execution(void aopanno.Think.thinking( String )) && args( thought )")
	public void think(String thought){}	// 가짜 메서드
	
	@Before("think(thought)")
	@Override
	public void intercept(String thought) throws PerformanceException {
		// TODO Magician - MindReader
		System.out.println("("+"독심술사가 읽어낸 것! : " + thought + ")");
	}
	@After("think(thought)")
	@Override
	public void answer(String thought) throws PerformanceException {
		System.out.println("독심술사의 대답! : " + thought);
	}

}
