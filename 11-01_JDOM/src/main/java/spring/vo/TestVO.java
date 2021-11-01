package spring.vo;

public class TestVO {
	// xml 문서에서 원하는 엘리먼트를 객체화 시키기 위한 VO클래스 정의
	
	private String name;
	private String email;
	
	public TestVO(String name, String email) {
		this.name=name;
		this.email=email;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
