<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h2> JDBC - select - 출력 페이지 </h2>
    
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
	
	/* 	Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "encore";
		String dbPasswd = "encore";
		
		con = DriverManager.getConnection(url, dbId, dbPasswd); */
		
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/encore");
		con = ds.getConnection();
		
		String id = request.getParameter("id");
		
		String sql = null;
		if(id == null || id.equals("")) {
			sql = "SELECT * FROM dbtest ORDER BY logtime ASC";
			pstmt = con.prepareStatement(sql);
		} else {
			sql = "SELECT * FROM dbtest WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
		}
		
		
		rs = pstmt.executeQuery();
		
		
			%>
			<table border="1">
				<%
				while(rs.next()) {
					%>
						<tr>
							<td> <%=rs.getString("id")%></td>
							<td> <%=rs.getString("passwd")%></td>
							<td> <%=rs.getString("name")%></td>
							<td> <%=rs.getString("tel")%></td>
							<td> <%=rs.getTimestamp("logtime")%></td>
						</tr>
					<%
				}
				%>
			</table>
			
			<%	
		
		
	} catch (NamingException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try{
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
			if(con != null)con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
%>