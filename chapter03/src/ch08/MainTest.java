package ch08;

import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) {

       Book book1 = new Book(1, "흐르는강물처럼", "파울로코엘료");
       Book book2 = new Book(2, "플러터UI실전", "김근호");
       Book book3 = new Book(3, "무궁화꽃이피었습니다", "김진명");
       Book book4 = new Book(4, "리딩으로리드하라", "이지성");
       Book book5 = new Book(5, "사피엔스", "유발하라리");
       
       //how, why
       //사용방법(어떠한 데이터 타입을 담을지 미리 지정해 준다)!
       ArrayList<Book> cart = new ArrayList<Book>();//ArrayList (카드라는 공간에 담는다)
       
       //데이터 추가하는 방법 add메서드 사용!
       cart.add(book1);
       cart.add(book2);
       cart.add(book3);
       cart.add(book4);
       
       //데이터 꺼내는 방법 .get 메서드 사용!
//       System.out.println(cart.get(0).getTitle());
//       System.out.println(cart.get(1).getTitle());
//       System.out.println(cart.get(2).getTitle());
//       System.out.println(cart.get(0));
//       System.out.println(cart.get(1));
//       System.out.println(cart.get(2));
       
       for (Book book : cart) {
		System.out.println(book);
	}
       
       //데이터 삭제하는 방법!
       cart.remove(0); //인덱스 0번째 삭제!
       //사이즈 출력
       System.out.println(cart.size());
       System.out.println("================");
       System.out.println(cart.get(0));
       System.out.println("================");
       //수정하기
       cart.set(0, book5);
       System.out.println(cart.size());
       System.out.println(cart.isEmpty());//값이 들어있어서 false
       
       for (Book book : cart) {
		System.out.println(book);
		
		//데이터를 전부 한번에 삭제 하고싶다면
		cart.removeAll(cart);
		System.out.println("================");
		
//		for (Book book : cart) {
//			System.out.println(book);
//		}
		
		// C R U D
		
		
	}
       

	}

}
