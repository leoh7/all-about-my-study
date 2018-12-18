<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<h2> 내장객체 - 내장객체영역 - 생성 페이지 </h2>
	
<%
	/* 
		page에는 현재에서만 사용하는 내장객체이기 때문에 setAttribute 메서드 자체가 없다.
		page
	
		이건 입력받는 것도, 흐름제어하는 것도, 아니고 기존에 제어하는 방식으로 하긴 힘들지, 이럴땐 버튼을 따로 만ㄷ르어서
		확인하는 페이지로 강제로 넘길꺼야.
	*/
	request.setAttribute("id", "aaa");
	session.setAttribute("id", "bbb");
	application.setAttribute("id", "ccc");
	
	
%>

<!-- 이벤트 처리 할 때는 on 을 붙이면 된다 깐딴하지 -->
<input type="button" value="확인" onclick="javascript:window.location='getAttribute.jsp'">