<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp" %>
<script src="<%=project%>script.js"></script>


<jsp:useBean id="memberDto" class="memberStudy.LogonDataBean"/>
	<jsp:setProperty name="memberDto" property="*"/>
	
<%
	// tel 가공 / 자바스크립트에서 유효성검사를 이미 했기 때문에 안해도 되지만 해주기로
	String tel = null;
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	if(!tel1.equals("") && !tel2.equals("") && !tel3.equals("")) {
		tel = tel1 + "-" + tel2 + "-" + tel3;
	}
	
	memberDto.setTel(tel);
%>

<%
	// email
	String email = null;
	String email1 = request.getParameter("email1");
	String email2 = request.getParameter("email2");
	if(!email1.equals("")) {
		if(email2.equals("0")) {
			// 직접입력의 경우
			email = email1;
		} else {
			// 선택입력의 경우
			email = email1 + "@" + email2;
		}
	}
	memberDto.setEmail(email);
%>

<%
	// reg_date
	memberDto.setReg_date(new Timestamp( System.currentTimeMillis() ) );
%>

<!-- id, passwd, name, jumin1, jumin2 -->
<!-- tel(tel1,tel2), email(email1, email2) 은 가공해야함 -->

id : <%=memberDto.getId() + "<br>"%>
passwd : <%=memberDto.getPasswd() + "<br>"%>
name : <%=memberDto.getName() + "<br>"%>
jumin1 : <%=memberDto.getJumin1() + "<br>"%>
jumin2 : <%=memberDto.getJumin2() + "<br>"%>
tel : <%=memberDto.getTel() + "<br>"%>
email : <%=memberDto.getEmail() + "<br>"%>