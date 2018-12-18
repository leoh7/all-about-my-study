<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.BoardDataBean"%>
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
/* 	String list_num = (String)request.getAttribute("list_num");
	String pageNum = (String)request.getAttribute("pageNum");
	BoardDataBean boardDto = (BoardDataBean)request.getAttribute("boardDto"); */
%>


<div class="container">
<h2>${page_content}</h2>
	
	<table class="table table-bordered">
		<tr>
			<th> ${str_number} </th>
			<td align="center"> ${list_num} </td>	<!-- 글 하나 꺼내오는 메서드가 필요 -->
			<th> ${str_readcount} </th>
			<td align="center"> ${boardDto.readcount} </td>
		</tr>
		
		<tr>
			<th> ${str_writer} </th>
			<td align="center"> ${boardDto.writer} </td>
			<th> ${str_reg_date} </th>
			<td align="center">
			<fmt:formatDate value="${boardDto.reg_date}" pattern="yyyy-MM-dd HH:mm"/>
			</td>
		</tr>
		
		<tr>
			<th> ${str_subject} </th>
			<td colspan="3"> ${boardDto.subject} </td>
		</tr>
		
		<tr>
			<th> ${str_content} </th>
			<td colspan="3"> <pre>${boardDto.content}</pre> </td>
		</tr>
		<tr>
			<th colspan="4">
				<input class="inputbutton" type="button" value="${btn_modify}"
					onclick="location='boardModifyForm.do?num=${boardDto.num}&pageNum=${pageNum}'">
				<input class="inputbutton" type="button" value="${btn_delete}"
					onclick="location='boardDeleteForm.do?num=${boardDto.num}&pageNum=${pageNum}'">
				<input class="inputbutton" type="button" value="${btn_reply}"
					onclick="location='boardWriteForm.do?num=${boardDto.num}&ref=${boardDto.ref}&re_step=${boardDto.re_step}&re_level=${boardDto.re_level}'">
				<input class="inputbutton" type="button" value="${btn_list}"
					onclick="location='boardList.do?pageNum=${pageNum}'">
			</th>
		</tr>
	</table>
</div>