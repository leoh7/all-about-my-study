<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/jQueryEx/jquery-3.3.1.js"></script>
    
<h2> mouse event </h2>

<style type="text/css">
	.outer{
		width : 200px;
		height : 200px;
		background : magenta;
		padding : 50px;
	}
	.inner{
		width : 100px;
		height : 100px;
		background : pink;
		margin : 50px;
	}
	
</style>

<script type="text/javascript">
	//<!--
	$(document).ready(
		function(){
			// var result = document.getElementById("result");
			var msg = "";
			
			$('.outer').mouseover(
				function(){
					msg += "마우스 들어왔다<br>";
					$('#result').html(msg);
				}		
			).mouseout(
				function(){
					msg += "마우스 나갔다<br>";
					$('#result').html(msg);
				}	
			);
			
			$('.inner').mouseover(
				function(){
					msg = "";
					$('#result').html(msg);
				}	
			).mousedown(
				function(){
					$('.inner').css('background', 'red');
				}	
			).mouseup(
				function(){
					$('.inner').css('background', 'pink');
				}	
			);
			// result.innerHTML = msg;
		}	
	);
	//-->
</script>


<div class="outer">
	<div class="inner">
	</div>
</div>
<br><br>

<div id="result"></div>