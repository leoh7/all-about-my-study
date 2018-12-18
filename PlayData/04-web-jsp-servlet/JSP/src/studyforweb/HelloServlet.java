package studyforweb;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// import Exception
import java.io.IOException;
import javax.servlet.ServletException;

public class HelloServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType( "text/html; charset=utf-8" );	// 여기를 잘못 쓰면 다운로드가 뜬다, 기본적으로 모르는 거 얘기하면 다운로드 뜸.

		// getWriter() 는 ServletResponse 클래스가 가지고 있는 메서드, return java.io.PrintWriter 그래서 이걸 참조하는 변수 out에 넣었다.
		java.io.PrintWriter out = resp.getWriter();		// out 이 stream 이 되는 것
	
		out.println("<html>");
		out.println(	"<head>");
		out.println(		"<meta charset='utf-8'>");
		out.println(		"<title> Servlet </title>");
		out.println(	"</head>");
		out.println(	"<body>");
		out.println(		"Hello Servlet!!!<br>");
		out.println(		"안녕하세요<br>");
		out.println(	"</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet( req, resp );
	}
}


/*
	doGet(HttpServletRequest req, HttpServletResponse resp)
	HttpServletRequest 와 HttpServletResponse 역시 클래스이기 때문에 import 해주었다.
	
	서버에서 클라이언트로 보내는 것도 IO 
	통로를 통해 어떤 것을 보낼것인지 확보하고, 보내면 되는 것.
	
	데이터의 방향과 request, response
	클라이언트 -> 서버 request
	클라이언트 <- 서버 response
*/