<%@page import="board.BoardDataBean"%>
<%@page import="board.BoardDBBean"%>
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
		int num = Integer.parseInt(request.getParameter("num"));
		String passwd = request.getParameter("passwd");
		String pageNum = request.getParameter("pageNum");
	%>
	<%
		BoardDBBean boardDao = BoardDBBean.getInstance();
		int result = boardDao.check(num, passwd);
	%>
	<%
		if(result == 0){
			// 비밀번호 틀렸을 경우
			%>
			<script type="text/javascript">
				<!--
				erroralert(passerror);
				//-->
			</script>
			<%
		} else {
			// 비밀번호 맞았을 경우
			BoardDataBean boardDto = boardDao.getArticle(num);
			%>
		<body onload="modifyfocus()">
			<div class = container>
				<h2><%=page_modify%></h2>
				<form method="post" action="modifyPro.jsp" name="modifyform" onsubmit="return modifycheck()">
					<input type="hidden" name="num" value="<%=num%>">
					<input type="hidden" name="pageNum" value="<%=pageNum%>">
					<table class = table>
						<tr>
							<th colspan="2">
								<%=msg_modify%>
							</th>
						</tr>
						
						<tr>
							<th> 
								<%=str_writer%> 
							</th>
							<td> 
								<%=boardDto.getWriter()%>
							</td>
						
						</tr>
						
						
						
						
						
						<tr>
							<th> <%=str_email%> </th>
							<td> 
								<%
									String email = boardDto.getEmail();
								if(email == null || email.equals("")){
									%>
									<input class="form-control" type="text" name="email" maxlength="30">
									<%
								} else {
									%>
									<input class="form-control" type="text" name="email" maxlength="30"
										value="<%=email%>">
									<%
								}
								%>
							</td>
						</tr>
						<tr>
							<th> <%=str_subject%> </th>
							<td>
								<input class="form-control" type="text" name="subject" maxlength="50"
									value="<%=boardDto.getSubject()%>">
						</tr>
						
						<tr>
							<th> <%=str_content%> </th>
							<td>
								<textarea name="content" rows="10" cols="40"><%=boardDto.getContent()%></textarea>
							</td>
						</tr>
						
						<tr>
							<th> <%=str_passwd%> </th>
							<td>
								<input class="form-control" type="password" name="passwd" maxlength="12"
									value="<%=boardDto.getPasswd()%>">
							</td>
						</tr>
						
						<tr>
							<th colspan="2">
							<input class="inputbutton" type="submit" value="<%=btn_mod%>">
							<input class="inputbutton" type="reset" value="<%=btn_cancel%>">
							<input class="inputbutton" type="button" value="<%=btn_mod_cancel%>"
								onclick="location='list.jsp?pageNum=<%=pageNum%>'">
							</th>
						</tr>
						
					</table>
				</form>
			</div>
		</body>
			<%
		}
	%>
	

