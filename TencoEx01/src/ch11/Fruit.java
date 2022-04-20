package ch11;

public class Fruit {

	String name;
	int price;
	int fresh;
	
	public Fruit(String name, int price, int fresh) {
		this.name = name;
		this.price = price;
		this.fresh = fresh;
	}
	
	public void showInfo() {
		System.out.println("이름 :" + name);
		System.out.println("가격 :" + price);
		System.out.println("신선도 " + fresh);
	}
}
