package ch11;

public class Book {
	int id;
	String title;
	
	//포함관계
	Author author;
	
	public Book() {
		author = new Author("임우성", 4107);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
	
}
