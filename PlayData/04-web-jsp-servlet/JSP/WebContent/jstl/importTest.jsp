<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<h2> JSTL - core - import </h2>

<c:import url="top.jsp"/>

<hr color="red" size="3" align="left">
	현재 페이지는 포함하는 페이지 importTest.jsp 입니다 <br>
	<c:set var="name" value="${'홍길동'}"/>
	
	
<hr color="red" size="3" align="left">
	<c:import url="bottom.jsp">
		<c:param name="name" value="${name}"/>
	</c:import>
