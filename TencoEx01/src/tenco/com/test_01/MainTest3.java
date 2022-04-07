package tenco.com.test_01;

public class MainTest3 {

	public static void main(String[] args) {
		
		//재료를 메모리에 올리기
		Powder powder = new Powder();
		Plastic plastic = new Plastic();
		Water water = new Water();
		//재네릭 올리기
		
		//사용하는 시점에 지정된 자료형으로 컴파일 됩니다.
		GenericPrinter<Powder> genericPrinter1 = new GenericPrinter<Powder>();
		
		//컴파일 시점에서 재료를 쓸수 없다고 뜬다.
		//The method setMeterial(Plastic) in the type GenericPrinter<Plastic> is not applicable for the arguments (Powder)
		genericPrinter1.setMeterial(powder);
		System.out.println(genericPrinter1.getMeterial());
		
		GenericPrinter<Plastic> genericPrinter2 = new GenericPrinter<Plastic>();
		genericPrinter2.setMeterial(plastic);
		System.out.println(genericPrinter2.getMeterial());
		
		GenericPrinter<Water> genericPrinter3 = new GenericPrinter<Water>();
		genericPrinter3.setMeterial(water);
		System.out.println(genericPrinter3.getMeterial());

		GenericPrinter2<Powder> g2 = new GenericPrinter2<Powder>();
		//이렇게 바로 출력을 하면 nullPointerException이 뜬다
//		System.out.println(g2);
		g2.setMaterial(powder);
		System.out.println(g2);
		
		//<T extends 클래스> 사용하기;
		//상위 클래스의 필요성
		//T 자료형의 범위를 제한할 수 있다 (제한 하지 않으면 아무 클래스나 올 수 있다)
		
//		GenericPrinter3<Water> g3 = new GenericPrinter3<Water>();
		
		
		
		
		
		
		
		
		
		
	}

}
