package mvc.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloHandler implements CommandHandler {

//	@RequestMapping("hello")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		String result = "안녕하세요";
		String name = "홍길동";
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", result);
		map.put("name", name);
		
		return new ModelAndView("hello/hello", map);
	}

}
