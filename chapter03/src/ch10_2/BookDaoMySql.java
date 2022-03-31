package ch10_2;

import java.util.ArrayList;

import ch08.Book;



public class BookDaoMySql implements BookDao{

	//ArrayList
	ArrayList<Book> books = new ArrayList<Book>();
	
	
	@Override
	public void addBook(Book book) {
		books.add(book); //.add(추가)
		
	}

	@Override
	public void updateBook(int index, Book book) {
		books.set(index, book); // .set(수정)
		
	}

	@Override
	public void deleteBook(int index) {

          books.remove(index);  //.remove (삭제)
		
	}

	@Override
	public void selectBook(int index) {

          books.get(index); //.get(출력,내보내기)
		
	}

	@Override
	public void selesctAll() {

      for (Book book : books) {
		System.out.println(book);
	}
		
	}

	
	

}
