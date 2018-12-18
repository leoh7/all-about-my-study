package wiring.bean;

public class Juggler implements Performer{
	public int beanBags = 3;
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println("Juggler : " + beanBags + "개를 저글링합니다.");
	}
}
