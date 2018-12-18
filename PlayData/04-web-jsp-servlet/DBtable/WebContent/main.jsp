<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<form>
<!-- 	
	상단구조
		Attribute		Data Type	NN	Ky	Default	Descripton
		table_name									테이블명
		write_date									작성일
		sys_name						PK			시스템이름
		writer						Y				작성자
		table_explain				Y				테이블 설명
		page										페이지 1/n
-->
		<table border="1">
			<tr>
				<th> <%=str_tableName%> </th>
				<td colspan="2"> <input type="text" name="table_name"></td>
				<th rowspan="2"> <%=str_tableTitle%> </th>
				<th> <%=str_date%> </th>
				<td> <input type="text" name="write_date"></td>
				<th rowspan="2"> <%=str_page%></th>
			</tr>
			
			<tr>
				<th> <%=str_sysName%> </th>
				<td colspan="2"> <input type="text" name="sys_name"></td>
				<th> <%=str_writer%> </th>
				<td> <input type="text" name="writer"></td>
			</tr>
			
			<tr>
				<th colspan="2"><%=str_tableExp%></th>
				<td colspan="5"> <input type="text" name="table_explain"> </td>
			</tr>
		
		<!-- no / Attribute / Data Type / NN / ky / Default / Description -->
			<tr>
				<th> <%=str_no%> </th>
				<th> <%=str_attribute%> </th>
				<th> <%=str_dataType%> </th>
				<th> <%=str_nn%> </th>
				<th> <%=str_ky%> </th>
				<th> <%=str_defalut%> </th>
				<th> <%=str_desc%> </th>		
			</tr>
		</table>
	</form>
</body>
</html>