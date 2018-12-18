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
	
	
<h2><%=page_modify%></h2>

<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="boardDto" class="board.BoardDataBean"/>
	<jsp:setProperty property="*" name="boardDto"/>
	<!-- 받는 것 num subject content passwd email -->
	
<%
	String pageNum = request.getParameter("pageNum");
%>
<%
	BoardDBBean boardDao = BoardDBBean.getInstance();
	int result = boardDao.modifyArticle(boardDto);

%>
<%
	if(result == 0){
		// 수정 실패
		%>
			<script type="text/javascript">
			<!--
			alert(modifyerror);
			//-->
			</script>
			<meta http-equiv="refersh" content="0; url=list.jsp?pageNum=<%=pageNum%>">
		<%
	} else {
		// 수정 성공
		%>
		<script type="text/javascript">
		<!--
		alert(list_modify_ok);
		//-->
		</script>
		<meta http-equiv="refresh" content="0; url=list.jsp?pageNum=<%=pageNum%>">
	<%
	}
%>