package ch11_3;

public class UserClient {

	public UserInfo createUserInfo(String name, String id, String password) {
		return new UserInfo(name, id, password);
	}

}
