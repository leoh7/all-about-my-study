<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>흐름 제어 페이지</h2>

<%
	// 한글이 안 넘어왔어도 흐름 제어에서 미리 한글 인코딩을 해버리면 편하다.
	request.setCharacterEncoding("utf-8");
%>

<%
	String product = request.getParameter("product");
	String company = request.getParameter("company");
	String indexIs = request.getParameter("indexIs");
%>

<%
	String control = null;
	String name = null;
	
	if(product.equals("1")) {
		control = "tv";
		name = "텔레비젼";
	} else if(product.equals("2")) {
		control = "pc";
		name = "컴퓨터";
	} else if(product.equals("3")) {
		control = "dc";
		name = "디지털카메라";
	}
	
%>


<jsp:forward page="template.jsp">
	<jsp:param name="paramControl" value="<%=control%>"/>
	<jsp:param name="paramName" value="<%=name%>"/>
	<jsp:param value="<%=company%>" name="paramCompany"/>
	<jsp:param value="<%=indexIs%>" name="paramIndexIs"/>
	
</jsp:forward>


