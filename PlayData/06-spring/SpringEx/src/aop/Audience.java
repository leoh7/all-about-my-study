package aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
	// before
	public void takeSeat(){
		System.out.println("자리에 앉는다");
	}
	// before
	public void turnOffPhone(){
		System.out.println("핸드폰을 끈다");
	}
	
	// after-returnig
	public void applaud(){
		System.out.println("짝짝짝짝");
	}
	// after-throwing
	public void refund(){
		System.out.println("환불해줏쑈!");
	}
	// after
	public void audExit(){
		System.out.println("관객퇴장");
	}
	
	// around
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
