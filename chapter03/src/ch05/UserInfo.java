package ch05;

public class UserInfo {
    
	private String userid;
	private String password;
	private String userName;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", password=" + password + ", userName=" + userName + "]";
	}
	
	
}
