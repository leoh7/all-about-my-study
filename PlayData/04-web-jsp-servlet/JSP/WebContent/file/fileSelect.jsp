<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>



<div class="container">
	<h2> 파일업로드  - 선택 페이지</h2>
	<form method="post" action="fileUpload.jsp" enctype="multipart/form-data">
		<table class="table table-dark">
			<tr>
				<th> 이름  </th>
				<td> <input class="form-control" type="text" name="name"></td>
			</tr>
			<tr>
				<th> 제목  </th>
				<td> <input class="form-control" type="text" name="title"></td>
			</tr>
			<tr>
				<th rowspan="2"> 파일  </th>
				<td> <input class="form-control" type="file" name="upload1"></td>
			</tr>
			<tr>
				<td> <input class="form-control" type="file" name="upload2"></td>
			</tr>
			<!-- <div class="container"> -->
				<tr>
					<th colspan="2" align="center"> 
						<input class="btn btn-secondary" type="submit" value="전송">
						<input class="btn btn-secondary" type="reset" value="취소">
					</th>
				</tr>
			<!-- </div> -->
		</table>
	</form>
</div>
