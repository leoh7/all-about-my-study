<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h2> JavaScript 구구단 문제 </h2>
    
    
<script type="text/javascript">
	var SIZE = 10;
	var m = [];
	for( var i=0; i<SIZE; i++) {
		// 행이 10개
		m[i] = [];
		m[i][0] = parseInt(Math.random()*9) + 1;
		m[i][1] = parseInt(Math.random()*9) + 1;
		m[i][2] = m[i][0]*m[i][1];
	}
	
	var cnt=0, sum=0;
	
	function start() {
		
		document.write("<form name='inputform'>");
		document.write("<table border='1'>");
		for(var i=0; i<SIZE; i++) {
			document.write("<tr>");
				document.write("<td>");
				document.write(m[i][0]+" * "+m[i][1]+" = ");
				document.write("</td>");
				document.write("<td>");
				document.write("<input type='text' name='id_"+i+"'>");
				document.write("</td>");
			document.write("</tr>");
		}
		document.write("<tr>");
			document.write("<th colspan='2'>");
			document.write("<input type='button' value='제출' onclick='calc()'>");
			document.write("<input type='reset' value='취소'>");
			document.write("</th>");
		document.write("</tr>");
		document.write("<table border='1'>");
		document.write("<br>맞은개수 :<input type='text' name='cnt' readonly><br>");
		document.write("<br>점수 :<input type='text' name='sum' readonly><br>");
		document.write("</form>");
	}
	function calc () {
		for(var i=0; i<SIZE; i++) {
			if(m[i][2] == eval("inputform.id_"+i+".value")) {
				cnt++;
				sum += 100/SIZE;
			}
		}
		inputform.cnt.value = cnt;
		inputform.sum.value = sum;
	}




</script>
<body onload='start()'>
	
</body>














