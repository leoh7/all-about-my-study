<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2> JSON </h2>

<script type="text/javascript">
//<!--
	function show(){
		var result = document.getElementById("result");
		var msg = "";
		
		//// number
		msg += "//// number<br>";
		var m = { 'a':10, b:20, c:30 };
		msg += "a : " + m.a + "<br>"
			+ "b : " + m.b + "<br>"
			+ "c : " + m['c'] + "<br><br>";
		
		//// String
		msg += "//// String<br>";
		var str = {
				name:'홍길동', age:30, tel:'111-2222-3333'
				};
		msg += "이름 : " + str.name + "<br>"
			+ "나이 : " + str.age + "<br>"
			+ "전화번호 : " + str.tel + "<br><br>";
			
		//// Array	
		// key : [Array]
		msg += "//// Array<br>";
		msg += "// key : [Array]<br>";
		var w = {salary : [2000, 3000, 4000, 5000]};
		for(var i=0; i<w.salary.length; i++){
			msg += "연봉 : " + w.salary[i] + "<br>";
		}
		msg += "<br>";
		
		
		
		//// Object - JSON 객체
		// easy
		msg += "//// Object - JSON 객체<br>";
		msg += "// easy<br>";
		var e = {
				employee:{
					name:'홍길동', 
					age:30
					}
				};
		msg += "이름 : " + e.employee.name + "<br>"
			+ "나이 : " + e.employee.age + "<br><br>";
		
		// harder
		msg += "// harder<br>";
		var es = 
		{
				employees : [
					{name : '홍길동', age : 30},
					{name : '이순신', age : 40},
					{name : '김유신', age : 50}
				]
		};
		for(var i=0; i<es.employees.length; i++){
			msg += "이름 : " + es.employees[i].name + " "
				+ "나이 : " + es.employees[i].age + "<br>";
		}
		msg += "<br>";
		
		// harder++
		msg += "// harder++<br>";
		
		var ee = [
			{name : '홍길동', age : 30},
			{name : '이순신', age : 40},
			{name : '김유신', age : 50}
		];
		for(var i=0; i<ee.length; i++){
			msg += "이름 : " + ee[i].name + " "
				+ "나이 : " + ee[i].age + "<br>";
		}
		msg += "<br>";
		
		// harder#
		msg += "// harder#<br>";
		var ees = {		// 이건 배열이 아니어서 반복문을 못 쓴다는 단점이 있다
				hong : {name : '홍길동', age : 30},
				lee : {name : '이순신', age : 40},
				kim : {name : '김유신', age : 50}
		};
		msg += "이름 : " + ees.hong.name + "<br>"
			+ "나이 : " + ees.hong.age + "<br>";
		msg += "이름 : " + ees.lee.name + "<br>"
			+ "나이 : " + ees.lee.age + "<br>";
		msg += "이름 : " + ees.kim.name + "<br>"
			+ "나이 : " + ees.kim.age + "<br>";
		
		
		
		
		
		/* 자바에서의 표현 int m[] = {}; */
		/* var m = [];  {}를 쓸 필요가 없어져서 이게 들어가면 죄다 JSON이 되는 걸로 해논 것 */
		
		
		
		result.innerHTML = msg;
	}
//-->
</script>
<br><br>
<body onload="show()">
<div id="result"></div>
</body>