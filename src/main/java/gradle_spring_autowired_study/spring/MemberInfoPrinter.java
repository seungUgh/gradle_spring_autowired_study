package gradle_spring_autowired_study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MemberInfoPrinter {
//	private MemberDao memDao;
//	private MemberPrinter printer;
	
	@Autowired
	private MemberDao memDao;
	@Autowired
	private MemberPrinter printer;
	
	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		if(member == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(member);
		System.out.println();

		
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memDao = memberDao;
	}

	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}

	
	
}
