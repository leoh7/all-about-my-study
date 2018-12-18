package mybatis;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MyBatisTest {
	
	public static void main(String[] args) {
		SqlSession session = SqlMapClient.getSession();
		
		int result;
		String id = "zzz";
	
		User hong = new User();
		hong.setId(id);
		hong.setPasswd("111");
		hong.setName("임임이");
		hong.setTel("9999-1111");
		
		// delete
		result = session.delete("User.deleteUser", hong);
		if(result == 0){
			System.out.println("삭제실패");
		} else {
			System.out.println("삭제성공");
		}
		
		// insert(namespace.id, 바구니)
		result = session.insert("User.insertUser", hong);	// int 로 몇개 리턴했는지 알려줌
		if(result == 0){
			System.out.println("가입실패");
		} else {
			System.out.println("가입성공");
		}
		
		// select all
		List<User> users = session.selectList("User.getUsers");
		for(int i=0; i<users.size(); i++){
			User user = users.get(i);
			System.out.println(user.getId() + "\t" +
					user.getPasswd() + "\t" +
					user.getName() + "\t" +
					user.getTel() + "\t" +
					user.getLogtime()
					);
		}
		// select one
		int count = session.selectOne("User.getCount");	// selectOne 은 리턴값을 뭘로 받겠냐에 따라 바뀐다
		System.out.println("회원수 : " + count);
		
		// update
		hong.setPasswd("999");
		hong.setTel("1111-1111");
		hong.setId(id);
		
		result = session.update("User.updateUser", hong);
		if(result == 0){
			System.out.println("수정실패");
		} else {
			System.out.println("수정성공");
		}
		
		// select user
		User user = session.selectOne("User.getUser", id);
		System.out.println(user.getId() + "\t" +
				user.getPasswd() + "\t" +
				user.getName() + "\t" +
				user.getTel() + "\t" +
				user.getLogtime()
				);
		
		session.close();
	}

}











