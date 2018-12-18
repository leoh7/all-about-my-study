package mvc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet{
	// 원래 서블릿은 우리가 객체를 만들질 않아. request가 들어오면 그 때 생성된다.
	// 그래서 생성자를 맘대로 조절하기가 힘듦.
	// 그래서 쓰는게 init 메서드(서블릿config가 있는) / 얘가 제일 먼저 실행된다 
	private HashMap<String, CommandHandler> handlerMap = new HashMap<String, CommandHandler>();
	@Override
	public void init(ServletConfig config) throws ServletException {	// 최종적으로 HashMap에 CommandHandler 자리를 채워주는 역할을 하게 될 것임
		// 매핑을 걸면서 (매핑이 먼저) .xml 의 configFile 에다가 설정을 해주면 된다.
		String configFile = config.getInitParameter("configFile");	// web.xml 에 있는 값을 읽어올 수 있다.
//		String path = application.get	// 이런 방식으로 realpath 를 얻지 못함
		String path = config.getServletContext().getRealPath("/");
		String fileName = path + configFile;	// 실제 서버에 올라가 있는 핸들러.properties를 읽기 위한 경로를 만듦
		FileInputStream fis = null;
		Properties prop = new Properties();
		try {
			fis = new FileInputStream(fileName);
			prop.load(fis);
			Iterator<Object> keys = prop.keySet().iterator();
			while(keys.hasNext()) {
				String command = (String)keys.next();
				String handlerName = prop.getProperty(command);
				
				// prop 이 command 와 handlerName 을 가지고 있긴 하지만
				// 이를 command 와 handler객체 를 가지고 있으면 쓰기가 편하기에 가공을 해줄 것임
				Class<?> handlerClass = Class.forName(handlerName);
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();
				handlerMap.put(command, handlerInstance);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
//		String command = request.getParameter("command");
		String command = request.getRequestURI();
		if(command.indexOf(request.getContextPath()) == 0) {	// 방어용 / 인터넷 주소 처음부터 시작하느냐
			command = command.substring(request.getContextPath().length());	// command에 글자의 길이 만큼 미리 줘버림
		}
		
		CommandHandler handler = handlerMap.get(command);
		if(handler == null) {
			handler = new DefaultHandler();
		}
		String viewPage = null;
		
		try {
			viewPage = handler.process(request, response);
		} catch (HandlerException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
}
