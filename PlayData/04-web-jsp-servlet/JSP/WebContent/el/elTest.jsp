<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

    <h2> Expression Language</h2>
    
<%
	int a=5, b=2;
%>
a + b = <%out.println(a+b);%> <br>
a + b = <%=a + b%> <br>
a + b = ${a + b} <br>	<!-- EL 태그는 자바영역이 아니라 출력이 안된다! -->
						<!-- 반드시 EL 변수는 JSTL로 정의해야 한다 / 변수 공유는 JSTL 과만 됨(java 안됨)-->
a + b = ${5 + 2} <br> 	<!-- 값이 나온다 -->
<p>
<!-- 연산 가능 언어 / 자바, 자바스크립트, EL -->
<div class="container">
<table class="table table-dark">
	<thead>
		<tr>
			<th >언어</th>
			<th>"5 + 2" = </th>
			<th>"5" + 2 = </th>
			<th>"5" + "2" = </th>
			<th>5 + 2 = </th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>자바 </td>
			<td><%="5 + 2"%> </td>
			<td><%="5" + 2%> </td>
			<td><%="5" + "2"%> </td>
			<td><%=5 + 2%> </td>
		</tr>
		<tr>
			<td>자바 스크립트 </td>
			<td><script>document.write("5 + 2");</script> </td>
			<td><script>document.write("5" + 2);</script> </td>
			<td><script>document.write("5" + "2");</script> </td>
			<td><script>document.write(5 + 2);</script> </td>
		</tr>
		<tr>
			<td>EL 태그 <%="${ }"%> </td>
			<td>${"5 + 2"} </td>
			<td>${"5" + 2} </td>
			<td>${"5" + "2" } </td>
			<td>${5 + 2} </td>
		</tr>
	</tbody>
	
	<thead>
		<tr>
			<th>언어</th>
			<th>"5 - 2" = </th>
			<th>"5" - 2 = </th>
			<th>"5" - "2" = </th>
			<th>5 - 2 = </th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>자바 </td>
			<td><%="5 - 2"%> </td>
			<td>"5" - 2 는 에러 </td>
			<td>"5" - "2" 는 에러 </td>
			<td><%=5 - 2%> </td>
		</tr>
		<tr>
			<td>자바 스크립트 </td>
			<td><script>document.write("5 - 2");</script> </td>
			<td><script>document.write("5" - 2);</script> </td>
			<td><script>document.write("5" - "2");</script> </td>
			<td><script>document.write(5 - 2);</script> </td>
		</tr>
		<tr>
			<td>EL 태그 <%="${ }"%> </td>
			<td>${"5 - 2"} </td>
			<td>${"5" - 2} </td>
			<td>${"5" - "2" } </td>
			<td>${5 - 2} </td>
		</tr>
	</tbody>
	
	<thead>
		<tr>
			<th>언어</th>
			<th>"5 / 2" = </th>
			<th>"5" / 2 = </th>
			<th>"5" / "2" = </th>
			<th>5 / 2 = </th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>자바 </td>
			<td><%="5 / 2"%> </td>
			<td>"5" / 2 는 에러? </td>
			<td>"5" / "2" 는 에러? </td>
			<td><%=5 / 2%> </td>
		</tr>
		<tr>
			<td>자바 스크립트 </td>
			<td><script>document.write("5 / 2");</script> </td>
			<td><script>document.write("5" / 2);</script> </td>
			<td><script>document.write("5" / "2");</script> </td>
			<td><script>document.write(5 / 2);</script> </td>
		</tr>
		<tr>
			<td>EL 태그 <%="${ }"%> </td>
			<td>${"5 / 2"} </td>
			<td>${"5" / 2} </td>
			<td>${"5" / "2" } </td>
			<td>${5 / 2} </td>
		</tr>
	</tbody>
	
</table>
</div>

${5 > 2} : ${5 gt 2} <br>
${5 < 2} : ${5 lt 2} <br>
${5 >= 2} : ${5 ge 2} <br>
${5 <= 2} : ${5 le 2} <br>
${5 == 2} : ${5 eq 2} <br>
<%-- ${5 != 2} : ${5 ne 2} <br> 에러 아닌데 에러 표시나서 주석처리 --%>

<p>
${true && true} : ${true and true} <br>
${true || true} : ${true or true} <br>


<p>
<%-- ${5 / 2} : ${5 div 2} <br> 에러 아닌데 에러 표시나서 주석처리 --%>
${5 % 2} : ${5 mod 2} <br>

<p>
${5 mod 2 eq 0 ? "짝수" : "홀수"} <br>
${5 mod 2 eq 0 ? '짝수' : '홀수'} <br>












