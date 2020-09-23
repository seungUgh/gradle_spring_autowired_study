package gradle_spring_autowired_study.spring;

public class ChangePasswordSerivce {
	
	private MemberDao memberDao;
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if(member == null)
			throw new MemberNotFoundExeception();
		
		member.changePassword(oldPwd, newPwd);
		
		memberDao.update(member);
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
