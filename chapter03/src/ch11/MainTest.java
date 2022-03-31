package ch11;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		
//		System.out.println(removeBlankString("    공백      제거    확인      1111"));
		
		
		
		// 객체 생성
		BookClient bookClient = new BookClient();
		//다형성
//		Bookservice bookArrayList = new BookArrayList();//메모리 올리기
		Bookservice bookArray = new BookArray();
		//스캐너
		Scanner sc = new Scanner(System.in);
		
		
	    
		
		
		//do while
		String selectedMenu = "";
		// 1 2 3 4 5 를 누르면 반복을 한다
		do {
			//출력할 내용
			System.out.println("---------------------------------------------------------------");
			System.out.println("1. 책 생성 2. 책 조회 3. 책 삭제 4. 책 전체 조회 5. 책 수정 0. 프로그램 종료");
			System.out.println("---------------------------------------------------------------");
			selectedMenu = sc.nextLine();
			if(selectedMenu.equals("0")) {
				System.out.println("프로그램을 종료 합니다.");
				sc.close();
			}else if(selectedMenu.equals("1")) {
				bookClient.printTitle();
				System.out.println("책 제목을 입력 합니다.");
				//객체를 생성하는 기능
				String title = sc.nextLine();
				System.out.println("작가의 이름을 입력하세요.");
				String author = sc.nextLine();
				Book book = bookClient.createBook(title, author);//title author 를 입력하면 생ㄱ성이되고
//				bookArrayList.addBook(book);		
				bookArray.addBook(book);		
				
				
			}else if (selectedMenu.equals("2")) {
				System.out.println("책 제목을 입력해 주세요.(조회)");
				String title = sc.nextLine();
				bookArray.selectedByTitleBook(title);
//				bookArrayList.selectedByTitleBook(title);
				
				
			}else if(selectedMenu.equals("3")) {
				System.out.println("삭제 하려는 책 제목을 입력해 주세요");
				String title =sc.nextLine();
				bookArray.deleteBook(title);
//				bookArrayList.deleteBook(title);
				
				//TODO
				
			}else if(selectedMenu.equals("4")) {
				System.out.println("저장 되어 있는 책 목록 조회");
				bookArray.showAllBook();
//				bookArrayList.showAllBook();
				
			}else if(selectedMenu.equals("5")) {
				System.out.println("수정 하려는 책 제목을 입력해 주세요");
				String savedtitle = sc.nextLine();
				System.out.println("새로운 책 제목을 입력 하세요.");
				String title = sc.nextLine();
				System.out.println("새로운 작가 이름을 입력 하세요.");
				String author = sc.nextLine();
				Book book = bookClient.createBook(title, author);
				
				bookArray.updateBook(savedtitle, book);
//				bookArrayList.updateBook(savedtitle, book);
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		     
		} while (! selectedMenu.equals("0"));//셀렉티드메뉴 값이 0이 아니라면 계속 반복한다 //문자열이면 .equals
           
	}//end of main
      
//	public static String removeBlankString(String str) {
//		String result1 = str.trim();
//		String result2 = str.replace(" ", "");
//		return result2;
//	}
	
} // end of class
