package ch05;

public interface UserInfoDao {

	//기능넣기 //축약형 //추상메서드
	void insertUserInfo(UserInfo info); //객체를 모두 다 넣을려면 클래스명을 넣어라!
	void updateUserInfo(UserInfo info);
	void deletUserInfo(String userId);
	
}
