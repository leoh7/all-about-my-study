<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
<body>
	<h2> 새로운 태그 </h2>
	
	<form oninput="result.value=parseInt(a.value)+parseInt(b.value)">
		<input type="text" name="a" value="0">
		+ <input type="text" name="b" value="0">
		= <output name="result"/>
	</form>	
	<br><br>
	
	0<progress max="10" value="7"></progress>10
	<br><br>
	
	0<meter min="0" max="10" low="4" high="7" value="5"></meter>10
	<br><br>
	<div contenteditable="true">
		<div> 편집가능 </div> <br>
		<div contenteditable="false"> 편집불가능 </div> <br>
	</div>
</body>
</html>