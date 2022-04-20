package ch13;

public class Car {

	String company;
	String name;
	String color;
	int price;
	
	Engine engine = new Engine("자동차용 엔진", 700);
	public Car(String company, String name, String color, int price) {
		this.company = company;
		this.name = name;
		this.color = color;
		this.price = price;
	}
	
	public void showInfo() {
		System.out.println("차 회사 : " + company);
		System.out.println("차 이름 : " + name);
		System.out.println("차 색상 : " + color);
		System.out.println("차 가격 : " + price);
		engine.showInfo();
	}
}
