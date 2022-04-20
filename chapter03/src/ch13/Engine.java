package ch13;

public class Engine {

	String name;
	int price;
	
	public Engine(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public void showInfo() {
		System.out.println("엔진 이름 : " + name);
		System.out.println("엔진 가격 : " + price);
	}
}
