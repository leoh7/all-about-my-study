<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2> script - declaration </h2>

<%
	String name = "지역변수 : jspService() 메서드 안에 존재한다.";
%>

<%!
	/* 
		이럴 때는 declaration 을 주고, 이건 전역변수이다(?) 
		왜? 를 알아야 한다.
	*/
	
	/*
		같은 이유로 jspService() 안에 내장객체가 생기게 되므로,
		declaration 은 내장객체를 쓸 수가 없다.
	*/
	String name = "전역변수 : jspService() 메서드 밖에 존재한다. class 바로 밑";
	
	public int hap(int a, int b) {
	 	return a+b;
	}

	public int gop(int a, int b) {
		return a*b;
	}
%>

합 : <%=hap(5, 2)%> <br>
곱 : <%=gop(5, 2)%> <br>