package gradle_spring_autowired_study.spring;

import java.time.LocalDateTime;

public class Member {
	private int id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;
	
	public Member() {
	}

	public Member(int id, String email, String password, String name, LocalDateTime registerDateTime) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = registerDateTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}

	public void setRegisterDateTime(LocalDateTime registerDateTime) {
		this.registerDateTime = registerDateTime;
	}
	
	public void changePassword(String oldPassowrd, String newPassword) {
		if(!password.equals(oldPassowrd))
			throw new WrongIdPasswordException();
		this.password=newPassword;
	}
}
