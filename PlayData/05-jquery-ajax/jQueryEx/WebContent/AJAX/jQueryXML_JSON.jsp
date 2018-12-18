<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/jQueryEx/jquery-3.3.1.js"></script>
    
<h2> jQuery AJAX - XML & JSON </h2>

<script type="text/javascript">
	//<!--
	$(document).ready(
		function(){
			var msg = "";
			
			$.ajax(
					{
						type : 'POST',
						url : 'user.jsp',
					//	data : '',
						dataType : 'xml',
						success : function(data){
							var members = eval("("+ $(data).find('members').text() +")");
							for(var i=0; members.member.length; i++){
								msg += "이름 : " + members.member[i].name + "<br>"
									+ "나이 : " + members.member[i].age + "<br>"
									+ "전화번호 : " + members.member[i].tel + "<br><br>";
							}
							$('#result').html(msg);
						},
						error : function(e){
							$('#result').html(e);
						}
					}	
			);
		}
	);
	//-->
</script>

<div id="result"></div>