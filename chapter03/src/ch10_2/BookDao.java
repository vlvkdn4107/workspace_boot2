package ch10_2;

import ch08.Book;

public interface BookDao {

	//인터페이스 (축약형
    void addBook(Book book);
    void updateBook(int index, Book book);
    void deleteBook(int index);
    void selectBook(int index);
    void selesctAll();
	
	
	
}
