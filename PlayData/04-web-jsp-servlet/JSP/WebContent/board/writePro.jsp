<%@page import="board.BoardDBBean"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp"%>
<script src="<%=project%>script.js"></script>

<h2><%=page_write%></h2>

<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="boardDto" class="board.BoardDataBean"/>
	<jsp:setProperty property="*" name="boardDto"/>
<!-- 	writer email subject content passwd-->
<!-- 	num ref re_step re_level -->

<%
	boardDto.setReg_date(new Timestamp(System.currentTimeMillis()));
	boardDto.setIp(request.getRemoteAddr());
%>
<%
	BoardDBBean boardDao = BoardDBBean.getInstance();
	int result = boardDao.insertArticle(boardDto);
%>
<%
	if(result == 0){
		%>
		<script type="text/javascript">
		<!--
		erroralert(inserterror);
		//-->
		</script>
		<%
	} else {
		response.sendRedirect("list.jsp");
	}
%>