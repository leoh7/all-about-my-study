<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2> JSTL - core - if / choose </h2>

<c:set var="a" value="${8}"/>
<c:if test="${a gt 5}">
	크다 <br>
</c:if>
<c:if test="${a le 5}">
	작다 <br>
</c:if>

<br>

<!-- switch case 역할을 하는 choose -->

<c:set var="b" value="${1}"/>
<c:choose>
	<c:when test="${b eq 1}">
		하나 <br>
	</c:when>
	<c:when test="${b eq 2}">
		둘 <br>
	</c:when>
	<c:when test="${b eq 3}">
		셋 <br>
	</c:when>
	<c:otherwise>
		숫자 <br>
	</c:otherwise>
</c:choose>


<form method="post" action="ifTest.jsp">
	<table border="1">
		<tr>
			<th> 점수 </th>
			<td>
				<input type="text" name="score">
			</td>
			<td>
				<input type="submit" value="확인">
			</td>
		</tr>
	</table>
</form>



<!-- 
90 이상 A학점
80 이상 B학점
70 이상 C학점
60 이상 D학점
60 미만 F학점 
0~100 사이가 아니면 잘못입력 출력
-->
	<!-- 70점 이상이면 합격 아니면 불합격 출력 -->
	<%-- <c:param name="score"/> 이럴 필요가 없다 --%>
<%-- <c:set var="score" value="${param.score}"/> 이렇게 해서  반복되는 param.score 를 score 로만 쓸 수도 있다--%>
<c:if test="${param.score ge 0 && param.score le 100}">
	
	<c:if test="${param.score ge 70}">
		합격 <br>
	</c:if>
	<c:if test="${param.score lt 70}">
		불합격 <br>
	</c:if>
	<c:choose>
		<c:when test="${param.score ge 90}">${param.score} : A학점</c:when>
		<c:when test="${param.score ge 80}">${param.score} : B학점</c:when>
		<c:when test="${param.score ge 70}">${param.score} : C학점</c:when>
		<c:when test="${param.score ge 60}">${param.score} : D학점</c:when>
		<c:otherwise>${param.score} : F학점</c:otherwise>
	</c:choose>
</c:if>
<c:if test="${param.score lt 0 || param.score gt 100}">
	잘못입력 <br>
</c:if>

