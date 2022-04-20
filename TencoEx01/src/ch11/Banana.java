package ch11;

public class Banana extends Fruit{

	String origin;
	
	public Banana(String name, int price, int fresh) {
		super(name, price, fresh);
		this.origin = "필리핀";
	}
	public void saleBanana() {
		System.out.println("바나나 세일 합니다.");
	}
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("원산지 :" + origin);
	}
}
