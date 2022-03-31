package ch11;

public interface Bookservice {

	//객체를 저장하는 기능
	void addBook(Book book);
	
	//북 객체를 수정하는 기능 (ArrayList인덱스에 접근해서 객체 교체
	//String title
    void updateBook(String title, Book book); //(타이틀을 , 어떤 객체를 넣을것인지)	
	
    //삭제 기능
    void deleteBook(String title);
    
    //책 한건에 정보를 출력하는 기능
    void selectedByTitleBook(String title);
    
    //ArrayList에 저장되어있는 책 정보를 전부 출력
    void showAllBook();//매게변수를 굳이 넣을필요가없다
}
