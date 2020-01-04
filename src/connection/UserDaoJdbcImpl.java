package connection;

import user.User;
import java.sql.*;
public class UserDaoJdbcImpl implements UserDao
{
	private static Connection conn=null;

	public static boolean findUser(User user) {
		if(conn==null)return false;
		String sql="select * from userinfo where acount = ?";
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try
		{
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, user.getAcount());
			resultSet = pStatement.executeQuery(sql);
			if(resultSet.wasNull())
			{
				return false;
			}
			else return true;
		} catch (SQLException e) {
			System.out.println(new SQLException("30"));
		} finally
		{
			ConnectionManager.releaseAll(resultSet, pStatement, conn);
		}
		return false;
	}

	public static boolean Login(User user) {
		if(!UserDaoJdbcImpl.findUser(user))return false;	//不存在该用户
		String sql="select * from userinfo where acount = ?";
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try
		{
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, user.getAcount());
			resultSet = pStatement.executeQuery(sql);
			String pwd = resultSet.getString("password");
			if(user.getPassword().equals(pwd))
			{
				return true;	//密码正确登陆成功
			}
			else return false;	//密码错误登陆失败
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
		String sql="insert into userinfo values(?,?)";
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try
		{
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, user.getAcount());
			pStatement.setString(2, user.getPassword());
			resultSet = pStatement.executeQuery(sql);
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
