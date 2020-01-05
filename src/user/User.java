package user;

import java.util.Random;

public class User {
	private String acount;
	private String password;
	private String nickName;
	private int score = 0;
	public User(String acount, String password) {
		this.acount = acount;
		this.password = password;
		this.setNickName(randomNickName());
	}
	private static String randomNickName()
	{
		String nickName="player";
		Random r = new Random();		
		return nickName+r.nextInt(99999);
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getScore() {
		return score;
	}
}
