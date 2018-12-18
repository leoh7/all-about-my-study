package handler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.Dao;
import member.LogonDataBean;

@Controller
public class ModifyViewHandler implements CommandHandler {

	@Resource
	private Dao dao;
	
	@RequestMapping("modifyView")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		String id = (String)request.getSession().getAttribute("memid");
		String passwd = request.getParameter("passwd");

		int result = dao.check(id, passwd);
		
		request.setAttribute("result", result);
		
		if(result == 1) {
			LogonDataBean memberDto = dao.getMember(id);
			request.setAttribute("memberDto", memberDto);
		}
		
		return new ModelAndView("member/modifyView");
	}
}
