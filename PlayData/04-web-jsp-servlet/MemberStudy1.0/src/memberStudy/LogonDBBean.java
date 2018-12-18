package memberStudy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class LogonDBBean {
	// DB처리할 게 있으면 여기다 부탁할거
	// JSP 가 얘를 호출할 거다
	// LogonDBBean 객체를 만들고, 메서드를 쓰면되
	//	근데 JSP가 전부다 객체들을 만들면 메모리가 낭비가되니까
	//	여기서 객체를 만들어서 뿌려줄거야.
	//	이게 싱글톤 패턴 방식
	
	// 바로 접근할 수 있도록 static으로 만들어 줬다.
	private static LogonDBBean instance = new LogonDBBean();
	public static LogonDBBean getInstance() {
		return instance;
	}
	
	
	// 커넥션 받아오는 부분을 여기다 줄것
	// 내부호출이라 static 은 필요 없다.
	// 얘를 받아 쓰는 쪽에선 어차피 예외를 던질거니깐 그냥 던져준다.
	public Connection getConnection() throws NamingException, SQLException {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/encore");
		return ds.getConnection();
	}
	public int modifyMember(LogonDataBean memberDto) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "UPDATE memberstudy SET passwd=?,zipcode=?,address=?,tel=?,email=? WHERE id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDto.getPasswd());
			pstmt.setString(2, memberDto.getZipcode());
			pstmt.setString(3, memberDto.getAddress());
			pstmt.setString(4, memberDto.getTel());
			pstmt.setString(5, memberDto.getEmail());
			pstmt.setString(6, memberDto.getId());
			result = pstmt.executeUpdate();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	} // updateMember(LogonDataBean memberDto)
	
	public int insertMember(LogonDataBean memberDto) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "INSERT INTO memberstudy VALUES( ?,?,?,?,?,?,?,?,?,? )";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getPasswd());
			pstmt.setString(3, memberDto.getName());
			pstmt.setString(4, memberDto.getJumin1());
			pstmt.setString(5, memberDto.getJumin2());
			pstmt.setString(6, memberDto.getZipcode());
			pstmt.setString(7, memberDto.getAddress());
			pstmt.setString(8, memberDto.getTel());
			pstmt.setString(9, memberDto.getEmail());
			pstmt.setTimestamp(10, memberDto.getReg_date());
			result = pstmt.executeUpdate();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	} // insertMember(LogonDataBean memberDto)
	
	// deleteMember
	public int deleteMember(String id) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "DELETE FROM memberstudy WHERE id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	} // deleteMember
	
	// check() 아이디 체크
	public int check(String id) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "SELECT * FROM memberstudy WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				// 아이디가 있는 것
				result = 1;
			} else {
				// 아이디가 없는 것
				result = 0;
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return result;
	} // check(String id)
	public int check(String id, String passwd) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "SELECT * FROM memberstudy WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				// 아이디가 있는 것
				if(passwd.equals(rs.getString("passwd"))) {
					result = 1;
				} else {
					result = -1;
				}
			} else {
				// 아이디가 없는 것
				result = 0;
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return result;
	} // check(String id, String passwd)


	public LogonDataBean getMember(String id) {
		LogonDataBean memberDto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "SELECT * FROM memberstudy WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// 참조변수에다가 데이터를 넣을 순 없어
				// 객체에다가 넣어줘야 함
				memberDto = new LogonDataBean();
				memberDto.setId(rs.getString("id"));
				memberDto.setPasswd(rs.getString("passwd"));
				memberDto.setName(rs.getString("name"));
				memberDto.setJumin1(rs.getString("jumin1"));
				memberDto.setJumin2(rs.getString("jumin2"));
				memberDto.setZipcode(rs.getString("zipcode"));
				memberDto.setAddress(rs.getString("address"));
				memberDto.setTel(rs.getString("tel"));
				memberDto.setEmail(rs.getString("email"));
				memberDto.setReg_date(rs.getTimestamp("reg_date"));
				
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return memberDto;
	}
	
	
	
	
	public ArrayList getZipcodes(String area3) {
		ZipcodeBean zipDto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ZipcodeBean> zipArray = new ArrayList<ZipcodeBean>();
		
		try {
			con = getConnection();
			String sql = "SELECT * FROM zipcode WHERE area3=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area3);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				zipDto = new ZipcodeBean();
				zipDto.setZipcode(rs.getString("zipcode"));
				zipDto.setArea1(rs.getString("area1"));
				zipDto.setArea2(rs.getString("area2"));
				zipDto.setArea3(rs.getString("area3"));
				zipDto.setArea4(rs.getString("area4"));
				zipArray.add(zipDto);
				
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return zipArray;
	}
	
} // class







