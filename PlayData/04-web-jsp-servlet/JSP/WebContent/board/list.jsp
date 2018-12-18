<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.BoardDataBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="setting.jsp"%>
<%-- <link rel="stylesheet" type="text/css" href="<%=project%>style_board.css">--%>
<script src="<%=project%>script.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<%
	int pageSize = 5;
	int pageBlock = 3;	// [1][2][3]...[10]
%>

<%
	int count = 0;	// 전체 글 갯수 파악 모양새 잡기
	int start = 0;
	int end = 0;
	String pageNum = null; 	// 넘어오는게 String이니까
	int currentPage = 0;	// 정수로 바꿔줄 꺼야
	int number = 0;			// 글번호(출력용 값일 뿐 PK와는 상관없는 번호)
	// rowNum 정렬이 다 된 다음 붙이는 번호
	int startPage = 0;		// [startPage][][] (pageBlock=3)...[endPage]
	int endPage = 0;
	int pageCount = 0;		// 페이지 갯수 페이지 3개밖에 없는데 10개 찍어라 이러면 안되니깐
	
%>

<%
	BoardDBBean boardDao = BoardDBBean.getInstance();
	count = boardDao.getCount();			// 실질적인 전체 글 갯수 파악

	pageNum = request.getParameter("pageNum");
	if(pageNum == null || pageNum.equals("")){
		pageNum = "1";
	} 
	currentPage = Integer.parseInt(pageNum);	// pageNum을 연산가능하게 해서 start 랑 end 를 계산할 것임
	pageCount = count / pageSize + (count % pageSize > 0 ? 1 : 0);
	if(currentPage > pageCount) currentPage = pageCount;
%>

<%
	
	start = (currentPage -1)*pageSize +1;	// (5 -1 )*10 + 1 = 41 현재 보겠다는 페이지(5) 에서 1을 빼고 10개씩 보는 것에다 1을 더해
	end = start + pageSize -1;				// 41 에서 10을 덜한다음 1을 빼 41 + 10 -1= 50
	// 이렇게 10개씩 가져오라고 했는데 만약에 한 페이지에 10개가 안되면 에러가 난다 
	if(end > count){		// end 페이지가 글의 수count 보다 커
		end = count;	// 3 페이지면 30이지, 글이 25개 있으면 25개 까지가 end 가 되어야 하는 것.
	}
	
	number = count - (currentPage - 1)*pageSize;	// 전체글 - 현재 내가 보겠다는 수 / ex) 50 - (5-1)*10 = 5페이지는 10부터 1까지 / 1페이지는 50번 부터

	
	startPage = (currentPage / pageBlock)*pageBlock + 1;	// 5페이지 보겠다. (5/10)*10+1	11
	if(currentPage % pageBlock == 0){	// 현재 페이지가 페이지 블럭의 배수일 경우 계산이 오류가 난다
		startPage -= pageBlock;
	}
	endPage = startPage + pageBlock - 1;					// 11 + 10 - 1 = 20
	// endPage 보정
	if(endPage > pageCount){ // 내가 실제로 갖고 있는 페이지보다 endPage가 커
		endPage = pageCount; // 그럼 있는 페이지 까지만
	}
%>

<div class="container">
<h2><%=page_list%> (<%=str_count%> : <%=count%>)</h2>
<br>
<table class="table table-dark table-hover">
	<thead>
	<tr>
		<th colspan="6" align="right">
			<div class="d-flex justify-content-end">
				<a class = text-info href="writeForm.jsp"><%=str_write%></a>
			</div>
		</th>
	</tr>
		<tr>
			<th style="width : 5%">	 <%=str_num%> </th>
			<th style="width : 35%"> <%=str_subject%> </th>
			<th style="width : 10%"> <%=str_writer%> </th>
			<th style="width : 15%"> <%=str_reg_date%> </th>
			<th style="width : 9%">  <%=str_readcount%> </th>
			<th style="width : 10%"> <%=str_ip%> </th>
		</tr>
	</thead>
<%
	if(count == 0){
		// 글이 없는 경우 게시판
		%>
		<tbody>
			<tr>
				<td colspan="6" align="center">
					<%=str_msg_list_x%>
				</td>
			</tr>
		</tbody>
		<%
	} else {
		// 글이 있는 경우 게시판
		ArrayList<BoardDataBean> articles = boardDao.getArticles( start, end );
		
		for(int i=0; i<articles.size(); i++){
			BoardDataBean article = articles.get(i);
			%> 
			<tr>
				<td align="center">
					<%=number--%>
				</td>
				
				<td>
					<%
					int level = article.getRe_level();
					int readcount = article.getReadcount();
					if(level > 1){	// 재답글 띄어주기
						int wid = (level - 1)*10;
						%>
						<img src="<%=project%>images/level.gif" border="0" width="<%=wid%>" height="15">
						<%
					}
					if(level > 0){	// 원글은 0
						%>
						<%-- <img src="<%=project%>images/re.gif" border="0" width="25" height="15"> --%>
						<span class="badge badge-success">Re :</span>
						<%
					}
					if(readcount >= 20){
						%>
						<span class="badge badge-warning">Hot!</span>
						<%
					}
					%>
					<a class = text-info href="content.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>&list_num=<%=number+1%>">
						<%=article.getSubject()%>
					</a>
				</td>
				
				<td align="center">
					<%=article.getWriter()%>
				</td>
				
				<td align="center">
					<%
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					%>
					<%=sdf.format(article.getReg_date())%>
				</td>
				
				<td align="center">
					<%=article.getReadcount()%>
				</td>
				
				<td align="center">
					<%=article.getIp()%>
				</td>
			</tr>
			<%
		}
	}
%>
</table>
</div>
<br>
<div class="container">
<%
	if(count > 0){
		%>
		<ul class="pagination pagination-sm">
		<%
		if(startPage > pageBlock ){	
			%>
			<!-- <a href="list.jsp?pageNum=1">[◀◀]</a> -->
			
			<li class="page-item"><a class = "page-link" href="list.jsp">◀◀</a></li>
			<li class="page-item"><a class = "page-link" href="list.jsp?pageNum=<%=startPage-pageBlock%>">◀</a></li>
			
			<%
		}
		for(int i=startPage; i<=endPage; i++){
			if(i==currentPage){
				// 현재 페이지 따로 표시
				%>	
				<li class="page-item active"><a class = "page-link" href="#"><%=i%></a></li>
				<%
			} else {
				%>
				<li class="page-item"><a class = "page-link" href="list.jsp?pageNum=<%=i%>"><%=i%></a></li>
				<%
			}
		}
		if( pageCount > endPage){
			%>
			<li class="page-item"><a class = "page-link" href="list.jsp?pageNum=<%=startPage+pageBlock%>">▶</a></li>
			<li class="page-item"><a class = "page-link" href="list.jsp?pageNum=<%=pageCount%>">▶▶</a></li>
			<%
		}
		%>
		</ul>
		<%
	}

%>

</div>