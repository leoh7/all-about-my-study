package mvc.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultHandler implements CommandHandler {
//	@RequestMapping("*")	// 메서드에 mapping을 걸면 ModelAndView로 리턴하기로 약속되어 있다
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		String result = "처리할 수 없는 요청입니다";
		
		return new ModelAndView("mvc/default", "result", result);
	}
	
	
	
	
}
