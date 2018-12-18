package wiring.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration	// 환경설정
public class CreateBean {
	// 메서드 형식으로 Bean(객체)를 만든다
	// 우리가 알던 메서드는 아님
	
	//// Role
	@Bean
	public Role student(){	// 메서드명 중요 / 메서드의 이름이 객체의 이름이다
		return new Student();
	}
	@Bean
	public Role company(){
		return new Company();
	}
	@Bean
	public Role teacher(){
		return new Teacher();
	}
	
	
	//// Song
	@Bean
	public Song bounce(){
		return new Bounce();
	}
	@Bean
	public Song hello(){
		return new Hello();
	}
	
	//// Instrument
	public Instrument piano(){
		return new Piano();
	}
	public Instrument drum(){
		return new Drum();
	}
	public Instrument guitar(){
		return new Guitar();
	}
	
	@Bean
	public Performer actor(){
		Actor actor = new Actor();
		actor.setName("조용필");
		actor.setAge(31);
		actor.setRole( student() );
		
		return actor;
	}
	@Bean
	public Performer singer(){
		Singer singer = new Singer("박효신", hello(), piano());
//		singer.setName("박효신");
//		singer.setSong( bounce() );
//		singer.setInstrument( piano() );
		return singer;
	}
}
