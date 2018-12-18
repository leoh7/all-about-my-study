import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class InsertTest {
	private Connection con;
	private Statement stmt = null;
//	private ResultSet rs; 이건 SELECT 가 아니니까 ResultSet 을 잡을 필요가 없다

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

	public void insertMember(String id, String passwd, String name, String tel){		// 원래는 beanClass (바구니)를 만들어서 던져야 하는데 지금 못하니깡
		String sql = "INSERT INTO dbtest VALUES("
					+"'"+ id +"', '"+ passwd +"', '"+ name +"', '"+ tel +"', sysdate)";		//기본이 오토commit 이다
		
		try{
			stmt = con.createStatement();
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
		InsertTest it = new InsertTest();
		it.setConnection();
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));		
			System.out.print("아이디 : ");
			String id = br.readLine();
			System.out.print("패스워드 : ");
			String passwd = br.readLine();
			System.out.print("이름 : ");
			String name = br.readLine();
			System.out.print("전화번호 : ");
			String tel = br.readLine();

			// 입력받을 거임!		// 웹프로그램에서 다루는 모든 데이터의 마지막 종착점은 다 DB. // 여태까지는 프로그램에서 변수잡을 때 내 맘대로 잡았는데, 그 데이터가 언젠간 DB에 들어가거나 DB와 비교를 해야 해. 그래서 무조건 DB의 자료형과 맞춰줘야해. 이름도! 그래야 관리하기 편해. 
			it.insertMember(id, passwd, name, tel);
	
		}catch(IOException e){}
	}
}
