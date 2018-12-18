package handler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.Dao;

@Controller
public class LoginProHandler implements CommandHandler {

	@Resource
	private Dao dao;
	
	@RequestMapping("loginPro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");

		int result = dao.check(id, passwd);
		
		request.setAttribute("result", result);
		request.setAttribute("id", id);
		
		return new ModelAndView("member/loginPro");
	}

}
