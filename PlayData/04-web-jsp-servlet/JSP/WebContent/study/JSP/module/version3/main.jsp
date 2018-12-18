<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2> 메인 페이지 </h2>


<form method="post" action="control.jsp">
	<input type="hidden" name="indexIs" value="1">
	<table border="1">
		<tr>
			<th colspan="2">
				제품을 선택해 주세요.
			</th>
		</tr>
		
		<tr>
			<th>제품</th>
			<td>
				<input type="radio" name="control" value="tv">텔레비젼<br>
				<input type="radio" name="control" value="pc">컴퓨터<br>
				<input type="radio" name="control" value="dc">디지털카메라<br>
			</td>
			
		</tr>
		
		<tr>
			<th colspan="2">
				<input type="submit" value="확인">
				<input type="reset" value="취소">
			</th>
		</tr>
	</table>
</form>