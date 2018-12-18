package aopanno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Singer implements Performer {
	@Value("박효신")
	private String name;
	@Resource
	private Song song;
	
	@Resource
	private Instrument instrument;

	
	@Override
	public void perform() throws PerformanceException {
		// TODO Perform - Singer
		System.out.println(name + " 이 부릅니다.");
		song.singing();
		instrument.playing();
	}
}
