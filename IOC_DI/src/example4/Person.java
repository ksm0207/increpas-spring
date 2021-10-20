package example4;

public class Person {
	
	private String buyer;
	private Store store;
	
	public Person(Store store, String buyer) {
		this.store=store;
		this.buyer=buyer;
	}
	
	public Store getStore() {
		return store;
	}
	
	public void setStore(Store store) {
		this.store = store;
	}
	
	public String getBuyer() {
		return buyer;
	}
	
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

}
