<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="setting.jsp"%>
<%-- <link rel="stylesheet" type="text/css" href="<%=project%>style_board.css"> --%>
<script src="<%=project%>script.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<%
	// 제목글인 경우
	int num = 0;		// 제목글 0 / 답변글 !0 구분
	int ref = 0;		// 그룹화아이디
	int re_step = 0;	// 글 순서
	int re_level = 0;	// 글 레벨
	
	// 답변글인 경우
	if(request.getParameter("num")!=null){
		num = Integer.parseInt(request.getParameter("num"));
		ref = Integer.parseInt(request.getParameter("ref"));
		re_step = Integer.parseInt(request.getParameter("re_step"));
		re_level = Integer.parseInt(request.getParameter("re_level"));
	}
%>
<div class="container">
<h2><%=page_write%></h2>



<body onload="writefocus()">
	<form method="post" action="writePro.jsp" name="writeform" onsubmit="return writecheck()">
		<input type="hidden" name="num" value="<%=num%>">
		<input type="hidden" name="ref" value="<%=ref%>">
		<input type="hidden" name="re_step" value="<%=re_step%>">
		<input type="hidden" name="re_level" value="<%=re_level%>">
		
		<table class="table table-bordered">
			<tr>
				<th colspan="2" align="right">
					<a href="list.jsp"><%=str_list%></a>&nbsp;&nbsp;&nbsp;
				</th>
			</tr>
			
			<tr>
				<th> <%=str_writer%> </th>
				<td> <input class="form-control" type="text" name="writer" maxlength="10"> </td>
			</tr>
			
			<tr>
				<th> <%=str_email%> </th>
				<td> <input class="form-control" type="text" name="email" maxlength="30"> </td>
			</tr>
			
			<tr>
				<th> <%=str_subject%> </th>
				<td> <input class="form-control" type="text" name="subject" maxlength="50"> </td>
			</tr>
			
			<tr>
				<th> <%=str_content%> </th>
				<td>
					<textarea class="form-control" name="content" rows="10" cols="45"></textarea>
				</td>
			</tr>
			
			<tr>
				<th> <%=str_passwd%></th>
				<td> <input class="form-control" type="password" name="passwd" maxlength="12"> </td>
			</tr>
			
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="<%=btn_write%>">
					<input class="inputbutton" type="reset" value="<%=btn_cancel%>">
					<input class="inputbutton" type="button" value="<%=btn_list%>"
						onclick="location='list.jsp'">
				</th>
			</tr>
		</table>
	</form>
	</div>
</body>

