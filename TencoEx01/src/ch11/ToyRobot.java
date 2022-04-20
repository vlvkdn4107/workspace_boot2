package ch11;

public class ToyRobot implements RemoteController{

	String name;
	
	public ToyRobot() {
		this.name = "건담";
	}
	
	
	@Override
	public void turnOn() {
		System.out.println("건담 ON");		
	}

	@Override
	public void turnOff() {
		System.out.println("건담 OFF");
		
	}

}
