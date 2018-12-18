<%@page import="bean.SimpleBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h2> 액션태그 - useBean - 처리 페이지 </h2>
    
<%
	request.setCharacterEncoding("utf-8");
%>
<br>

<!-- useBean 도 안 쓰고, javaBean 클래스도 안 쓰고 -->
<% 
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String tel = request.getParameter("tel");
	String address = request.getParameter("address");
%>

이름 : <%=name%> <br>
나이 : <%=age%> <br>
전화번호 : <%=tel%> <br>
주소 :  <%=address%> <br>
<br>

<!-- useBean 은 안 쓰고, javaBean 은 쓰고 -->
	<jsp:useBean id="bean" class="bean.SimpleBean" scope="session"/>
<%
//	SimpleBean bean = new SimpleBean();		// 근데 위처럼 useBean 액션태그를 써도 호환이 으음청 잘된다.
	
	bean.setName(request.getParameter("name"));
	bean.setAge(Integer.parseInt(request.getParameter("age")));
	bean.setTel(request.getParameter("tel"));
	bean.setAddress(request.getParameter("address"));
%>


이름 : <%=bean.getName()%> <br>
나이 : <%=bean.getAge()%> <br>
전화번호 : <%=bean.getTel()%> <br>
주소 : <%=bean.getAddress()%> <br>
<br>

<!-- useBean 도 쓰고, javaBean 도 쓰고 -->
	<!-- new 가 아닌 객체를 생성하는 방법이 나와. JSP에선 또 다르다. EL 태그 가면 또 나올거지만 뭐 쨌든 -->
<%--
<jsp:setProperty property="name" name="bean"/>
<jsp:setProperty property="age" name="bean"/>
<jsp:setProperty property="tel" name="bean"/>
<jsp:setProperty property="address" name="bean"/>
 --%>
 
<jsp:setProperty property="*" name="bean"/>
이름 : <jsp:getProperty property="name" name="bean"/> <br>
나이 : <jsp:getProperty property="age" name="bean"/> <br>
전화번호 : <jsp:getProperty property="tel" name="bean"/> <br>
주소 : <jsp:getProperty property="address" name="bean"/> <br>

<jsp:forward page="simpleBeanView.jsp"/>