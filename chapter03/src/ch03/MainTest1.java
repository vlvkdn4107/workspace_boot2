package ch03;

public class MainTest1 {

	public static void main(String[] args) {
		
		//객체 만들기
		Televison televison = new Televison();	
		Refrigerator refrigerator = new Refrigerator();	
		ToyRobot robot = new ToyRobot();

		//기능 동작하기
//        televison.turnOn();
//        refrigerator.turnOn();
//        robot.turnOn();
//        System.out.println("============");
//        televison.turnOff();
//        refrigerator.turnOff();
//        robot.turnOff();
        //다형성
        
        //배열 만들기
        RemoteController[] remoteControllers = new RemoteController[3];
        //배열 안에 넣기
        remoteControllers[0] = televison;
        remoteControllers[1] = refrigerator;
        remoteControllers[2] = robot;
        
        //반복문
        for (int i = 0; i < remoteControllers.length; i++) {
			remoteControllers[i].turnOn();
		}
        for (int i = 0; i < remoteControllers.length; i++) {
			remoteControllers[i].turnOff();
		}
        
       
	}

}
