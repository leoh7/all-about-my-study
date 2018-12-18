<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/jQueryEx/jquery-3.3.1.js"></script>

<h2> attr </h2>
<script type="text/javascript">
	//<!--
	$(document).ready(
		function(){
			var result = document.getElementById("result");
			var msg = "";
			
			// DOM
			var first = document.getElementById("first");	// var first 는 태그 자체
			first.setAttribute('src', '/jQueryEx/images/images1.jpg');
			first.setAttribute('width', '200px');
			first.setAttribute('height', '100px');
			msg += "src : " + first.getAttribute('src') + "<br>";
			
			// jQuery
			// 지금부터 하는 많은 것들이 set 뿐만 아니라 get의 의미도 갖고 있다
				// $(selector).attr( name, value )
			$('#second').attr('src', '/jQueryEx/images/images2.png');
			
				// $(selector).attr(object)
			$('#second').attr({
							width : '200px',
							height: "100px"
						}
			);
				
				// $(selctor).attr( function(index, attr) )
			$('img').attr(
					'border',
					function(index, attr){
						return index * 10;
					}
				
			);
				
				// $(selector).attr(name)
			msg += "src : " + $('#second').attr('src') + "<br>"
			
			var align = ['left', 'right']
			$('img').attr(
					'align',
					function(index){
						return align[index];
					}
			)
			
			$('img').attr({
					width : function(index,attr){
						return (index + 1) * 100;
					},
					height : function(index){
						return (index + 1) * 100;
					}
				}
			);
			
			$('#first').removeAttr('width');
			$('#first').removeAttr('height');
			
			
			result.innerHTML = msg;
		}	
	);
	
	//-->
</script>

<div id="result"></div> <br><br>
<img id="first"> <br><br>
<img id="second"> <br><br>
















