<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<h2> script - scriptlet </h2>
	
	<%
	/*
		// 처리용, 출력용 파일을 분업을 시켜야 하기 때문에 (출력은 html, 처리는 자바)
		// 아래는 좋지 않은 행위다.
		int a = 8;
		if(a > 5) {
			out.println("크다");
		} else {
			out.println("작다");
		}
	
	*/
	
		int a = 8;
		if(a > 5) {
			//out.println("크다");
			
			// 째고 출력을 넣는다!
			%>
			<%=a %> 크다<br>
			<%
		} else {
			//out.println("작다");
			
			// 째고 출력을 넣는다!
			%>
			작다<br>
			<%
		}
	%>
	
	
	
	
	