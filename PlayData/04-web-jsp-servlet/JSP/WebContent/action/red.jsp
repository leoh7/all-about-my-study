<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<h2> 액션태그 - forward - 출력 페이지 </h2>

<%
	request.setCharacterEncoding("utf-8");
%>

<%
	String name = request.getParameter("paramName");
%>

<body bgcolor="red">
	<%=name%> 님 안녕하세요 <br>
	당신이 선택한 색상은 빨간색입니다. <br>

</body>