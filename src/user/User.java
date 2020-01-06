package user;

import java.net.*;
import java.sql.*;
import java.util.*;

import connection.ConnectionManager;

public class User {
	private String acount;
	private String password;
	private String nickName = null;
	private int score = 0;
	private Connection conn = null;
	private boolean onlineState = false;
	private Socket socket = null;
	
	public User(String acount, String password) {
		this.acount = acount;
		this.password = password;
		//if(this.nickName==null)this.setNickName(randomNickName());
		this.conn = ConnectionManager.getConnection();
	}
	public static String randomNickName()
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
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}	
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public boolean getOnlineState() {
		return onlineState;
	}
	public void setOnlineState(boolean onlineState) {
		this.onlineState = onlineState;
	}
	
}
