package ch11;

public class AICar extends Car{

	@Override
	public void wiper() {
		System.out.println("와이퍼가 작동합니다");
		
	}

	@Override
	void drive() {
		System.out.println("자율 주행 합니다");
		System.out.println("자동차가 스스로 방향을 바꿉니다");
		
	}

	@Override
	void stop() {
		System.out.println("자동차가 스스로 멈춥니다.");
		
	}
	public void washCar() {
		System.out.println("스스로 세차합니다.");
	}

}
