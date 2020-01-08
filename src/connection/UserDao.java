package connection;

import user.User;

public interface UserDao {
	public static int findUser(User user) {
		return 0;
	}
	public static int login(User user) {
		return 0;
	}
	public static boolean register(User user) {
		return false;
	}
	public static boolean exit(User user)
	{
		return false;
	}
}