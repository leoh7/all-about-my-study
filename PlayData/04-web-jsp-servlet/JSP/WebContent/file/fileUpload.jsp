<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<div class="container">
<h2> 파일 업로드 - 처리 페이지</h2>

<%
	String path = application.getRealPath("/save"); // 서버의 진짜 경로 얻기
	new File(path).mkdir();	// 경로에
	//, 폴더는 진짜 파일 경로
 	MultipartRequest multi 
	= new MultipartRequest(request, path, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy()); 
%>
경로 : <%=path%> <br>

<%
	String originName1 = multi.getOriginalFileName("upload1");
	String systemName1 = multi.getFilesystemName("upload1");
	
	String originName2 = multi.getOriginalFileName("upload2");
	String systemName2 = multi.getFilesystemName("upload2");
%>
파일 1 : <%=originName1%> - <%=systemName1%> <br>
파일 2 : <%=originName2%> - <%=systemName2%> <br>

<%
	String name = multi.getParameter("name");
	String title = multi.getParameter("title");
%>
이름 : <%=name%> <br>
제목 : <%=title%> <br>

</div>

<div class="container">
	<h2> 파일 다운로드 </h2>
	<!-- 프로젝트 경로부터 주면 된다 -->
<%-- 	
	파일 1 : <a href="/JSP/save/<%=systemName1%>"><%=originName1%></a> <br>
	파일 2 : <a href="/JSP/save/<%=systemName2%>"><%=originName2%></a> <br> 
--%>
<%
	String originName11 = URLEncoder.encode( originName1, "utf-8");
	String systemName11 = URLEncoder.encode( systemName1, "utf-8");
	String originName22 = URLEncoder.encode( originName2, "utf-8");
	String systemName22 = URLEncoder.encode( systemName2, "utf-8");
%>

파일 1 : <a class="text-warning" href="fileDownload.jsp?originName=<%=originName11%>&systemName=<%=systemName11%>">
	<%=originName1%>
	</a> <br>
파일 2 : <a class="text-warning" href="fileDownload.jsp?originName=<%=originName22%>&systemName=<%=systemName22%>">
	<%=originName2%>
	</a> <br>


</div>