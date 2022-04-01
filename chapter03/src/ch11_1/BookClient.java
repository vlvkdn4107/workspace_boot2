package ch11_1;

public class BookClient {

	public static int srialBookNumber = 0;
	
	//북 객체 생성
	public Book createBook(String title, String author) {
		srialBookNumber++;
		return new Book(srialBookNumber, title, author);
		
	}
	
	
}
