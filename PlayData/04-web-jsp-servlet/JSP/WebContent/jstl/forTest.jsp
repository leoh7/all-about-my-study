<%@page import="java.util.HashMap"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <h2>JSTL - core - forEach / forTokens </h2>
    
<h3>forEach 쓰기</h3>
<c:forEach var="i" begin="1" end="10">
	${i} &nbsp;
</c:forEach>
<br>

<c:forEach var="i" begin="1" end="10" step="2">
	${i} &nbsp;
</c:forEach>
<br>


<h3> 감소를 쓰는 방법 </h3>
<c:set var="num" value="10"/>
<c:forEach var="i" begin="1" end="10">
	${num} &nbsp;
	<c:set var="num" value="${num-1}"/>
</c:forEach>
<br>

<h3> item 쓰기 </h3>
자바로 하는 방법 <br>
<%
	int m[] = {10,20,30,40,50,60,70};
%>
<%
	for(int a : m){
		%>
			<%=a%>&nbsp;
		<%
	}
%>
<br>
아이템에는 배열이나 컬렉션을 넣을 수 있다. 자바랑 똑같음 <br>
<c:set var="m" value="<%=new int[] {10,20,30,40,50,60,70}%>"/>
<c:forEach var="a" items="${m}">
	${a} &nbsp;
</c:forEach>
<br>

자바스크립트로 했던 for in 반복문 <br>
<script type="text/javascript">
//<!--
	var m = [10,20,30,40,50,60,70];
	for( var a in m ){
		document.write(a + "&nbsp");
	}
//-->
</script>
<br>

<h3>컬렉션으로 해보기</h3>
<h4>vector</h4>
<%
	Vector<String> v = new Vector <String>();
	v.add("홍길동");
	v.add("이순신");
	v.add("김유신");
	v.add("대조영");
%>
<c:set var="v" value="<%=v%>"/>
${v.add("강감찬")}	<!-- 이렇게 해버리면 리턴이 출력이 되버려 / 대신 값은 정상적으로 들어가는 것이 보인다 -->
<c:forEach var="b" items="${v}">
	${b} &nbsp;
</c:forEach>

<h4>map</h4>
<%
	HashMap<Integer, String> map = new HashMap<Integer, String>();
	map.put(9, "홍길동");
	map.put(7, "김유신");
	map.put(0, "이순신");
	map.put(5, "대조영");
%>
<c:forEach var="map" items="<%=map%>">
	${map.key} : ${map.value} &nbsp;&nbsp;
</c:forEach>
<br>
<h3>forTokens</h3>

<c:forTokens var="str" items="${'1,2,3,4,5,6,7'}" delims="${','}">
	${str} &nbsp;
</c:forTokens>
<br><br>

<h2> 예 제 </h2>
23,43,21,25,65,73,65,68,36,98 한방에 입력 받아서 점수 합계와 평균 출력 <br>


<form method="post" action="forTest.jsp">
	점수들 : <input type="text" name="scores"><input type="submit" value="전송">
	
</form>
<br><br>
<c:set var="sum" value="${0}"/>
<c:set var="cnt" value="${0}"/>
<c:forTokens var="score" items="${param.scores}" delims="${','}">
	점수 : ${score} &nbsp;
	<c:set var="sum" value="${sum+score}"/>
	<c:set var="cnt" value="${cnt+1}"/>
</c:forTokens>
<br>
	합계 : ${sum} <br>
	평균 : ${sum / cnt} <br>
	
	

<h2>구구단</h2>
<h3>구구단 가로</h3>
<table border="1">
<c:forEach var="i" begin="2" end="9">
	<tr>
	<c:forEach var="j" begin="1" end="9">
		<td>${i} * ${j} = ${i*j} </td>
		<c:set var="j" value="${j+1}"/>
	</c:forEach>
	</tr>
</c:forEach>
</table>
<h3>구구단 세로</h3>
<table border="1">
<c:forEach var="i" begin="1" end="9">
	<tr>
	<c:forEach var="j" begin="2" end="9">
		<td>${j} * ${i} = ${i*j} </td>
		<c:set var="j" value="${j+1}"/>
	</c:forEach>
	</tr>
</c:forEach>
</table>













