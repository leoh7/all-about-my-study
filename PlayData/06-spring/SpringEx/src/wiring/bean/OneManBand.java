package wiring.bean;

import java.util.ArrayList;
import java.util.List;

public class OneManBand implements Performer {

	private String song;
	private List<Instrument> instruments = new ArrayList<>();
	
	public void setSong(String song) {
		this.song = song;
	}
	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}

	@Override
	public void perform() throws PerformanceException {
		System.out.println("OneManBand : " + song + "을 연주합니다.");
		for(Instrument instrument : instruments){
			instrument.playing();
		}
	}

}
