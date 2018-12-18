package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		String result = "안녕";
		request.setAttribute("result", result);
		return "mvc/hi.jsp";
	}
}
