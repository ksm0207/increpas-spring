package example2;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext2.xml");
		// Person person =  context.getBean(Person.class);
		Animal animal = context.getBean(Animal.class);
		
		
		System.out.println(animal.getPerson().getName());
		System.out.println(animal.getPerson().getAge());
		System.out.println(animal.getPerson().getGender());
		System.out.println(animal.getPerson().getAddr());
		System.out.println(animal.getPerson().getPhone());
		System.out.println(animal.getDog_name());
		
	}
}
