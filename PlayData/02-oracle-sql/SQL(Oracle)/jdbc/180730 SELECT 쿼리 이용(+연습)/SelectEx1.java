import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

class SelectEx1 {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;


	public SelectEx1(){			//����̹� �ε�
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("����̹� �ε� ����");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	public void setConnection(){ // DB���� -> Connection ��ü
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "encore";
		String dbPasswd = "encore";
		

		try{
			con = DriverManager.getConnection(url, dbId, dbPasswd);
			//System.out.println("DB ���� ����");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void getMember(String id){
		String sql = null;		// �ؿ� ������ ���������� �Ǳ� ������ ������ ���־���

		if (id != null){
			sql = "SELECT * FROM dbtest WHERE id = '" + id + "'";
			System.out.println( sql );
		}else if( id == null || id.equals("")){
			sql = "SELECT * FROM dbtest";
			System.out.println( sql );
		}

		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery( sql );
			
			while( rs.next() ){
				System.out.println(
					rs.getString( "id" ) + "\t"
					+ rs.getString( "passwd" ) + "\t"
					+ rs.getString( "name" ) + "\t"
					+ rs.getString( "tel" ) + "\t"
					+ rs.getTimestamp( "logtime" )
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
		SelectEx1 se1 = new SelectEx1();
		se1.setConnection();
		se1.getMember( "aaa" );
	}
}
