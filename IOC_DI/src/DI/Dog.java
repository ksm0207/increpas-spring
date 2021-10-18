package DI;

public class Dog {
	
	public void dogName(String dog_name , String secondDogName) {
		System.out.println("DogName ()");
		System.out.println("첫번째 강아지 이름 : " + dog_name );
		System.out.println("두번째 강아지 이름 : " + secondDogName);
	}
	
	public void dogAge(String dog_age , String secondDogAge) {
		System.out.println("DogAge()");
		System.out.println("첫번째 강아지 나이 : " + dog_age );
		System.out.println("두번째 강아지 나이 : " + secondDogAge);
	}

}
