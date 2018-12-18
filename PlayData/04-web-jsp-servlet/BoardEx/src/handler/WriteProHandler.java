package handler;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.BoardDataBean;
import board.Dao;

@Controller
public class WriteProHandler implements CommandHandler {

	@Resource
	private Dao dao;
	
	@RequestMapping("writePro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {

	try {
		request.setCharacterEncoding("utf-8");
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}

//	<jsp:useBean id="boardDto" class="board.BoardDataBean"/>
//	<jsp:setProperty property="*" name="boardDto"/>
//<!-- 	writer email subject content passwd-->
//<!-- 	num ref re_step re_level -->
	
	BoardDataBean boardDto = new BoardDataBean();
	boardDto.setWriter(request.getParameter("writer"));
	boardDto.setEmail(request.getParameter("email"));
	boardDto.setSubject(request.getParameter("subject"));
	boardDto.setContent(request.getParameter("content"));
	boardDto.setPasswd(request.getParameter("passwd"));
	boardDto.setNum(Integer.parseInt(request.getParameter("num")));
	boardDto.setRef(Integer.parseInt(request.getParameter("ref")));
	boardDto.setRe_step(Integer.parseInt(request.getParameter("re_step")));
	boardDto.setRe_level(Integer.parseInt(request.getParameter("re_level")));
	
	boardDto.setReg_date(new Timestamp(System.currentTimeMillis()));
	boardDto.setIp(request.getRemoteAddr());
	
	int result = dao.insertArticle(boardDto);
	
	request.setAttribute("result", result);
	
		return new ModelAndView("board/writePro");
	}
}
