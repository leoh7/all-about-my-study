<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2> Canvas Element</h2>
	
	<style type="text/css">
	<!--
		canvas {
			border : 2px solid blue;
			width : 500px;
			height : 500px;
		}
	-->
	</style>
	
	<canvas id="cvs"></canvas>
	
	<script type="text/javascript">
	//<!--
		var cvs = document.getElementById('cvs');
		var ctx = cvs.getContext('2d');
		
		// 사각형
		ctx.fillStyle = 'yellow';
		ctx.fillRect(10, 10, 50, 50);
		ctx.strokeRect(70, 10, 50, 50);
		ctx.clearRect(40, 40, 50, 50);
	
		// 선긋기
		ctx.lineWidth = "5";
		ctx.lineCap = "round";
		ctx.beginPath();
		ctx.lineTo(10, 50);
		ctx.lineTo(200, 50);
		ctx.lineTo(100, 100);
		ctx.lineTo(10, 50);
		ctx.stroke();
		
		ctx.moveTo(200, 70);
		
		ctx.lineTo(200, 70);
		ctx.lineTo(200, 200);
		ctx.stroke();
		
		// 글자넣기
		ctx.fillStyle = "red";
		ctx.font = "15px Gothic";
		ctx.textAlign("left");
		ctx.fillText("Hello", 250, 20);
		
		ctx.closePath();
	//-->
	</script>
</body>
</html>