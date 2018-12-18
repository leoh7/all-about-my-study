<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>expression 과제</title>
</head>
<body>
	<h2> expression 과제 - 별찍기</h2>
	<table border = "1">
	<% 
		int cnt = 0;
		int SIZE = 11;
		int m[][] = new int[SIZE][SIZE];
		
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m[i].length; j++) {
				if(i<=j+(SIZE/2) && i+(SIZE/2)>=j && (i+j >= (SIZE-1)-(SIZE/2)) && (i+j-(SIZE/2) <= (SIZE-1)) )
					m[i][j] = ++cnt;
			}
		}
		
		for(int i=0; i<m.length; i++){
			%> </tr> <%
			for(int j=0; j<m[i].length; j++){
				if(m[i][j] != 0) {
					%> <td align="center" width="22px"><%=" "+ m[i][j] +" "%></td> <%
				}else if(m[i][j] == 0) {
					%> <td></td> <%
				}
			}
			%> </tr> <%
		}
	%>
	</table>
</body>
</html>