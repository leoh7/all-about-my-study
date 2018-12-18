package aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {
	@Pointcut( "execution( * aopanno.Performer.perform(..) )" )
	public void performance(){}	// perform 이란 메서드를 대신할 가짜메서드
	
	// before
	@Before("performance()")
	public void takeSeat(){
		System.out.println("자리에 앉는다");
	}
	// before
	@Before("performance()")
	public void turnOffPhone(){
		System.out.println("핸드폰을 끈다");
	}
	
	// after-returnig
	@AfterReturning("performance()")
	public void applaud(){
		System.out.println("짝짝짝짝");
		System.out.println();
	}
	
	// after-throwing
	@AfterThrowing("performance()")
	public void refund(){
		System.out.println("환불해줏쑈!");
	}
	
	// after
	@After("performance()")
	public void audExit(){
		System.out.println("관객퇴장");
	}
	
	// around
	@Around("performance()")
	public void runtime( ProceedingJoinPoint joinPoint){
		long start = System.currentTimeMillis();
		try {
			joinPoint.proceed();	// 이게 perform() 되는 것
		} catch (Throwable e) {		// pointcut method
			e.printStackTrace();
		}	
		long end = System.currentTimeMillis();
		System.out.println("공연시간 : " + (end - start));
	}
}
