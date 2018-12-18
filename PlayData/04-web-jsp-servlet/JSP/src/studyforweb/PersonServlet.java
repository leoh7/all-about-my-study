package studyforweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class PersonServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 앞으로 뭘 받을 땐 항상 getParameter
		String name 							// 1바이트로 쪼개서,		utf-8 로 재조립했다
			= new String(req.getParameter("name").getBytes("8859_1"), "utf-8" );
		
		int age = Integer.parseInt( req.getParameter("age") );
		String gender = req.getParameter("gender");
		
		// 여러개가 넘어오는 것 받기(취미)	// 여러개가 넘어오기 때문에 getParameterValues() 로 받았다.
		String hobby[] = req.getParameterValues("hobby");
		
		
		//응답에 대한 설정
		resp.setContentType( "text/html; charset=utf-8" );
		PrintWriter out = resp.getWriter();
		
		// html 을 보낼 껀데, 사실 안보내도 됭
		out.println("<title> Servlet 데이터 처리</title>");
		out.println("<h2> Servlet 폼 데이터 처리</h2><br>");
		out.println("당신의 이름은 "+ name + " 이고<br>");		// 이름이 깨지는건 넘기는 한글이 깨지는 것. 넘어오는 한글은 resp.setContentType 에서 잡아줬다.
		out.println("나이는 " + age + " 살 이고<br>");
		
		if(gender.equals("1")) {
			out.println("성별은 남자 입니다.<br>");
		} else {
			out.println("성별은 여자 입니다.<br>");
		}
		
		// 취미는 o, o 입니다.
		String tmp = new String("");
		
		for(int i=0 ; i < hobby.length; i++) {
			
			if(i+1 != hobby.length) {
				if(hobby[i].equals("1")) {
					tmp = tmp + "축구" + ", ";
				}else if(hobby[i].equals("2")) {
					tmp = tmp + "야구" + ", ";
				}else if(hobby[i].equals("3")) {
					tmp = tmp + "농구" + ", ";
				}else if(hobby[i].equals("4")) {
					tmp = tmp + "배구" + ", ";
				}
			} else {
				if(hobby[i].equals("1")) {
					tmp = tmp + "축구";
				}else if(hobby[i].equals("2")) {
					tmp = tmp + "야구";
				}else if(hobby[i].equals("3")) {
					tmp = tmp + "농구";
				}else if(hobby[i].equals("4")) {
					tmp = tmp + "배구";
				}
			}
		}
		
		out.println("취미는 "+tmp+"입니다");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet( req, resp );
	}
}
