package Ex;

public class Dog {
	
	private String dog_name;
	private int dog_age;
	private String secondDogName;
	private int secondDogAge;
	
	public void dogName() {
		System.out.println("DogName ()");
		System.out.println("첫번째 강아지 이름 : " + dog_name );
		System.out.println("두번째 강아지 이름 : " + secondDogName);
	}
	
	public void dogAge() {
		System.out.println("DogAge()");
		System.out.println("첫번째 강아지 나이 : " + dog_age );
		System.out.println("두번째 강아지 나이 : " + secondDogAge);
	}
	
	
	public String getDog_name() {
		return dog_name;
	}
	public void setDog_name(String dog_name) {
		this.dog_name = dog_name;
	}
	public int getDog_age() {
		return dog_age;
	}
	public void setDog_age(int dog_age) {
		this.dog_age = dog_age;
	}
	public String getSecondDogName() {
		return secondDogName;
	}
	public void setSecondDogName(String secondDogName) {
		this.secondDogName = secondDogName;
	}
	public int getSecondDogAge() {
		return secondDogAge;
	}
	public void setSecondDogAge(int secondDogAge) {
		this.secondDogAge = secondDogAge;
	}
	
	

}
