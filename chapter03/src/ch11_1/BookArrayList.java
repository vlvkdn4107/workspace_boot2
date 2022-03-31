package ch11_1;

import java.util.ArrayList;

public class BookArrayList implements BookService {

	/**
	 * Book 객체를 ArrayList 자료 구조에 저장하기
	 */
	private ArrayList<Book> books = new ArrayList<Book>();

	@Override
	public void addBook(Book book) {

		System.out.println(book.getTitle() + " 책을 추가하였습니다.");
		books.add(book);
		showAllBook();
	}

	/**
	 * 책클라이언트에 있는 책객체 여부를 확인 있다면 매개 변수로 넘어 오는 Book 객체를 수정한다.
	 */
	@Override
	public void updateBook(String title, Book book) {
		System.out.println(title + " 책을 수정 합니다.");
		// 책 타이틀로 인덱스 변화를 찾아야 한다.
		int bookIndex = -1;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().equals(title)) {
				bookIndex = i;
			}
		}
		if (bookIndex == -1) {
			System.out.println(title + "이름에 책이 존재하지 않습니다.");
		} else {
			books.set(bookIndex, book);
		}
		showAllBook();

	}

	@Override
	public void deleteBook(String title) {
		System.out.println("삭제 합니다.");
		boolean deleteOK = false; // 삭제 하기전이라서 false를 넣는다
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().equals(title)) {
				books.remove(i);
				deleteOK = true; // 삭제를 하면 true
			}
		}

		if (deleteOK) {
			System.out.println(title + "책을 삭제 하였습니다.");
		} else {
			System.out.println(title + "책이 존재하지 않습니다.");
		}
		showAllBook();
	}

	/**
	 * 책 제목에 해당하는 객체에 정보를 출력 합니다.
	 */
	@Override
	public void selectedByTitleBook(String title) {
		System.out.println(title + " 책을 조회 합니다");
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().equals(title)) {
				System.out.println(books.get(i));
				return;
			}
		}
		System.out.println(title + "제목으로 책을 찾을수 없습니다.");
	}

	@Override
	public void showAllBook() {
		System.out.println(">>>>>현재 저장된 데이터 정보<<<<<");
		for (Book book : books) {
			System.out.println(book);
		}
	}

}
