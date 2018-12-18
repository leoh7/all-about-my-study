package bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import board.BoardDBBean;
import board.BoardDao;
import member.LogonDBBean;
import member.MemberDao;

@Configuration
public class CreateBean {
	@Bean
	public BoardDao boardDao(){
		return new BoardDBBean();
	}
	
	@Bean
	public MemberDao memberDao(){
		return new LogonDBBean();
	}
	@Bean
	public ViewResolver viewResolver(){
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass( JstlView.class );
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
}
