<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2> JSON Class Test </h2>

<script type="text/javascript">
	//<!--
	// 이전
	function Member(name, age, tel){
		this.name = name;
		this.age = age;
		this.tel = tel;
	}
	Member.prototype.getName = function(){
		return this.name;
	}
	Member.prototype.getAge = function(){
		return this.age;
	}
	Member.prototype.getTel = function(){
		return this.tel;
	}
	// JSON
	function User(name, age, tel){
		this.name = name;
		this.age = age;
		this.tel = tel;
	}
	User.prototype = {
		getName : function(){ return this.name },
		getAge : function(){ return this.age },
		getTel : function(){ return this.tel }
	}
	
	window.onload = function(){
		var result = document.getElementById("result");
		var msg = "";
		
		// 이전
		var hong = new Member('홍길동', 30, '1111-2222');
		msg += "이름 : " + hong.getName() + "<br>"
			+ "나이 : " + hong.getAge() + "<br>"
			+ "전화번호 : " +hong.getTel() + "<br><br>";
			
		// <== 이전에 배운 방식( 클래스 생성 )
		// JSON 으로 표기하는 방식 ==>
		// key 에 getName / value 에 function 을 줄것임
		
		var kim = new User('김유신', 20, '2222-3333');
		msg += "이름 : " + kim.getName() + "<br>"
		+ "나이 : " + kim.getAge() + "<br>"
		+ "전화번호 : " +kim.getTel() + "<br><br>";
			
			
		result.innerHTML = msg;
	}
	//-->
</script>

<div id="result"></div>
