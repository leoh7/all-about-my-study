package mvc;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleController extends HttpServlet{

	// 원래는 service를 호출한다는 것을 잊지 말자
	public void doProcess(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		// 여태까지는 글을 쓸려면 writeForm 등 으로 직접 호출을 보냈어
		// 이렇게 하면 내가 글을 읽을래, 글을 쓸래, 수정할래, 지울래(요청 : request 들을 커맨드라고 한다)
		// 요청을 처리하는 페이지로 직접 넘어갔다
		// 이런 요청들은 하나의 페이지가 받는게 맞아.
		// 내가 hello 라고 하고 싶으면 command=hello 를 하면 되는 것.
		// jsp 페이지가 요청을 받지 않을 거야.
		// simple 이라는 애한테 '어떤 요청을 한다' 라는 것을 보내는 것. // 그러나 이것도 뒤에 가면 사용자가 직접 하는게 아니게 할 거야
		// 이 simple 은 mapping 을 한 SimpleController 라는 Servlet

/* 		① 클라이언트의 요청을 받는다.
	    ② 클라이언트가 요구하는 작업을 분석한다.
	        String type = request.getParameter( "type" );
	    ③ 비즈니스 로직을 처리하는 모델(Model)(JavaBean)을 사용
	    ④ 처리결과를 request또는 session의 속성에 저장
	        request.setAttribute( "result", result );
	    ⑤ 적당한 뷰를 선택 후 해당 뷰(View)로 포워딩(forwarding)
	        서블릿에서 dispacher.forward(request,response)로 해당 JSP페이지와 request, response를 공유한 경우
	        해당 JSP페이지에서 request.getAttribute("result")와 같이 사용해서 결과를 화면에 표출한다.

		Controller 는 하나, 핸들러가 여러개 View도 여러개
*/
//		// 1. 요청을 받는다
//		String command = request.getParameter("command");
//		String viewPage = null;
//		// 2. 요청을 분석한다
//		if(command == null || command.equals("")) {
//			// 3. 요청을 처리한다.
//			String result = "처리할 요청이 없습니다";
//			// 4. 결과를 저장한다.
//			request.setAttribute("result", result); 	// 일단 중복이지만 넣어놓을 겁니다 / 나중에 뺄 거
//			viewPage = "/mvc/null.jsp";
//			
//		} else if(command.equals("hello")) {
//			// 요청을 처리한다.
//			String result = "안녕하세요";// 원래는 처리하는 곳까지 보냈다가 다시 받아야 하는데 단순하게 가자
//			// 결과를 저장한다.
//			request.setAttribute("result", result);
//			viewPage = "/mvc/hello.jsp";
//		} else if(command.equals("bye")) {
//			String result = "안녕히 계세요";
//			request.setAttribute("result", result);
//			viewPage = "/mvc/bye.jsp";
//		} else if(command.equals("date")) {
//			Date date = new Date();
//			request.setAttribute("result", date);
//			viewPage = "/mvc/date.jsp";
//		} else {
//			String result = "처리할 수 없는 요청입니다";
//			request.setAttribute("result", result);
//			viewPage = "/mvc/default.jsp";
//		}
//		
//		// 5. 적당한 View를 선택한다.
////		String viewPage = "/mvc/hello.jsp";
//			
//		// 6. View로 포워딩(실행)한다.
//			// http://localhost:8080/JSP/mvc/hello.jsp	요청/응답	// 여태까지의 방식
//			// 지금부턴 요청을 controller 가 받기 때문에 이 요청을 보내줄 필요가 있다
//			// request dispatcher
//		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
//		dispatcher.forward(request, response); 	// 포워딩을 했으니까 hello.jsp 가 실행이 될 것.
//		// cf) mapping 필요

	String command = request.getParameter("command");
	String viewPage = null;
	CommandHandler handler = null;
	
	if(command == null || command.equals("")) {
		// 요청처리, 데이터 저장, 적당한 뷰 선택 까지가 핸들러의 임무
		handler = new NullHandler();
	} else if(command.equals("hello")) {
		handler = new HelloHandler();
	} else if(command.equals("bye")) {
		handler = new ByeHandler();
	} else if(command.equals("date")) {
		handler = new DateHandler();
	} else {
		handler = new DefaultHandler();
	}
	
	try {
		viewPage = handler.process(request, response);
	} catch (HandlerException e) {
		e.printStackTrace();
	}
	
		// request dispatcher
	RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	dispatcher.forward(request, response); 	// 포워딩을 했으니까 hello.jsp 가 실행이 될 것.
	// cf) mapping 필요
} // doProcess()
	
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
}
