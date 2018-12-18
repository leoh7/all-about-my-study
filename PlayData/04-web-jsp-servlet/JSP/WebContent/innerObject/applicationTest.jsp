<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<h2> 내장객체 - application </h2>
	
<%
	String info = application.getServerInfo();
	int major = application.getMajorVersion();
	int minor = application.getMinorVersion();
	
	// 서버에서 어떤 경로로 들어갈 지 사실 우리는 몰라
	// 전체 경로를 얻어다가 파일 경로를 줘야 할 때가 있는데, 이럴 때 쓴다.
	// 실제 경로를 보여줌.
	String path = application.getRealPath("/");
%>

서버 정보 : <%=info%> <br>
서버 버전 : <%=major%>.<%=minor%> <br>
실제 경로 : <%=path%><br>

<br><br>

<%
//	application.getInitParameter("level")
	Enumeration<String> e = application.getInitParameterNames();
	while(e.hasMoreElements()) {
		String name = e.nextElement();
		String data = application.getInitParameter(name);
		
		%>
			이름 : <%=name %> - 값 : <%=data %> <br>
		<%
	}


%>