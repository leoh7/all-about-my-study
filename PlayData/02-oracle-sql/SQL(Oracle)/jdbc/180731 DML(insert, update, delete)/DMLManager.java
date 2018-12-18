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
			System.out.print("Column 의 갯수를 입력해주세요 : ");
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
					System.out.print(columnCnt+" 중 "+(i+1)+"번째 값을 입력 : ");
					sqlArr[i] = br.readLine();
				}
				for(int i=0; i<sqlArr.length; i++ ){
					System.out.println("입력받은 "+(i+1)+"번 째 값 : "+sqlArr[i]);
					
				}
				break;
			} // while
		}catch(IOException ie){
			ie.printStackTrace();
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
	
	public void insertMember(String id, String passwd, String name, String tel){		// 원래는 beanClass (바구니)를 만들어서 던져야 하는데 지금 못하니깡
		String sql = "INSERT INTO dbtest VALUES("
					+"'"+ id +"', '"+ passwd +"', '"+ name +"', '"+ tel +"', sysdate)";		//기본이 오토commit 이다
		try{
//			stmt = con.createStatement();
			int result = stmt.executeUpdate( sql );	// 작업이 성공하면 1 실패하면 0, 10줄 넣었으면 10 인 식
			
			if( result == 0 ){
				System.out.println("가입실패");	// 이거 거의 뜰 일이 없어. 이게 뜬단 소리는 디비 에런데... 오타만 안낸다면 볼 일이 없다.
			} else {
				System.out.println("가입성공");
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
