package ch07;

public class MainTest {

	public static void main(String[] args) {
		Car car1 = new Car("G70",1);
		Car car2 = new Car("G80",2);
		Car car3 = new Car("G90",3);
		Car car4 = new Car("G70",4);

		System.out.println(car1);
		System.out.println(car2);
		System.out.println(car3);
		System.out.println(car4);
	
		
		
		
		if(car1.equals(car4)) {
			System.out.println("둘다 맞습니다");
		}else {
			System.out.println("틀립니다");
		}
	}

}
