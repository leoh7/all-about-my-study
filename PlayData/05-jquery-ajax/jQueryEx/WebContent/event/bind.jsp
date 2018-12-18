<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 	<script src="/jQueryEx/jquery-3.3.1.js"></script>
    
<h2> event bind </h2>

<style type="text/css">
	.reverse {
		color : pink;
		background : red;
	}
</style>


<script type="text/javascript">
	//<!--
	$(document).ready(
		function(){
			// $(selector).bind( eventname, function( event ) {} )
			$('h5').bind(
				'click',
				function( event ){
					$(this).text( $(this).text() + "☆" );
				}
			);
			
			// $(selector).bind( object )
			var size = 20;
			$('h5').bind(
				{
					'mouseover' : function( event ){
						$(this).addClass('reverse');
					},
					'mouseout' : function( event ){
						$(this).removeClass('reverse');
					},
					'dblclick' : function( event ){
						$(this).css('font-size', ++size);
					}
				}
			);
			
			
			// unbind
			setTimeout(	// 시간 제약
				function(){
					$('h5').unbind('click');
				}, 3000	
			);
			
			// one	// 한번만 실행해라로 제약
			$('h5').one(
				'click',
				function( event ){
					alert( 'click' )
				}
			);
		}
	);
	//-->
</script>

<h5> 짜장면 먹고싶다 </h5>