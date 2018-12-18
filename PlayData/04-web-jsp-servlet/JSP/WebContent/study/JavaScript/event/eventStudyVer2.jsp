<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<form name="form">
	<table border="1">
		<!-- default 문제 갯수는 10개로 하자 -->
<script type="text/javascript">
	
	// TO-DO
	// 클래스로 만들고, 이벤트에서 queCnt를 선택할 수 있게 한 다음, 클래스를 호출한다?

// 기본 옵션
	var queCnt;	// 문제 갯수
// 불변 변수
	var numA = new Array();	// 곱셈 재료 1 배열
	var numB = new Array();	// 곱셈 재료 2 배열
	var result = new Array();		// 답 배열
	var outQue = new Array();		// 표출되는 문제 문자열
	var valArr = new Array();
// 가변 변수
	var inputValue = new Array();		// 입력값 배열
	var resultCnt = new Array();	// 맞은 갯수 배열
	var resultCorrectCnt = new Array();

	queCnt = 2;
	for(var i=0; i<queCnt; i++) {
		numA[i] = parseInt(Math.random()*9)+1;
		numB[i] = parseInt(Math.random()*9)+1;
		result[i] = numA[i]*numB[i];
		outQue[i] = numA[i] + " * " + numB[i] + " = ";
		valArr[i] = String("val"+i);
		// 디버깅
		document.write(valArr[i]);
	}
	
	function getQueCnt() {
		
	}
	
	// 문제 <tr>들 생성
	for(var i=0; i<queCnt; i++) {
		document.write("<tr>")
		document.write(		"<td>");
		document.write(outQue[i]);
		document.write(		"</td>");		
		document.write(		"<td>");		
		document.write(			"<input id='"+valArr[i]+"' type='text'>"+valArr[i]);			
		document.write(		"</td>");		
		document.write("</tr>");
	}
	function setInputValue () {
		for(var i=0; i<queCnt; i++) {
	//		var cnt = String(eval("val"+i));
	//		inputValue[i] = document.getElementById(cnt);
	//		document.write(inputValue[i]);
	//		document.write(cnt);
			
	//		var cnt = new Array();
	//		cnt = String(eval("val"+i));
	//		document.write(cnt);
			inputValue[i] = document.getElementById(valArr[i]).value;
			document.write(inputValue[i]+"<br>");
			
			
		}
	}
	
</script>
		<tr>
			<th colspan="2">
				<input type="button" value="제출" onclick='setInputValue()'>
				<input type="reset" value="취소">
			</th>
		</tr>
	</table>
맞은 개수 : <input type="text" name="resultCorrect" readonly><br>
점수 : <input type="text" name="result" readonly><br>
</form>