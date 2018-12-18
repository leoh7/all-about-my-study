<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2> session - 생성 페이지 </h2>

<%
	session.setAttribute("id", "aaa");
	session.setAttribute("passwd", "1111");
	
	// 로그아웃 할 떄, 강제로 로그인 정보를 없애버리기 때문에 로그아웃이 된다.
//	session.removeAttribute("id");	
	
	//아예 다 없애ㅐ버리기
//	session.invalidate();
	//시간차 없애기
	session.setMaxInactiveInterval(3);
%>

확인 : <input type="button" value="확인" onclick="javascript:window.location='sessionView.jsp'"><br>