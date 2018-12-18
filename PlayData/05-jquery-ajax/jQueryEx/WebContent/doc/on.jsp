<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/jQueryEx/jquery-3.3.1.js"></script>
    
<h2> on / off </h2>

<script type="text/javascript">
	//<!--
	$(document).ready(
		function(){
			// bind()
/* 			$('h5').bind(
				'click',
				function( event ){
					$('<h5>').text( $(this).text() ).appendTo('#result');
				}
			); */
			
			// bind() 형식의 on()
			// $(selector).on( eventname, eventhandler )
/* 			$('h5').on(
					'click',
					function( event ){
						$('<h5>').text( $(this).text() ).appendTo('#result');
					}
			); */
			
			// live()/delegate 형식의 on()
			// $(selector).on( eventname, selector, eventhandler )
			$('div').on(	// 이 영역중에
					'click',
					'h5',	// 얘
					function( event ){
						$('<h5>').text( $(this).text() ).appendTo('#result');
					}
			);
			
			setTimeout(
				function(){
					$('div').off('click');
				}, 1000*5	
			);
		}	
	);
	//-->
</script>


<div id="result">
	<h5> 짜장면 </h5>
	<h5> 짬뽕 </h5>
	<h5> 볶음밥 </h5>
	<h5> 탕수육 </h5>
	<hr size="3" color="red" align="left">
</div>