import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// import Exception
import java.io.IOException;
import javax.servlet.ServletException;

public class HelloServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType( "text/html; charset=utf-8" );	// ���⸦ �߸� ���� �ٿ�ε尡 ���, �⺻������ �𸣴� �� ����ϸ� �ٿ�ε� ��.

		// getWriter() �� ServletResponse Ŭ������ ������ �ִ� �޼���, return java.io.PrintWriter �׷��� �̰� �����ϴ� ���� out�� �־���.
		java.io.PrintWriter out = resp.getWriter();		// out �� stream �� �Ǵ� ��
	
		out.println("<html>");
		out.println(	"<head>");
		out.println(		"<meta charset='utf-8'>");
		out.println(		"<title> Servlet </title>");
		out.println(	"</head>");
		out.println(	"<body>");
		out.println(		"Hello Servlet!!!<br>");
		out.println(		"�ȳ��ϼ���<br>");
		out.println(	"</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet( req, resp );
	}
}


/*
	doGet(HttpServletRequest req, HttpServletResponse resp)
	HttpServletRequest �� HttpServletResponse ���� Ŭ�����̱� ������ import ���־���.
	
	�������� Ŭ���̾�Ʈ�� ������ �͵� IO 
	��θ� ���� � ���� ���������� Ȯ���ϰ�, ������ �Ǵ� ��.
	
	�������� ����� request, response
	Ŭ���̾�Ʈ -> ���� request
	Ŭ���̾�Ʈ <- ���� response
*/