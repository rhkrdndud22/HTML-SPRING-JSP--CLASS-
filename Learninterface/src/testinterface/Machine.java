package testinterface;

public class Machine {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private int price;
	public Machine(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
}
