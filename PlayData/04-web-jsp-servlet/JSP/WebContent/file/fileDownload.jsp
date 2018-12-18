<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2> 파일 다운로드 - 처리 페이지 </h2>

<%
	String originName = request.getParameter("originName");
	String systemName = request.getParameter("systemName");
	originName = URLDecoder.decode(originName, "utf-8");
	systemName = URLDecoder.decode(systemName, "utf-8");
%>

파일 이름 : <%=originName%> <br>
저장 이름 : <%=systemName%> <br>

<%
	// 버퍼에 이것저것 들어있으니까 버퍼를 일단 깔끔하게 비워줄꺼야
	// 버퍼 내장객체 out
	out.clear();
	out = pageContext.pushBody();
	String path = application.getRealPath("/save");
	String fileName = path + "/" + systemName;
	
	// 클라이언트 속이기
	response.setContentType("text/unknown");
	response.setHeader("content-disposition", 
			"attachname;filename=" + URLEncoder.encode(originName, "utf-8") + ";");
	
	BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
	BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	byte buffer[] = new byte[1024];
	int length = 0;
	
	while((length = bis.read(buffer, 0, buffer.length)) != -1){
		bos.write(buffer, 0, length);
	}
	
	bis.close();
	bos.close();
	
	
	
%>













