package aop;

public interface Magician {
	public void intercept (String thought) throws PerformanceException;
	public void answer (String thought) throws PerformanceException;
}
