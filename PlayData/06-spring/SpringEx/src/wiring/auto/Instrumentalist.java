package wiring.auto;

public class Instrumentalist implements Performer {
	private String song;
	private Instrument instrument;
	
	// 생성자	byName, byType
	public Instrumentalist(String song, Instrument instrument) {
		this.song = song;
		this.instrument = instrument;
	}
	public Instrumentalist(){}
	
	
	public void setSong(String song) {
		this.song = song;
	}
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void perform() throws PerformanceException {
		System.out.println("Instrument : " + song + "을 연주합니다.");
		instrument.playing();
		
	}
}
