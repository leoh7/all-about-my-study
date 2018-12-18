import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


class DBConnectEx3 {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public DBConnectEx3(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void setConnection(){
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "HR";
		String dbPasswd = "hr";
		try{
			con = DriverManager.getConnection(url, dbId, dbPasswd);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void getMember(){
		String sql = "SELECT * FROM locations";
		
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery( sql );

			while( rs.next() ){
				System.out.println(
					rs.getString("location_id") + "\t" +
					rs.getString("street_address") + "\t" +
					rs.getString("postal_code") + "\t" +
					rs.getString("city") + "\t" +
					rs.getString("state_province") + "\t" +
					rs.getString("country_id")

				);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args)	{
		DBConnectEx3 de3 = new DBConnectEx3();
		de3.setConnection();
		de3.getMember();
	}
}
