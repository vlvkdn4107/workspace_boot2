package ch11_1;

public interface BookService {

	//개게를 저장하는 기능
	void addBook(Book book);//.add
	//객체를 수정하는 기능 (ArrayList인덱스에 접근해서 객체 교체
	void updateBook(String title, Book book);//.set
	
	//삭제 기능
	void deleteBook(String title); //.remove
	//책 한권에 정보를 출력하는 기능
	void selectedByTitleBook(String title);
	//ArrayList에 저장되어있는 책 정보를 전부 출력
	void showAllBook();
	
}
