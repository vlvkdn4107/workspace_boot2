package ch10_1;

import java.util.Scanner;

import ch08.Book;

public class BookClient {
    
	Scanner sc = new Scanner(System.in);
	//사용자한테 Book객체를 생성하는 메서드 기능을 만든다.
	public Book createBookObj() {
	   //지역변수
		System.out.println("북 객체를 생성해 주세요!");
		int bookId = sc.nextInt();
		String bookTitle = sc.nextLine();
		String author = sc.nextLine();
		
		
		//클래스 생성
		Book book;
		return new Book(bookId, bookTitle, author);
	}
	//title 로 비교가능
	//책의 정보를 확인하는 기능
	public void showBookInfo(int index) {
		
	}
	//저장되어있는 객체를 삭제하는 기능
	public void deleteBook(String title) {
		
	}
    //수정하는 기능
	public void updateBook(int index, Book book) {
		
	}

}
