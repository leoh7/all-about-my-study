package wiring.scan;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;

public class Singer implements Performer {
	@Value("박효신")
	private String name;
	
	@Resource(name="bounce")
	private Song song;
	
	@Resource(name="piano")
	private Instrument instrument;
	
	@Override
	public void perform() throws PerformanceException {
		// TODO Perform - Singer
		System.out.println();
		System.out.println(name + " 이 부릅니다.");
		song.singing();
		instrument.playing();
	}

}
