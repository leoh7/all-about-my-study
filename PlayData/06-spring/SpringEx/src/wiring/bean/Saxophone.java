package wiring.bean;

public class Saxophone implements Instrument {

	@Override
	public void playing() throws PerformanceException {
		System.out.println("Saxophone : 쎅쏘뽄!!!");	

	}

}
