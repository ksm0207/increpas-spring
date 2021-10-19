package example3;

public class Owner {
	
	private String name;
	private Animal animal;

	public Owner(Animal animal, String name) {
		this.animal = animal;
		this.name=name;
	}
	
	public Animal getAnimal() {
		return animal;
	}
	
	public String getName() {
		return name;
	}
	
}
