package ch11;

public class MainTest7 {

	public static void main(String[] args) {
		
		Television television = new Television();
		Refrigerator refrigerator = new Refrigerator();
		ToyRobot robot = new  ToyRobot();
		
		RemoteController[] remoteControllers = new RemoteController[3];
		remoteControllers[0] = television;
		remoteControllers[1] = refrigerator;
		remoteControllers[2] = robot;
		
		for (int i = 0; i < remoteControllers.length; i++) {
			remoteControllers[i].turnOn();
		}
		System.out.println();
		for (int i = 0; i < remoteControllers.length; i++) {
			remoteControllers[i].turnOff();
			
		}

	}

}
