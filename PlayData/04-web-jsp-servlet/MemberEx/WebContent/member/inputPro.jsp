<%@page import="member.LogonDBBean"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="member.LogonDataBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp" %>
<script src="${project}script.js"></script>

<h2>${page_input}</h2>
<%
	// EL 태그로 변환
	/* int result = (Integer)request.getAttribute("result"); */
%>

<c:if test="${result eq 0}">
	<script type="text/javascript">
		<!--
		erroralert(inputerror);
		//-->
	</script>
</c:if>

<c:if test="${result eq 1}">
	<c:redirect url="loginForm.do"/>
</c:if>