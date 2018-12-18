<%@page import="el.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>EL - 처리 페이지 - Form - Pro</h2>

<%
	request.setCharacterEncoding("utf-8");
%>

<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String gender = request.getParameter("gender");
	String hobby[] = request.getParameterValues("hobby");
%>
이름 : <%=name%> <br>
나이 : <%=age%> <br>
성별 : <%=gender.equals("1") ? "남자" : "여자"%> <br>
취미 : <%=hobby[0]%> <br>

<br><br>

이름 : ${param.name} <br>
나이 : ${param.age} <br>
성별 : ${param.gender eq '1' ? '남자' : '여자'} <br>
취미 : ${paramValues.hobby[0]} <br>

<br><br>
<%
	request.setAttribute( "id", "aaa" );
	session.setAttribute( "id", "bbb" );
	application.setAttribute( "id", "ccc" );
%>
스크립트릿<br>
request : <%=request.getAttribute( "id" )%> <br>
session : <%=session.getAttribute( "id" )%> <br>
application : <%=application.getAttribute( "id" )%> <br>

<br><br>
EL 태그<br>
request : ${requestScope.id} <br>
session : ${sessionScope.id} <br>
application : ${applicationScope.id} <br>
<%-- 
<br><br>
데이터를 넣고 꺼내오는 용도로도 쓰일 수 있음(출력은 덤)<br>
${requestScope.passwd = '111'} <br>
${sessionScope.passwd = '222'} <br>
${applicationScope passwd = '333'} <br>

<br>
꺼내오기<br>
request : ${requestScope.passwd} <br>
session : ${sessionScope.passwd} <br>
application : ${applicationScope.passwd} <br>
${passwd}
 --%>
<%
	Cookie id = new Cookie("id", "aaa");
	Cookie passwd = new Cookie("passwd", "111");
	// 쿠키는 반드시 클라이언트에 써줘야 한다
	response.addCookie(id);
	response.addCookie(passwd);
%>

${cookie.id.name} - ${cookie.id.value} <br>
${cookie.passwd.name} - ${cookie.passwd.value} <br>

<br>

<h2> Bean Class </h2>
 <%
 	User hong = new User();
 	hong.setName(request.getParameter("name"));
 	hong.setAge(Integer.parseInt(request.getParameter("age")));
 	hong.setGender(request.getParameter("gender"));
 	hong.setHobby(request.getParameterValues("hobby"));
 %>
이름 : <%=hong.getName()%> <br>
나이 : <%=hong.getAge()%> <br>
성별 : <%=hong.getGender().equals("1") ? "남자" : "여자" %> <br>
취미 : <%=hong.getHobby()[0]%> <br>

<br><br>
<jsp:useBean id="kim" class="el.User"/> <!-- 객체를 생성할 순 있는데, 생성자를 디폴트로밖에 못 써, 그래서 잘 안씀 -->
	<jsp:setProperty property="*" name="kim"/>
이름 : <%=kim.getName()%> <br>
나이 : <%=kim.getAge()%> <br>
성별 : <%=kim.getGender().equals("1") ? "남자" : "여자" %> <br>
취미 : <%=kim.getHobby()[0]%> <br>

<br><br>
이름 : ${kim.getName()} <br>
이름 : 객체가 EL 태그를 쓸 수 있는 상황이라면 <br>
	${kim.name} <br>
나이 : ${kim.age} <br>
성별 : ${kim.gender == '1' ? '남자' : '여자'} <br>
취미 : ${kim.hobby[0]} <br>

<!-- 근데 생성자를 디폴트로만 쓸꺼면 이렇게도 할 수 있단 소리 -->

<jsp:useBean id="date" class="java.util.Date"/>
시각 : ${date} <br> <!-- TODO : 이거 왜 이렇게 되는 건지 자바적으로 찾아보자 -->