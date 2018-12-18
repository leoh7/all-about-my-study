package handler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.Dao;

@Controller
public class ConfirmIdHandler implements CommandHandler {

	@Resource
	private Dao dao;
	
	@RequestMapping("confirmId")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		String id = request.getParameter("id");
		int result = dao.check(id);
		
		request.setAttribute("result", result);
		request.setAttribute("id", id);
		
		return new ModelAndView("member/confirmId");
	}

}
