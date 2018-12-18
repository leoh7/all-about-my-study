<%@page import="board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="setting.jsp"%>
<%-- <link rel="stylesheet" type="text/css" href="<%=project%>style_board.css"> --%>
<script src="${project}script.js"></script>
</head>
<h2>${page_delete}</h2>

<%
/* 	int resultCheck = (Integer)request.getAttribute("resultCheck");
	String pageNum = (String)request.getAttribute("pageNum"); */
%>

	<c:if test="${resultCheck eq 0}">
			<!-- if(resultCheck == 0){ -->
			<!-- 비밀번호가 다르다 -->
	<script type="text/javascript">
	<!--
		erroralert(passerror);
		erroralert
	//-->
	</script>
	</c:if>
	<c:if test="${resultCheck eq 1}">
		<!-- 비밀번호가 같다 -->
		<c:if test="${result eq 0}">
			<!-- 삭제 실패 : 리스트로 돌아 갈 것 -->
			<script type="text/javascript">
				<!--
				alert(deleteerror);
				//-->
			</script>
			<meta http-equiv="refresh" content="0; url=boardList.do?pageNum=${pageNum}">
		</c:if>
		<c:if test="${result eq -1}">
			<!-- 답글이 있는 경우 : 못 지우는 경우 -->
			<script type="text/javascript">
				<!--
				alert(replyerror);
				//-->
			</script>
			<meta http-equiv="refresh" content="0; url=boardList.do?pageNum=${pageNum}">
		</c:if>
		<c:if test="${result eq 1}">
			<!-- 삭제 성공 -->
			<script type="text/javascript">
				<!--
				alert(list_del_ok);
				//-->
			</script>
			
			<!-- 페이지 이동은 이런식으로 시켜도 된다 -->
			<%-- <c:redirect url="list.do?pageNum=${pageNum}"/> --%>
			<meta http-equiv="refresh" content="0; url=boardList.do?pageNum=${pageNum}">
		</c:if>
	</c:if>
</html>