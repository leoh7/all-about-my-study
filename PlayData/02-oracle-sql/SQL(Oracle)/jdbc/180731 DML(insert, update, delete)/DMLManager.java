import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class DMLManager {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private int cnt;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public DMLManager(){
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

	public void getMember(String forWhat, String columnName){
		String sql = "SELECT "+forWhat+" FROM "+columnName ;
		rs = getResultSet( sql );
	}

	public void getMember(String forWhat, String columnName, String forWhere){
		String sql = "SELECT "+forWhat+"FROM "+columnName+"WHERE "+forWhere;
		rs = getResultSet( sql );
	}

	public ResultSet getResultSet(String sql){
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery( sql );
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}


	public int setColumnCnt (){
		try{
			System.out.print("Column �� ������ �Է����ּ��� : ");
			cnt = Integer.parseInt( br.readLine() );
		}catch(IOException ie){
			ie.printStackTrace();
		}
		return cnt;
	}


	public void insertMember(String columnName, int columnCnt){
		String[]sqlArr = new String[columnCnt];
		String sql = "INSERT INTO "+columnName+"VALUES(" + ")";
		
		try{			
			while(true){
				for(int i=0; i<sqlArr.length; i++ ){
					System.out.print(columnCnt+" �� "+(i+1)+"��° ���� �Է� : ");
					sqlArr[i] = br.readLine();
				}
				for(int i=0; i<sqlArr.length; i++ ){
					System.out.println("�Է¹��� "+(i+1)+"�� ° �� : "+sqlArr[i]);
					
				}
				break;
			} // while
		}catch(IOException ie){
			ie.printStackTrace();
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
	
	public void insertMember(String id, String passwd, String name, String tel){		// ������ beanClass (�ٱ���)�� ���� ������ �ϴµ� ���� ���ϴϱ�
		String sql = "INSERT INTO dbtest VALUES("
					+"'"+ id +"', '"+ passwd +"', '"+ name +"', '"+ tel +"', sysdate)";		//�⺻�� ����commit �̴�
		try{
//			stmt = con.createStatement();
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
		DMLManager dmlm = new DMLManager();
		dmlm.setConnection();
		dmlm.insertMember("dbtest", dmlm.setColumnCnt());
	}
}
