package server;

import java.util.Vector;

public class ServerData {

	private static ServerData instance;
	private static Vector<User> userlist ;
	
	
	public static ServerData getinstance() {
		if(instance == null) {
			instance = new ServerData();
		}
		return instance;
	}
	
	
	public User userName(String userName) {
		
		User checkUser = null;
		for(User user : userlist)
			if(user.getUserName().equals(userName)) {
				checkUser = user;
				break;
			}
		return checkUser;
	}
	
	
	
	
	
	
	
	public ServerData() {
		userlist = new Vector<User>();
	}

	public static Vector<User> getUserlist() {
		return userlist;
	}

	public static void setUserlist(Vector<User> userlist) {
		ServerData.userlist = userlist;
	}
	
	
}
