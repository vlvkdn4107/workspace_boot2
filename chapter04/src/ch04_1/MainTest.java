package ch04_1;

public class MainTest {

	public static void main(String[] args) {
		
		Activity1_1 activity1_1 = new Activity1_1("화면1");
		Activity2_1 activity2_1 = new Activity2_1("화면1");
		
		activity2_1.setCallbackCheckPosition_1(activity1_1.cPosition_1);

	}

}
