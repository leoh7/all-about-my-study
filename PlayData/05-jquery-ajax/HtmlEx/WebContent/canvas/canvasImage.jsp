<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
<body>
	<style type="text/css">
		canvas{
			border : 2px solid red;
			width : 400px;
			height : 300px;
		}
	</style>
	
	<canvas id="cvs"></canvas>

	<script type="text/javascript">
	//<!--
		window.onload = function(){
			var cvs = document.getElementById("cvs");
			var ctx = cvs.getContext("2d");
			
			var img = new Image();
			img.src = "/HtmlEx/data/";
			img.onload function(){
				ctx.drawImage(img, 0, 0);
			}
	}
	//-->
	</script>

</body>
</html>