package ch05;

public class UserInfoMySqlDao implements UserInfoDao{

	//추상메서드를 일반 메서드로 재정의하기!
	@Override
	public void insertUserInfo(UserInfo info) {
		System.out.println("MYSQL: 저장하기 id " + info.getUserid());
		System.out.println("MYSQL: 저장하기 pw " + info.getPassword());
		System.out.println("MYSQL: 저장하기 name " + info.getUserName());
		
	}

	@Override
	public void updateUserInfo(UserInfo info) {
		System.out.println("MYSQL: 수정하기 id " + info.getUserid());
		System.out.println("MYSQL: 수정하기 pw " + info.getPassword());
		System.out.println("MYSQL: 수정하기 name " + info.getUserName());
		
	}

	@Override
	public void deletUserInfo(String userId) {
		System.out.println("MYSQL : 동작");
		System.out.println("delete from dbName userId = ' " + userId +" ' ");
	}

	

	//
}
