package wiring.bean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TwoManBand implements Performer {

	private String song;
	private Map<String, Instrument> instruments = new HashMap<String, Instrument>();
	
	public void setSong(String song) {
		this.song = song;
	}

	public void setInstruments(Map<String, Instrument> instruments) {
		this.instruments = instruments;
	}

	@Override
	public void perform() throws PerformanceException {
		System.out.println("TwoManBand : " + song + "을 연주합니다.");
		Iterator<String> keys = instruments.keySet().iterator();
		while(keys.hasNext()){
			String key = keys.next();
			Instrument instrument = instruments.get(key);
			System.out.println(key + " : 헤이 신난다!");
			instrument.playing();
		}
	}

}
