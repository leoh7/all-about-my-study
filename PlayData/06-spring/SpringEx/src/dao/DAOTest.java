package dao;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DAOTest {

	public static void main(String[] args) {
		// TODO DAO - main
		ClassPathXmlApplicationContext ctx 
			= new ClassPathXmlApplicationContext("dao/ApplicationContext.xml");
		
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		
		String id = "aaa";
		
		// delete
		int result = userDao.deleteUser(id);
		if(result == 0){
			System.out.println("삭제실패");
		} else {
			System.out.println("삭제성공");
		}
		
		// insert
		User hong = new User();
		hong.setId(id);
		hong.setPasswd("1111");
		hong.setName("홍길동");
		hong.setTel("1111-6666");
		
		result = userDao.insertUser(hong);
		if(result == 0){
			System.out.println("가입실패");
		} else {
			System.out.println("가입성공");
		}
		System.out.println();
		
		
		int count = userDao.getCount();
		System.out.println("회원수 : " + count);
		
		List<User> users = userDao.getUsers();
		for(int i=0; i<users.size(); i++ ){
			User user = users.get(i);
			System.out.println(
					user.getId() + "\t"
					+ user.getPasswd() + "\t"
					+ user.getName() + "\t"
					+ user.getTel() + "\t"
					+ user.getLogtime()
					);
		}
		
		// update
		hong.setId(id);
		hong.setPasswd("1111");
		hong.setTel("9999-9999");
		result = userDao.updateUser(hong);
		if(result == 0){
			System.out.println("수정실패");
		} else{
			System.out.println("수정성공");
		}
		
		// select one
		User user = userDao.getUser(id);
		System.out.println(
				"id : " + user.getId() + "\t" +
				"비밀번호 : " + user.getPasswd() + "\t" +
				"이름 : " + user.getName() + "\t" +
				"전화번호 : " + user.getTel()
				);
		
		
		
		ctx.close();
	}

}














