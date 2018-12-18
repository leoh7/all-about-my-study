package member;

import org.apache.ibatis.session.SqlSession;

import bean.SqlMapClient;

public class LogonDBBean implements MemberDao{
	private SqlSession session = SqlMapClient.getSession();
	
	public int insertMember(LogonDataBean memberDto) {
		return session.insert("Member.insertMember", memberDto);
	}
	public int modifyMember(LogonDataBean memberDto) {
		return session.update("Member.modifyMember", memberDto);
	} 
	public int deleteMember(String id) {
		return session.delete("Member.deleteMember", id);
	}
	public int check(String id) {
		return session.selectOne("Member.checkId", id);	// namespace,
	} // check(String id)
	
	public int check(String id, String passwd) {
		int result = 0;
		if(check(id) > 0) {
			// 아이디가 있는 것
			LogonDataBean memberDto = getMember(id);
			if(passwd.equals(memberDto.getPasswd() ) ) {
				result = 1;
			} else {
				result = -1;
			}
		} else {
			// 아이디가 없는 것
			result = 0;
		}
		return result;
	} // check(String id, String passwd)

	public LogonDataBean getMember(String id) {
		return session.selectOne("Member.getMember", id);
	}
	
	
} // class















