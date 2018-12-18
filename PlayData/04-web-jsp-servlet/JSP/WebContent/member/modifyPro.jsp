<%@page import="member.LogonDBBean"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="member.LogonDataBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp" %>
<script src="<%=project%>script.js"></script>

<h2><%=page_modify%></h2>

<jsp:useBean id="memberDto" class="member.LogonDataBean"/>
	<!-- 받는건 passwd 밖에 없지만 그래도 바구니로 던지는게 편하다 -->
	<jsp:setProperty name="memberDto" property="*"/>
	
<%
//	String id = (String)session.getAttribute("memid");
//	String passwd = request.getParameter("passwd");
//	memberDto.setId(id);
//	memberDto.setPasswd(passwd); 
	memberDto.setId((String)session.getAttribute("memid"));
%>

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
	if(!email1.equals("") && !email2.equals("")) {
		email = email1 + "@" + email2;	
	}
	memberDto.setEmail(email);
%>

<%
	// DB 처리 Bean 의 객체 가져오기
	LogonDBBean memberDao = LogonDBBean.getInstance();
	// 0 아니면 1이 넘어옴
	int result = memberDao.modifyMember(memberDto);
%>

<%	
	if(result == 0) {
		// 수정 실패 / DB 에러 아니면 이거 뜰 일은 없다.
		%>
		<script type="text/javascript">
			<!--
			erroralert(modifyerror);
			//-->
		</script>
		<meta http-equiv="refresh" content="0;url=main.jsp">
		<%
	} else { 
		// 가입 성공
		// 확인해보라고 로그온 페이지로 넘기기
		// 원래 loginForm.jsp 로 보내야 하는데 확인을 위해 main.jsp 로 보낸다
		// response.sendRedirect("main.jsp");
		%>
		<script type="text/javascript">
			<!--
			alert(modify_ok);
			//-->
		</script>
		<meta http-equiv="refresh" content="0;url=main.jsp">
		<%
	}
%>