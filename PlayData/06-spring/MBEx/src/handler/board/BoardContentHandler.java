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
public class BoardContentHandler implements CommandHandler {

	@Resource
	private BoardDao boardDao;
	
	@RequestMapping("boardContent")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) 
			throws HandlerException {
		int num = Integer.parseInt(request.getParameter("num"));

		String pageNum = request.getParameter("pageNum");
		String list_num = request.getParameter("list_num");
		
		// 글을 읽는다는건 readcount 는 DB처리 / 여기서 늘리면 들어가자 마자 늘어남
		BoardDataBean boardDto = boardDao.getArticle( num );
		// 글을 읽는다는건 readcount 는 DB처리 / 여기서 늘리면 들어가자 마자는 안늘어나, 나오면 늘어남
		if(!request.getRemoteAddr().equals(boardDto.getIp())){
			boardDao.addCount(num);
			
		}
		
		request.setAttribute("list_num", list_num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("boardDto", boardDto);
		return new ModelAndView("board/content");
	}

}
