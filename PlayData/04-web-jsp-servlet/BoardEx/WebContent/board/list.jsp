<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.BoardDataBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="setting.jsp"%>
<%-- <link rel="stylesheet" type="text/css" href="<%=project%>style_board.css">--%>
<script src="${project}script.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<%
/* 	int pageBlock = (Integer) request.getAttribute("pageBlock"); 
	int count = (Integer) request.getAttribute("count");
	String pageNum = (String) request.getAttribute("pageNum");
	int currentPage = (Integer) request.getAttribute("currentPage");
	int number = (Integer) request.getAttribute("number");
	int startPage = (Integer) request.getAttribute("startPage");
	int endPage = (Integer) request.getAttribute("endPage");
	int pageCount = (Integer) request.getAttribute("pageCount"); */
%>

<div class="container">
<h2>${page_list} (${str_count} : ${count})</h2>
<br>
<table class="table table-dark table-hover">
	<thead>
	<tr>
		<th colspan="6" align="right">
			<div class="d-flex justify-content-end">
				<a class = text-info href="writeForm.do">${str_write}</a>
			</div>
		</th>
	</tr>
		<tr>
			<th style="width : 5%">	 ${str_num} </th>
			<th style="width : 35%"> ${str_subject} </th>
			<th style="width : 10%"> ${str_writer} </th>
			<th style="width : 15%"> ${str_reg_date} </th>
			<th style="width : 9%">  ${str_readcount} </th>
			<th style="width : 10%"> ${str_ip} </th>
		</tr>
	</thead>
	<c:if test="${count eq 0}">
		<!--  글이 없는 경우 게시판 -->
		<tbody>
			<tr>
				<td colspan="6" align="center">
					${str_msg_list_x}
				</td>
			</tr>
		</tbody>
	</c:if>
	<c:if test="${count ne 0}">	
		<c:forEach var="article" items="${articles}">
			<tr>
				<td align="center">
					${number}
					<c:set var="number" value="${number-1}"/>
				</td>
				
				<td>
					<c:if test="${article.re_level gt 1}">
						<c:set var="wid" value="${(article.re_level-1)*10}"/>
						<img src="${project}images/level.gif" border="0" width="${wid}" height="15">
					</c:if>
					<c:if test="${article.re_level gt 0}">
						<span class="badge badge-success">Re :</span>
					</c:if>
					<c:if test="${article.readcount gt 20}">
						<span class="badge badge-warning">Hot!</span>
					</c:if>
					
					<a class = text-info href="content.do?num=${article.getNum()}&pageNum=${pageNum}&list_num=${number+1}">
						${article.getSubject()}
					</a>
				</td>
				
				<td align="center">
					${article.getWriter()}
				</td>
				
				<td align="center">
					<fmt:formatDate value="${article.reg_date}" pattern="yyyy-MM-dd HH:mm"/>
				</td>
				
				<td align="center">
					${article.getReadcount()}
				</td>
				
				<td align="center">
					${article.getIp()}
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
</div>
<br>
<div class="container">
<c:if test="${count gt 0}">
	<ul class="pagination pagination-sm">
		<c:if test="${startPage gt pageBlock}">
			<li class="page-item"><a class = "page-link" href="list.do">◀◀</a></li>
			<li class="page-item"><a class = "page-link" href="list.do?pageNum=${startPage-pageBlock}">◀</a></li>
		</c:if>
		
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<c:if test="${i eq currentPage}">
				<!--  현재 페이지 따로 표시 -->
				<li class="page-item active"><a class = "page-link" href="#">${i}</a></li>
			</c:if>
				
			<c:if test="${i ne currentPage}">
				<li class="page-item"><a class = "page-link" href="list.do?pageNum=${i}">${i}</a></li>
			</c:if>
		</c:forEach>
		
		<c:if test="${pageCount gt endPage}">
			<li class="page-item"><a class = "page-link" href="list.do?pageNum=${startPage+pageBlock}">▶</a></li>
			<li class="page-item"><a class = "page-link" href="list.do?pageNum=${pageCount}">▶▶</a></li>
		</c:if>
	</ul>
</c:if>

</div>
