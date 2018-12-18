package test.di;

import java.util.ArrayList;

public class Band implements Performer {
	private String name;
	private String song;
	private ArrayList<Partition> parts;
	
	@Override
	public void perform() throws PerformanceException {
		// TODO Performer - Band
		System.out.println( "밴드 " + name + " 이/가 부릅니다 \n" + ".." + song + "!" );
		for(int i=0; i<parts.size(); i++){
			parts.get(i).live();	
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public ArrayList<Partition> getParts() {
		return parts;
	}

	public void setParts(ArrayList<Partition> parts, Partition...partitions) {
		this.parts = parts;
		for(int i=0; i<partitions.length; i++){
			parts.add(partitions[i]);
		}
	}

}
