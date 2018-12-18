<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>JavaScript - Class</h2>
<script type="text/javascript">
//<!--
	//// 클래스 만들기
	document.write("<hr>");
	document.write("<h2>Class</h2>");
	
	

	document.write("<h3>Class-클래스와 함수 생성</h3>");
	// 생성자라는 개념이 없고, 매개변수 자리에 집어넣는다 / 멤버 변수를 만드는게 아니라 데이터를 받으면서 그냥 만들면 됨.
	function Member(name, age, tel) {
		this.name = name;
		this.age = age;
		this.tel = tel;
		// 메서드도 이런식으로 이 자리에서 만들어버린다.
		this.getName = getName;
		this.getAge = getAge;
		this.getTel = getTel;
		// 메서드가 없으니깐 메서드를 만들어 주자.
	}
	// 멤버 메서드들의 정의
	function getName() {
		return this.name;
	}
	function getAge() {
		return this.age;
	}
	function getTel() {
		return this.tel;
	}
	// 방법 1
	document.write("<h4>Class-클래스와 함수 생성 방법1</h4>");
	var msg = "";
	// 방법 1 객체 호출(var kim)
	var kim = new Member("김유신",20,"1111-2222");
	// msg 에 누적
	msg += "이름 : " + kim.getName() + "<br>"
		+ "나이 : " + kim.getAge() + "<br>"
		+ "전화번호 : " + kim.getTel() + "<br><br>";
	
	
	// 방법 2	
	document.write("<h4>Class-클래스와 함수 생성 방법2</h4>");

	function User(name, age, tel) {
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.getName = function() {
			return this.name;
		}
		this.getAge = function() {
			return this.age;
		}
		this.getTel = function() {
			return this.tel;
		}
	}
	
	// 방법 2 객체 호출(var hong)
	var hong = new User("홍길동", 30, "2222-1111");
	// msg 에 누적
	msg += "이름 : " + hong.getName() + "<br>"
		+ "나이 : " + hong.getAge() + "<br>"
		+ "전화번호 : " + hong.getTel() + "<br><br>";
	
	
	
	// data 에서 많이 쓰는게 Json 과 xml // 왜 언급하셨지?
	// 방법 3
	document.write("<h4>Class-클래스와 함수 생성 방법3</h4>");
	
	function Customer(name, age, tel) {
		this.name = name;
		this.age = age;
		this.tel = tel;
		// 위에선 메서드에 대한 명시라도 해줬어, 근데 이번엔 명시도 안해줌
	}
	// 메서드 정의
	Customer.prototype.getName = function() {
		return this.name;
	}
	Customer.prototype.getAge = function() {
		return this.age;	
	}
	Customer.prototype.getTel = function() {
		return this.tel;
	}
	
	var lee = new Customer("이순신",25,"3333-1111");
	msg += "이름 : " + lee.getName() + "<br>"
	+ "나이 : " + lee.getAge() + "<br>"
	+ "전화번호 : " + lee.getTel() + "<br><br>";
	
	// 신기한거 보여줄까?
	// 심지어 객체를 만들지도 않는다.
	// 방법 4
	document.write("<h4>Class-클래스와 함수 생성 방법4</h4>");

	var kang = new Object();
	kang.name = "강감찬";
	kang.age = 35;
	kang.tel = "2222-3333";
	kang.getName = function() {
		return this.name;
	}
	kang.getAge = function() {
		return this.age;
	}
	kang.getTel = function() {
		return this.tel;
	}
	
	msg += "이름 : " + kang.getName() + "<br>"
	+ "나이 : " + kang.getAge() + "<br>"
	+ "전화번호 : " + kang.getTel() + "<br><br>";
	
	// 누적된 걸 한번에 출력한다.
	document.write(msg);
		
		
		
	//// 이벤트객체
	document.write("<h3>Class-이벤트객체 생성</h3>");		
	// body 태그에다가 on 붙여서 이벤트 를 호출 설정
	
	/* Window	Frame
			Location
			History
			Event
			Navigator
			Document		Applet
							Link
							Anchor
							Area
							Image
							All
							Layer
							Form		Checkbox Button Radio Reset Submit
										Hidden Password FileUpload Text Textarea Select - Option */
//-->

</script>














