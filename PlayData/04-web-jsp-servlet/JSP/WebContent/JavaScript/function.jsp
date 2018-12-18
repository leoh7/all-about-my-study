<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2> 함수 function </h2>

<script type="text/javascript">
//	<!--
	
	//// function 을 만드는 방법
	// 함수, 익명 함수 => 위치에 차이가 있다.
	// 함수를 만드는 예약어와 클래스를 만드는 예약어가 function 으로 똑같아. 즉 함수 안에 함수를 만드는게 가능하다는 것(내부 함수 / 이건 나중에).
	// 이게 지랄같이 헷갈리게 만든다.
	
	// 자료형이 없으니까 리턴값도 표시를 안한다.
	// 함수 (선언적 함수)
	function hap() {
		var a = 5, b = 2;
		document.write("합 : "+ (a+b) + "<br>");
	}
	hap();
	
	// 익명 함수 / 함수를 변수처럼 다룬다
	var gop = function() {
		var a=5, b=2;
		document.write("곱 : " + (a*b) + "<br>");
	}
	gop();
	
	//++ 함수와 익명 함수의 차이 / 함수의 경우 선언을 통해 쓰기 때문에 선언 위에서 hap() 을 쓰더라도 기능하지만, gop() 의 경우 
	//++ 익명 함수를 선언하기 전에 사용하는게 가능하다.
	
	
	// 매개변수 / 이름만 받는다.
	// C		void cha(int, int)
	// java		void cha(int a, int b)
	// 무슨 자료형을 몇 개를 받느냐가 중요하다. 그러나 얘는 자료형이 없으니깐, 이름만 받으면 되는거야
	function cha(a, b) {
		document.write("차 : " + (a-b) + "<br>");
	}
	/* function cha(a, b, c) {
		document.write("차 : " + (a-b-c) + "<br>");
	} 이렇게 하면 앞에 선언한거에 덮어씌워져 버린다(cha(5,2)가 먹통이 됨). 오버로드가 없다는 증거*/ 
	cha(5,2);
	// 근데 3개를 던지면 필요없는건 버려, 오버로딩이 없다는 소리야, 하나를 던져도 되
	// 하나를 던지면 NaN 이 나온다. Not a Number
	cha(5,3,2);
	cha(5);
	
	
	
	// return / 별거 없음
	function mok(a,b) {
		return a/b;
	}
	document.write("몫 : " + mok(5,2) + "<br>");
	
	document.write("<hr>");
	document.write("<h2>내장함수</h2>");
	//// 내장 함수
	//isNaN() 숫자냐 문자냐를 구분하는 함수
	document.write("isNaN : " + isNaN("123") + "<br>");
	document.write("isNaN : " + isNaN(123) + "<br>");
	document.write("isNaN : " + isNaN("ABC") + "<br>");
	
	//parseInt(), parseFloat()
	document.write("parseInt : " + parseInt(10.5) + "<br>");
	document.write("parseFloat : " + parseFloat(10) + "<br>");
	
	// eval() // 중요 // 엄청 많이씀 // 안에 있는 문자를 값으로 취급해라 // xml, ajax 할 때도 많이 쓸 꺼야
	document.write("eval안씀 : " + ("5+2") + "<br>");
	document.write("eval씀  : " + eval("5+2") + "<br>");
	
	document.write("<hr>");
	document.write("<hr>");
	document.write("<h2>내장객체</h2>");
	//// 내장 객체(Element 라고 부른다.)	// 자바스크립트는 이벤트 때문에 쓰는 거다.
	// 문자열 관리하는 객체(함수)
	// String 객체	// 스타일 주는건 CSS랑 Jquerry 가 할 일.
	document.write("<h3>내장객체 - 문자열 관리하는 객체1</h3>");
	var str = "Hello JavaScript!!!";
	document.write("bold : " + str.bold() + "<br>");
	document.write("italics : " + str.italics() + "<br>");
	document.write("strike : " + str.strike() + "<br>");
	document.write("sub : " + str + "r".sub() + "<br>");
	document.write("sup : " + str + "r".sup() + "<br>");
	document.write("fontcolor : " + str.fontcolor("red") + "<br>");
	document.write("fontsize : " + str.fontsize(5) + "<br>");

	document.write("<h3>내장객체 - 문자열 관리하는 객체2</h3>");
	document.write("charAt : " + str.charAt(6) + "<br>");
	document.write("indexOf : " + str.indexOf('J') + "<br>");
	document.write("substring : " + str.substring(6) + "<br>");
	document.write("concat : " + str.concat("..!!") + "<br>");
	var s = str.split(" ") // 델리미터
	document.write("split : " + s[0] + "<br>");
	document.write("<hr>");
	
	document.write("<h3>내장객체 - 날짜 객체 Date</h3>");
	var date = new Date();
	var now = date.getFullYear() + "년"
				+ (date.getMonth()+ 1) + "월"
				+ date.getDate() + "일"
				+ date.getHours() + "시"
				+ date.getMinutes() + "분"
				+ date.getSeconds() + "초"
				+ date.getDay();
	document.write("현재시각 : " + now + "<br>");
	document.write("<hr>");
	
	document.write("<h3>내장객체 - Array객체 </h3><br>");
	//배열
 	var m = [10,20,30,40,50];
	var w = new Array(50,10,20,40,30);
	document.write("length : "+w.length+"<br>");
	document.write("join : "+w.join()+"<br>");
	document.write("join : "+w.join("/")+"<br>");
	document.write("sort : "+w.sort()+"<br>");
	document.write("reverse : "+w.reverse()+"<br>"); 
	
	
	document.write("<hr>");
	document.write("<h3>내장객체 - Array객체-활용</h3><br>");
	
	// Math
	var y = new Array();
	for(var i=0; i<6; i++) {
		y[i] = (parseInt(Math.random()*45)+1);
		for(var j=0; j<i; j++ ) {
			if(y[i] == y[j]) {
			i--;
			break;
			}
		}
	}
	
//	y.sort(); 데이터를 뒤에 넣으니까 sort가 안되나???
	for(var i in y) {
		document.write(y[i] + "&nbsp;&nbsp;")
	}
	
	document.write("<hr>");
	document.write("<h3>내장객체 - screen</h3>");
	document.write("screen : " + screen.height + "<br>");
	document.write("screen : " + screen.width + "<br>");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	document.write("<br><br><br><br><br><br>");
	
//	-->
</script>
