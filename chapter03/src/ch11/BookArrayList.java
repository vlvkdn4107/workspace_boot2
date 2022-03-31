package ch11;

import java.util.ArrayList;


public class BookArrayList implements Bookservice{

	
	
	/**
	 * Book 객체를 ArrayList 자료 구조에 저장하기
	 */
	private ArrayList<Book> books = new ArrayList<Book>();
	@Override
	public void addBook(Book book) {
		System.out.println("저장 합니다");
		books.add(book);
		showAllBook();//밑에 만들었던 메소드를 활용함
	}
	
	
    /**
     * 책에 타이틀로 책 존재 여부 확인
     * 있다면 매개 변수로 넘어 오는 Book객체를 
     * 수정 한다	
     */
	@Override
	public void updateBook(String title, Book book) {
		System.out.println("수정 합니다.");
		//인덱스값을 반환 받아서 이 기능을 완성할수있다
        // 책 타이틀로 인덱스 번호를 찾아야 한다.
		int bookIndex = -1;
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getTitle().equals(title)) {
				//책이 존재
				bookIndex = i;
			}
		}
		
		if(bookIndex == -1) {                //북인덱스가 -1이라면
			System.out.println(title + "이름에 책이 존재하기 않습니다");
		}else {
			books.set(bookIndex,book);
		}
		showAllBook();
		
		//books.set(0, book)
		
	}
    
	
    /**
     * 책 타이틀로 ArrayList에 객체를 삭제 합니다.	
     */
	@Override
	public void deleteBook(String title) {
		System.out.println("삭제 합니다");
		//flag
		boolean deleteOK= false;
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getTitle().equals(title)) {//인데스 i번째에 타이틀을 불러온다 
				books.remove(i);
				deleteOK = true;
			}
		}
		if(deleteOK) {
			System.out.println(title + "책을 삭제 하였습니다");
		}else {
			System.out.println(title + "책이 존재 하지 않습니다.");
		}
		showAllBook();
		
	}
	
	
    /**
     * 책 제목에 해당하는 객체에 정보를 출력 합니다.    
     */
	@Override
	public void selectedByTitleBook(String title) {
		System.out.println("조회 합니다.");
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getTitle().equals(title)) {
				System.out.println(books.get(i));
				return; //for문 멈추는 리턴
			}
		}
		System.out.println(title + "제목으로 책을 찾을수 없습니다");
	}
	
	
    /**
     * 모든 데이터를 출력!
     */
	@Override
	public void showAllBook() {
		System.out.println(">>>> 현재 저장된 데이터 확인 <<<<");
		for (Book book : books) {
			System.out.println(book);//북이라는 클래스에서 to String로 재정의 하였기 때문에 주소값이 안나온다 
		}
	}

}
