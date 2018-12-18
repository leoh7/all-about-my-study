<%@ page import="bean.StudyBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h2> 흐름제어 페이지 </h2>
    
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="ver3" class="bean.StudyBean" scope="session"/>
<jsp:setProperty property="*" name="ver3"/>
<% 
	
	if(ver3.getControl().equals("tv")) {
		ver3.setName("텔레비젼");
	} else if(ver3.getControl().equals("pc")) {
		ver3.setName("컴퓨터");
	} else if(ver3.getControl().equals("dc")) {
		ver3.setName("디지털카메라");
	}

%>

<jsp:forward page="template.jsp"/>

