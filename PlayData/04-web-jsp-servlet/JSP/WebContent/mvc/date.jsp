<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<h2> MVC - View Page - date 처리</h2>

<%
	Date result = (Date)request.getAttribute("result");
%>

결과 : <%=result%> <br>