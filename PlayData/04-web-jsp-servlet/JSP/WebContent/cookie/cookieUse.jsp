<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2> Cookie - 확인 페이지 </h2>

<%
	/* 내가 만든 쿠키만 나한테 돌려주게 되있어, 내가 그걸 받으면 되는데, 쿠키를 하나만 넣었다는 보장이 없기 때문에
	get메서드를 쓰는데 get쿠키 이거 안되. getCookies 해서 다 가져와야되. 
	웹 브라우저는 서버에 저장된 쿠키를 다 가져오게 되있어 */
	
	// 클라이언트에서 서버로 넘어오는 부분이기 때문에
	Cookie cookies[] = request.getCookies();
	for(int i=0; i<cookies.length; i++) {
		%>
		<%=cookies[i].getName()%> : <%=cookies[i].getValue()%> <br>
		<%
		
	}
	

%>