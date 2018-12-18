<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2> Event / DOM </h2>
<script type="text/javascript">
// JavaScript 는 정적인 이벤트 처리(static) Jquery 는 동적인 이벤트 처리(dynamic)

//<!--

//////Document Object Model DOM
//////설명 파일 밑에 있는건 DOM을 우리가 만들고 조정할 수 있는거
//// Window 객체
// 윈도우는 전체 창을 의미
// self와 opener, open 중요 / 나중에 볼 것
	// 의미 없음 : window.status = "Event";

//// Document 객체
// title 정도는 해보자
// Document는 현재 창을 의미
	//document.title = "Event";
	
	
	// 다 써먹을 메서드니깐 주목해서 볼것
	function clock() {
		var date = new Date();
		var now = date.getHours() + " : " + date.getMinutes() + " : " + date.getSeconds();
		document.title = now;
		// setTimeout은 재귀호출로 1초 / 일정시간 뒤에 이 메서드를 한번만 호출하게 되어있음
		// 이건 한번만 호출한다.
		//setTimeout("clock()", 1000);
		var m = ["red","yellow","blue","green","pink","gray"];
		// 반복돌릴 때 쓰는 방식 5로 나누면 4까지 밖에 안나오니까 0부터 5번 방중에 하나씩 실행해라가 되는거야
//		document.bgColor = m[date.getSeconds() % 5];
	}
	clock();	// setInterval 을 하면 1초 뒤에 실행 되서 일부러 clock() 을 살려놨다.
	// 이건 계속해서 하는 것. / 실시간 처리할 때 써야되기 때문에 잘 알아두는 것이 좋다.
	setInterval("clock()", 1000);

	// Form 객체용
	
	// onload 란 = 창이 뜨자마자 호출해라
	window.onload = function() {
		document.inputform.color.focus();
	}
	
	function setColor() {
		// 한 페이지에 document는 하나여서 생략이 가능하지만 그 밑에 것들은 이름이 필요하다 
		var c = document.inputform.color.value;
		//if(c == "") { 이게 생략이 가능하네 와
		if( c ) {
			document.bgColor= document.inputform.color.value;
		} else {
			document.bgColor = "white";
		}
	}
		
	function add() {
		document.inputform.result.value
			= eval(document.inputform.a.value) + eval(document.inputform.b.value);
	}
	function sub() {
		inputform.result.value
			= eval(inputform.a.value) - eval(inputform.b.value);
	}
	function mul() {
		inputform.result.value
			= eval(inputform.a.value) * eval(inputform.b.value);
	}
	function div() {
		inputform.result.value
			= eval(inputform.a.value) / eval(inputform.b.value);
	}
//// Form 객체
// value 를 많이 씀

//// Select checkbox radio는 조금 달라
// select
function goSite() {
	// window.location 의 window는 생략 가능
	location = inputform.site.options[/*index자리*/inputform.site.selectedIndex].value;
}
// checkbox
function myhobby() {
	// div의 id를
	var result = document.getElementById("result");
	var msg = "취미는";
	for(var i=0; i</*몇개를 선택할 수 있는지를 모른다 checkbox의 length*/inputform.hobby.length; i++) {
		if(inputform.hobby[i].checked/*체크가 되있는지 안되있는지 확인 가능*/) {
			msg += inputform.hobby[i].value + " ";
		}
	}
	msg +="입니다<br><br><br>";
	// innerHTML = 공간을 추가해서 출력해주는 것.
	result.innerHTML = msg;
}

//-->
</script>

<Form name="inputform">
<!-- checkbox -->
	<div id="result">
	</div>
	취미 : <input type="checkbox" name="hobby" value="등산"> 등산
	<input type="checkbox" name="hobby" value="낚시"> 낚시
	<input type="checkbox" name="hobby" value="게임"> 게임
	<input type="checkbox" name="hobby" value="독서"> 독서
	<input type="button" value="선택" onclick="myhobby()">
	<br>
	<!-- select -->
	목록 : <select name="site">
		<option value="http://www.naver.com">네이버</option>
		<option value="http://www.daum.com">다음</option>
		<option value="http://www.google.com">구글</option>
		<option value="http://www.w3schools.com">w3스쿨</option>
		<option value="http://naver.me/Gym1JiMG">집에</option>
	</select>
	<input type="button" value="가자" onclick="goSite()">
	<br>
	



	연산 : <input type="text" name="a">
			, <input type="text" name="b">
			= <input type="text" name="result" readonly>
		<input type="button" value="+" onclick="add()">
		<input type="button" value="-" onclick="sub()">
		<input type="button" value="*" onclick="mul()">
		<input type="button" value="/" onclick="div()">
		<br>

<!-- #은 자기 페이지를 의미 --> 
	글자 : <a href="#" onmouseover="javascript:document.fgColor='red'">빨간색</a> <br>
		<a href="#" onmouseover="document.fgColor='blue'" onmouseout="document.bgColor='black'">파란색</a> <br>
		<a href="#" onmouseover="document.bgColor='yellow'">노란색</a> <br>
		<a href="#" onmouseover="document.bgColor='green'">초록색</a> <br>

<br><br>
	색상 : <input type="text" name="color">
			<input type="button" value="선택" onclick="setColor()">
</Form>













