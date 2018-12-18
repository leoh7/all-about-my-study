package member;

public interface Dao {
	public int insertMember(LogonDataBean memberDto);
	public int check(String id);
	public int check(String id, String passwd);
	public int deleteMember(String id);
	public LogonDataBean getMember(String id);
	public int modifyMember(LogonDataBean memberDto);
}
