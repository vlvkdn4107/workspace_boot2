package ch03;

public class Televison extends HomeAppliances implements RemoteController{

	@Override
	public void turnOn() {
		System.out.println("티비 ON");
		
	}

	@Override
	public void turnOff() {
	    System.out.println("티비 OFF");
		
	}
	
	
     
	
	
	
}
