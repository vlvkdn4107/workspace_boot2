package ch10_1;

import java.util.ArrayList;

import ch08.Book;

public class BookDaoMySql implements BookDao{
	//ArrayList<객체>
	ArrayList<Book> books = new ArrayList<Book>();
	@Override
	public void addBook(Book book) {
		System.out.println("추가합니다");
		books.add(book);
		
		
	}

	@Override
	public void updateBook(int index, Book book) {
		// TODO Auto-generated method stub
		books.set(index, book);
	}

	@Override
	public void deleteBook(int index) {
		// TODO Auto-generated method stub
		books.remove(index);
	}

	@Override
	public void selectBook(int index) {
		books.get(index);
		System.out.println(books.get(index));
		
	}

	@Override
	public void selectAll() {
	 for (Book book : books) {
		System.out.println(book);
	}
		
	}

}
