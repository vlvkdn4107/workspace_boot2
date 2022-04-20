package ch11;

public class MainTest {

	public static void main(String[] args) {
		//과일 타입으로 바나나 객체화 했을때.
		// 바나나 생성자만 읽고, 오버라이드된 메서드만 사용가능.
		//(오버라이드 안했다면 부모클래스에 있는 메서드만 사용가능)
		Fruit fruit1 = new Banana("바나나", 3000, 70);
		Fruit fruit2 = new Peach("복숭아", 5000, 80);
		fruit1.showInfo();
		fruit2.showInfo();
		System.out.println("=======");
		
		//과일 타입으로 객체화 했지만 바나나의 메소드나 변수를 사용해야 한다면
		//형변환
		//변수의 형변환
		String origin = ((Banana)fruit1).origin; //변수에 담아주거나
		System.out.println(origin);
		System.out.println(((Banana)fruit1).origin); //바로 사용 해줘야할때
		System.out.println();
		
		//메서드의 형변환
		((Banana)fruit1).saleBanana();
	}

}
