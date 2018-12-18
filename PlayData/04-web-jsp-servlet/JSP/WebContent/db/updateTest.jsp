<%@page import="javax.naming.NamingException"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2> JDBC - update - 처리페이지 </h2>
<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
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
		
		Context	initCtx = new InitialContext();
		Context envCtx	= (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/encore");
		con = ds.getConnection();
		
		String sql = null;
		
		sql = "UPDATE dbtest SET passwd=?, tel=? WHERE id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, passwd);
		pstmt.setString(2, tel);
		pstmt.setString(3, id);
		
		int result = pstmt.executeUpdate();
		
		if(result == 0) {
			// 수정 실패
			%>
			회원정보 수정에 실패했습니다. <br>
			잠시 후 다시 시도하세요 <br>
			<meta http-equiv="refresh" content="2;url=updateTestForm.jsp">
			<%
		} else {
			// 수정 성공
			response.sendRedirect("selectTest.jsp?id="+id);
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