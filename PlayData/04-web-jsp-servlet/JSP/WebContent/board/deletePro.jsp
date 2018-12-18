<%@page import="board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="setting.jsp"%>
<%-- <link rel="stylesheet" type="text/css" href="<%=project%>style_board.css"> --%>
<script src="<%=project%>script.js"></script>
</head>
<h2><%=page_delete%></h2>

<% 
	int num = Integer.parseInt(request.getParameter("num"));
	String passwd = request.getParameter("passwd");
	String pageNum = request.getParameter("pageNum");
%>
<%
	BoardDBBean boardDao = BoardDBBean.getInstance();
	int result = boardDao.check(num, passwd);	// 비밀번호가 맞는지 확인
%>

<%
	if(result == 0){
		// 비밀번호가 다르다
		%>
		<script type="text/javascript">
		<!--
			erroralert(passerror);
			erroralert
		//-->
		</script>
		<%
	} else {
		// 비밀번호가 같다
		result = boardDao.deleteArticle(num);
		if(result == 0){
			// 삭제 실패 : 리스트로 돌아 갈 것
			%>
			<script type="text/javascript">
				<!--
				alert(deleteerror);
				//-->
			</script>
			<meta http-equiv="refresh" content="0; url=list.jsp?pageNum=<%=pageNum%>">
			<%
		} else if(result == -1){
			// 답글이 있는 경우 : 못 지우는 경우
			%>
			<script type="text/javascript">
				<!--
				alert(replyerror);
				//-->
			</script>
			<meta http-equiv="refresh" content="0; url=list.jsp?pageNum=<%=pageNum%>">
			<%
		} else {
			// 삭제 성공
			/* response.sendRedirect("list.jsp?pageNum=" + pageNum); */
			%>
			<script type="text/javascript">
				<!--
				alert(list_del_ok);
				//-->
			</script>
			<meta http-equiv="refresh" content="0; url=list.jsp?pageNum=<%=pageNum%>">
			<%
		}
	}
%>


</html>