package connection;

import user.User;

import java.io.*;
import java.net.*;
import java.sql.*;
import msg.*;

public class UserDaoJdbcImpl implements UserDao
{
	private static ConnectClient connectClient = null;
	public static int  findUser(User user) {
		Connection conn=ConnectionManager.getConnection();
		if(conn==null)
		{
			System.out.println("conn==null");
			return -1;
		}
		String sql="select * from userinfo where acount = ?";
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try
		{
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, user.getAcount());
			resultSet = pStatement.executeQuery();
			if(!resultSet.next())
			{
				System.out.println("find 0");
				return 0;
			}
			else
			{
				System.out.println("find 1");
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(new SQLException("30"));
		} finally
		{
			ConnectionManager.releaseAll(resultSet, pStatement, conn);
		}
		return -1;
	}

	public static int login(User user) {
		if(UserDaoJdbcImpl.findUser(user)==0)return 0;	//不存在该用户
		Connection conn = null;
		String loginsql="select * from userinfo where acount = ?";
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try
		{
			conn = user.getConn();
			if(conn==null)
			{
				System.out.println("连接失败");
				return -1;
			}
			else if(user.getOnlineState()==1)
			{
				System.out.println("用户已在线");
				return -2;
			}
			pStatement = conn.prepareStatement(loginsql);
			pStatement.setString(1, user.getAcount());	
			resultSet = pStatement.executeQuery();	
			String pwd = null;
			String nickName = null;
			if(resultSet.next())
			{
				pwd	= resultSet.getString("password");
				nickName = resultSet.getString("nickName");
				if(nickName!=null)
				{
					user.setNickName(nickName);
				}
			}			
			System.out.println("Acount:"+user.getAcount());
			System.out.println("Pwd:"+pwd);
			connectClient = new ConnectClient(ConnectionManager.getSocket());
			
			if(user.getPassword().equals(pwd))
			{
				if(connectClient.getClientSocket()!=null)
				{
					if(connectClient.sendMsg(new UserLoginMsg(user))!=false)
					{
						Thread clientThread = new Thread(connectClient);
						clientThread.start();
						user.setOnlineState(1);
						String onlinesql = "update userinfo set onlineState = ? where acount = ?";
						pStatement = conn.prepareStatement(onlinesql);
						pStatement.setInt(1, 1);
						pStatement.setString(2, user.getAcount());
						pStatement.executeUpdate();	
						return 1;	//密码正确登陆成功
					}
					else
					{
						System.out.println("写入user失败");
						return -4;
					}
				}
				else
				{
					System.out.println("与服务器连接socket失败");
					return -3;
				}	
			}
			else
			{
				System.out.println("密码错误");
				return -3;	//密码错误登陆失败
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			ConnectionManager.releaseAll(resultSet, pStatement, null);//连接等退出游戏再关闭
		}
		return -1;
	}

	public static int register(User user) {	
		if(UserDaoJdbcImpl.findUser(user)==1)
		{
			System.out.println("用户已存在");
			return -1;	//已存在该用户，无法注册
		}	
		if(user.getAcount().length()>20||user.getPassword().length()<6)return 0;
		Connection conn = null;
		String sql="insert into userinfo values(?,?,?,?,?)";
		PreparedStatement pStatement = null;
		try
		{
			conn=ConnectionManager.getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, user.getAcount());
			pStatement.setString(2, user.getPassword());
			pStatement.setString(3, user.randomNickName());
			pStatement.setInt(4, 0);
			pStatement.setInt(5, 0);
			pStatement.executeUpdate();
			return 1;
		} catch(SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			ConnectionManager.releaseAll(null, pStatement, conn);
		}
		return -2;
	}	
	public static boolean exit(User user)
	{
		if(UserDaoJdbcImpl.findUser(user)==0)
		{
			System.out.println("用户不存在");
			return false;
		}
		Connection conn = null;
		String exitsql = "update userinfo set onlineState = ? where acount = ?";
		PreparedStatement pStatement = null;
		try
		{
			conn=ConnectionManager.getConnection();	
			pStatement = conn.prepareStatement(exitsql);
			pStatement.setInt(1, 0);
			pStatement.setString(2, user.getAcount());
			pStatement.executeUpdate();	
			return true;
		} catch(SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			ConnectionManager.releaseAll(null, pStatement, conn);
		}
		return false;
	}
	public static ConnectClient getConnectClient() {
		return connectClient;
	}	
}
