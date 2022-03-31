package ch11;

public class BookArray implements Bookservice{
	
	
	Book[] books = new Book[10];
    
	
	@Override
	public void addBook(Book book) {
//		books[0] = new Book(1, "가", "나");
		for (int i = 0; i < books.length; i++) {
			if(books[i] == null) {
				books[i] =book;
				showAllBook();
				return;
			}
		}
		
	}

	@Override
	public void updateBook(String title, Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectedByTitleBook(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showAllBook() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
