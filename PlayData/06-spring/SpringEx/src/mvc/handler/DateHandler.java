package mvc.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DateHandler implements CommandHandler {

//	@RequestMapping("date")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		String pattern = "yyyy / MM / dd a hh : mm";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		return new ModelAndView("date/date", "result", sdf.format( new Date() ) );
	}

}
