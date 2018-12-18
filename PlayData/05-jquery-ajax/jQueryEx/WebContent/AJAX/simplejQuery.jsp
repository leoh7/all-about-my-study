<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/jQueryEx/jquery-3.3.1.js"></script>
    
<h2> Simple jQuery AJAX </h2>

<script type="text/javascript">
	//<!--
	$(document).ready(
		function(){
			$('input:button').on(
				'click',
				function( event ){
					// 데이터 만들기
				//	var params = "name=" + encodeURI(inputform.name.value)
				//				+ "&age=" + inputform.age.value;
				
					$.ajax(
							{
								type : 'POST',
								url : 'simpleData.jsp',
								/* data : params, */
								/* data : {
									name : inputform.name.value,
									age : inputform.age.value
								}, */
								data : $('form').serialize(),
									// form에 있는 name을 가져다 쓰고 거기 있는 데이터 다 넘김
								dataType : 'text',
								success : function( data ){
									$('#result').html( data );
								},
								error : function( e ){
									$('#result').html( e.responseText );
								},
							}	
					);	// ajax
				}
			);	// on
			
			
		}
	);
	//-->
</script>


<br>
<form name="inputform">
	이름 : <input type="text" name="name"> <br>
	나이 : <input type="text" name="age"> <br>
</form>

확인 : <input type="button" value="확인">

<div id="result"></div>
