package wiring.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class Singer implements Performer {
	@Value("조용필")
	private String name;
	@Autowired( required=false )
	@Qualifier("bounce")
	private Song song;
	
	public String getName() {
		return name;
	}
	@Override
	public void perform() throws PerformanceException {
		System.out.print("Singer : " + name + "이 부릅니다, ");
		song.singing();
		System.out.println();
	}


}
