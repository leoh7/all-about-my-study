<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h2> 내장객체 - response - 1 </h2>
    
    현재 페이지는 리다이렉트 되기 전 페이지 responseTest1.jsp 입니다. <br>
    

<% 
	// response 는 sendRedirect() 밖에 안 쓴다.
	// 1번 페이지가 응답하기 싫으면 2번 페이지로 넘겨버릴 수가 있는 것.
	// 뒤에 나오는 "<jsp:forward> 페이지의 흐름을 제어할 때" 이런 때 쓴다. 전체 페이지의 흐름제어
	// 지금은 sendRedirect() 하면 응답페이지가 바뀐다는 것만 알아두자.
	// 일단 출력하려고 버퍼에 다 넣어, 근데 sendRedirect() 를 만나면 버퍼 싹 다 비우고 그냥 페이지를 넘겨버려
	response.sendRedirect("responseTest2.jsp");
%>