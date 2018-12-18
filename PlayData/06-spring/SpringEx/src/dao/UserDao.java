package dao;

import java.util.List;

public interface UserDao {
	public int insertUser( User user );
	public int deleteUser( String id );
	public int getCount();
	public List<User> getUsers();
	public int updateUser( User user );
	public User getUser( String id );
}
