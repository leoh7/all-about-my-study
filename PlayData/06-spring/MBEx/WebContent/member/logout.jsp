<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	// FIXME : logout.jsp 핸들러로 인해 필요없어진 페이지
	session.removeAttribute("memid");
	response.sendRedirect("main.jsp");
%>