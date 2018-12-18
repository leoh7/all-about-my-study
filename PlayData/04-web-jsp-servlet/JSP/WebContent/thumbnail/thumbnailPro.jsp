<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="javax.media.jai.RenderedOp"%>
<%@page import="javax.media.jai.JAI"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<!DOCTYPE html>

<div class="container">
<h2> 섬네일 이미지 - 처리 페이지</h2>

<%
	// 서버의 최상위 폴더부터 경로 얻어오기
	String path = application.getRealPath("/save");
	new File(path).mkdir();

	MultipartRequest multi						// 5MB
		= new MultipartRequest(request, path, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
	String name = multi.getParameter("name");
	String title = multi.getParameter("title");
	Enumeration e = multi.getFileNames();
%>
	파일 경로 : <%=path%> <br>
	이름 : <%=name%> <br>
	제목 : <%=title%> <br>	
<%
	while(e.hasMoreElements()){
		String inputName = (String)e.nextElement();
		String originName = multi.getOriginalFileName(inputName);
		String systemName = multi.getFilesystemName(inputName);
		
		String sName = path + "/" + systemName; 	// 혹은 역슬래시 두개 (\\)
		String tName = path + "/t" + systemName;	// 원본이미지파일 -> buffer => 1/4 buffer -> 섬네일 이미지
		
		RenderedOp op = JAI.create("fileload", sName);		// 원본을 로드
		BufferedImage sbuffer = op.getAsBufferedImage();	// 버퍼로 옮기기
		
		int SIZE = 3;	// 줄일 사이즈 1/9
		int width = sbuffer.getWidth() / SIZE;	// 원본 이미지 줄이기
		int height = sbuffer.getHeight() / SIZE;
		
		BufferedImage tbuffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);	// 빈 버퍼 만들기
		Graphics g = tbuffer.getGraphics();	// 버퍼에 그리기
		g.drawImage(sbuffer, 0, 0, width, height, null);
		
		ImageIO.write(tbuffer, "jpg", new File(tName));
		ImageIO.write(tbuffer, "png", new File(tName));
		ImageIO.write(tbuffer, "gif", new File(tName));
		
		
		
		%>
		파일이름(<%=inputName%>) : <%=originName%> <br>
		저장이름(<%=inputName%>) : <%=systemName%> <br>
		<br>
		<img src="/JSP/save/<%=systemName%>"> 
		<img src='/JSP/save/<%="t"+systemName%>'>
		<br>
		<%
	}
%>
</div>