package aop;


public class Singer implements Performer {
	private String name;
	private Song song;
	private Instrument instrument;

	public Singer(){}
	public Singer(String name, Song song, Instrument instrument){
		this.name = name;
		this.song = song;
		this.instrument = instrument;
	}
	
	
	@Override
	public void perform() throws PerformanceException {
		// TODO Perform - Singer
		System.out.println();
		System.out.println(name + " 이 부릅니다.");
		song.singing();
		instrument.playing();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
