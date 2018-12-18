import java.sql.*;
import java.io.*;

class DeleteTest {
	private Connection con;
	private Statement stmt;

	public DeleteTest() throws ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	public void setConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "encore";
		String dbPasswd = "encore";
		
		con = DriverManager.getConnection(url, dbId, dbPasswd);
	}

	public void deleteMember(String id) throws SQLException {
		String sql = "DELETE FROM dbtest WHERE id = '"+id+"'";
		stmt = con.createStatement();
		
		int result = stmt.executeUpdate(sql);
		if(result == 0){
			System.out.println("Ż�����");
		}else{
			System.out.println("Ż�𼺰�");
		}

		if(stmt != null) stmt.close();
		if(con != null) con.close();
	}


	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		DeleteTest dt = new DeleteTest();
		dt.setConnection();

		SelectEx1 st = new SelectEx1();
		st.setConnection();
		st.getMember(null);
		System.out.println();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("������ ���̵� : ");	// ������ ���̵�� ��й�ȣ Ȯ���ؼ� ������ �ϴµ�, �װ� ���� �� �غ���.
		String id = br.readLine();
		dt.deleteMember(id);
		System.out.println();
		
		st.setConnection();
		st.getMember(null);
		
	}
}
