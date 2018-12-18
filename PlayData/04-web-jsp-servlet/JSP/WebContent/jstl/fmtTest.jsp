<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:requestEncoding value="utf-8"/>

    <h2> JSTL - fmt </h2>
    
<form method="post" action="fmtTest.jsp">
	이름 : <input type="text" name="name">
		<input type="submit" value="전송">
</form>

이름 : ${param.name} <br>


<h3> 숫자 형식 </h3>

<c:set var="num" value="${1234.5678}"/>
   숫자 형식을 표현할 때 사용<br>
 num : 1234.5678 <br>
<table border="1">
	<tr>
    	<td>value</td>            	<td>Number로 형식화될 수치 지정</td>
    </tr>
    <tr>
    	<td>type</td>            	<td>숫자 통화 퍼센트 ( number currency percent )중 지정</td>
    </tr>
    <tr>
    	<td>pattern</td>			<td>사용자가 지정한 형식 패턴 지정</td>
    </tr>
    <tr>
    	<td>currencyCode</td>		<td> ISO 4217 통화 코드 지정. 통화 형식일 때만 적용</td>
    </tr>
    <tr>
    	<td>currencySymbol</td>		<td> 통화 기호 지정. 통화 형식일 때만 적용</td>
    </tr>
    <tr>
    	<td>groupingUsed </td>		<td> 출력에 그룹 분리 기호를 포함할지 여부 지정</td>
    </tr>
</table>
<fmt:formatNumber value="${num}"/><br>
type= number // 					<fmt:formatNumber value="${num}" type="number"/> <br>
type= number, pattern=0000.00 // 	<fmt:formatNumber value="${num}" type="number" pattern="0,000.00"/> <br>
type= currency // 					<fmt:formatNumber value="${num}" type="currency"/><br>
type= currency, currencySymbol=$// 	<fmt:formatNumber value="${num}" type="currency" currencySymbol="$"/><br>
type= percent // 					<fmt:formatNumber value="${num}" type="percent"/><br>
    
<h3>날짜</h3>
<c:set var="now" value="<%=new java.util.Date()%>"/>
<fmt:formatDate value="${now}"/> <br>
type =date			<fmt:formatDate value="${now}" type="date"/> <br>
type =date+ptrn		<fmt:formatDate value="${now}" type="date" pattern="yyyy-MM-dd"/> <br>
type =time			<fmt:formatDate value="${now}" type="time"/> <br>
type =time+ptrn		<fmt:formatDate value="${now}" type="time" pattern="HH:mm:ss"/> <br>
type =both			<fmt:formatDate value="${now}" type="both"/> <br>
type =both+ptrn		<fmt:formatDate value="${now}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/> <br>








<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>













