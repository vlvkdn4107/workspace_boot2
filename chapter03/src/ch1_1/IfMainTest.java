package ch1_1;

public class IfMainTest {

	public static void main(String[] args) {
		
		int age = 14;
		int charge;
		
		if(age <= 8) {
			charge = 900;
			System.out.println("초등학생");
		}else if(age <= 14 ) {
			charge = 1200;
			System.out.println("중학생");
		}else if(age <= 17) {
			charge = 1500;
			System.out.println("고등학생입니다");
		}else{
			charge = 2000;
			System.out.println("성인입니다");
		}
	     System.out.println("입장료는 :" + charge + "원입니다");
		

	}

}
