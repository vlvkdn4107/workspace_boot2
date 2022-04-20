package ch03;

public class House implements ICallbackTest1{

	Store store;
	String dog = "puppy";
	public House() {
		new Store(dog);
	}
	
	
	@Override
	public void selldog(String dog) {
		System.out.println(dog +"를 분양 받았습니다");
		
		
	}

	

}
