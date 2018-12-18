<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    buffer="10kb"
    %>

    <h2> 내장객체 - out </h2>
    
    <%
    	int size = out.getBufferSize();
    	int remain = out.getRemaining();
    	int use = size - remain;
    %>
    버퍼 크기 : <%= size %> <br>
    남은 크기 : <%= remain %> <br>
    사용 크기 : <%= use %> <br>