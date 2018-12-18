<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/jQueryEx/jquery-3.3.1.js"></script>

<h2> css </h2>

<script type="text/javascript">
	//<!--
	$(document).ready(
		function(){
			var result = document.getElementById("result");
			var msg = "";
			
			
			// $(selector).css( name, value )
			$('h4:first').css('color', 'red');
			
			// $(selector).css( name, function(index, style){} )
			var color = ['blue', 'red', 'yellow', 'green']
			$('h4').css(
					'color', 
					function(index, style){
						return color[index];
					}
			);
			
			// $(selector).css( name ) / name 만 적으면 값을 얻어온다
			$('h4').each(
				function(index, item){
					msg += index + " : " + $(item).css('color') + " "
						+ $(item).css('font-size') + "<br>";
				}
			);
			
			// $(selector).css( object ) / object는 당연히 JSON
			$('h4:odd').css(
					{
						background : 'gray',
						'font-style' : 'italic',
					}
			);
			
			var size = [15, 25, 35, 45];
			var back = ['silver', 'lightgray', 'gray', 'darkgray'];
			
			$('h4').css(
					{
						'font-size' : function(index, style){
							return size[index];
						},
						background : function(index, style){
							return back[index];
						}
					}
			);
			
			
			
			result.innerHTML = msg;
		}	
	);
	//-->
</script>

<h4>하나</h4>
<h4>둘</h4>
<h4>셋</h4>
<h4>넷</h4>
<br><br>
<div id="result"></div>