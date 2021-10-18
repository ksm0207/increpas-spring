package DI;

public class MyDog {
	
	Dog dog;
	
	private String dog_name;
	private String dog_age;
	private String secondDogName;
	private String secondDogAge;
	
	
	public void dogNameInfo() {
		dog.dogName(dog_name, secondDogName);
	}
	
	public void dogAgeInfo() {
		dog.dogAge(dog_age, secondDogAge);
	}
	
	public void setDog(Dog dog) {
		this.dog=dog;
	}

	public String getDog_name() {
		return dog_name;
	}

	public void setDog_name(String dog_name) {
		this.dog_name = dog_name;
	}

	public String getDog_age() {
		return dog_age;
	}

	public void setDog_age(String dog_age) {
		this.dog_age = dog_age;
	}

	public String getSecondDogName() {
		return secondDogName;
	}

	public void setSecondDogName(String secondDogName) {
		this.secondDogName = secondDogName;
	}

	public String getSecondDogAge() {
		return secondDogAge;
	}

	public void setSecondDogAge(String secondDogAge) {
		this.secondDogAge = secondDogAge;
	}
	
	
	

}
