<%-- <%@page import="java.text.SimpleDateFormat"%> --%>
<%@page import="member.LogonDataBean"%>
<%@page import="member.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp" %>
<link rel="stylesheet" type="text/css" href="${project}style_member.css">
<script src="${project}script.js"></script>

<h2>${page_modify}</h2>
<%
	/* int result = (Integer)request.getAttribute("result"); */
%>
<c:if test="${result eq 1}">
	<%-- <c:set var="memberDto" value="${requestScope.memberDto}"/> 굳이? --%>
		<body onload="modifyfocus()">
			<form method="post" action="modifyPro.do" name="modifyform" onsubmit="return modifycheck()">
				<table>
					<tr>
						<th colspan="2">
							${msg_modify}
						</th>
					</tr>

					<!-- id -->
					<tr>
						<th>${str_id}</th>
						<td>&nbsp; ${memberDto.id}</td>	<!-- 핸들러쪽에서 memberDto라고 넘기기로 했으니까 이건 함부로 건들면 안되 / 지만 id-->
					</tr>

					<!-- passwd -->
					<tr>
						<th rowspan="2">${str_passwd}</th>
						<td>
							<input class="input" type="password" name="passwd" maxlength="15"
								value="${memberDto.passwd}">
						</td>
					</tr>
					<tr>
						<td>
							<input class="input" type="password" name="repasswd" maxlength="15"
								value="${memberDto.passwd}">
						</td>
					</tr>

					<!-- name -->
					<tr>
						<th>${str_name}</th>
						<td>&nbsp; ${memberDto.name}</td>
					</tr>

					<!-- jumin -->
					<tr>
						<th>${str_jumin}</th>
						<td>&nbsp; ${memberDto.jumin1}-${memberDto.jumin2}</td>
					</tr>

					<!-- tel -->
					<tr>
						<th>${str_tel}</th>
						<td>
							<c:set var="tel" value="${memberDto.tel}"/>
							<c:if test="${tel eq null || tel eq ''}">
								<!-- 전화번호가 없다 -->
								<input class="input" type="text" name="tel1" maxlength="3" style="width: 27px">
								- <input class="input" type="text" name="tel2" maxlength="4" style="width: 33px">
								- <input class="input" type="text" name="tel3" maxlength="4" style="width: 33px">
							</c:if>
							<c:if test="${tel ne null && tel ne ''}">
								<!-- 전화번호가 있다. -->
								<!-- String t[] = tel.split("-"); -->
								<c:set var="t" value="${fn:split(tel, '-')}"/>
								<input class="input" type="text" name="tel1" maxlength="3" style="width: 27px" value="${t[0]}">
								- <input class="input" type="text" name="tel2" maxlength="4" style="width: 33px" value="${t[1]}">
								- <input class="input" type="text" name="tel3" maxlength="4" style="width: 33px" value="${t[2]}">
							</c:if>
						</td>
					</tr>
					
					<!-- email -->
					<tr>
						<th>${str_email}</th>
						<td>
							<c:set var="email" value="${memberDto.email}"/>
							
							<c:if test="${email eq null || email eq ''}">
									<input class="input" type="text" name="email1" maxlength="15" style="width: 100px">
									@ <input class="input" type="text" name="email2" maxlength="15" style="width: 100px">
							</c:if>
							<c:if test="${email ne null && email ne ''}">
								<c:set var="e" value="${fn:split(email, '@')}"/>
									<input class="input" type="text" name="email1" maxlength="15" style="width: 100px" 
										value="${e[0]}">
									@ <input class="input" type="text" name="email2" maxlength="15" style="width: 100px" 
										value="${e[1]}">
							</c:if>
						</td>
					</tr>
					
					<tr>
						<th>${str_reg_date}</th>
						<td>
						<%-- <c:set var="sdf" value='<%=new SimpleDateFormat("yyyy-MM-dd HH:mm")%>'/> --%>
							<fmt:formatDate value="${memberDto.reg_date}" pattern="yyyy-MM-dd HH:mm"/>
							&nbsp; ${sdf.format(memberDto.reg_date)}
						</td>
					</tr>
					
					<tr>
						<th colspan="2">
							<input class="inputbutton" type="submit" value="${btn_mod}">
							<input class="inputbutton" type="reset" value="${btn_cancel}">
							<input class="inputbutton" type="button" value="${btn_mod_cancel}"
								onclick="location='main.do'">
						</th>
					</tr>
				</table>
			</form>
		</body>
</c:if>
<c:if test="${result eq 0}">
	<!-- 비밀번호가 다른 경우 -->
	<script type="text/javascript">
		<!--
		erroralert(loginpasswderror);
		//-->
	</script>
</c:if>