package aopanno;

import org.springframework.stereotype.Component;

public class Guitar implements Instrument {

	@Override
	public void playing() throws PerformanceException {
		System.out.println("Guitar : 따라랑");	
		
	}

}
