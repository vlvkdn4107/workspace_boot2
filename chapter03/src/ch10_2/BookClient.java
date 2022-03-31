package ch10_2;

import java.util.Scanner;

import ch08.Book;

public class BookClient {

    Scanner sc = new Scanner(System.in);
    
    public Book createBookObj() {
    	System.out.println("북 객체를 생성해 주세요");
    	
    	int bookId = sc.nextInt();
    	String bookTitle = sc.nextLine();
    	String author = sc.nextLine();
    	
    	
    	
    	Book book;
    	return new Book(bookId, bookTitle, author);
    	
    	
    }
    
    
	
}
