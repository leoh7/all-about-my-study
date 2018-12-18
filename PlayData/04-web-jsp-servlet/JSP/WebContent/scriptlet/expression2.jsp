<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head>
<!--     	<link rel="stylesheet" text="text/css" href="style_hjh.css">  -->
    </head>
    <body>
	    <h2> script - expression 연습 2 </h2><br>
	    <h2> 구구단 출력 </h2>
		
 			<table border = 2px solid;>			 
<!--			<table width="1000px">			-->
		    <%
		    // 2단 3단 4단 5단 6단 ... 9단
		    //2*1=2
		    //2*2=4
		    // ...
		    	int multiple = 0;
		    	%> <tr> <%
		    	for(int i=2; i<10; i++) {
		    		%> <td align=center> <%
		    		%> <%= i+"단" %> <%
		    		%> </td> <%
		    	}
		    	%> </tr> <%
		    
		    	for(int i=1; i<10; i++) {
		    		%> <tr> <% 
		    		
		    		for(int j=2; j<10; j++) {
		    			%> <td> <%
		    			multiple = j*i;
		    			%> <%= j +" * "+ i +" = "+ multiple +" " %> <%
						%> </td> <%	    		
		    		}
		    		%> </tr> <%
		    	}
		    
		    %>
	    
	    </table>
	    
	    <table border="1">
	    	<%
	    	for(int i=1; i<10; i++) {
	    		%>
	    			<tr>
	    		<%
	    		for(int j=2; j<10; j++) {
	    			%>
	    			<td><%=j %> * <%=i %> = <%=i*j %></td>
	    			<%
	    		}
	    		%> </tr> <%
	    	}
	    	%>
	    </table>
    </body>
</html>