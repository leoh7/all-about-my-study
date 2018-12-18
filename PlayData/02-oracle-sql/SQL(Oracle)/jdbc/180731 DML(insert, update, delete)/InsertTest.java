import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class InsertTest {
	private Connection con;
	private Statement stmt = null;
//	private ResultSet rs; �̰� SELECT �� �ƴϴϱ� ResultSet �� ���� �ʿ䰡 ����

	public InsertTest(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	public void setConnection(){
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "encore";
		String dbPasswd = "encore";
		try{
			con = DriverManager.getConnection(url, dbId, dbPasswd);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void insertMember(String id, String passwd, String name, String tel){		// ������ beanClass (�ٱ���)�� ���� ������ �ϴµ� ���� ���ϴϱ�
		String sql = "INSERT INTO dbtest VALUES("
					+"'"+ id +"', '"+ passwd +"', '"+ name +"', '"+ tel +"', sysdate)";		//�⺻�� ����commit �̴�
		
		try{
			stmt = con.createStatement();
			int result = stmt.executeUpdate( sql );	// �۾��� �����ϸ� 1 �����ϸ� 0, 10�� �־����� 10 �� ��
			
			if( result == 0 ){
				System.out.println("���Խ���");	// �̰� ���� �� ���� ����. �̰� ��� �Ҹ��� ��� ������... ��Ÿ�� �ȳ��ٸ� �� ���� ����.
			} else {
				System.out.println("���Լ���");
				SelectEx1 st = new SelectEx1();
				st.setConnection();
				st.getMember( null );
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		it.setConnection();
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));		
			System.out.print("���̵� : ");
			String id = br.readLine();
			System.out.print("�н����� : ");
			String passwd = br.readLine();
			System.out.print("�̸� : ");
			String name = br.readLine();
			System.out.print("��ȭ��ȣ : ");
			String tel = br.readLine();

			// �Է¹��� ����!		// �����α׷����� �ٷ�� ��� �������� ������ �������� �� DB. // ���±����� ���α׷����� �������� �� �� ����� ��Ҵµ�, �� �����Ͱ� ������ DB�� ���ų� DB�� �񱳸� �ؾ� ��. �׷��� ������ DB�� �ڷ����� ���������. �̸���! �׷��� �����ϱ� ����. 
			it.insertMember(id, passwd, name, tel);
	
		}catch(IOException e){}
	}
}
