<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2> 템플릿 페이지 </h2>

<%--
	request.setCharacterEncoding("utf-8");
--%>

<%
	String control = request.getParameter("paramControl");
	String name = request.getParameter("paramName");
	String company = request.getParameter("paramCompany");
	String indexIs = request.getParameter("paramIndexIs");
%>

<%
	boolean tmpIs = true;

	if(indexIs.equals("1")) {
		tmpIs = true;
	} else if(indexIs.equals("0")) {
		tmpIs = false;
	}
%>

<table border="1">
	<tr>
		<th colspan="2" height="100">
		
		<!-- 상단 메뉴 -->
		<jsp:include page="top.jsp" flush="false"/>
		
		</th>
	</tr>
	
	<tr>
		<th height="300" width="200">
			<!-- 좌측 메뉴 -->
			<jsp:include page='<%=control+"/"+control + "Left.jsp"%>' flush="false"/>
		</th>
		
		<td width="500" valign="top">
			<!-- 가운데 내용 -->
			<br>
			&nbsp;<b><%=name%></b>
			<br><br>
			<%
				if(tmpIs) {
					%>&nbsp;<jsp:include page='<%=control+"/"+control + ".jsp"%>' flush="false"/><%
				} else if(!tmpIs) {
					%>&nbsp;<jsp:include page='<%=control+"/"+control + company +".jsp"%>' flush="false"/><%
				}
			%>
		</td>
	</tr>
	
	<tr>
		<th colspan="2" height="100">
			<!-- 하단 메뉴 -->
			<jsp:include page="bottom.jsp" flush="false"/>
		</th>
	</tr>
</table>

