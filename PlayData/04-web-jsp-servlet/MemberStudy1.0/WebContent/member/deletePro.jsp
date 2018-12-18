<%@page import="memberStudy.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp" %>
<script src="<%=project%>script.js"></script>

<h2><%=page_delete%></h2>

<%
	String id = (String)session.getAttribute("memid");
	String passwd = request.getParameter("passwd");
%>

<%
	LogonDBBean memberDao = LogonDBBean.getInstance();
	int result = memberDao.check(id, passwd);
%>

<%
	if(result == 1) {
		// 비밀번호가 같다
		result = memberDao.deleteMember(id);
		if(result == 0 ) {
			// 탈퇴 실패 - 메세지 // DB쪽에 문제가 있는 것.
			%>
				<script type="text/javascript">
				<!--
					alert(deleteerror);
				//-->
				</script>
				<meta http-equiv="refresh" content="0;url=main.jsp">
			<%
		} else {
			// 탈퇴 성공 -> main 이동
			%>
				<script type="text/javascript">
				<!--
					alert(delete_ok);
				//-->
				</script>
				<meta http-equiv="refresh" content="0;url=main.jsp">
			<%
			session.removeAttribute("memid");
			// 탈퇴 확인 메세지를 띄우주기 위해서 sendRedirect를 빼주었다.
			//response.sendRedirect("main.jsp");
		}
	} else {
		// 비밀번호가 다르다
			// 경고창
		%>
		<script type="text/javascript">
		<!--
			erroralert(loginpasswderror);
		//-->
		</script>
		<%
	}
%>