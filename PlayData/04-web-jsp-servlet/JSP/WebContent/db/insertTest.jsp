<%@page import="javax.naming.NamingException"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2> JDBC - insert - 처리페이지 </h2>

<%
	request.setCharacterEncoding("utf-8");
%>

<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
%>

<%
	Connection con = null;
	PreparedStatement pstmt = null;
	
	try {
		/* Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "encore";
		String dbPasswd = "encore";
		con = DriverManager.getConnection(url, dbId, dbPasswd); */
		
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/encore");
		con = ds.getConnection();
		
		String sql = null;
		
		sql = "INSERT INTO dbtest VALUES(?,?,?,?,sysdate)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, passwd);
		pstmt.setString(3, name);
		pstmt.setString(4, tel);
		
		int result = pstmt.executeUpdate();
		if(result == 0) {
			%> 회원가입에 실패 했습니다. <br> 잠시 후 다시 시도하세요.
			<meta http-equiv="refresh" content="2;url=insertTestForm.jsp">
			<%
		} else {
			response.sendRedirect("selectTest.jsp");
			%> 회원가입에 성공 했습니다. <%
		}
		
	}catch(NamingException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally{
		try {
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
%>