package gradle_spring_autowired_study.spring;

public class VersionPrinter {
	private int majorVersion;
	private int minoVersion;
	
	public void print() {
		System.out.printf("이 프로그램의 버전은 %d.%d입니다.\n\n",
				majorVersion, minoVersion);
	}

	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}

	public void setMinoVersion(int minoVersion) {
		this.minoVersion = minoVersion;
	}
	

}
