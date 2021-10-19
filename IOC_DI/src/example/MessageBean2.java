package example;

public class MessageBean2 implements MessageBean{

	private String name;
	private String msg;
	
	@Override
	public void sayHello() {
		System.out.println(name + " : " + msg);
	}
	
	public MessageBean2(String name , String msg) {
		this.name=name;
		this.msg=msg;
	}

	
}
