package wiring.anno;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;

public class TwoManBand implements Performer {
	@Value("#{singer.name}, 이순신")
	private String[] names;
	
	@Resource(name="ins")
	private List<Instrument> instruments;
	
	@Resource(name="ss")
	private Map<String, Song> songs;
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println("TwoManBand : ");
		for(String n : names){
			System.out.println("name : " + n);
		}
		
		for(int i=0; i<instruments.size(); i++){
			instruments.get(i).playing();;
		}
		Iterator<String> keys = songs.keySet().iterator();
		while(keys.hasNext()){
			String key = keys.next();
			Song song = songs.get(key);
			System.out.println("제목 : "+ key);
			song.singing();
		}
	}

}
