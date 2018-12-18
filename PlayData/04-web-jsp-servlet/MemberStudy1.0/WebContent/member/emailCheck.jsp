<%@page import="memberStudy.EmailConfirm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="setting.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=project%>style_member.css">
<script src="<%=project%>script.js"></script>

<h2><%=page_emailconfirm%></h2>

<%
	String email = null;
	String email1 = request.getParameter("email1");
	String email2 = request.getParameter("email2");
	if(!email1.equals("")) {
		if(email2.equals("0")) {
			// 직접입력의 경우
			email = email1;
		} else {
			// 선택입력의 경우
			email = email1 + "@" + email2;
		}
	}
	EmailConfirm emailconfirm = new EmailConfirm();
	String authNum = emailconfirm.connectEmail(email);
%>
<form method="post" action="" name="emailcheck">
	<table>
		<tr>
			<th colspan="2"><%=str_msg_emailconfirm%></th>
		</tr>
		
		<tr>
			<td>
				<input type="text" name="emailconfirm">
			</td>
			<td>
				<input type="button" value="<%=btn_ok%>"
					onclick="confirmemail(emailcheck.emailconfirm.value,<%=authNum%>)">
			</td>
		</tr>
	</table>
</form>