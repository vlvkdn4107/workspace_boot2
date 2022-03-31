package ch11_1;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {

		// 객체 생성
		BookClient bookClient = new BookClient();
		BookService bookArrayList = new BookArrayList();

		// 스캐너 사용
		Scanner scan = new Scanner(System.in);
		String selectedMenu = "";

		// do while문 사용
		do {
			System.out.println("-----------------------------------------------------------------");
			System.out.println("| 1. 책 생성 2. 책 조회 3. 책 삭제 4. 책 전체 조회 5. 책 수정 0. 프로그램 종료|");
			System.out.println("-----------------------------------------------------------------");
			selectedMenu = scan.nextLine();
			if (selectedMenu.equals("0")) {
				System.out.println("프로그램을 종료 합니다.");
				scan.close();

			} else if (selectedMenu.equals("1")) {
				System.out.println("책 정보를 추가합니다!");
				System.out.println("책 제목을 입력 하세요");
				String title = scan.nextLine();
				System.out.println("작가 이름을 입력하세요.");
				String author = scan.nextLine();
				Book book = bookClient.createBook(title, author);
				bookArrayList.addBook(book);

			} else if (selectedMenu.equals("2")) {
				System.out.println("책 제목을 입력해주세요.(조회)");
				String title = scan.nextLine();
				bookArrayList.selectedByTitleBook(title);

			} else if (selectedMenu.equals("3")) {
				System.out.println("책 제목을 입력하주세요.(삭제)");
				String title = scan.nextLine();
				bookArrayList.deleteBook(title);

			} else if (selectedMenu.equals("4")) {
				System.out.println("저장 되어있는 책을 조회 합니다.");
				bookArrayList.showAllBook();

			} else if (selectedMenu.equals("5")) {//제목에서 없으면 
				System.out.println("책 정보를 수정 합니다.");
				System.out.println("수정할 책을 입력해주세요");
				String savedtitle = scan.nextLine();
				System.out.println("수정할 제목을 수정해주세요");
				String title = scan.nextLine();
				System.out.println("수정할 책의 작가를 수정해주세요");
				String author = scan.nextLine();

				Book book = bookClient.createBook(title, author);
				bookArrayList.updateBook(savedtitle, book);
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		} while (!selectedMenu.equals("0"));// 셀렉티드메뉴(스캐너)값이 0이 아니라면 계속 반속한다

	}

}
