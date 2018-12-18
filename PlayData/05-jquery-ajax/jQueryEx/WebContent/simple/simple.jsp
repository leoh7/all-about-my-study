<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- <script src="http://code.jquery.com/jquery-3.3.1.js"></script> -->
<script src="/jQueryEx/jquery-3.3.1.js"></script>

<h2>Simple jQuery</h2>

<script type="text/javascript">
//<!--
function show(){
	var result = document.getElementById( "result" );
	result.innerHTML += "이렇게 써도 같은 효과가 난다<br>";
}
window.onload = function(){
	var result = document.getElementById( "result" );
	result.innerHTML += "window.onload 이렇게 써도 같은 효과가 난다<br>";
}
/* 윈도우가 뜨자마자 어떻게 해라 -> 이게 jQuery의 시작 */
// 현재 문서(document)가 준비되자 마자(.ready()) 뭔가를 해라
	// Java : 작업 x 데이터들 o
	// Javascript : 작업들 o
jQuery(document).ready(
	function(){
		var result = document.getElementById( "result" );
		result.innerHTML += "jQuery 이렇게 써도 같은 효과가 난다<br>";
	}
);
$(document).ready(
	function(){
		var result = document.getElementById( "result" );
		result.innerHTML += "$로 써도 같은 효과가 난다<br>";
	}
);
$(function(){
			var result = document.getElementById( "result" );
			result.innerHTML += "(document).ready를 생략해도 같은 효과가 난다<br>";
		}
	);
//-->
</script>


<!-- 
<body onload="show()"></body>
 -->
 
 
 <div id="result">
</div>