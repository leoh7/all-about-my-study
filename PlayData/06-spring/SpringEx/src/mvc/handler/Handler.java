package mvc.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface Handler {
	public ModelAndView helloProcess(HttpServletRequest request, HttpServletResponse response) 
			throws HandlerException;
	public ModelAndView byeProcess(HttpServletRequest request, HttpServletResponse response) 
			throws HandlerException;
	public ModelAndView dateProcess(HttpServletRequest request, HttpServletResponse response) 
			throws HandlerException;
	public ModelAndView defaultProcess(HttpServletRequest request, HttpServletResponse response) 
			throws HandlerException;
	public ModelAndView hiProcess(HttpServletRequest request, HttpServletResponse response) 
			throws HandlerException;
}
