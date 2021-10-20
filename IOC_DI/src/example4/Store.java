package example4;

public class Store {
	
	private String location; // 위치
	private String owner; // 주인
	private String pencil; // 연필
	
	private int price; // 가격
	
	public Store(String location, String owner, String pencil , int price) {
		this.location=location;
		this.owner=owner;
		this.pencil=pencil;
		this.price=price;
	}
	
	public String getPencil() {
		return pencil;
	}
	
	public void setPencil(String pencil) {
		this.pencil = pencil;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
