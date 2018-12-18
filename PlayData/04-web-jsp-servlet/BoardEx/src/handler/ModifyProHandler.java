package handler;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.BoardDataBean;
import board.Dao;

@Controller
public class ModifyProHandler implements CommandHandler {

	@Resource
	private Dao dao;
	
	@RequestMapping("modifyPro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {

	try {
		request.setCharacterEncoding("utf-8");
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}

//	<jsp:useBean id="boardDto" class="board.BoardDataBean"/>
//	<jsp:setProperty property="*" name="boardDto"/>
//	<!-- 받는 것 num subject content passwd email -->
	BoardDataBean boardDto = new BoardDataBean();
	boardDto.setNum(Integer.parseInt(request.getParameter("num")));
	boardDto.setSubject(request.getParameter("subject"));
	boardDto.setContent(request.getParameter("content"));
	boardDto.setPasswd(request.getParameter("passwd"));
	boardDto.setEmail(request.getParameter("email"));
	
	String pageNum = request.getParameter("pageNum");

	int result = dao.modifyArticle(boardDto);

	request.setAttribute("pageNum", pageNum);
	request.setAttribute("result", result);
	
		return new ModelAndView("board/modifyPro");
	}

}
