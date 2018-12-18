package handler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.BoardDataBean;
import board.Dao;

@Controller
public class ContentHandler implements CommandHandler {

	@Resource
	private Dao dao;
	
	@RequestMapping("content")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		int num = Integer.parseInt(request.getParameter("num"));

		String pageNum = request.getParameter("pageNum");
		String list_num = request.getParameter("list_num");
		
		// 글을 읽는다는건 readcount 는 DB처리 / 여기서 늘리면 들어가자 마자 늘어남
		BoardDataBean boardDto = dao.getArticle( num );
		// 글을 읽는다는건 readcount 는 DB처리 / 여기서 늘리면 들어가자 마자는 안늘어나, 나오면 늘어남
		if(!request.getRemoteAddr().equals(boardDto.getIp())){
			dao.addCount(num);
			
		}
		
		request.setAttribute("list_num", list_num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("boardDto", boardDto);
		return new ModelAndView("board/content");
	}

}
