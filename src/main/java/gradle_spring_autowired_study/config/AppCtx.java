package gradle_spring_autowired_study.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gradle_spring_autowired_study.spring.ChangePasswordService;
import gradle_spring_autowired_study.spring.MemberDao;
import gradle_spring_autowired_study.spring.MemberInfoPrinter;
import gradle_spring_autowired_study.spring.MemberListPrinter;
import gradle_spring_autowired_study.spring.MemberPrinter;
import gradle_spring_autowired_study.spring.MemberRegisterService;
import gradle_spring_autowired_study.spring.MemberSummaryPrinter;
import gradle_spring_autowired_study.spring.VersionPrinter;

@Configuration
public class AppCtx {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
// Bean이 없다면  ->	UnsatisfiedDependencyException 발생 
	
	
	@Bean
	public MemberRegisterService memberRegSvc() {
//		return new MemberRegisterService(memberDao());
//		@autowired해놨기때문에 memberDao() 필요 x
		return new MemberRegisterService();
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
//		pwdSvc.setMemberDao(memberDao());
// 		스프링이 자동으로 넣어주기때문에 필요없다!!!	
// 		@Autowired애노테이션을memberDao필드에추가하였으므로@Bean 설정메서드에서의존을주입하는코드를삭제		
		return pwdSvc;
	}
	
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
//	MemberPrinter와MemberSummaryPrinter가상속관계이므로스프링컨테이너는
//	MemberPrinter 타입빈을자동주입해야하는@Autowired 애노테이션을만나면어떤빈을주입해야할지알수없음.
	
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(/* memberDao(), memberPrinter() */);
	}

	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//		infoPrinter.setMemberDao(memberDao());
//		infoPrinter.setPrinter(memberPrinter());
//		MemberInfoPrinter 클래스에 setMemberDao, setPrinter @Autowired 설정해줌
		return infoPrinter;
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinoVersion(0);
		return versionPrinter;
	}
}
