<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/jQueryEx/jquery-3.3.1.js"></script>

<h2> text() / html() / remove() / empty() </h2>

<script type="text/javascript">
	//<!--
	$(document).ready(
		function (){
			// $(selector).text( value )
			// $(selector).html( value )
			// 차이를 보자
/* 			var a = document.getElementById("a");
			a.innerHTML = "<b> innerHTML </b>";		// 태그가 먹나 안 먹나를 중점으로 볼 것
			$('span:eq(1)').text("<b> text() </b>");
			$('span:eq(2)').html("<b> html() </b>"); */
			
			
		}	
	);
	
	function show(){
		var a = document.getElementById("a");
		a.innerHTML = "<b> innerHTML </b>";		// 태그가 먹나 안 먹나를 중점으로 볼 것
		$('span:eq(1)').text("<b> text() </b>");
		$('span:eq(2)').html("<b> html() </b>");
		
		var result = document.getElementById("result");
		var msg = "";
		
		// $(selector).text()
		// $(selector).html()
		$('#result').text( "text : " + $('span:eq(1)').text() + "<br>" );
		$('#result1').html( "html : " + $('span:eq(2)').html() + "<br><br>" );
		
		// $(selector).text( function(index, text){} )
		// $(selector).html( function(index, html){} )
		$('a:even').text(
			function(index, text){	// 원래있던 값이 text로 들어오고 index 번째에 return으로 뿌림
				return index + " : " + text + " text";
			}	
		);
		
		$('a:odd').html(
			function(index, html){
				return index + " : " + html + " html";
			}	
		);
		
		
		$('span:first').remove();	// span 태그까지 완전히 지워버림
		$('span:last').empty();		// 태그는 냅두고 안에 내용만 비움
		
		
		//result.innerHTML = msg;
	}
	//-->
</script>
<div id="result"></div>
<div id="result1"></div>
<br><br>
확인 : <input type="button" value="확인" onclick="show()"> <br>
<span id="a"></span><br>
<span></span><br>
<span></span><br>
<br><br>
<a><b> A </b></a> <br>
<a><b> B </b></a> <br>
<a><b> C </b></a> <br>
<a><b> D </b></a> <br>














