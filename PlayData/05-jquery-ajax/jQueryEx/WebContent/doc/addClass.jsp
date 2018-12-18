<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="/jQueryEx/jquery-3.3.1.js"></script>

<h2> addClass / removeClass </h2>


<style type="text/css">
	.point {
		color : red;
	}
	.strong {
		color : blue;
	}
</style>

<script type="text/javascript">
	//<!--
		// 클래스를 만들어라 지워라
	$(document).ready(
		
		function(){
			// addClass
			// $(selector).addClass( className );
			$('h4').filter(':first').addClass('point');
			$('h4').each(
					function( index ){
						$(this).addClass('strong');
					}
			);
		
			
			// removeClass
			// $(selector).removeClass( className );
			// $('h4:contains(순대)').removeClass('strong');
			$('h4').each(
					function( index ){
						if( $(this).is('.strong') ){
							$(this).removeClass('strong');
						}
					}	
			);
			
			//
			$('h4').first().removeClass('point');
		}		
	);
	
	//-->
</script>

<h4> 떡볶이 </h4>
<h4> 순대 </h4>
<h4> 튀김 </h4>
<h4> 오뎅 </h4>