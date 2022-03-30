package ch04;

public class Refrigerator extends HomeAppliances implements RemoteController,Sound{

	@Override
	public void turnOn() {
		System.out.println("냉장고 ON");
		
	}

	@Override
	public void turnOff() {
		System.out.println("냉장고 OF");
		
	}
	 @Override
	public void notification() {
		System.out.println("띠리링~~~~");
		
	}

}
