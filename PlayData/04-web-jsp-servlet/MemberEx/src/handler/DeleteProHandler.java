package handler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.Dao;

@Controller
public class DeleteProHandler implements CommandHandler {

	@Resource
	private Dao dao;
	
	@RequestMapping("deletePro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {

		String id = (String) request.getSession().getAttribute("memid");
		String passwd = request.getParameter("passwd");

		int resultCheck = dao.check(id, passwd);
		
		request.setAttribute("resultCheck", resultCheck);
		
		if(resultCheck == 1) {
			int result = dao.deleteMember(id);
			request.setAttribute("result", result);
		}
	
		return new ModelAndView("member/deletePro");
	}

}
