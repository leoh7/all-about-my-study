package mvc;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		Date date = new Date();
		request.setAttribute("result", date);
		return "/mvc/date.jsp";
	}

}
