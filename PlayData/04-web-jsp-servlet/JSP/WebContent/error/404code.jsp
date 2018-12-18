<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<h2> 404 error page </h2>


<%
	// 웹 브라우저 속이기
	response.setStatus(HttpServletResponse.SC_OK);
%>

현재 페이지는 404 에러 페이지 입니다. <br>
경로 에러 입니다. <br>
파일 이름과 경로를 다시 확인 하세요 <br>