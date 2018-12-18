<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h2> 500 error page </h2>

<%
	// 웹 브라우저 속이기
	response.setStatus(HttpServletResponse.SC_OK);
%>

현재 페이지는 500 에러 페이지 입니다. <br>
서버 내부 오류(오타) 입니다. <br>
소스를 다시 확인 하세요 <br>