package wiring.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class Instrumentalist implements Performer {
	@Value("Hello")
	private String song;

	@Autowired( required=false )
	@Qualifier("drum")
	private Instrument instrument;	// private 은? 편리성을 위해 무시해버린다
	
//	// 생성자	byName, byType
//	public Instrumentalist(String song, Instrument instrument) {
//		this.song = song;
//		this.instrument = instrument;
//	}
//	public Instrumentalist(){}
//	
//	public void setSong(String song) {
//		this.song = song;
//	}
	
//	@Autowired
//	public void setInstrument(Instrument instrument) {
//		this.instrument = instrument;
//	}
//	@Autowired
//	public void myInstrument(Instrument instrument) {
//		this.instrument = instrument;
//	}
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println("Instrument : " + song + "을 연주합니다.");
		instrument.playing();
		
	}
}
