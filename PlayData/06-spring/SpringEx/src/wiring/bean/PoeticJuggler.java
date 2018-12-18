package wiring.bean;

public class PoeticJuggler extends Juggler {
	private Poem poem;
	
	public PoeticJuggler(int beanBags, Poem poem) {
		this.beanBags = beanBags;
		this.poem = poem;
	}

	@Override
	public void perform() throws PerformanceException {
		System.out.println("PoeticJuggler : " + beanBags + "개를 저글링합니다.");
		poem.recite();
	}
}
