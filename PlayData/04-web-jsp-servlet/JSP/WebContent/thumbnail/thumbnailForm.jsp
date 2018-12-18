<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<h2> 섬네일 이미지 - 입력 페이지 </h2>

<div class=container>
	<form method="post" enctype="multipart/form-data" action="thumbnailPro.jsp">
		<table class="table table-dark">
			<tr>
				<th> 이름 </th>
				<td> <input type="text" name="name"> </td>
			</tr>
			
			<tr>	
				<th> 제목 </th>
				<td> <input type="text" name="title"> </td>
			</tr>
			
			<tr>
				<th> 이미지 </th>
				<td> 
					<input type="file" name="image1"> 
					<input type="file" name="image2"> 
				</td>
			</tr>
			
			<tr>
				<td colspan="2"> 
					<input type="submit" value="전송"> 
					<input type="reset" value="취소"> 
				</td>
			</tr>
			
		</table>
	</form>
</div>