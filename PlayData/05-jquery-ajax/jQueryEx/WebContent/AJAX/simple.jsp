<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2> Simple AJAX </h2>

<script type="text/javascript">
	//<!--
	var request = null;
	var str = "";
	function show(){
		if(window.ActiveXObject){
			// IE 인 경우
			try{
				request = new ActiveXObject('Msxml2.XMLHTTP');
			} catch(e){
				request = new ActiveXObject('Microsoft.XMLHTTP');
			}
		} else {
			// 다른 브라우저
			request = new XMLHttpRequest();
		}
		
		// 넘길 데이터 만들기
		var params = "?name=" + encodeURI(inputform.name.value) 
					+ "&age=" + inputform.age.value;
		
		// 콜백 function 등록
		request.onreadystatechange = showresult;	// 누적하거나 덮어서 써도 됨
		request.open('GET', 'simpleData.jsp' + params, true);	// 두개의 데이터를 받아서 처리할 파일을 넣는다
			// simpleData.jsp 에 들어가는 애는 받기도, 처리도, 돌려주기도 한다.
		request.send( null );	
	}
		
	
	
	
	function showresult(){
		var state = document.getElementById("state");
		str = "state : " + request.readyState + "<br>";
		
		if( request.readyState == 4 ){
			if( request.status == 200 ){
				str += "정상종료<br>";
				
				// simpleData.jsp 에서 처리한 데이터를 받아서 출력한다
				var result = document.getElementById("result");
				result.innerHTML = request.responseText;	// responseText 와 responseXML 이 있다
					// simpleData.jsp 에서는 그냥 출력만 하면 받아진다.
			} else {
				str += "에러발생<br>";
			}
		} else {
			str += "통신중<br>";
		}
		
		state.innerHTML += str;
	}
	//-->
</script>
<br>
<form name="inputform">
	이름 : <input type="text" name="name"> <br>
	나이 : <input type="text" name="age"> <br>
</form>



확인 : <input type="button" value="확인" onclick="show()">


<div id="result"></div>
<div id="state"></div>