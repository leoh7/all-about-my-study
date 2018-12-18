<%@page import="javax.naming.NamingException"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2> JDBC - delete - 처리 페이지</h2>

<%
	request.setCharacterEncoding("utf-8");
%>

<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
%>

<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
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
		
		sql = "SELECT * FROM dbtest WHERE id=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			// 아이디가 있다는 얘기
			if(passwd.equals(rs.getString("passwd"))) {
				// 비밀번호가 같다
				sql = "DELETE FROM dbtest WHERE id=?";
				pstmt.close();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				int result = pstmt.executeUpdate();
				
				if(result == 0) {
					// 탈퇴 실패	탈퇴에 실패했습니다. 잠시 후 다시 시도하세요 출력 후 2초 뒤 폼 페이지로 이동
					%> 탈퇴에 실패했습니다.<br> 잠시 후 다시 시도해세요
						<meta http-equiv="refresh" content="2;url=deleteTestForm.jsp">
					<%
				} else {
					// 탈퇴 성공	selectTest.jsp 로 이동 전체 리스트 출력
					response.sendRedirect("selectTest.jsp");
				}
				
				
			} else {
				// 비밀번호가 다르다.
				%>
				입력하신 비밀번호가 다릅니다<br> 다시 확인하세요
				<meta http-equiv="refresh" content="2;url=deleteTestForm.jsp">
				<%
			}
		} else {
			// 아이디가 없다는 얘기
			%>입력하신 아이디가 존재하지 않습니다. <meta http-equiv="refresh" content="2;url=deleteTestForm.jsp"><%
		}
		
	}catch(NamingException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally{
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
%>