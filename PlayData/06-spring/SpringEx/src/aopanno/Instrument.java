package aopanno;

import org.springframework.stereotype.Component;

public interface Instrument {
	public void playing() throws PerformanceException;
	
}
