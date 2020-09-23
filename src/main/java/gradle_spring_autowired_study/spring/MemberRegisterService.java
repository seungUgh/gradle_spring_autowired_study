package gradle_spring_autowired_study.spring;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
	@Autowired
	private MemberDao memberDao;
	
// 매개변수가 있는 생성자가 없기때문에 자바 컴파일러가 자동으로 기본생성자 만들어줌...!
// 자동으로 넣어주기때문에 매개변수가 있는 생성자는 잘 사용안한다. 	

//	public MemberRegisterService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
	
	
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
