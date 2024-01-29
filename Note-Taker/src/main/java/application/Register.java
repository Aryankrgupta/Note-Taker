package application;

public class Register {
	private String userName;
	private String password;
	private int userId;
	
	
	public Register(String password, String user) {
		this.password = password;
		this.userName = user;
	}
	
	public Register(String userName, String password, int userId) {
		this.userName = userName;
		this.password = password;
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Register [userName=" + userName + ", password=" + password + ", userId=" + userId + "]";
	}
	
	
}
