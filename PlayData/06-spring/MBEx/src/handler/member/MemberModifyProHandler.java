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
import member.LogonDataBean;

@Controller
public class MemberModifyProHandler implements CommandHandler {
	@Resource
	private MemberDao memberDao;
	
	@RequestMapping("memberModifyPro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) 
			throws HandlerException {
//		<jsp:useBean id="memberDto" class="member.LogonDataBean"/>
//		<!-- 받는건 passwd 밖에 없지만 그래도 바구니로 던지는게 편하다 -->
//		<jsp:setProperty name="memberDto" property="*"/>
		LogonDataBean memberDto = new LogonDataBean();
		
		memberDto.setId((String)request.getSession().getAttribute("memid"));
		memberDto.setPasswd(request.getParameter("passwd"));
		
		
		
		// tel 가공 / 자바스크립트에서 유효성검사를 이미 했기 때문에 안해도 되지만 해주기로
		String tel = null;
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		if(!tel1.equals("") && !tel2.equals("") && !tel3.equals("")) {
			tel = tel1 + "-" + tel2 + "-" + tel3;
		}
		memberDto.setTel(tel);
		
		// email
		String email = null;
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		if(!email1.equals("") && !email2.equals("")) {
			email = email1 + "@" + email2;	
		}
		memberDto.setEmail(email);

	 	// DB 처리 Bean 의 객체 가져오기
		// 0 아니면 1이 넘어옴
		int result = memberDao.modifyMember(memberDto); 
		
		request.setAttribute("result", result);
		
		return new ModelAndView("member/modifyPro");
	}

}
