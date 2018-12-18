// ojdbc6.jar // jdbc 인데 oracle 로 하는 1.6버전이다 // 오라클과 연동해서 대화를 하고 싶은것. 그러면 당연히 오라클 서버를 제어할 수 있는 드라이버가 필요한것.
// 자바는 다 OOP 라 클래스로 되어있다. // 드라이버는 어디서 제공한다? 제공하는 대서 하지 / 
// 드라이버 로딩은 한 번만 하면 된다./ 생성자 // db접속은 끊었다 연결했다 해야 함/ 메서드로 만들거고 / 
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
		// 드라이버 로딩
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 바뀔 수 있는 내용이야, new 해버리면 강한결합(바꿀 수 없는 상태)가 되어버림. spring 때 봅시다 // 변경이 가능하도록 객체를 만드는 방법 // Class를 관리하는 class 의 static 메서드인 것!
			System.out.println("드라이버 로딩 성공");
		}catch (ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}// 생성자 
	
	public void setConnection(){ //DB 를 연결하면 Connection 객체가 생긴다.
		//DB 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";	// 열댓번 입력하게 될겁니다 외우세여
		String dbId = "encore";
		String dbPasswd = "encore";

		try{
			con = DriverManager.getConnection(url, dbId, dbPasswd);
			System.out.println("DB 연결 성공");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void getMember( String id ){
		// id가 null인 경우		전체 출력
		// id가 null이 아닌 경우	해당 id만 출력
		

		// 딱히 할게 없어서 데이터를 가져다가 출력까지 해보자
		String sql = "SELECT * FROM dbtest";
		// sql 을 DB에 날려야 한다.
		// DB가 알아먹을 수 있는 상태로 만들어서 날려야 하고
		try{
			stmt = con.createStatement(); // Statement 라는 객체가 돌아온다.
			rs = stmt.executeQuery( sql ); // 이 방법과 executeQuery()
									// executeUpdate() 이렇게 두가지 메서드가 있다.
									// 뭘로 구분하냐. DB가 바뀌는 작업이 아니야 그럼 executeQuery  SELECT할 때만 쓴단 소리
									// DB가 바뀌는 작업이면 executeUpdate INSERT UPDATE DELETE
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
		st.getMember( null );	// 여기 "aaa" 라고 주면 결과가 "aaa" 아이디의 정보만 나오게 해야 한다는 것. // null 과 "aaa" 둘 다 되야 한다.
	}
}



/* 
프로그램이 서버한테서 DB를 받아와야하는데, 그 많은 데이터를 어떻게 받아 올거야? 데이터가 하나도 아니고
ResultSet 이라는 객체에 넣어서 받는다.
그러면 어떻게 되느냐. DB에서 다 주면 executeQuery 라는 메서드가 그걸 객체로 만들어서 주는거야. 그걸 ResultSet 객체에 넣는거고
이 많은 데이터를 어떻게 잘라서 출력할 것인가가 우리가 고민할 이야기.

1 튜플을 자를거야
rs.next() 한번 쓰면 한번 잘라온다. 특이하게도 보통 메서드는 한가지 일을 하고 리턴을 하는데, 얘는 두가지를 해, 자르는 일을 하고/ 잘랐으면 true가 넘어와.
자르고 계속 갖고 있어. 도리어 잘랐다 못잘랐다만 알려주는거야.
	그 다음에 열 단위로 자를거야.
	rs.getString("id") 컬럼의 이름을 줘서 꺼낸다.
	* date자료형은 어쩔거? rs.getTimestamp("logtime") 얘를 쓰면 되
*/