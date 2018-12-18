<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h2> 템플릿 페이지 </h2>
    
    <jsp:useBean id="ver3" class="bean.StudyBean" scope="session"/>
    


<table border="1">
	<tr>
		<th colspan="2" height="100" width="750">
		
		<!-- 상단 메뉴 -->
		<jsp:include page="top.jsp" flush="false"/>
		
		</th>
	</tr>
	
	<tr>
	
	
	
	
	<% if(ver3.getIndexIs()==null || ver3.getIndexIs().equals("0") || ver3.getIndexIs().equals("1")) { %>
		<th height="300" width="200">
			<!-- 좌측 메뉴 -->
			<jsp:include page='<%=ver3.getControl()+"/"+ver3.getControl() + "Left.jsp"%>' flush="false"/>
		</th>
		
		<td width="500" valign="top">
			<!-- 가운데 내용 -->
			<br>
			&nbsp;<b><%=ver3.getName()%></b>
			<br><br>
			<%	
				if(ver3.getIndexIs() == null || ver3.getIndexIs().equals("0")) {
					%>&nbsp;<jsp:include page='<%=ver3.getControl()+"/"+ver3.getControl() + ver3.getCompany()+".jsp"%>' flush="false"/><%
				} else {
					%>&nbsp;<jsp:include page='<%=ver3.getControl()+"/"+ver3.getControl() + ".jsp"%>' flush="false"/><%
				}
			%>
		</td>
	<% } else if(ver3.getIndexIs().equals("2")) { %>
		<td colspan="2" height="300" valign="top">
			&nbsp;<jsp:include page='<%="botMenu/menu"+ver3.getBotMenu() + ".jsp"%>' flush="false"/>
		</td>
	<% } %>
	
	
	
	
	</tr>
	
	<tr>
		<th colspan="2" height="100">
			<!-- 하단 메뉴 -->
			<jsp:include page="bottom.jsp" flush="false"/>
		</th>
	</tr>
</table>
    
<h1>디버깅용</h1>
get한 control 는 : <%=ver3.getControl()%> <br>
get한 company 는 : <%=ver3.getCompany()%> <br>
get한 indexIs 는 : <%=ver3.getIndexIs()%> <br>
get한 name 은 : <%=ver3.getName()%> <br>
get한 botMenu 는 : <%=ver3.getBotMenu()%> <br>