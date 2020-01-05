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

	public static boolean Login(User user) {
		if(!UserDaoJdbcImpl.findUser(user))return false;	//不存在该用户
		Connection conn = null;
		String sql="select * from userinfo where acount = ?";
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try
		{
			conn = ConnectionManager.getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, user.getAcount());
			resultSet = pStatement.executeQuery();
			String pwd = null;
			if(resultSet.next())
			{
				pwd	= resultSet.getString("password");
			}			
			System.out.println("Acount:"+user.getAcount());
			System.out.println("Pwd:"+pwd);
			if(user.getPassword().equals(pwd))
			{
				return true;	//密码正确登陆成功
			}
			else
			{
				System.out.println("密码错误");
				return false;	//密码错误登陆失败
			}
		} catch (SQLException e) {
			System.out.println(new SQLException("30"));
		} finally
		{
			ConnectionManager.releaseAll(resultSet, pStatement, conn);
		}
		return false;
	}

	public static boolean Regester(User user) {	
		if(UserDaoJdbcImpl.findUser(user))return false;	//已存在该用户，无法注册
		if(user.getAcount().length()>20||user.getPassword().length()<6)return false;
		Connection conn = null;
		String sql="insert into userinfo values(?,?)";
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try
		{
			conn=ConnectionManager.getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, user.getAcount());
			pStatement.setString(2, user.getPassword());
			resultSet = pStatement.executeQuery();
			return true;
		} catch(SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			ConnectionManager.releaseAll(resultSet, pStatement, conn);
		}
		return false;
	}
}
