package ch11;

public class Eagle extends Animal{

	@Override
	public void hunt() {
		System.out.println("독수리가 날다가 사냥을 합니다");
	}
	public void move() {
		System.out.println("독수리가 날개를 펴고 날아갑니다");
	}

}
