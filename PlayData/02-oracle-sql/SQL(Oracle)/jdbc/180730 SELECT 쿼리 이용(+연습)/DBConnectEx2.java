import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

class DBConnectEx2 {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public DBConnectEx2(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	public void setConnection(){	// DB에 커넥션 하려면 url, dbId, dbPasswd 가 필요
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String dbId ="encore";
		String dbPasswd ="encore";
		try{
			con = DriverManager.getConnection(url, dbId, dbPasswd);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void getMember(){
		String sql = "SELECT * FROM dbtest";
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery( sql );
			
			while( rs.next() ){
				System.out.println(
					rs.getString("id") + "\t" +
					rs.getString("passwd") + "\t" +
					rs.getString("name") + "\t" +
					rs.getString("tel") + "\t" +
					rs.getTimestamp("logtime")
				);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {
		DBConnectEx2 de2 = new DBConnectEx2();
		de2.setConnection();
		de2.getMember();
	}
}
