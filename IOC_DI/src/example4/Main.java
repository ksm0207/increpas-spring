package example4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext4.xml");
		
			Person person = context.getBean(Person.class);
			
			if(context != null) {
				System.out.println("구매자 : "+person.getBuyer());
				System.out.println("구매 위치 : "+person.getStore().getLocation());
				System.out.println("판매자 : "+person.getStore().getOwner());
				System.out.println("구매 물품 : "+person.getStore().getPencil());
				System.out.println("가격 : " + person.getStore().getPrice());
			
			}
		
		
		
	}
}
