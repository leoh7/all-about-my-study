// ojdbc6.jar // jdbc �ε� oracle �� �ϴ� 1.6�����̴� // ����Ŭ�� �����ؼ� ��ȭ�� �ϰ� ������. �׷��� �翬�� ����Ŭ ������ ������ �� �ִ� ����̹��� �ʿ��Ѱ�.
// �ڹٴ� �� OOP �� Ŭ������ �Ǿ��ִ�. // ����̹��� ��� �����Ѵ�? �����ϴ� �뼭 ���� / 
// ����̹� �ε��� �� ���� �ϸ� �ȴ�./ ������ // db������ ������ �����ߴ� �ؾ� ��/ �޼���� ����Ű� / 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

class SelectTest {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
//	private String id;

	public SelectTest(){
		// ����̹� �ε�
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver"); // �ٲ� �� �ִ� �����̾�, new �ع����� ���Ѱ���(�ٲ� �� ���� ����)�� �Ǿ����. spring �� ���ô� // ������ �����ϵ��� ��ü�� ����� ��� // Class�� �����ϴ� class �� static �޼����� ��!
			System.out.println("����̹� �ε� ����");
		}catch (ClassNotFoundException e){
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		}
	}// ������ 
	
	public void setConnection(){ //DB �� �����ϸ� Connection ��ü�� �����.
		//DB ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe";	// ����� �Է��ϰ� �ɰ̴ϴ� �ܿ켼��
		String dbId = "encore";
		String dbPasswd = "encore";

		try{
			con = DriverManager.getConnection(url, dbId, dbPasswd);
			System.out.println("DB ���� ����");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void getMember( String id ){
		// id�� null�� ���		��ü ���
		// id�� null�� �ƴ� ���	�ش� id�� ���
		

		// ���� �Ұ� ��� �����͸� �����ٰ� ��±��� �غ���
		String sql = "SELECT * FROM dbtest";
		// sql �� DB�� ������ �Ѵ�.
		// DB�� �˾Ƹ��� �� �ִ� ���·� ���� ������ �ϰ�
		try{
			stmt = con.createStatement(); // Statement ��� ��ü�� ���ƿ´�.
			rs = stmt.executeQuery( sql ); // �� ����� executeQuery()
									// executeUpdate() �̷��� �ΰ��� �޼��尡 �ִ�.
									// ���� �����ϳ�. DB�� �ٲ�� �۾��� �ƴϾ� �׷� executeQuery  SELECT�� ���� ���� �Ҹ�
									// DB�� �ٲ�� �۾��̸� executeUpdate INSERT UPDATE DELETE
			while( rs.next() ){
				System.out.println(
					rs.getString("id") + "\t"
					+ rs.getString( "passwd" ) + "\t"
					+ rs.getString( "name" ) + "\t"
					+ rs.getString( "tel") + "\t"
					+ rs.getTimestamp( "logtime" )
				);
			}
		}catch( SQLException e){ 
			e.printStackTrace();
		} finally {
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
		SelectTest st = new SelectTest ();
		st.setConnection();
		st.getMember( null );	// ���� "aaa" ��� �ָ� ����� "aaa" ���̵��� ������ ������ �ؾ� �Ѵٴ� ��. // null �� "aaa" �� �� �Ǿ� �Ѵ�.
	}
}



/* 
���α׷��� �������׼� DB�� �޾ƿ;��ϴµ�, �� ���� �����͸� ��� �޾� �ðž�? �����Ͱ� �ϳ��� �ƴϰ�
ResultSet �̶�� ��ü�� �־ �޴´�.
�׷��� ��� �Ǵ���. DB���� �� �ָ� executeQuery ��� �޼��尡 �װ� ��ü�� ���� �ִ°ž�. �װ� ResultSet ��ü�� �ִ°Ű�
�� ���� �����͸� ��� �߶� ����� ���ΰ��� �츮�� ����� �̾߱�.

1 Ʃ���� �ڸ��ž�
rs.next() �ѹ� ���� �ѹ� �߶�´�. Ư���ϰԵ� ���� �޼���� �Ѱ��� ���� �ϰ� ������ �ϴµ�, ��� �ΰ����� ��, �ڸ��� ���� �ϰ�/ �߶����� true�� �Ѿ��.
�ڸ��� ��� ���� �־�. ������ �߶��� ���߶��ٸ� �˷��ִ°ž�.
	�� ������ �� ������ �ڸ��ž�.
	rs.getString("id") �÷��� �̸��� �༭ ������.
	* date�ڷ����� ��¿��? rs.getTimestamp("logtime") �긦 ���� ��
*/