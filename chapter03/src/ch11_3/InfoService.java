package ch11_3;

public interface InfoService {

	// 추가
	void addInfo(UserInfo userinfo);

	// 수정
	void updateInfo(String name, UserInfo userInfo);

	// 조회
	void seletedInfo(String name);

	// 모두 조회
	void showAll();
}
