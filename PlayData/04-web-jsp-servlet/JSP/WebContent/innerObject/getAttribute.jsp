<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<h2> 내장객체 - 내장객체영역 - 확인 페이지 </h2>
	
	request : <%=request.getAttribute("id")%><br>
	session : <%=session.getAttribute("id")%><br>
	application : <%=application.getAttribute("id")%><br>
	
	<!-- request는 거의 submit으로 받을 때 많이 공유를 해, 그거 말고도 있지만
	지금 무슨 요청을 해서 넘긴게 아니라 버튼 누르면 그냥 넘겨버린거지. 그래서 앞 뒤의 request는 공유를 안해
	처리를 공유하는 페이지들 끼리 데이터를 넘길 수 있는 것.
	
	session / setAttribute 로  실행했던 걸, 끄고 getAttribute 부터 실행하면 null이 나오는 걸 볼 수 있다.
	
	application 은 서버를 껐다 키면 없어진다. -->