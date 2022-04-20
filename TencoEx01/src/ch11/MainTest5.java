package ch11;

public class MainTest5 {

	public static void main(String[] args) {
		// 불가능함
//		Animal animal = new Animal();
		
		Animal animal1 = new Tiger();
		animal1.move();
		animal1.hunt();
		System.out.println("----------------");
		
		Animal animal2 = new Eagle();
		animal2.move();
		animal2.hunt();
		System.out.println("----------------");
		
		Animal animal3 = new Person();
		animal3.move();
		animal3.hunt();
		System.out.println("----------------");
		
		
	}

}
