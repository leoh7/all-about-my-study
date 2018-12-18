<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<h2> MVC - View Page - null 처리</h2>

<%
	String result = (String)request.getAttribute("result");
%>

결과 : <%=result%> <br>