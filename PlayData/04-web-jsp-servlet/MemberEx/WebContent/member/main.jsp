<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ include file="setting.jsp" %>
<link rel="stylesheet" type="text/css" href="${project}style_member.css">
<script src="${project}script.js"></script>


<h2> ${page_main} </h2>

<c:if test="${sessionScope.memid eq null}">
	<!-- if(session.getAttribute("memid") == null) { -->
	
		<body onload="mainfocus()">
		<!-- submit을 누르면 액션으로 넘어가는데 그걸 onsubmit으로 처리했다. 앞에 return 을 붙여서 return false 가 작동하게끔 했음-->
			<form name="mainform" method="post" action="loginPro.do" onsubmit="return maincheck()">
				<table>
					<tr>
						<th colspan="2">${msg_main}</th>
					</tr>
					
					<tr>
						<th> ${str_id}</th>
						
						<td>
							<input class="input" type="text" name="id" maxlength="15">
						</td>
					</tr>
					
					<tr>
						<th> ${str_passwd}</th>
						
						<td>
							<input class="input" type="password" name="passwd" maxlength="15">
						</td>
					</tr>
					
					<tr>
						<th colspan="2">
							<input class="inputbutton" type="submit" value="${btn_login}">
							<input class="inputbutton" type="reset" value="${btn_cancel}">
							<input class="inputbutton" type="button" value="${btn_join}"
								onclick="location='inputForm.do'">
						</th>
					</tr>
				</table>
			</form>
		</body>
		
</c:if>
		
<c:if test="${sessionScope.memid ne null}">	
		
		<table>
			<tr>
				<td align="center">
				<span>${sessionScope.memid}</span>
				${msg_main_login}
				</td>
			</tr>
			
			<tr>
				<th>
					<input class="inputbutton" type="button" value="${btn_modify}"
						onclick="location='modifyForm.do'">
					<input class="inputbutton" type="button" value="${btn_delete}"
						onclick="location='deleteForm.do'">
					<input class="inputbutton" type="button" value="${btn_logout}"
						onclick="location='logout.do'">
				</th>
			</tr>
		</table>
</c:if>