package example3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext3.xml");
		Owner o = context.getBean(Owner.class);
		
		System.out.println("생성자 연습 ");
		System.out.println("강아지 : " +o.getAnimal().getDog_name() + "\n주인 : " + o.getName());
		
		
	}
}
