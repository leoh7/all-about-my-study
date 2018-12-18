<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp" %>
<link rel="stylesheet" type="text/css" href="${project}style_member.css">
<script src="${project}script.js"></script>

<h2> ${page_login}</h2>
<%
	// TODO : (수정완)loginForm.jsp action에서 파일로 보내던 것을  *.do 형태로(URL) 바꿔줘야 함 
%>
<body onload="loginfocus()">
	<form method="post" action="memberLoginPro.do" name="loginform"
		onsubmit="return logincheck()">
		<table>
			<tr>
				<th colspan="2">
					${msg_login}
				</th>
			</tr>
			
			<tr>
				<th>${str_id}</th>
				<td><input class="input" type="text" name="id" maxlength="15"></td>
			</tr>
			
			<tr>
				<th>${str_passwd}</th>
				<td><input class="input" type="password" name="passwd" maxlength="15"></td>
			</tr>
			
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="${btn_login}">
					<input class="inputbutton" type="reset" value="${btn_cancel}">
				</th>
			</tr>
		</table>
	</form>
</body>
