package aopanno;

import org.springframework.stereotype.Component;

@Component
public class Volunteer implements Think {

	@Override
	public void thinking(String thought) throws PerformanceException {
		// TODO Think - Volunteer - pointcut
		System.out.println("지원자의 생각 : " + thought);
	}

}
