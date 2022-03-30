package ch06;

public class Book {

	private int bookid;
	private String title;
	
	public Book(int bookId, String title) {
		this.bookid = bookId;
		this.title = title;
	}
	
	public boolean isSameBook(Book book) {
		if(book.title.equals(this.title)) {
			return true;
		}else {
			return false;		
		}
	}
	
	//북이라는 클래스에 타이틀이 같은 녀석이면 같은 객체다 라고 재정의 했음.
	
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + "]";
	}
	@Override
	public boolean equals(Object obj) {
	    if(obj instanceof Book) {//instanceof ->비교
	        //북이라는 클래스 타입이 들어오면 안에 접근해서 멤버변수인 title을 확인
	    	Book tempBook = (Book)obj;//다운캐스팅
	    	String title = tempBook.title;
	    	if(this.title == title){//this 지금 클래스에
	    	    return true;    	
	    	}else {
	    		return false;
	    	 	}
	  	   }
	    return false;
	}
	
	
}
