package handler.board;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.BoardDataBean;
import handler.CommandHandler;
import handler.HandlerException;
import board.BoardDao;

@Controller
public class BoardModifyViewHandler implements CommandHandler {

	@Resource
	private BoardDao boardDao;
	
	@RequestMapping("boardModifyView")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) 
			throws HandlerException {
		int num = Integer.parseInt(request.getParameter("num"));
		String passwd = request.getParameter("passwd");
		String pageNum = request.getParameter("pageNum");
		
		int result = boardDao.check(num, passwd);
		
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("result", result);
		
		if(result != 0) {
			BoardDataBean boardDto = boardDao.getArticle(num);
			request.setAttribute("boardDto", boardDto);
		}
		
		return new ModelAndView("board/modifyView");
	}

}
