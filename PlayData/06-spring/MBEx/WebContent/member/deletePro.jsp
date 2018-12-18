<%@page import="member.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp" %>
<script src="${project}script.js"></script>

<h2>${page_delete}</h2>

<%
	/* int resultCheck = (Integer)request.getAttribute("resultCheck"); */
%>
<<c:if test="${resultCheck eq 1}">
	<c:if test="${result eq 0}">
		<script type="text/javascript">
		<!--
			alert(deleteerror);
		//-->
		</script>
		<meta http-equiv="refresh" content="0;url=memberMain.do">
	</c:if>
	<c:if test="${result eq 1}">
		<script type="text/javascript">
		<!--
			alert(delete_ok);
		//-->
		</script>
		<meta http-equiv="refresh" content="0;url=memberMain.do">
			<%
			/* // TODO : EL 태그로 뺼 예정
			session.removeAttribute("memid");*/
			%>
		${sessionScope.memid = null}	// 메인의 조건과 맞춰준 것이다. 	
	</c:if>
</c:if>

<c:if test="${resultCheck eq -1}">
		<script type="text/javascript">
		<!--
			erroralert(loginpasswderror);
		//-->
		</script>
</c:if>