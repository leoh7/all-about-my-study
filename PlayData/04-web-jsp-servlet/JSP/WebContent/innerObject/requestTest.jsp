<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h2>내장객체 - request - 처리/출력 페이지 </h2>
    
<%
	/*
		원래 인코딩을 1바이트로 쪼개서 다시 인코딩 했었는데,
		JSP에서는 넘어오는 한글을 한번에 다 처리할거야
	*/
	request.setCharacterEncoding("utf-8");
	
%>
<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String gender = request.getParameter("gender");
	String []hobby = request.getParameterValues("hobby");
%>

당신의 이름은 <%=name%> 이고<br>
나이는 <%=age%> 살 이고<br>
성별은
<%
	if(gender.equals("1")) {
		%>
		남자입니다.<br>
		<%
	} else {
		%>
		여자입니다.<br>
		<%
	}
%> <br>

취미는
<%	
	for(int i = 0; i<hobby.length; i++) {
		switch(hobby[i]) {
			case "1" : %> 독서 <%;	 break;
			case "2" : %> 등산 <%;	 break;
			case "3" : %> 운동 <%;	 break;
			case "4" : %> 게임 <%;	 break;
		} 
	} 
	
%>
입니다 <br>