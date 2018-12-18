package handler.member;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.CommandHandler;
import handler.HandlerException;
import member.MemberDao;

@Controller
public class MemberDeleteProHandler implements CommandHandler {

	@Resource
	private MemberDao memberDao;
	
	@RequestMapping("memberDeletePro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) 
			throws HandlerException {

		String id = (String) request.getSession().getAttribute("memid");
		String passwd = request.getParameter("passwd");

		int resultCheck = memberDao.check(id, passwd);
		
		request.setAttribute("resultCheck", resultCheck);
		
		if(resultCheck == 1) {
			int result = memberDao.deleteMember(id);
			request.setAttribute("result", result);
		}
	
		return new ModelAndView("member/deletePro");
	}

}
