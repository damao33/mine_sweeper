package user;

public class User {
	private String acount;
	private String password;
	
	public User(String acount, String password) {
		super();
		this.acount = acount;
		this.password = password;
	}
	public String getAcount() {
		return acount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
