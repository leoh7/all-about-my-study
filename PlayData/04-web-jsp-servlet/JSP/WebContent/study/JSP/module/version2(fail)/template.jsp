<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2> 템플릿 페이지 </h2>

	<jsp:useBean id="bean" class="bean.StudyBean" scope="session"/>

<%
	boolean tmpIs = true;

	if(bean.getIndexIs().equals("1")) {
		tmpIs = true;
	} else if(bean.getIndexIs().equals("0")) {
		tmpIs = false;
	}
%>

<table border="1">
	<tr>
		<th colspan="2" height="100">
		
		<!-- 상단 메뉴 
		<jsp:include page="top.jsp" flush="false"/>
		-->
		</th>
	</tr>
	
	<tr>
		<th height="300" width="200">
			<!-- 좌측 메뉴 
			<jsp:include page='<%=bean.getControl()+"/"+bean.getControl() + "Left.jsp"%>' flush="false"/>
			-->
		</th>
		
		<td width="500" valign="top">
			<!-- 가운데 내용
			<br>
			&nbsp;<b><%=bean.getName()%></b>
			<br><br>
			<%
				if(tmpIs) {
					%>&nbsp;<jsp:include page='<%=bean.getControl()+"/"+bean.getControl() + ".jsp"%>' flush="false"/><%
				} else if(!tmpIs) {
					%>&nbsp;<jsp:include page='<%=bean.getControl()+"/"+bean.getControl() + bean.getCompany() +".jsp"%>' flush="false"/><%
				}
			%>
			 -->
		</td>
	</tr>
	
	<tr>
		<th colspan="2" height="100">
			<!-- 하단 메뉴 -->
			<jsp:include page="bottom.jsp" flush="false"/>
			
		</th>
	</tr>
</table>

