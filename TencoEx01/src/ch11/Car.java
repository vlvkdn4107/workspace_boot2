package ch11;

public abstract class Car {
	
	public abstract void wiper();
	//후크 메서드 --> 걸어둔다
	// 필요하면 사용하는 클래스에서 직접 구현해서 사용해라 라는 메소드
	public void washCar() {}
	
	void startCar() {
		System.out.println("시동을 켭니다");
	}
	void turnOff() {
		System.out.println("시등을 끕니다");
	}
	abstract void drive();
	abstract void stop();
	
	//메소드앞에 final --> 재정의 불가함
	final public void run() {
		startCar();
		wiper();
		drive();
		stop();
		turnOff();
		washCar();
	}
}
