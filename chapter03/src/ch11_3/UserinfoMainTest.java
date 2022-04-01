package ch11_3;

import java.util.Scanner;

public class UserinfoMainTest {

	public static void main(String[] args) {

		// 객체 생성
		UserClient userClient = new UserClient();
		InfoArrayList arrayList = new InfoArrayList();

		String selectedMn = "";

		// 스캐너 사용
		Scanner scan = new Scanner(System.in);

		// do while문 사용
		do {

			System.out.println("================================================================================-=");
			System.out.println(" 1. 회원 추가 2. 회원 정보 조회 3. 등록된 회원 모두 조회 4. 회원의 정보를 수정합니다. 0. 프로그램 종료");
			System.out.println("==================================================================================");

			selectedMn = scan.nextLine();

			if (selectedMn.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				scan.close();
			} else if (selectedMn.equals("1")) {
				System.out.println("추가할 회원의 이름을 입력하세요");
				String name = scan.nextLine();

//				String  removeBlank= name.replace(" ", "");
				System.out.println("추가할 회원의 아이디를 입력하세요");
				String userid = scan.nextLine();
				System.out.println("추가할 회원의 비밀번호을 입력하세요");
				String userpassword = scan.nextLine();
				UserInfo userinfo = userClient.createUserInfo(name.replace(" ", ""), userid.replace(" ", ""),
						userpassword.replace(" ", ""));
				arrayList.addInfo(userinfo);

//				String removeBlank = selectedMn.trim();
//				 name = removeBlank.replace(" ", "");

			} else if (selectedMn.equals("2")) {
				System.out.println("조회할 회원의 이름을 입력해주세요.");
				String name = scan.nextLine();
				arrayList.seletedInfo(name);

			} else if (selectedMn.equals("3")) {
				arrayList.showAll();

			} else if (selectedMn.equals("4")) {
				System.out.println("수정할 회원의 이름을 입력하세요.");
				String savename = scan.nextLine();
				System.out.println("수정할 회원이 이름을 수정해주세요.");
				String name = scan.nextLine();
				System.out.println("수정할 아이디를 입력하세요.");
				String id = scan.nextLine();
				System.out.println("수정할 비밀번호를 입력하세요.");
				String password = scan.nextLine();

				UserInfo userinfo = userClient.createUserInfo(name.replace(" ", ""), id.replace(" ", ""),
						password.replace(" ", ""));
				arrayList.updateInfo(savename, userinfo);

			} else {
				System.out.println("잘못된 입력입니다");// 방어적 코드
			}

		} while (!selectedMn.equals("0"));

	}// end of main

}
