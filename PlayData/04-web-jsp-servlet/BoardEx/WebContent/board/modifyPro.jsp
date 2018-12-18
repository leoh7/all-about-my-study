<%@page import="board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="setting.jsp"%>
<%-- <link rel="stylesheet" type="text/css" href="<%=project%>style_board.css"> --%>
<script src="${project}script.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<%
/* 	int result = (Integer)request.getAttribute("result");
	String pageNum = (String)request.getAttribute("pageNum"); */
%>	
	
<h2>${page_modify}</h2>

	<c:if test="${result eq 0}">
		<!-- 수정 실패 -->
		<script type="text/javascript">
		<!--
		alert(modifyerror);
		//-->
		</script>
		<meta http-equiv="refersh" content="0; url=list.do?pageNum=${pageNum}">
	</c:if>
	<c:if test="${result eq 1}">
		<!-- 수정 성공 -->
		<script type="text/javascript">
		<!--
		alert(list_modify_ok);
		//-->
		</script>
		<meta http-equiv="refresh" content="0; url=list.do?pageNum=${pageNum}">
	</c:if>
