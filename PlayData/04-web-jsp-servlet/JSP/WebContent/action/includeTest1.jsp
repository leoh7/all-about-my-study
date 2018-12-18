<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<h2> 액션태그 - include - 처리/출력 페이지1 </h2>
	
<%
	request.setCharacterEncoding("utf-8");
%>
	
<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
%>

이름 : <%=name%> <br>
나이 : <%=age%> <br>

<jsp:include page="includeTest2.jsp" flush="false">
	<jsp:param value="<%=name%>" name="paramName"/>
	<jsp:param value="<%=age%>" name="paramAge"/>
</jsp:include>