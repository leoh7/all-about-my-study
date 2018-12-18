package board;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapClient {
	// 세션 만들기
	private static SqlSession session;
	
	// *어떤 작업을 한번만 하고 말거고 공유를 할꺼야 그럴땐 static 영역을 준다
	static {
		//sqlMapConfig 읽어오기
		try {
			Reader reader = Resources.getResourceAsReader( "board/sqlMapConfig.xml" );
			SqlSessionFactory factory =
					new SqlSessionFactoryBuilder().build( reader );	// SqlSessionFactory를 리턴
			session = factory.openSession( true );	// true = auto commit
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// session 을 가져다 쓸 수 있게 만들자
	public static SqlSession getSession() {
		return session;
	}
}
