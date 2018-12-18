import java.sql.*;
import java.io.*;

class UpdateTest {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;


	public UpdateTest() throws ClassNotFoundException{
		System.out.println("����̹� �ε� ��...");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("����̹� �ε� ����!");
	}
	
	public void setConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "encore";
		String dbPasswd = "encore";

		con = DriverManager.getConnection(url, dbId, dbPasswd);
		System.out.println("DB ���� ����!");
	}

	public void updateMember() throws SQLException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("���̵� : ");
		String id = br.readLine();
		
		System.out.print("��й�ȣ : ");
		String passwd = br.readLine();
		
		String sql = "SELECT * FROM dbtest WHERE id= '" + id + "'";
		stmt = con.createStatement();
		rs = stmt.executeQuery( sql );	// rs.next() �� �ΰ��� ���� �Ѵ�. Ʃ�� �� ���� �����°�, ������ true, �� ������ false
		
		// while���� ���� Ǯ�䰡 ����. ������ �ϳ��� �����ðŴϱ�
		if( rs.next() ){
			// true = ���̵� �ִ�.
			if( passwd.equals(rs.getString("passwd") ) ){	//��й�ȣ üũ
				// ��й�ȣ ����.
				System.out.println();
				System.out.println( 
					"\t" + "���̵� : " + rs.getString("id") + "\n" +
					"\t" + "��й�ȣ : " + rs.getString("passwd") + "\n" +
					"\t" + "�̸� : " + rs.getString("name") + "\n" +
					"\t" + "��ȭ��ȣ : " + rs.getString("tel") + "\n" +
					"\t" + "�������� : " + rs.getTimestamp("logtime")					
				);
				System.out.println();
				
				System.out.print("������ ��й�ȣ : ");
				String newPw = br.readLine();

				System.out.print("������ ��ȭ��ȣ : ");
				String newTel = br.readLine();
				
				//����ó��
				sql = null;
				sql = "UPDATE dbtest SET passwd='"+newPw+"',tel='"+newTel+"' WHERE id='"+id+"'";
		//		stmt = con.createStatement(); ������ Session �� �ο��߱� ������ �ѹ��� �൵ �ȴ�.
				int result = stmt.executeUpdate( sql );

				if(result == 0 ){
				//��������	�������� ���
					System.out.println("���� ����");
				} else {
				//��������	�������� ��� / �ش� ���̵��� ������ ���
					System.out.println("���� ����");
					sql = null;
					sql = "SELECT * FROM dbtest WHERE id = '"+id+"'";
					
					stmt = con.createStatement();
					rs = stmt.executeQuery( sql );

					if(rs.next()){
						System.out.println();
						System.out.println( 
							"\t" + "���̵� : " + rs.getString("id") + "\n" +
							"\t" + "��й�ȣ : " + rs.getString("passwd") + "\n" +
							"\t" + "�̸� : " + rs.getString("name") + "\n" +
							"\t" + "��ȭ��ȣ : " + rs.getString("tel") + "\n" +
							"\t" + "�������� : " + rs.getTimestamp("logtime")					
						);
						System.out.println();
					}

				}	// close �� �޾ƾ� �ϴµ� ������

			} else {
				// ��й�ȣ�� �ٸ���
				System.out.println("��й�ȣ�� �ٸ���.");
			}


		} else {
			// false = ���̵� ����.
			System.out.println("�ش� ���̵� ����");
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		UpdateTest ut = new UpdateTest();
		ut.setConnection();
		ut.updateMember();
	}
}
