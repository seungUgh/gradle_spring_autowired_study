package gradle_spring_autowired_study.spring;

import java.time.LocalDateTime;

public class MemberRegisterService {
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public int regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new DuplicateMemberException("dup emial" + req.getEmail());
		}
		Member newMember = new Member(
				0, req.getEmail(),
				req.getPassword(),
				req.getName(),
				LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
