package user;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

import connection.ConnectionManager;

public class User implements Serializable
{
	private static final long serialVersionUID = -4058332813000180067L;
	private String acount;
	private String password;
	private String nickName = null;
	private int score = 0;
	private transient Connection conn = null;
	private int onlineState = 0;

	public User(String acount, String password) {
		this.acount = acount;
		this.password = password;
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
	
	public int getOnlineState() {
		return onlineState;
	}
	public void setOnlineState(int onlineState) {
		this.onlineState = onlineState;
	}
	@Override
	public String toString() {
		return "User "+this.getNickName();
	}	
	
}
