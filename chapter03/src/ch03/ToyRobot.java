package ch03;

public class ToyRobot implements RemoteController{

	String name;
	
	public ToyRobot() {
	  this.name = "건담 로봇";
	}

	@Override
	public void turnOn() {
		System.out.println("로봇 ON");
		
	}

	@Override
	public void turnOff() {
		System.out.println("로봇 OFF");
		
	}
	
	//기능 만들기
//	public void turnOn() {
//		System.out.println("장난갑 로봇을 켭니다");
//	}
//	public void turnOff() {
//		System.out.println("장난감 로봇을 끕니다.");
//	}
	
	
}
