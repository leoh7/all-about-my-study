package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JDBCUserDao extends JdbcDaoSupport implements UserDao {
//	private JdbcTemplate template;
//
//	public void setTemplate( JdbcTemplate template ) {
//		this.template = template;
//	}
	
	@Override
	public int insertUser(User user) {
		return getJdbcTemplate().update(
			"insert into dbtest values( ?, ?, ?, ?, sysdate )",
			user.getId(), user.getPasswd(), user.getName(), user.getTel()
			);
	}
	@Override
	public int deleteUser(String id) {
		return getJdbcTemplate().update(
				"DELETE FROM dbtest WHERE id=?",
				id
				);
	}
	@Override
	public int getCount() {
		// 데이터를 여러개 가져올때는 queryForObject()
		// 다수를 가져올 때는 query
		return getJdbcTemplate().queryForObject(
				"SELECT count(*) FROM dbtest", 
				Integer.class
				);
	}
	RowMapper<User> rowMapper = new RowMapper<User>() {
		public User mapRow(ResultSet rs, int count) throws SQLException {
			User user = new User();
			user.setId(rs.getString("id"));
			user.setPasswd(rs.getString("passwd"));
			user.setName(rs.getString("name"));
			user.setTel(rs.getString("tel"));
			user.setLogtime(rs.getTimestamp("logtime"));
			return user;
		}
	};
	
	
	@Override
	public List<User> getUsers() {
		return getJdbcTemplate().query(
				"SELECT * FROM dbtest", 
				rowMapper);
	}
	
	@Override
	public int updateUser(User user) {
		return getJdbcTemplate().update(
				"UPDATE dbtest SET passwd=?, tel=? WHERE id=?",
				user.getPasswd(), user.getTel(), user.getId()
				);
	}
	@Override
	public User getUser(String id) {
		return getJdbcTemplate().queryForObject(
				"SELECT * FROM dbtest WHERE id=?",
				new Object[]{ id }, 
				rowMapper);
	}
	
	
} // class















