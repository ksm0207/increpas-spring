package ex1.vo;

public class Test1 {
	
	private String msg;
	private String age;
	
	public Test1() {System.out.println("DI Example");}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
}
