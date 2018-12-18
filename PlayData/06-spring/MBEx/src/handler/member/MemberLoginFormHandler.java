package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.CommandHandler;
import handler.HandlerException;

@Controller
public class MemberLoginFormHandler implements CommandHandler {
	
	@RequestMapping("memberLoginForm")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) 
			throws HandlerException {
		return new ModelAndView("member/loginForm");
	}

}
