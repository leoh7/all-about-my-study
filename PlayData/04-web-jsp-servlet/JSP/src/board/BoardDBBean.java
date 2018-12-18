package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDBBean {
	private static BoardDBBean instance = new BoardDBBean();
	public static BoardDBBean getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws NamingException, SQLException {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/encore");
		return ds.getConnection();
	}
	public int getCount() {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "SELECT count(*) FROM board";
			pstmt = con.prepareStatement(sql);
	
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
//				rs.getInt("count(*)");
				count = rs.getInt(1);
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	public int insertArticle(BoardDataBean boardDto) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			int num = boardDto.getNum();
			int ref = boardDto.getRef();
			int re_step = boardDto.getRe_step();
			int re_level = boardDto.getRe_level();
						//	그룹화id /그룹 내 순서		몇 번째 댓글인가(들여쓰기)
			// 번호 			ref		re_step		re_level
			// 10 제목글		8		0			0
			// 11 ㄴ1답글		8		0+1			0+1
			// 12  ㄴ재답글		8		0+1+1		0+1+1
			// 13 ㄴ2답글		8		0+1			0+1		// 얘가 최신이니까 10번 밑으로 올리고 싶다 / 변경
			
			
				//			그룹화id /그룹 내 순서		몇 번째 댓글인가(들여쓰기)
			// 번호 			ref		re_step		re_level
			// 10 제목글		8		0			0
			// 11 ㄴ1답글		8		0+1(+1)		0+1
			// 12  ㄴ재답글		8		0+1+1(+1)	0+1+1
//변경->		// 13 ㄴ2답글		8		0+1			0	
									// 자기보다 큰 애들은 re_step을 하나씩 밀어버리고 그 후 자기는 +1
									// update 후에 insert를 해야 하는 것.
			String sql = null;
			if(num == 0) {
				// 제목글
				sql = "SELECT MAX(num) FROM board";	// 글이 있는 경우와 없는 경우를 나눠줘야한다.
													// 글이 없을 땐 null 을 가져오고 그러면 rs.next()가 false가 나올것
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					// 글이 있는 경우
					ref = rs.getInt(1) + 1; // 그룹화아이디 = 글번호 최대값 + 1
				} else {
					// 글이 없는 경우
					ref = 1;
				}
				
				re_step = 0;
				re_level = 0;
			} else {
				// 답변글
				sql = "UPDATE board SET re_step=re_step+1 WHERE ref=? and re_step>?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();
				
				re_step ++;
				re_level ++;
			}
			pstmt.close(); // pstmt 를 한번 썼기 때문에 닫아준다
			sql = "INSERT INTO board(num, writer, email, subject, passwd, reg_date, ref, re_step, re_level, content, ip) "
					+ "VALUES( board_seq.NEXTVAL, ?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardDto.getWriter());
			pstmt.setString(2, boardDto.getEmail());
			pstmt.setString(3, boardDto.getSubject());
			pstmt.setString(4, boardDto.getPasswd());
			pstmt.setTimestamp(5, boardDto.getReg_date());
			pstmt.setInt(6, ref);
			pstmt.setInt(7, re_step);
			pstmt.setInt(8, re_level);
			pstmt.setString(9, boardDto.getContent());
			pstmt.setString(10, boardDto.getIp());
			
			result = pstmt.executeUpdate();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	public ArrayList<BoardDataBean> getArticles(int start, int end){
		
		ArrayList<BoardDataBean> articles = null;

		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
		    
			// sql 중 *를 하나 쓸 수 있다. 찾아서 쓰도록
			// 시퀀스는 최근 가져온 값이 가장 큰 값이야. // 내가 가져온 값
			// 그걸 가지고 num 을 잡았으니까 가장 최근게 번호가 가장 커. 그걸 가지고 ref를 만들었으니까
			// 그룹화 아이디도 가장 최근에 쓴 게 가장 크고 그걸로 내림차순 정렬이 되있다
			// start 랑 end 값을 가지고 rownum 을 사용한다 그랬어
			// rownum 의 alias 가 r / SELECT의 순서와 기능 : 정렬 -> 정렬에 번호붙이기 -> 그 중에 내가 원하는거 10개만 가져오겠다
			String sql = "select num,writer,email,subject,passwd,";
		    sql+= "reg_date,ref,re_step,re_level,content,ip,readcount,r ";
		    sql+= "from (select num,writer,email,subject,passwd,reg_date,ref,re_step";
		    sql+= ",re_level,content,ip,readcount,rownum r from ";
		    sql+= "(select * from board order by ref desc, re_step asc) ";
		    sql+= "order by ref desc, re_step asc ) where r >= ? and r <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 글 하나 꺼내옴 컬럼이 12개
				// 글이 있을 때 호출하기로 했으니 글이 없을 수는 없다고 상정하고 갈 수 있음.
				articles = new ArrayList<BoardDataBean>(end - start + 1);	// 10 - 1 + 1
				do {
					BoardDataBean article = new BoardDataBean();	// 바구니 채우기
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPasswd(rs.getString("passwd"));
					article.setReg_date(rs.getTimestamp("reg_date"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setRe_step(rs.getInt("re_step"));
					article.setRe_level(rs.getInt("re_level"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
					
					articles.add(article);
					
				} while(rs.next());
			}
		    
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return articles;
	}
	
	public BoardDataBean getArticle( int num ) {
		BoardDataBean article = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "SELECT * FROM board WHERE num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				article = new BoardDataBean();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPasswd(rs.getString("passwd"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return article;
	}
	public void addCount(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			con = getConnection();
			String sql = "UPDATE board SET readcount=readcount+1 WHERE num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int check(int num, String passwd) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "SELECT * FROM board WHERE num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(passwd.equals(rs.getString("passwd"))) {
					result = 1;
				} else {
					result = 0;
				}
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int deleteArticle(int num) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			//					그룹화id  그룹 내 순서		몇 번째 댓글인가(들여쓰기)
			// 번호				ref		res_step	re_level
			// 10 제목글			8		0			0
			// 13  ㄴ 나중에 쓴 답글	8		1			1
			// 11 ㄴ 답글			8		2			1
			// 12	ㄴ재답글		8		3			2
			
			// ref 		= ?		// 나랑 같아야 해
			// re_step 	= ?+1	// 나보다 하나 큰게 있나?
			// re_level > ?		// 나보다 큰게 있나?
			// 이 세가지 조건을 만족하면 답글이 있다고 판단할 수 있다.
			
			// 중간에 끼어넣은 11 같은 애가 지워져 버리면?
			// 하나씩 땡겨줘야 함
			// 번호				ref		res_step	re_level
			// 10 제목글			8		0			0
			// 13  ㄴ 나중에 쓴 답글	8		1			1
			// 11 ㄴ 답글			8		2			1
			// 12	ㄴ재답글		8		3			2
			
			// 번호				ref		res_step	re_level
			// 10 제목글			8		0			0
			// 11 ㄴ 답글			8		2-1			1
			// 12	ㄴ재답글		8		3-1			2
		
			
			//삭제를 하기전에 답글이 있는지를 먼저 확인 필요
			BoardDataBean article = getArticle(num);	// 같은 클래스에 있는 거니까 그냥 가져다 쓰면 됨
			int ref = article.getRef();
			int re_step = article.getRe_step();
			int re_level = article.getRe_level();
			
			String sql = null;
			sql = "SELECT * FROM board WHERE ref=? AND re_step=?+1 AND re_level>?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, re_step);
			pstmt.setInt(3, re_level);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// 답글이 있는 경우
				result = -1;
			} else {
				// 답글이 없는 경우
				sql = "UPDATE board SET re_step=re_step-1 WHERE ref=? AND re_step>?";
				pstmt.close();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();
				
				sql = "DELETE FROM board WHERE num=?";
				pstmt.close();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				result = pstmt.executeUpdate();
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int modifyArticle(BoardDataBean article) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			con = getConnection();
			
			String sql = "UPDATE board SET email=?, subject=?, content=?, passwd=? WHERE num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getEmail());
			pstmt.setString(2, article.getSubject());
			pstmt.setString(3, article.getContent());
			pstmt.setString(4, article.getPasswd());
			pstmt.setInt(5, article.getNum());
			result = pstmt.executeUpdate();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
}
