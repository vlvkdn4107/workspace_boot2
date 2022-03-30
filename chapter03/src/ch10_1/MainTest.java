package ch10_1;

import ch08.Book;

public class MainTest {

	public static void main(String[] args) {

     BookClient bookClient = new BookClient();
     Book book = bookClient.createBookObj();
     //기능이 완성 되었다면
     bookClient.createBookObj();
     bookClient.deleteBook("홍길동전");

     BookDaoMySql bookDaoMySql = new  BookDaoMySql();
     bookDaoMySql.addBook(book);
     
     //실행에 흐름
     // 1. 조회 2.생성 3.삭제 4.출력
	}

}
