<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>
<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
%>

이름 : <%=name%> <br>
나이 : <%=age%> <br>
<%=name%>(<%=age%>세) 님 반갑습니다! 
