package ch11_3;

import java.util.ArrayList;

public class InfoArrayList implements InfoService {

	private ArrayList<UserInfo> userInfos = new ArrayList<UserInfo>();

	@Override
	public void addInfo(UserInfo userinfo) {
		String name = "";
		name = name.stripLeading();
		name = name.stripTrailing();

		System.out.println(userinfo.getName() + ": 회원의 정보를 추가합니다");
		userInfos.add(userinfo);

		showAll();
	}

	@Override
	public void updateInfo(String name, UserInfo userInfo) {

		int userinfoIndex = -1;

		for (int i = 0; i < userInfos.size(); i++) {

			if (userInfos.get(i).getName().equals(name)) {
				userinfoIndex = i;

			}

		}
		if (userinfoIndex == -1) {
			System.out.println(name + "회원이 존재하지 않습니다");
		} else {
			userInfos.set(userinfoIndex, userInfo);
		}
		showAll();
	}

	@Override
	public void seletedInfo(String name) {

		System.out.println(name + " 회원의 정보를 조회합니다.");
//		for (int i = 0; i < userInfos.size(); i++) {// i는 0부터 시작 하고 i는 userInfos의 size보다 작으면 실행 / i는 +1씩 증가한다	          
//			if (userInfos.get(i).equals(name)) {//userInfos 의 i 번째를 부르고 name과 비교해서  동일하다면
//				
//				System.out.println(userInfos.get(i)); // userInfos의 i 번째를 출력한다.
//				return;
//			}
//		}
		for (int i = 0; i < userInfos.size(); i++) {
			if (userInfos.get(i).getName().equals(name)) {
				System.out.println(userInfos.get(i));
				return;
			}
		}
		System.out.println("회원을 찾을수 없습니다.");
	}

	@Override
	public void showAll() {
		System.out.println(">>등록된 회원들을 모두 조회 합니다.<<");
		for (UserInfo userInfo : userInfos) {
			System.out.println(userInfo);
		}

	}

}
