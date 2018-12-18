<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2> Cookie - 생성페이지</h2>

<%
	// 서버에서 만들지만 클라이언트에 저장한댔지
	Cookie cookie1 = new Cookie("id", "aaa");
	// 클라이언트에 쿠키 써주기
	response.addCookie(cookie1);
	
	Cookie cookie2 = new Cookie("passwd", "111");
	response.addCookie(cookie2);
%>

확인 : <input type="button" value="확인" onclick="javascript:window.location='cookieUse.jsp'">