package ex1.vo;

public class Test4 {
	private Test2 t2; // Test4 클래스는 Test2 클래스를 의존하고있음.
	
	public Test2 getT2() {
		return t2;
	}
	
	public void setT2(Test2 t2) {
		this.t2 = t2;
	}
	
}
