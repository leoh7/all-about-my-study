package wiring.scan;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("actor")	// actor
public class Actor implements Performer {
	@Value("조용필")
	private String name;
	
	@Value("#{31}")
	private int age;
	
	@Autowired(required=false)
	@Qualifier("student")
	private Role role;
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println("배우 : " + name + " 은/는 " + age + " 살 입니다.");
		role.play();
	}

}
