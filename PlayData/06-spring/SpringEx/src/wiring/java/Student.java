package wiring.java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Component	// student
public class Student implements Role {
	@Value("학생")
	private String name;
	
	@Override
	public void play() throws PerformanceException {
		// TODO Role-Student
		System.out.println( name + " : " + name + " 을 연기합니다");
	}

}
