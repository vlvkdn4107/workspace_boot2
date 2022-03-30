package ch02;

public class Refrigerator extends HomeAppliances{

	@Override
	public void trunOn() {
		System.out.println("냉장고를 켭니다");
		
	}

	@Override
	public void trunOff() {
		System.out.println("냉장고를 끕니다");
	}
     
	
	
}
