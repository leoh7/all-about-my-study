<%@page import="memberStudy.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp" %>
<script src="<%=project%>script.js"></script>

<h2><%=page_login%></h2>

<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
%>

<%
	LogonDBBean memberDao = LogonDBBean.getInstance();
	int result = memberDao.check(id, passwd);
%>

<%
	if(result == 0) {
		// 아이디 없다
		%>
			<script type="text/javascript">
			<!--
			erroralert(loginiderror);
			//-->
			</script>
		<%
	} else if(result == -1) {
		// 비밀번호가 다르다
		%>
			<script type="text/javascript">
			<!--
			erroralert(loginpasswderror);
			//-->
			</script>
		<%
	} else {
		// 아이디 있다/비밀번호 같다
		// 로그인
		// memid 라는 있냐 없냐 만 가지고 로그인 여부를 확인을 할 수 있고
		// 옆에 진짜 아이디는 세션에 저장을 해놓고 계속 쓸 수 있는 id 변수를 넣어놓은 것.
		session.setAttribute("memid", id);
		response.sendRedirect("main.jsp");
		
	}
%>