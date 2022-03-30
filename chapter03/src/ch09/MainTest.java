package ch09;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) {
		 
		 Book book1 = new Book(1, "흐르는강물처럼", "파울로코엘료");
	     Book book2 = new Book(2, "플러터UI실전", "김근호");
	     Book book3 = new Book(3, "무궁화꽃이피었습니다", "김진명");
	     Book book4 = new Book(4, "리딩으로리드하라", "이지성");
	     Book book5 = new Book(5, "사피엔스", "유발하라리");

         ArrayList<Book> cart = new ArrayList<Book>();
         
         cart.add(book1);
         cart.add(book2);
         cart.add(book3);
	     
         for (Book book : cart) {
			System.out.println(book);
		}
         //삭제
         cart.remove(0);
         System.out.println(cart.size());
         System.out.println("==================");
         //0번째 인덱스 보기
         System.out.println(cart.get(0));
         System.out.println("==================");
         
         
         //0번째 인덱스를 북5로 수정하기!
         cart.set(0, book5);
         System.out.println(cart.size());
         System.out.println(cart.isEmpty()); //내용물이 있어서 false
         
         for (Book book : cart) {
			System.out.println(book);
		}
         System.out.println("==================");
         //전부 삭제!
         cart.removeAll(cart);
         
         for (Book book : cart) {
			System.out.println(book);
		}
         System.out.println(cart.isEmpty());// 다 삭제하고 내용물이 없어서 true
	     
	     
	     
	     
	}

}
