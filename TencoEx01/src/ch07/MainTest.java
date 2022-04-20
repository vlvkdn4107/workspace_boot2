package ch07;

public class MainTest {

	public static void main(String[] args) {
		Car car1 = new Car("제네시스", "G70", 5000, "black");
		Car car2 = new Car("GENESIS", "G80", 6000, "white");
		Car car3 = new Car("제네시스", "G70", 6000, "Green");
		
		if(car1.equals(car3)) {
			System.out.println("같은 시리즈 입니다.");
		}else {
			System.out.println("다른 시리즈 입니다.");
		}

	}

}
