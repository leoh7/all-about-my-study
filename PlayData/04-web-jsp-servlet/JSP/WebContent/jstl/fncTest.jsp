<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h2> JSTL - functions </h2>

<h3> 문자열 작업 </h3>
<c:set var="str" value="${'Hello JSTL!!!'}"/>
legnth : ${fn:length(str)} <br>		<!-- 태그 안에 () 괄호를 못써서 EL 태그에 넣어서 쓴다 -->
startsWith : ${fn:startsWith(str, "H")} <br>
startsWith : ${fn:startsWith(str, "h")} <br>
toLowerCase : ${fn:toLowerCase(str)} <br>
startsWith : ${fn:startsWith(fn:toLowerCase(str), "h")} <br>
substring : ${fn:substring(str, 6, 13)} <br>

<h4> 합치기 </h4>
<c:set var="m" value="<%=new int[] {10,20,30,40,50}%>"/> 	<!-- 자바에게 배열은 손을 벌려야 한다 했음 -->
join : ${fn:join(m, "-")} <br>								<!-- 델리미터로 한데 묶기 -->

<h4> 나누기 </h4>
<c:set var="w" value="${fn:join(m, '-')}"/>
<c:forTokens var="t" items="${w}" delims="-">
	${t} &nbsp;
</c:forTokens>

<h4> 스플릿 </h4>
<c:set var="a" value="${'10,20,30,40,50'}"/> 		<!-- 이건 배열 아니고 그냥 문자열임 -->
<c:forEach var="t" items="${fn:split(a, ',')}">		<!-- items 에 배열이나 컬렉션을 줄 수 있는게 상당히 유용하다 -->
	${t} &nbsp;
</c:forEach>
<br>
split : ${fn:split(a, ',')} <br>				<!-- 자르면 객체 배열이 되고, 배열이라는 개념이 여기 없으니 그냥 객체가 됨 -->

<h4> trim </h4>
<c:set var="s" value="${'            a            a         a           '}"/>
trim : <pre>${s}</pre> <br>
trim : <pre>${fn:trim(s)}</pre> <br>


<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>





