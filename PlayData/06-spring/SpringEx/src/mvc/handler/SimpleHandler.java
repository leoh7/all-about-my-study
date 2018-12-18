package mvc.handler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleHandler implements Handler{
	@RequestMapping("hello")
	@Override
	public ModelAndView helloProcess(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		String result = "안녕하세요";
		String name = "홍길동";
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", result);
		map.put("name", name);
		
		return new ModelAndView("hello/hello", map);
	}
	@RequestMapping("bye")
	@Override
	public ModelAndView byeProcess(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		String result = "안녕히가세요";
		request.setAttribute("result", result);
		return new ModelAndView("bye/bye");
	}
	@RequestMapping("date")
	@Override
	public ModelAndView dateProcess(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		String pattern = "yyyy / MM / dd a hh : mm";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		return new ModelAndView("date/date", "result", sdf.format( new Date() ) );
	}
	@RequestMapping("hi")
	@Override
	public ModelAndView hiProcess(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		String result = " Hi ! ";
		request.setAttribute("result", result);
		return new ModelAndView("hi/hi");
	}
	
	@RequestMapping("*")	// 메서드에 mapping을 걸면 ModelAndView로 리턴하기로 약속되어 있다
	@Override
	public ModelAndView defaultProcess(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		String result = "처리할 수 없는 요청입니다";
		
		return new ModelAndView("mvc/default", "result", result);
	}
	
}
