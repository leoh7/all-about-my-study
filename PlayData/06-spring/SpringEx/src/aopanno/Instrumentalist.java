package aopanno;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("lee")
public class Instrumentalist implements Performer {
	@Value("박효신 - 그 날")
	private String song;
	
	@Autowired
	@Qualifier("piano")
	private Instrument instrument;

	@Override
	public void perform() throws PerformanceException {
		System.out.println("Instrument : " + song + "을 연주합니다.");
		instrument.playing();
		
	}
}
