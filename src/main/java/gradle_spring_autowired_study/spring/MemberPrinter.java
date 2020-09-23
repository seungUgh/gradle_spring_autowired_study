package gradle_spring_autowired_study.spring;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberPrinter {
	private DateTimeFormatter dateTimeFormatter;

	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
	}

	public void print(Member member) {
		if (dateTimeFormatter == null) {
			System.out.println("null");
			System.out.printf("회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF%n", member.getId(), member.getEmail(),
					member.getName(), member.getRegisterDateTime());
		} else {
			System.out.println("not null");
			System.out.printf("회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%sF%n", member.getId(), member.getEmail(),
					member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}

	@Autowired /* (required = false) */
	public void setDateTimeFormatter(Optional<DateTimeFormatter> dateTimeFormatter) {
//		this.dateTimeFormatter = dateTimeFormatter;
		if (dateTimeFormatter.isPresent()) {
			this.dateTimeFormatter = dateTimeFormatter.get();
		} else {
			this.dateTimeFormatter = null;
		}

	}

}
