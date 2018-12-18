<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<h2> JDBC - select - 입력 페이지 </h2>
	
	<form method="post" action="selectTest.jsp">
		<table>
			<tr>
				<td colspan="2">
				입력하면 해당 아이디 출력 <br>
				입력하지 않으면 전체 출력
				</td>
			</tr>
			
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="확인">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>