<%@page import="bean.StudyBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>흐름 제어 페이지</h2>

<%
	// 한글이 안 넘어왔어도 흐름 제어에서 미리 한글 인코딩을 해버리면 편하다.
	request.setCharacterEncoding("utf-8");
%>
	<jsp:useBean id="bean" class="bean.StudyBean" scope="session"/>
	

<%
	if(bean.getProduct().equals("1")) {
		bean.setControl("tv");
		bean.setName("텔레비젼");
	} else if(bean.getProduct().equals("2")) {
		bean.setControl("pc");
		bean.setName("컴퓨터");
	} else if(bean.getProduct().equals("3")) {
		bean.setControl("dc");
		bean.setName("디지털카메라");
	}

%>
<<jsp:setProperty property="indexIs" name="bean" value="1"/>
<jsp:setProperty property="*" name="bean"/>
<jsp:forward page="template.jsp"/>

