<%@ page language="java" 
		contentType="text/html; charset=UTF-8"
		session="true"
		buffer="10kb"
		autoFlush="true"
		isThreadSafe="true"
    	pageEncoding="UTF-8"%>

    	
<h2> directive - page + 스크립트릿 맛보기</h2>

<%
	// 처리하는건 무조건 다 자바로 하는게 편하다.
	// 영역을 계속 나눠주는게 연습이 되야 한다.
	int a=5, b=2;
	
%>

a + b = <% out.println(a+b); %> <br>
a + b = <% out.println(a-b); %> <br>
a + b = <% out.println(a*b); %> <br>
a + b = <% out.println(a/b); %> <br>
