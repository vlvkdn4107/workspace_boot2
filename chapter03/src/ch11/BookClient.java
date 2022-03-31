package ch11;

public class BookClient {
  
	private static int serialBookNumber = 0;
	//북 객체 생성                받을 매게 변수
	public Book createBook(String title, String author) {//createBook을 만들고
		serialBookNumber++;
		return new Book(serialBookNumber, title, author);//createBook을 입력하면 이 객체를 생성한다
	}
	
	public void printTitle() {
		System.out.println("책 제목을 입력 합니다.");
		System.out.println("공백은 입력하지 마세요.");
	}
	
}
