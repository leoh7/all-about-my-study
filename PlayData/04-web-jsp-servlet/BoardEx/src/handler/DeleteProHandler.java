package handler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.Dao;

@Controller
public class DeleteProHandler implements CommandHandler {

	@Resource
	private Dao dao;
	
	@RequestMapping("deletePro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		int num = Integer.parseInt(request.getParameter("num"));
		String passwd = request.getParameter("passwd");
		String pageNum = request.getParameter("pageNum");
		int resultCheck = dao.check(num, passwd);	// 비밀번호가 맞는지 확인
		
		request.setAttribute("resultCheck", resultCheck);
		request.setAttribute("pageNum", pageNum);
		
		if(resultCheck != 0) {
			int result = dao.deleteArticle(num);
			request.setAttribute("result", result);
		}
		return new ModelAndView("board/deletePro");
	}

}
