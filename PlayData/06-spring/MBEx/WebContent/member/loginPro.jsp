<%@page import="member.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp" %>
<script src="${project}script.js"></script>

<h2>${page_login}</h2>
<%
	//TODO : (수정완)loginPro.jsp action에서 파일로 보내던 것을  *.do 형태로(URL) 바꿔줘야 함 
/* 	int result = (Integer)request.getAttribute("result");
	String id = (String)request.getAttribute("id"); */
%>

<c:if test="${result eq 0}">
<!-- if(result == 0) { -->
	<script type="text/javascript">
	<!--
	erroralert(loginiderror);
	//-->
	</script>
</c:if>

<c:if test="${result eq -1}">
<!-- } else if(result == -1) { -->
	<script type="text/javascript">
	<!--
	erroralert(loginpasswderror);
	//-->
	</script>
</c:if>

<%-- <c:if test="${result ne 0 && result ne -1}"> --%>
<c:if test="${result eq 1}">
<!-- } else { -->
	<!-- session.setAttribute("memid", id);
		response.sendRedirect("main.do"); -->
	<%-- <c:set var="${sessionScope.memid}" value="${id}"/> 이게 안되네....? --%>
	
	${sessionScope.memid = id} <!-- requestScope.id 가 생략되어있다 -->
	<c:redirect url="memberMain.do"/>
</c:if>
