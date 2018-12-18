package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutHandler implements CommandHandler {
	
	@RequestMapping("logout")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		// session 은 jsp 객체니까 sessing 객체 가져오기
		// session.removeAttribute("memid");
		request.getSession().removeAttribute("memid");
		// response.sendRedirect("main.jsp");	// viewPage 를 main으로 돌리면 된다
		return new ModelAndView("member/main");
	}

}
