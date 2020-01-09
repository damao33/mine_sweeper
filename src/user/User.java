package user;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import connection.ConnectionManager;
import connection.UserDaoJdbcImpl;
import gui.InfSetting;

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
		return UserDaoJdbcImpl.readScore(this);
	}
	public void setScore(int score) {
		UserDaoJdbcImpl.writeScore(this, score);
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acount == null) ? 0 : acount.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (acount == null) {
			if (other.acount != null)
				return false;
		} else if (!acount.equals(other.acount))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		return true;
	}

	
}
