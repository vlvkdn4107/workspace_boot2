package ch06;

public class MainTest {

	public static void main(String[] args) {
		Book book1 = new Book(1, "흐르는 강물처럼");
		Book book2 = new Book(2, "사피엔스");
		Book book3 = new Book(3, "흐르는 강물처럼");
		Book book4 = new Book(4, "무궁화 꽃이 피었습니다");
		Student student = new Student();
		
		
		System.out.println(book1);
		System.out.println(book2);
		
		//Object -->equals
		// 오버라이드(필요에 의해서 재정의 한다)
		//매개 변수로 참조값(주소값)을 받아서 코딩한다.
		// instanceof
		// if else
		
		
		// 주소값1 == 주소값2
		//equals를 재정의해서 같은 객체입니다. 라고 나온다
//		if(book1.equals(book3)) {
//			System.out.println("같은 책입니다");
//		}else {
//			System.out.println("다른 책입니다");
//		}
//		if(book1.equals(student)) {
//			System.out.println("ture 리턴");
//		}else {
//			System.out.println("false 리턴");
//		}
		if(book1.isSameBook(book3)) {
			System.out.println("같은 책입니다");
		}else {
			System.out.println("다른책 입니다");
		}

	}

}
