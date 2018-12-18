<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2> 문서 객체 변경 </h2>
<script type="text/javascript">
//<!--
	// padding 은 안쪽
	// margin 은 바깥쪽
	var cnt = 0;
	function additem() {
		var result = document.getElementById("result");
		var newdiv = document.createElement("div");
		//복잡버전
		/* 		var msg = "새로운 노드" + ++cnt + "번 노드";
		var newtext = document.createTextNode(msg);
		// newtext 를 newdiv에 붙이고 그걸 result 에 붙이고
		newdiv.appendChild(newtext);
		result.appendChild(newdiv); */
		// 간략버전
		newdiv.innerHTML = "새로운 노드" + ++cnt + "번 노드 "
							+"<input type='button' value='수정' onclick='moditem("+cnt+")'> "
							+"<input type='button' value='삭제' onclick='delitem("+cnt+")'> ";
		// id 부여하기
		newdiv.setAttribute("id","id_"+cnt);
		result.appendChild(newdiv);
	}
	
/* 	function moditem(cnt) {
		// 수정한 노드를 삭제하는 게 되야 해	"수정한 노드" + cnt + "번";
		var result = document.getElementById("result");
		var deldiv = document.getElementById("id_"+ cnt);
		var nextdiv = document.getElementById("id_"+ ++cnt);
		var newdiv = document.createElement("div");
		
		
		result.removeChild(deldiv);
		
		newdiv.innerHTML = "수정한 노드" + --cnt + "번 노드 "
							+"<input type='button' value='수정' onclick='moditem("+ cnt +")'> "
							+"<input type='button' value='삭제' onclick='delitem("+ cnt +")'> ";

		newdiv.setAttribute("id","id_"+ cnt);
		
		result.insertBefore(newdiv, nextdiv);
	} */
	function moditem(cnt) {
		
		var result = document.getElementById("result");
		var olddiv = document.getElementById("id_"+ cnt);
		var newdiv = document.createElement("div");
		newdiv.innerHTML = "수정한 노드" + cnt + "번 노드 "
		+"<input type='button' value='수정' onclick='moditem("+ cnt +")'> "
		+"<input type='button' value='삭제' onclick='delitem("+ cnt +")'> ";
		
		newdiv.setAttribute("id","id_"+ cnt);
		result.replaceChild(newdiv, olddiv);
		
	}
	function delitem(cnt/*전역변수 아니고 지꺼,지역변수임*/) {
		var result = document.getElementById("result");
		var deldiv = document.getElementById("id_"+cnt);
		result.removeChild(deldiv);
	}
//-->
</script>

<style type="text/css">
<!--
	div{
		border : solid 2px blue;
		padding : 10px;
		margin : 10px;
	}
-->
</style>

추가: <input type="button" value="추가" onclick="additem()"> <br>
<br><br>
<div id="result">
</div>






