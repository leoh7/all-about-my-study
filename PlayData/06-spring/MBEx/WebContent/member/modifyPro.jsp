<%@page import="member.LogonDBBean"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="member.LogonDataBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp" %>
<script src="${project}script.js"></script>

<h2>${page_modify}</h2>


<%
	/* int result = (Integer)request.getAttribute("result"); */
%>
<c:if test="${result eq -1}">
		<script type="text/javascript">
			<!--
			erroralert(modifyerror);
			//-->
		</script>
		<meta http-equiv="refresh" content="0;url=memberMain.do">
		
</c:if>

<c:if test="${result eq 1}">
		<script type="text/javascript">
			<!--
			alert(modify_ok);
			//-->
		</script>
		<meta http-equiv="refresh" content="0;url=memberMain.do">
</c:if>
		
