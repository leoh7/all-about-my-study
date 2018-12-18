<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>JDBC - update - 입력페이지</h2>

<form method="post" action="updateTestPro.jsp">
	<table border="1">
		<tr>
			<th> 아이디 </th>
			<td> <input type="text" name="id" maxlength="20"> </td>
		</tr>
		<tr>
			<th> 비밀번호 </th>
			<td> <input type="password" name="passwd" maxlength="20"> </td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>