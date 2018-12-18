import java.sql.*;
import java.io.*;

class UpdateTest {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;


	public UpdateTest() throws ClassNotFoundException{
		System.out.println("드라이버 로딩 중...");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로딩 성공!");
	}
	
	public void setConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "encore";
		String dbPasswd = "encore";

		con = DriverManager.getConnection(url, dbId, dbPasswd);
		System.out.println("DB 접속 성공!");
	}

	public void updateMember() throws SQLException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("아이디 : ");
		String id = br.readLine();
		
		System.out.print("비밀번호 : ");
		String passwd = br.readLine();
		
		String sql = "SELECT * FROM dbtest WHERE id= '" + id + "'";
		stmt = con.createStatement();
		rs = stmt.executeQuery( sql );	// rs.next() 는 두가지 일을 한다. 튜플 한 줄을 얻어오는거, 얻어오면 true, 못 얻어오면 false
		
		// while문을 돌릴 풀요가 없다. 어차피 하나만 가져올거니까
		if( rs.next() ){
			// true = 아이디가 있다.
			if( passwd.equals(rs.getString("passwd") ) ){	//비밀번호 체크
				// 비밀번호 같다.
				System.out.println();
				System.out.println( 
					"\t" + "아이디 : " + rs.getString("id") + "\n" +
					"\t" + "비밀번호 : " + rs.getString("passwd") + "\n" +
					"\t" + "이름 : " + rs.getString("name") + "\n" +
					"\t" + "전화번호 : " + rs.getString("tel") + "\n" +
					"\t" + "가입일자 : " + rs.getTimestamp("logtime")					
				);
				System.out.println();
				
				System.out.print("수정할 비밀번호 : ");
				String newPw = br.readLine();

				System.out.print("수정할 전화번호 : ");
				String newTel = br.readLine();
				
				//수정처리
				sql = null;
				sql = "UPDATE dbtest SET passwd='"+newPw+"',tel='"+newTel+"' WHERE id='"+id+"'";
		//		stmt = con.createStatement(); 위에서 Session 을 부여했기 때문에 한번만 줘도 된다.
				int result = stmt.executeUpdate( sql );

				if(result == 0 ){
				//수정실패	수정실패 출력
					System.out.println("수정 실패");
				} else {
				//수정성공	수정성공 출력 / 해당 아이디의 정보만 출력
					System.out.println("수정 성공");
					sql = null;
					sql = "SELECT * FROM dbtest WHERE id = '"+id+"'";
					
					stmt = con.createStatement();
					rs = stmt.executeQuery( sql );

					if(rs.next()){
						System.out.println();
						System.out.println( 
							"\t" + "아이디 : " + rs.getString("id") + "\n" +
							"\t" + "비밀번호 : " + rs.getString("passwd") + "\n" +
							"\t" + "이름 : " + rs.getString("name") + "\n" +
							"\t" + "전화번호 : " + rs.getString("tel") + "\n" +
							"\t" + "가입일자 : " + rs.getTimestamp("logtime")					
						);
						System.out.println();
					}

				}	// close 를 달아야 하는데 귀찮당

			} else {
				// 비밀번호가 다르다
				System.out.println("비밀번호가 다르다.");
			}


		} else {
			// false = 아이디가 없다.
			System.out.println("해당 아이디 없음");
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		UpdateTest ut = new UpdateTest();
		ut.setConnection();
		ut.updateMember();
	}
}
