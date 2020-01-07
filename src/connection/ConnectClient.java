package connection;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

import user.User;

public class ConnectClient {
	private User user;
	private Socket socket;
	private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;
	public ConnectClient(User user) {
		super();
		this.user = user;
		try
		{
			this.oos = new ObjectOutputStream(this.socket.getOutputStream());
			this.ois = new ObjectInputStream(this.socket.getInputStream());
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("对象流初始化失败");
		}
	}
	//public void senMsg(Ob)
	//class 
}
