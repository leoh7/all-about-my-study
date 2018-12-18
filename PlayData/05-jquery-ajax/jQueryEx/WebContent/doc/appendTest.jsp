<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 	<script src="/jQueryEx/jquery-3.3.1.js"></script>
    
<h2> append </h2>

<script type="text/javascript">
	//<!--
	$(document).ready(
		function(){
			$('#result').append(
				'<br>',
				$('<img>').attr(
						{
							src : '/jQueryEx/images/images1.jpg',
							width : '200px',
							height : '100px'
						}
				),
				$('<img>').attr(
						{
							src : '/jQueryEx/images/images2.png',
							width : '200px',
							height : '100px'
						}
				),
				$('<img>').attr(
						{
							src : '/jQueryEx/images/images3.jpg',
							width : '200px',
							height : '100px'
						}
				)
			);
			
			setInterval( 
					function(){
						$('#result').append( $('img').first() );
					} 
			, 1000*1);
			
		}	
	);
	//-->
</script>


<div id="result"></div>













