<%@page import="java.text.SimpleDateFormat"%>
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
	String pageNum = request.getParameter("pageNum");
	String list_num = request.getParameter("list_num");
%>
<%
	BoardDBBean boardDao = BoardDBBean.getInstance();
	// 글을 읽는다는건 readcount 는 DB처리 / 여기서 늘리면 들어가자 마자 늘어남
	BoardDataBean boardDto = boardDao.getArticle( num );
	// 글을 읽는다는건 readcount 는 DB처리 / 여기서 늘리면 들어가자 마자는 안늘어나, 나오면 늘어남
	if(!request.getRemoteAddr().equals(boardDto.getIp())){
		boardDao.addCount(num);
	}
	
%>

<div class="container">
<h2><%=page_content%></h2>
	
	<table class="table table-bordered">
		<tr>
			<th> <%=str_number%> </th>
			<td align="center"> <%=list_num%> </td>	<!-- 글 하나 꺼내오는 메서드가 필요 -->
			<th> <%=str_readcount%> </th>
			<td align="center"> <%=boardDto.getReadcount()%> </td>
		</tr>
		
		<tr>
			<th> <%=str_writer%> </th>
			<td align="center"> <%=boardDto.getWriter()%> </td>
			<th> <%=str_reg_date%> </th>
			<td align="center">
			<%
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			%>
			<%=sdf.format(boardDto.getReg_date())%>
			</td>
		</tr>
		
		<tr>
			<th> <%=str_subject%> </th>
			<td colspan="3"> <%=boardDto.getSubject()%> </td>
		</tr>
		
		<tr>
			<th> <%=str_content%> </th>
			<td colspan="3"> <pre><%=boardDto.getContent()%></pre> </td>
		</tr>
		<tr>
			<th colspan="4">
				<input class="inputbutton" type="button" value="<%=btn_modify%>"
					onclick="location='modifyForm.jsp?num=<%=boardDto.getNum()%>&pageNum=<%=pageNum%>'">
				<input class="inputbutton" type="button" value="<%=btn_delete%>"
					onclick="location='deleteForm.jsp?num=<%=boardDto.getNum()%>&pageNum=<%=pageNum%>'">
				<input class="inputbutton" type="button" value="<%=btn_reply%>"
					onclick="location='writeForm.jsp?num=<%=boardDto.getNum()%>&ref=<%=boardDto.getRef()%>&re_step=<%=boardDto.getRe_step()%>&re_level=<%=boardDto.getRe_level()%>'">
				<input class="inputbutton" type="button" value="<%=btn_list%>"
					onclick="location='list.jsp?pageNum=<%=pageNum%>'">
			</th>
		</tr>
	</table>
</div>