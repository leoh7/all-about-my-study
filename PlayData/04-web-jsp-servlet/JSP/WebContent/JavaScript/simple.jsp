<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2> Simple Java Script </h2>

<script type="text/javascript">
	//자료형
	document.write(10 + "<br>");
	document.write(10.5 + "<br>");
	document.write("ABC" + "<br>");
	document.write(true + "<br>");
	document.write("<br>");
	document.write(typeof(10) + "<br>");
	document.write(typeof(10.5) + "<br>");
	document.write(typeof("ABC") + "<br>");
	document.write(typeof('ABC') + "<br>"); 
	document.write("<p>");
	// 일치연산자
	if(0 == false) document.write("같다<br>");
	else document.write("다르다<br>");
	if(0 == '') document.write("같다<br>");
	else document.write("다르다<br>");
	if('' == false) document.write("같다<br>");
	else document.write("다르다<br>");
	if(10 == "10") document.write("같다<br>");
	else document.write("다르다<br>");
	
	if(0 === false) document.write("같다<br>");
	else document.write("다르다<br>");
	if(0 === '') document.write("같다<br>");
	else document.write("다르다<br>");
	if('' === false) document.write("같다<br>");
	else document.write("다르다<br>");
	if(10 === "10") document.write("같다<br>");
	else document.write("다르다<br>");
	
	document.write("<p>");
	// 짧은 조건문 : 연산자에 대한 얘기라 쪼끔 땡겨서 봐보자
	// && 는 앞에가 거짓이면 뒤에는 보지도 않는다. (??????)
	// || 는 앞에가 참이면 뒤에는 보지도 않는다. (??????)
	true && document.write("&& 실행된다. <br>");
	false && document.write("&& 실행되지 않는다. <br>");
	true || document.write("|| 실행되지 않는다. <br>");
	false || document.write("|| 실행된다. <br>");
	document.write("<p>");
	
	// 배열 (과 반복문)
	// C		int m[3]; 빈 배열
	//			int m[3] = {10,20,30};
	// Java		int m[] = new int[3]; 빈 배열
	//			int m[] = {10,20,30}; 방 갯수 안써준다
	var m = [];	// 빈 배열
	var w = [10,20,30]; // 데이터가 있는 배열
	
	/* 얘네는 신기하게도 name, age, tel 로 객체를 잡았잖아. address 를 잡을 필요가 있으면 그냥 넣어. 
	참조변수도 역시 자료형이 없기 때문에, 빈 객체를 잡았다가 그냥 필요한걸 넣어서 써 */
	w[3] = 40;
	
	for(var i=0; i<w.length; i++) {
		document.write("w["+i+"] : "+w[i]+ "<br>" )
	}
	/* C나 자바에서 배열 방 갯수를 잡고 하는 행위는 메모리를 확정하는 건데(자료형을 잡는 것), 자료형이 자유로우니깐 이런게 가능한것 */
	document.write("<p>");
	
	// switch ~ case
	var score = 65;
	switch(true) {	// 첫번째 참인 애한테 가라, 라는 뜻
	case score >= 90 : document.write("A학점<br>"); break;
	case score >= 80 : document.write("B학점<br>"); break;
	case score >= 70 : document.write("C학점<br>"); break;
	case score >= 60 : document.write("D학점<br>"); break;
	default : document.write("F학점<br>");
	}	
	
	// 만약 hour < 24 케이스가 위에 있으면 참이 되버려서 항상 저녁이 나와버린다. 위에서 부터 점점 넓어지게 만드는 게 좋은 듯 해
	var now = new Date();
	var hour = now.getHours();
	switch(true) {
	case hour < 12 : document.write("오전<br>"); break;
	case hour < 16 : document.write("오후<br>"); break;
	case hour < 24 : document.write("저녁<br>"); break;
	}
	document.write("<p>");
	
	// 반복문
	var fruit = ["사과", "딸기", "바나나"];
	for(var i=0; i<fruit.length; i++) {
		document.write(fruit[i] + "<br>");
	}
	
	// for in 반복문
	for(var i in fruit) { // 자바에서는 fruit에서 꺼내서 i를 활용해 반복시켰는데 여기선 직접 꺼내서 출력해야한다.(어차피 인덱스를 돌려야 하기 때문에 차이가 없음)
		document.write(fruit[i] + "<br>");
	}
	document.write("<p>");
</script>















