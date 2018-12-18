<%@page import="memberStudy.LogonDBBean"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="memberStudy.LogonDataBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp" %>
<script src="<%=project%>script.js"></script>

<h2><%=page_input%></h2>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="memberDto" class="memberStudy.LogonDataBean"/>
	<jsp:setProperty name="memberDto" property="*"/>
	<!-- id, passwd, name, jumin1, jumin2 -->
	<!-- tel(tel1,tel2), email(email1, email2) 은 가공해야함 -->
	<!-- 추가: zipcode(zipcode1+zipcode2), address(address1+address2) 가공 및 입력 -->

<%
	String zipcode = null;
	String zipcode1 = request.getParameter("zipcode1");
	String zipcode2 = request.getParameter("zipcode2");
	zipcode = zipcode1+"-"+zipcode2;
	memberDto.setZipcode(zipcode);
%>

<%
	String address = null;
	String address1 = request.getParameter("address1");
	String address2 = request.getParameter("address2");
	address = address1 + address2;
	memberDto.setAddress(address);
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

<%
	// DB 처리 Bean 의 객체 가져오기
	LogonDBBean memberDao = LogonDBBean.getInstance();
	// 0 아니면 1이 넘어옴
	int result = memberDao.insertMember(memberDto);
	if(result == 0) {
		// 가입 실패 / DB 에러 아니면 이거 뜰 일은 없다.
		%>
		<script type="text/javascript">
			<!--
			erroralert(inputerror);
			//-->
		</script>
		<%
	} else { 
		// 가입 성공
		// 확인해보라고 로그온 페이지로 넘기기
		// 원래 loginForm.jsp 로 보내야 하는데 확인을 위해 main.jsp 로 보낸다
	//	response.sendRedirect("loginForm.jsp");
		
		%>
		<script type="text/javascript">
			<!--
			alert(input_ok);
			//-->
		</script>
		<meta http-equiv="fresh" content="0;url=login.jsp">
		<%
	}
%>