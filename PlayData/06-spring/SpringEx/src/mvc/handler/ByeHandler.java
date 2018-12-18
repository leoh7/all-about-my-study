package mvc.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ByeHandler implements CommandHandler {

//	@RequestMapping("bye")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		String result = "안녕히가세요";
		request.setAttribute("result", result);
		return new ModelAndView("bye/bye");
	}

}
