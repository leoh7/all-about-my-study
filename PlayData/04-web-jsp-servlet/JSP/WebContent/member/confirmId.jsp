<%@page import="member.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=project%>style_member.css">
<script src="<%=project%>script.js"></script>

<h2> <%=page_confirm%></h2>

<%
	String id = request.getParameter("id");
%>
<%
	// new 해도 되지만 객체가 계속 생기는걸 막기 위해서
	LogonDBBean memberDao = LogonDBBean.getInstance();
	int result = memberDao.check(id);
%>
<%
	if(result == 0) {
	// 아이디가 없다
	// 일단은 없다 있다만 출력해서 확인
		%>
		<table>
			<tr>
				<td align="center">
					<span><%=id%></span><%=msg_confirm_o%>
				</td>
			</tr>
			<tr>
				<th>
					<input class="inputbutton" type="button" value="<%=btn_ok%>" 
						onclick="setid('<%=id%>')">
				</th>
			</tr>
		</table>
		<%
	} else {
		%>
		<body onload="confirmfocus()">
			<form name="confirmform" method="post" action="confirmId.jsp" onsubmit="return confirmcheck()">
				<table>
					<tr>
						<th colspan="2">
							<span><%=id%></span><%=msg_confirm_x%>
						</th>
					</tr>
					
					<tr>
						<th> <%=str_id%> </th>
						<td>
							<input class="input" type="text" name="id" maxlength="15"> 
						</td>
					</tr>
					
					<tr>
						<th colspan="2">
							<input class="inputbutton" type="submit" value="<%=btn_confirm%>">
							<input class="inputbutton" type="button" value="<%=btn_confirm_cancel%>"
								onclick="setcancel()">
					</tr>
				</table>
			</form>
		</body>
		<%	
	}
%>