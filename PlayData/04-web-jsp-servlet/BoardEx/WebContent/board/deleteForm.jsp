<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="setting.jsp"%>
<%-- <link rel="stylesheet" type="text/css" href="<%=project%>style_board.css"> --%>
<script src="${project}script.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<%
/* 	int num = (Integer)request.getAttribute("num");
	String pageNum = (String)request.getAttribute("pageNum"); */
%>

<body onload="passwdfocus()">
<div class="container">
	<form method="post" action="deletePro.do" name="passwdform" onsubmit="return passwdcheck()">
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="pageNum" value="${pageNum}">
		<table class="table">
			<tr>
				<th colspan="2">
					${msg_passwd}
				</th>
			</tr>
			
			<tr>
				<th> 
					${str_passwd}
				</th>
				<td>
					<input class="form-control" type="password" name="passwd" maxlength="15">
				</td>
			</tr>
			
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="${btn_del}">
					<input class="inputbutton" type="button" value="${btn_del_cancel}"
						onclick="location='list.do?pageNum=${pageNum}'">
				</th>
			</tr>
		</table>
	</form>
</div>
</body>
</html>