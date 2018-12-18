package wiring.auto;

public class Singer implements Performer {

	private String name;
	private Song song;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSong(Song song) {
		this.song = song;
	}

	@Override
	public void perform() throws PerformanceException {
		System.out.print("Singer : " + name + "이 부릅니다, ");
		song.singing();
		System.out.println();
	}


}
