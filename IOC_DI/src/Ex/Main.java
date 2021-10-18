package Ex;

public class Main {
	
	public static void main(String[] args) {
		
		// 객체를 직접 생성함.
		// Main클래스는 Dog를 의존하고 있고
		// 이 클래스에서 직접 Dog를 생성해서 사용해야함.
		
		Dog dog = new Dog();
		
		dog.setDog_name("해랑이");
		dog.setSecondDogName("백덕이");
		
		dog.setDog_age(1);
		dog.setSecondDogAge(3);
		
		dog.dogName();
		dog.dogAge();
		
	}

}
