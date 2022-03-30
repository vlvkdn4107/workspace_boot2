package ch04;

public class ToyRobot implements RemoteController,Sound{

	@Override
	public void turnOn() {
		System.out.println("로봇 ON");
		
	}

	@Override
	public void turnOff() {
		System.out.println("로봇 OFF");
		
	}

	@Override
	public void notification() {
		System.out.println("쾅쾅쾅!!~");
		
	}

}
