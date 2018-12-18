<%@page import="java.text.SimpleDateFormat"%>
<%@page import="member.LogonDataBean"%>
<%@page import="member.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=project%>style_member.css">
<script src="<%=project%>script.js"></script>

<h2><%=page_modify%></h2>

<%
	String id = (String)session.getAttribute("memid");
	// 새로 받은 비밀번호
	String passwd = request.getParameter("passwd");
%>

<%
	LogonDBBean memberDao = LogonDBBean.getInstance();
	int result = memberDao.check(id, passwd);
%>

<%

// 전화번호 , 이메일 null 가능 / 비밀번호 not null
// 포커스
// 유효성 검사 / 전화번호에 - 들어갔는지, 이메일에 @ 들어갔는지



	if( result == 1 ) {
		// 비밀번호가 같은 경우
		// 바구니로 받아야 한다
		LogonDataBean memberDto = memberDao.getMember(id);
		%>
		<body onload="modifyfocus()">
			<form method="post" action="modifyPro.jsp" name="modifyform" onsubmit="return modifycheck()">
				<table>
					<tr>
						<th colspan="2">
							<%=msg_modify%>
						</th>
					</tr>

					<!-- id -->
					<tr>
						<th><%=str_id%></th>
						<td>&nbsp<%=memberDto.getId()%></td>
					</tr>

					<!-- passwd -->
					<tr>
						<th rowspan="2"><%=str_passwd%></th>
						<td>
							<input class="input" type="password" name="passwd" maxlength="15"
								value="<%=memberDto.getPasswd()%>">
						</td>
					</tr>
					<tr>
						<td>
							<input class="input" type="password" name="repasswd" maxlength="15"
								value="<%=memberDto.getPasswd()%>">
						</td>
					</tr>

					<!-- name -->
					<tr>
						<th><%=str_name%></th>
						<td>&nbsp<%=memberDto.getName()%></td>
					</tr>

					<!-- jumin -->
					<tr>
						<th><%=str_jumin%></th>
						<td>&nbsp<%=memberDto.getJumin1()%>-<%=memberDto.getJumin2()%></td>
					</tr>

					<!-- tel -->
					<tr>
						<th><%=str_tel%></th>
						<td>
						<%
							String tel = memberDto.getTel();
							if(tel == null || tel.equals("")) {
								// 전화번호가 없다
								%>
								<input class="input" type="text" name="tel1" maxlength="3" style="width: 27px">
								- <input class="input" type="text" name="tel2" maxlength="4" style="width: 33px">
								- <input class="input" type="text" name="tel3" maxlength="4" style="width: 33px">
								<%
							} else {
								// 전화번호가 있다.
								String t[] = tel.split("-");
								%>
								<input class="input" type="text" name="tel1" maxlength="3" style="width: 27px" value="<%=t[0]%>">
								- <input class="input" type="text" name="tel2" maxlength="4" style="width: 33px" value="<%=t[1]%>">
								- <input class="input" type="text" name="tel3" maxlength="4" style="width: 33px" value="<%=t[2]%>">
								<%
							}
						%>
					
						</td>
					</tr>
					
					<!-- email -->
					<tr>
						<th><%=str_email%></th>
						<td>
							<%
								String email = memberDto.getEmail();
								if(email == null || email.equals("")) {
									%>
									<input class="input" type="text" name="email1" maxlength="15" style="width: 100px">
									@ <input class="input" type="text" name="email2" maxlength="15" style="width: 100px">
									<%
								} else {
									String e[] = email.split("@");
									%>
									<input class="input" type="text" name="email1" maxlength="15" style="width: 100px" 
										value="<%=e[0]%>">
									@ <input class="input" type="text" name="email2" maxlength="15" style="width: 100px" 
										value="<%=e[1]%>">
									<%
								}
							%>
						</td>
					</tr>
					
					<tr>
						<th><%=str_reg_date%></th>
						<td>
							<%
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
							%>
							&nbsp<%=sdf.format(memberDto.getReg_date())%>
						</td>
					</tr>
					
					<tr>
						<th colspan="2">
							<input class="inputbutton" type="submit" value="<%=btn_mod%>">
							<input class="inputbutton" type="reset" value="<%=btn_cancel%>">
							<input class="inputbutton" type="button" value="<%=btn_mod_cancel%>"
								onclick="location='main.jsp'">
						</th>
					</tr>
				</table>
			</form>
		</body>
		<%
	} else {
		// 비밀번호가 다른 경우
		%>
		<script type="text/javascript">
			<!--
			erroralert(loginpasswderror);
			//-->
		</script>
		<%
	}
%>