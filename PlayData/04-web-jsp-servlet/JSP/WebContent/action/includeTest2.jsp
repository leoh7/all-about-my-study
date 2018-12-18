<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<h2> 액션태그 - include - 처리/출력 페이지2 </h2>
	

	
<%--
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
--%>

<%
	String name = request.getParameter("paramName");
	int age = Integer.parseInt(request.getParameter("paramAge"));
%>

이름 : <%=name %><br>
나이 : <%=age%> <br>