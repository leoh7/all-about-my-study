<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2> DBTest - jQuery AJAX - JSTL SQL - Insert User </h2>
<!-- 유효성검사를 AJAX 처리를 하려고 하는 것임. -->
<!-- jsp 쪽 요청을 쓰는게 아니라 AJAX 쪽 요청을 쓰는 것 -->
<!-- AJAX의 요청은 자바스크립트의 이벤트처리부터 시작임
<!-- jQuery의 요청은 뭐부터 시작? submit? --> 
<!-- 버튼누르면 그걸 직접 이벤트 처리해서 DB처리하겠다는 것임 -->
<script src="/jQueryEx/jquery-3.3.1.js"></script>

<script type="text/javascript">
	//<!--
	$(document).ready( // 시작하자마자 할 일이 없다, 그러면 안 줘도 됨. 지금은 이벤트 리스너를 달아주기 위해 있음
		function(){
			$('input[name=id]').on(
				'keyup',
				function(event){
					//	alert('중복확인'); 확인용
					var id = $('input[name=id]').val();
					if(id){		// id 가 null 인 상태에서 DB에 물어보면 안되
						$.ajax(
								{
									type : "POST",
									url : 'idcheck.jsp',
									data : {
										'id' : id
									},
									dataType : 'xml',
									success : function(data){
										
										$('.idresult').text( $(data).find('message').text() );
										if( $(data).find('checkcode').text() == 0 ){
											$('input:hidden[name=idcheckcode]').val(0);
										} else {
											$('input:hidden[name=idcheckcode]').val(1);
										}
									},
									error : function(e){
										$('.idresult').text(e);
									}
								}	
						);
					} else if(!id){
						$('.idresult').text('아이디를 입력하세요');
					}
				}
			);
			$('input[name=passwd]').on(
				'keyup',
				function(event){
					var passwd = $('input[name=passwd]').val();
					if(passwd){
						if(isNaN(passwd)){
							$('.passwdresult').text('사용가능');
						} else {
							$('.passwdresult').text('사용불가능');
						}
					}
				}
			);
			$('input[name=repasswd]').on(
				'keyup',
				function(event){
					var passwd = $('input[name=passwd]').val();
					var repasswd = $('input[name=repasswd]').val();
					if(passwd != repasswd){
						$('.repasswdresult').text('두 값이 일치하지 않음');
					} else {
						$('.passwdresult').text('');
						$('.repasswdresult').text('비밀번호 사용가능');
					}
				}
			);
			$('input:button[value=가입]').on(
				'click',
				function(event){
					if( $('input:hidden[name=idcheckcode]').val() != 0 ){
						$.ajax(
								{
									type : "POST",
									url : 'insert.jsp',
									data : $('form').serialize(),
									dataType : 'xml',
									success : function(data){
										$('#result').html( $('input[name=id]').text() + ' 님 가입성공');
									},
									error : function(e){
										$('#result').html(e);
									}
								}		
						);
					} else {
						alert("아이디가 중복됩니다!");
					}
				}	
			);
			// 리스트 출력
			$('input:button[value=검색]').on(
				'click',
				function(event){
					$.ajax(
							{
								type : 'POST',
								url : 'select.jsp',
								data : {
									id : $('input:text[name=search]').val()
								},
								dataType : 'xml',
								success : function(data){
									
									var code = $(data).find('code').text().trim();
									if(code == 'success'){
										var members = eval("("+ $(data).find('memebers').text() +")");
										
										for(var i=0; i<members.member.length; i++){
											$('#t').append('<tr>'
														+ '<td>'+ members.member[i].id +'</td>'
														+ '<td>'+ members.member[i].passwd +'</td>'
														+ '<td>'+ members.member[i].name +'</td>'
														+ '<td>'+ members.member[i].tel +'</td>'
														+ '<td>'+ members.member[i].logtime +'</td>'
														+ '</tr>'
											);
										}
									}
								},
								error : function(e){
									$('#result').html(e);
								}
							}
					);
				}
			);
		}
	);
		
	//-->
</script>

<form>
	<input type="hidden" name="idcheckcode" value="0">
	<table border="1">
		<tr>
			<th> 아이디 </th>
			<td> 
				<input type="text" name="id"> 
			</td>
			<td width="250" class="idresult">아이디를 입력하세요</td>
		</tr>
		<tr>
			<th rowspan="2"> 패스워드 </th>
			<td> <input type="password" name="passwd"> </td>
			<td class="passwdresult">비밀번호를 입력하세요</td>
		</tr>
		<tr>
			<td> <input type="password" name="repasswd"> </td>
			<td class="repasswdresult">한번 더 입력하세요</td>
		</tr>
		<tr>
			<th> 이름 </th>
			<td> <input type="text" name="name"> </td>
			<td class="nameresult">&nbsp;</td>
		</tr>
		<tr>
			<th> 전화번호 </th>
			<td> <input type="text" name="tel"> </td>
			<td class="telresult">&nbsp;</td>
		</tr>
		<tr>
			<th colspan="3"> 
				<input type="button" value="가입">
				<input type="reset" value="취소">
			</th>
		</tr>
	</table>
</form>


<input type="text" name="search"> <input type="button" value="검색">
<br><br>
<table border="1">
	<tbody id="t">
	</tbody>
</table>
<div id="result"></div>