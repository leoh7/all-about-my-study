<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h2> script - expression 연습 1</h2>
    
    <%
    	// 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55
    	int tmp = 0;
    	int sum = 0;
    	String strTmp = "";
    	
    	
    	for(int i = 0; i<10; i++){
    		tmp = i+1;
    		
    		if(i != 0){
    			strTmp = strTmp + " + " + tmp;
    		} else {
    			strTmp = ""+tmp;
    		}
    		
    		sum = sum + tmp;
    	}
    	
    	//out.print(strTmp+ " = " +sum);
    	%>
    	<%=strTmp + " = " + sum %>
    	<%
    %>
    
    <% /*풀이 이상해 ㅠㅠㅠ*/ 
    	%>
    		<br>
    		<%="풀이"%>
    	<%
    	int sumT = 0;
    	for(int i=1; i<11; i++) {
    		sumT += i;
    		if(i < 10){
    			%>
    			<%=i%> +
    			<%
    		} else {
    			%>
    			<%=i%> =
    			<%
    		}
    	}
    	%>
		<%=sumT %>
		
    
    
    
    
    