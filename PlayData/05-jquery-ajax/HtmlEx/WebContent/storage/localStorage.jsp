<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2> Local Storage </h2>

<script type="text/javascript">
	//<!--
	var cnt = 0;
	function savemsg() {
		var result = document.getElementById( "result" );
		if( ! window.localStorage ) {
			result.innerHTML += "지원하지 않는 브라우저입니다<br>";
			return;
		}
		var msg = document.getElementById( "ta" ).value;
		if( ! msg ) {
			result.innerHTML += "메세지를 입력하세요<br>";
		} else {
			// localStorage.setItem( "msg_" +  ++cnt, msg );
			var message = localStorage.getItem("msg");
			if( message == null ) {
				message = "";
				localStorage.setItem( "msg", message + msg );
				result.innerHTML += "메세지를 다시 저장했습니다<br>";
			} else {
				localStorage.setItem( "msg", message + "\n" + msg );
				result.innerHTML += "메세지를 저장했습니다<br>";
			}
		}		
	}	
	
	function loadmsg() {
		var result = document.getElementById( "result" );
		var msg = document.getElementById( "msg" );
		msg.innerHTML = localStorage.getItem( "msg" );
		result.innerHTML += "메세지를 로드했습니다<br>";
	}
	
	function deletemsg() {
		var result = document.getElementById( "result" );
		localStorage.removeItem( "msg" );
		result.innerHTML += "메세지를 삭제했습니다<br>";
	}
	//-->
</script>


<form>
	<table border="1">
		<tr>
			<th> 내용 </th>
			<td> <textarea autofocus placeholder="내용을 입력하세요" rows="10" cols="50" id="ta"></textarea>
		</tr>
		<tr>
			<th colspan="2">
				<input type="button" value="저장하기" onclick="savemsg()">
				<input type="button" value="불러오기" onclick="loadmsg()">
				<input type="button" value="삭제하기" onclick="deletemsg()">
			</th>
		</tr>
	</table>
</form>
<br><br>
<div id="result"></div>
<br><br>
<pre><div id="msg"></div></pre>







