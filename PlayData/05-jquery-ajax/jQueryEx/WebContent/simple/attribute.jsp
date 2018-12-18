<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="/jQueryEx/jquery-3.3.1.js"></script>


<h2> 속성선택자 </h2>
<script type="text/javascript">
//<!--
	$(document).ready(
		function(){
			//inputform.id.value = '아이디를 입력하세요';
			$('input[type=text]').val('아이디를 입력하세요');
			$('input:text').css('background', 'lightgray');
			$('input[name=passwd]').val('비밀번호를 입력하세요');
			$('input:button').css('background', 'red');
			$('input[value=확인]').css('color', 'white');
			$('input:reset').css('background','blue');
			$('input[type=reset]').css('background', 'white');
			
			$('input[name=passwd]').css('background', 'lightgray');
			
		}
	);
	
	function delid(){
		/* $('input:text:focus').val('').css('background', 'white'); 텍스트가 여러개인데 포커스가 간 애한테만 */
		$('input[name=id]:focus').val('').css('background', 'white'); /* 이 경우엔 포커스가 간 애를 따로 고를 필요가 없다 */
	}
	
	// 비밀번호란에 배경은 lightgray
	// 포커스가 오면 글자 없애고 배경은 white
	function delpasswd(){
		$('input[name=passwd]:focus').val('').css('background', 'white');
	}
	
	function show(){
		var result = document.getElementById( "result" );
		var msg = "";
		
		// DOM 방식
		msg += "아이디 : " + inputform.id.value + "<br>"
			+ "비밀번호 : " + inputform.passwd.value + "<br>"
			+ "성별 : " + (inputform.gender[0].checked ? "남자" : "여자") + "<br>"
			+ "취미 : " + inputform.hobby.options[ inputform.hobby.selectedIndex ].value + "<br><br>";
			
		// jQuery 방식
		msg += "아이디 : " + $('input[name=id]').val() + "<br>"
			+ "비밀번호 : " + $('input[name=passwd]').val() + "<br>"
			+ "성별 : " + ($('input[name=gender]:checked').val()=="1" ? "남자" : "여자")+ "<br>"
			+ "취미 : " + $('select[name=hobby] option:selected').val() + "<br><br>";
		
		
		
		
		/* 		
		innerHTML 의 정확한 용도는 원래 웹브라우저는 새로고침할 때 전체를 새로고침해야하는데(전체를 다 그려야 하는데)
		이걸 쓰면 일부분만 그리는게 가능하다.
 */		result.innerHTML = msg;
	}
//-->
</script>

<form name="inputform">
	<table border="1">
		<tr>
			<th>아이디</th>
			<td> <input type="text" name="id" onfocus="delid()"> </td>
		</tr>
		
		<tr>
			<th>비밀번호</th>
			<td> <input type="password" name="passwd" onfocus="delpasswd()"> </td>
		</tr>
		
		<tr>
			<th>성별</th>
			<td> 
				<input type="radio" name="gender" value="1" checked>남자
				<input type="radio" name="gender" value="2">여자
			</td>
		</tr>
		
		<tr>
			<th>취미</th>
			<td>
				<select name="hobby">
					<option value="독서">독서</option>
					<option value="등산">등산</option>
					<option value="운동">운동</option>
					<option value="게임">게임</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<th colspan="2">
				<input type="button" value="확인" onclick="show()">
				<input type="reset" value="취소">
			</th>
		</tr>
	</table>
</form>
<br><br>
<div id="result"></div>



