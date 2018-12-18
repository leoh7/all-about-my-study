package board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class BoardDBBean implements Dao {
	private SqlSession session = SqlMapClient.getSession();
	
	public int getCount() {
		return session.selectOne("Board.getCount");
	}
	
	public int insertArticle(BoardDataBean boardDto) {
			int num = boardDto.getNum();
			int ref = boardDto.getRef();	// Map으로 날려야하나
			int re_step = boardDto.getRe_step();
			int re_level = boardDto.getRe_level();
			
			if(num == 0) {
				// 제목글
				if(getCount() > 0) {
					// 글이 있는 경우
					ref = (int) session.selectOne("Board.maxNum") + 1;	// maxNum
				} else {
					// 글이 없는 경우
					ref = 1;
				}
				re_step = 0;
				re_level = 0;
			} else {	// num 이 0 이 아닌경우
				// 답변글
				session.update("Board.insertReply", boardDto);	// insertReply / ref, re_step 을 넘겨줘야 함
				re_step ++;
				re_level ++;
			}
			boardDto.setRef(ref);
			boardDto.setRe_step(re_step);
			boardDto.setRe_level(re_level);
			return session.insert("Board.insertArticle", boardDto);	// insertArticle
	}
	public List<BoardDataBean> getArticles(Map<String, Integer> map){
		return session.selectList("Board.getArticles", map);
		
	}
	
	public BoardDataBean getArticle( int num ) {
		return session.selectOne("Board.getArticle", num);
	}
	public void addCount(int num) {
		session.update("Board.addCount", num);
	}
	
	public int check(int num, String passwd) {
		int result = 0;
//		String sql = "SELECT count(*) FROM board WHERE num=?";
//		int count = getJdbcTemplate().queryForObject(	// select 날리는 거고, 정수 가져오는 것
//				sql, 
//				new Object[]{ num },
//				Integer.class
//				);
//		
//		if(count > 0) {
		
			BoardDataBean boardDto = getArticle( num );
			if(passwd.equals(boardDto.getPasswd())) {
				result = 1;
			} else {
				result = 0;
			}
//		}
			return result;
	}
	public int deleteArticle(int num) {
		int result = 0;
		
		BoardDataBean boardDto = getArticle(num);	// 같은 클래스에 있는 거니까 그냥 가져다 쓰면 됨
		int count = session.selectOne("Board.replyCheck", boardDto);	// replyCheck
		
		if(count > 0) {
			// 답글이 있는 경우
			result = -1;
		} else {
			// 답글이 없는 경우
									// deleteReply
			session.update("Board.deleteReply", boardDto);
									// deleteArticle
			result = session.delete("Board.deleteArticle", num);
		}
		return result;
	}
	
	public int modifyArticle(BoardDataBean article) {
		return session.update("Board.modifyArticle", article);
	}
	
	
	
}
