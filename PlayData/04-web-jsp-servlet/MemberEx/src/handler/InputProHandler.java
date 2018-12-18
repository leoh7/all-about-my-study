package handler;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.Dao;
import member.LogonDataBean;

@Controller
public class InputProHandler implements CommandHandler {
	
	@Resource
	private Dao dao;
	
	@RequestMapping("inputPro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// useBean 액션태그를 못쓴다.
//		<jsp:useBean id="memberDto" class="member.LogonDataBean"/>
//		<jsp:setProperty name="memberDto" property="*"/>
		LogonDataBean memberDto = new LogonDataBean();	// 직접 만들어주기
		memberDto.setId(request.getParameter("id"));
		memberDto.setPasswd(request.getParameter("passwd"));
		memberDto.setName(request.getParameter("name"));
		memberDto.setJumin1(request.getParameter("jumin1"));
		memberDto.setJumin2(request.getParameter("jumin2"));
		
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
		if(!email1.equals("")) {
			if(email2.equals("0")) {
				// 직접입력의 경우
				email = email1;
			} else {
				// 선택입력의 경우
				email = email1 + "@" + email2;
			}
		}
		memberDto.setEmail(email);

		// reg_date
		memberDto.setReg_date(new Timestamp( System.currentTimeMillis() ) );

		// 0 아니면 1이 넘어옴
		int result = dao.insertMember(memberDto);
		
		request.setAttribute("result", result);
		
		return new ModelAndView("member/inputPro");
	}

}
