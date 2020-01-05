package connection;

import user.User;
import java.sql.*;
public class UserDaoJdbcImpl implements UserDao
{
	public static boolean findUser(User user) {
		Connection conn=ConnectionManager.getConnection();
		if(conn==null)
		{
			System.out.println("conn==null");
			return false;
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
				return false;
			}
			else
			{
				System.out.println("find 1");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(new SQLException("30"));
		} finally
		{
			ConnectionManager.releaseAll(resultSet, pStatement, conn);
		}
		return false;
	}

	public static boolean login(User user) {
		if(!UserDaoJdbcImpl.findUser(user))return false;	//不存在该用户
		Connection conn = null;
		String sql="select * from userinfo where acount = ?";
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try
		{
			conn = user.getConn();
			if(conn==null)
			{
				System.out.println("连接失败");
				return false;
			}
			else if(user.getOnlineState())
			{
				System.out.println("用户已在线");
				return false;
			}
			pStatement = conn.prepareStatement(sql);
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
			if(user.getPassword().equals(pwd))
			{
				user.setOnlineState(true);
				return true;	//密码正确登陆成功
			}
			else
			{
				System.out.println("密码错误");
				return false;	//密码错误登陆失败
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			ConnectionManager.releaseAll(resultSet, pStatement, null);//连接等退出游戏再关闭
		}
		return false;
	}

	public static boolean register(User user) {	
		if(UserDaoJdbcImpl.findUser(user))
		{
			System.out.println("用户已存在");
			return false;	//已存在该用户，无法注册
		}	
		if(user.getAcount().length()>20||user.getPassword().length()<6)return false;
		Connection conn = null;
		String sql="insert into userinfo values(?,?,?,?)";
		PreparedStatement pStatement = null;
		try
		{
			conn=ConnectionManager.getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, user.getAcount());
			pStatement.setString(2, user.getPassword());
			pStatement.setString(3, user.randomNickName());
			pStatement.setInt(4, 0);
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
}
