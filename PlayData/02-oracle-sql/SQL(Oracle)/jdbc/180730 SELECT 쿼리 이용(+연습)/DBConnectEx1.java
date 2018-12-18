import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;

class DBConnectEx1 {
	private Connection con;		// Connection 은 곧 Session 인 듯?
	private Statement stmt;
	private ResultSet rs;

	public DBConnectEx1(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	public void setConnection(){	//Connection 엔 url, dbId, dbPasswd 가 필요하겠지???
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "encore";
		String dbPasswd = "encore";
		try{
			con = DriverManager.getConnection(url, dbId, dbPasswd);
			System.out.println("DB 접속 성공");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void getMember(){
		String sql = "SELECT * FROM dbtest";
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

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
				if(rs != null) {rs.close(); System.out.println("ResultSet : close");}
				if(stmt != null) {stmt.close(); System.out.println("Statement : close");}
				if(con != null) {con.close(); System.out.println("Connection : close");}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}		

	}


	public static void main(String[] args) {
		DBConnectEx1 de1 = new DBConnectEx1();
		de1.setConnection();
		de1.getMember();
	}
}
