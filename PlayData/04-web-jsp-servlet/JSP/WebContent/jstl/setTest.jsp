<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2> JSTL - core - set / out </h2>

<%
	int a = 10;
%>

expression : <%=a%> <br>
EL : ${a} (null에 관대하여 에러가 안나는 것이 보인다)<br>

<!-- var 은 무조건 새로 변수를 만드는 것이다 -->
<c:set var="a" value="20"/>
EL : ${a} <br>
out : <c:out value="a"/> <br> <!-- 값이 a라고 한 것임. 변수 a를 부른것이 아니라 -->
out : <c:out value="${a}"/> <br> <!-- 이런 식으로 써야 하는데, 어차피 그냥 EL 태그 쓰는 것과 다를바도 없고 불편하니 쓸 일이 없다 -->

<br>
<c:set var="b" value="${10}"/> <!-- 자료형을 확실하게 해주려고 이렇게 하긴하는데 큰 의미는 없음 -->
b : ${b} <br>

<br>
<c:set var="c" value="${'ABC'}"/>
c : ${c} <br>

<br>
<c:set var="d" value='${"ABC"}'/>
d : ${d} <br>

<c:set var="e" value='${ABC}'/>
e : ${e} (자료형에 대한 정보가 아무것도 없으면 / 저런 변수가 있지 않는 이상 아무것도 출력할 수 없다)<br>

<c:set var="f">
	10
</c:set>
f : ${f} <br>

<c:set var="g">
	"ABC"
</c:set>
g: ${g} <br>

<c:set var="h">
	${"ABC"}
</c:set>
h : ${h} <br>

<c:set var="i" value="<%=a%>"/><!--  자바 쪽 영역을 잡아서 쓸 수 있다는 것
그건 자바의 모든 코드들을 쓸 수 있다는 것 -->
i : ${i} <br>

<c:set var="now" value="<%=new java.util.Date()%>"/>
now : ${now} <br>
<c:set var="r" value="<%=new Random()%>"/>
r : ${r.nextInt(46) + 1} <br>

<c:set var="num" value="10"/>
<!-- 똑같은 변수를 또 쓰면 충돌이 나는게 아니라 값이 덮어씌워짐 -->
<c:set var="num" value="50"/>
num : ${num} <br>

<c:remove var="num"/>
num : ${num} <br>