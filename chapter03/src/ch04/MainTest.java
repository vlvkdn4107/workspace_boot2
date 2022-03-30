package ch04;

public class MainTest {

	public static void main(String[] args) {
	    
		
		//객체를 먼저 만들어준다.
		Televison televison = new Televison();
		Refrigerator refrigerator = new Refrigerator();
		ToyRobot robot = new ToyRobot();
		
		//리모트 컨트롤러의 배열을 만들어준다.
		RemoteController[] remoteControllers = new RemoteController[3]; //리모트컨드롤러의 배열크기는 3으로 만들어준다.
		//배열안에 객체 넣기
		remoteControllers[0] = televison;
		remoteControllers[1] = refrigerator;
		remoteControllers[2] = robot;
		
		//반복문 
		for (int i = 0; i < remoteControllers.length; i++) {
			remoteControllers[i].turnOn();
		}
		System.out.println("=================");
		for (int i = 0; i < remoteControllers.length; i++) {
			remoteControllers[i].turnOff();
		}

	}

}
