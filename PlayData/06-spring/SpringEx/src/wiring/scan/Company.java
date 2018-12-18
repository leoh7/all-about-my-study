package wiring.scan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Component	// company
public class Company implements Role {
	@Value("회사원")
	private String name;
	
	@Override
	public void play() throws PerformanceException {
		// TODO Role-Company
		System.out.println( name + " : " + name + " 을 연기합니다");
	}

}
