package wiring.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Singer implements Performer {
	private String name;
	private Song song;
	private Instrument instrument;
	private List<Song> songs = new ArrayList<Song>();
	private Map<String, Instrument> instruments = new HashMap<String, Instrument>();
	
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	public Singer(String name, Song song) throws PerformanceException {
		this.name = name;
		this.song = song;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	public void setInstruments(Map<String, Instrument> instruments) {
		this.instruments = instruments;
	}

	@Override
	public void perform() throws PerformanceException {
		System.out.print("Singer : " + name + "이 부릅니다, ");
		song.singing();
		instrument.playing();
		System.out.println();
		
		System.out.println("밴드 1 go :");
		for(Song s : songs){
			song.singing();
		}
		
		System.out.println();
		Iterator<String> keys = instruments.keySet().iterator();
		while(keys.hasNext()){
			String key = keys.next();
			instrument = instruments.get(key);
			System.out.println(key + ":" );
			instrument.playing();
		}
	}

}
