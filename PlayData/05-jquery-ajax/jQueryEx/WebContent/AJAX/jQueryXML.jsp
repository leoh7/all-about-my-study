<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/jQueryEx/jquery-3.3.1.js"></script>
    
<h2> jQuery AJAX - XML </h2>

<script type="text/javascript">
	//<!--
	$(document).ready(
		function(){
			$.ajax(
					{
					type : 'POST',		// 방식
			//		data : '',			// 넘기는 데이터(이번예제는 넘길게 없다)
					url : 'member.xml',	
					dataType : 'xml',		// 넘어오는 데이터 형식 request.responseXML 과 같다
					success : function(data){
						var msg = "";
						$(data).find('member').each(
							function (index, item){
								msg += "이름 : " + $(item).find('name').text() + "<br>"
									+ "나이 : " + $(item).find('age').text() + "<br>"
									+ "전화번호 : " + $(item).find('tel').text() + "<br><br>";
							}
						);
						$('#result').html( msg );
					},
					error : function( e ) {
						$('#result').html(e);
					}
					}
			);
		}
	);
	//-->
</script>

<div id="result"></div>