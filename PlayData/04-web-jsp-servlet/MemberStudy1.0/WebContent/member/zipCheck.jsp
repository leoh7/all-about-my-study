<%@page import="java.util.ArrayList"%>
<%@page import="memberStudy.ZipcodeBean"%>
<%@page import="memberStudy.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="setting.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=project%>style_member.css">
<script src="<%=project%>script.js"></script>

<%
	request.setCharacterEncoding("utf-8");
%>

<h2><%=page_zipcheck%></h2>

<body onload="zipfocus()">
	<form name="zipform" method="post" action="zipCheck.jsp">
		<table>
			<tr>
				<th colspan="2"><%=str_msg_address%></th>
			</tr>
			
			<tr>
				<th><%=str_address%></th>
				<td>
					<input class="input" type="text" name="area3">
					<input class="inputbutton" type="submit" value="<%=btn_search%>">
				</td>
			</tr>
		
		<%
		String area3 = request.getParameter("area3");
		if(area3==null || area3.equals("")) {
		} else {
			LogonDBBean zipDao = LogonDBBean.getInstance();
			ArrayList<ZipcodeBean> zipArray = zipDao.getZipcodes(area3);
			
			for(int i=0; i<zipArray.size(); i++) {
		%>
				<tr>
					<td colspan="2">
						<%
							String ziptmp[] = zipArray.get(i).getZipcode().split("-");
						%>
						<%
							if(session.getAttribute("memid")==null) {
						%>
						<a href="#" onclick="opener.document.inputform.zipcode1.value='<%=ziptmp[0]%>',
							opener.document.inputform.zipcode2.value='<%=ziptmp[1]%>',
							opener.document.inputform.address1.value='<%=
							zipArray.get(i).getArea1() + " " 
							+ zipArray.get(i).getArea2() + " "
							+ zipArray.get(i).getArea3() + " "%>',
							zipcheckin()">
							<div>
							&nbsp<%=zipArray.get(i).getZipcode()%>&nbsp
							<%=zipArray.get(i).getArea1()%>&nbsp
							<%=zipArray.get(i).getArea2()%>&nbsp
							<%=zipArray.get(i).getArea3()%>&nbsp
							<%=zipArray.get(i).getArea4()%>&nbsp
							</div>
						</a>
						<%
							} else {
								%>
								<a href="#" onclick="opener.document.modifyform.zipcode1.value='<%=ziptmp[0]%>',
									opener.document.modifyform.zipcode2.value='<%=ziptmp[1]%>',
									opener.document.modifyform.address1.value='<%=
									zipArray.get(i).getArea1() + " " 
									+ zipArray.get(i).getArea2() + " "
									+ zipArray.get(i).getArea3() + " "%>',
									zipcheckin()">
									<div>
									&nbsp<%=zipArray.get(i).getZipcode()%>&nbsp
									<%=zipArray.get(i).getArea1()%>&nbsp
									<%=zipArray.get(i).getArea2()%>&nbsp
									<%=zipArray.get(i).getArea3()%>&nbsp
									<%=zipArray.get(i).getArea4()%>&nbsp
									</div>
								</a>
								<%
							}
						%>
					</td>
				</tr>
				<%
			}
		}
		%>
		</table>
	</form>
</body>