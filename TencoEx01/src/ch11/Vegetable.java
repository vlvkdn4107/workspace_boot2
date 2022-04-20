package ch11;

public class Vegetable {
	
	String name;
	String taste;
	int price;
	
	public Vegetable(String name) {
		this.name = name;
	}
	
	public void showInfo() {
		System.out.println("야채 이름 :" + name);
		System.out.println("야채 맛 :" + taste);
		System.out.println("야채 가격 :" + price);
	}
}
