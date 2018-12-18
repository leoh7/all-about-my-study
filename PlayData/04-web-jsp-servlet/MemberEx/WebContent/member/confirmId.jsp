<%@page import="member.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp" %>
<link rel="stylesheet" type="text/css" href="${project}style_member.css">
<script src="${project}script.js"></script>

<h2> ${page_confirm}</h2>

<%
	/* int result = (Integer)request.getAttribute("result");
	String id = (String)request.getAttribute("id"); */
%>
<c:if test="${result eq 0}">
	<table>
		<tr>
			<td align="center">
				<span>${id}</span>${msg_confirm_o}
			</td>
		</tr>
		<tr>
			<th>
				<input class="inputbutton" type="button" value="${btn_ok}" 
					onclick="setid('${id}')">
			</th>
		</tr>
	</table>
</c:if>

<c:if test="${result eq 1}">
	<body onload="confirmfocus()">
		<form name="confirmform" method="post" action="confirmId.do" onsubmit="return confirmcheck()">
			<table>
				<tr>
					<th colspan="2">
						<span>${id}</span>${msg_confirm_x}
					</th>
				</tr>
				
				<tr>
					<th> ${str_id} </th>
					<td>
						<input class="input" type="text" name="id" maxlength="15"> 
					</td>
				</tr>
				
				<tr>
					<th colspan="2">
						<input class="inputbutton" type="submit" value="${btn_confirm}">
						<input class="inputbutton" type="button" value="${btn_confirm_cancel}"
							onclick="setcancel()">
				</tr>
			</table>
		</form>
	</body>
</c:if>