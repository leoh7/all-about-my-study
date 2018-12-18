package aopanno;

import org.springframework.stereotype.Component;

@Component
public interface Magician {
	public void intercept (String thought) throws PerformanceException;
	public void answer (String thought) throws PerformanceException;
}
