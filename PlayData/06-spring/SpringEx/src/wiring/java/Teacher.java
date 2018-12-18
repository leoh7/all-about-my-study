package wiring.java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Component	// teacher
public class Teacher implements Role {
	@Value("선생님")
	private String name;
	
	@Override
	public void play() throws PerformanceException {
		// TODO Role-Teacher
		System.out.println( name + " : " + name + " 을 연기합니다");
	}

}
