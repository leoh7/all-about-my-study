package aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration	// 환경설정
public class CreateBean {
	// 메서드 형식으로 Bean(객체)를 만든다
	// 우리가 알던 메서드는 아님
	
	
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
	public Performer singer(){
		Singer singer = new Singer("박효신", hello(), piano());
//		singer.setName("박효신");
//		singer.setSong( bounce() );
//		singer.setInstrument( piano() );
		return singer;
	}
}
