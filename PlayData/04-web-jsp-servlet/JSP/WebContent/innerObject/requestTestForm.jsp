<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    

    <h2> 내장객체 - request - 입력 페이지 </h2>
    
    <form method="post" action="requestTest.jsp">
    	<table border="1">
    		<tr>
    			<th> 이름 </th>
    			<td> <input type="text" name="name"></td>
    		</tr>
    		<tr>
    			<th> 나이 </th>
    			<td> <input type="text" name="age"></td>
    		</tr>
    		
    		<tr>
    			<th> 성별 </th>
    			<td> 
    				<label> <input type="radio" name="gender" value="1"> 남자 </label>
    				<label> <input type="radio" name="gender" value="2"> 여자 </label>
    			</td>
    		</tr>
    		
    		<tr>
    			<th> 취미 </th>
    			<td>
    				<label> <input type="checkbox" name="hobby" value="1"> 독서 </label>
    				<label> <input type="checkbox" name="hobby" value="2"> 등산 </label>
    				<label> <input type="checkbox" name="hobby" value="3"> 운동 </label>
    				<label> <input type="checkbox" name="hobby" value="4"> 게임 </label>
    				
    			</td>
    		</tr>
    		
    		<tr>
    			<th colspan="2">
    				<input type="submit" value="전송">
    				<input type="reset" value="취소">
    			</th>
    		</tr>
    	</table>    
    
    </form>