package test.di;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateBean {

	@Bean
	public Performer band(){
		Band band = new Band();
		ArrayList<Partition> session = new ArrayList<>();
		band.setName("조용한 밴드");
		band.setSong("박효신 - 그 날");
		band.setParts(session, vocal(), vocal(), keyboard(), guitar(), base());
		return band;
	}

	@Bean
	public Partition vocal(){
		Vocal vocal = new Vocal();
		vocal.setName("박효신");
		vocal.setRole("보컬");
		return vocal;
	}
	@Bean
	public Partition keyboard(){
		Keyboard keyboard = new Keyboard();
		keyboard.setName("이순신");
		keyboard.setRole("키보드");
		return keyboard;
	}
	@Bean
	public Partition guitar(){
		Guitar guitar = new Guitar();
		guitar.setName("김희성");
		guitar.setRole("기타");
		return guitar;
	}
	@Bean
	public Partition base(){
		Base base = new Base();
		base.setName("김유신");
		base.setRole("베이스");
		return base;
	}
}
