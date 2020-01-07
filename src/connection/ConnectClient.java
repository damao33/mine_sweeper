package connection;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

import msg.ExitMsg;
import msg.LoginMsg;
import user.User;

public class ConnectClient {
	private static Socket clientSocket;
	
	public static Socket getClientSocket() {
		return clientSocket;
	}
	
	public static void setClientSocket(Socket clientSocket) {
		ConnectClient.clientSocket = clientSocket;
	}

	public ConnectClient(Socket socket) {
		super();
		clientSocket = socket;
	}
	public static boolean sendLogin(User user)
	{
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
			oos.writeObject(new LoginMsg(user));
			oos.flush();
			
			System.out.println("login写入成功");
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("login写入失败");
			return false;
		}
	}	
	public static boolean sendExit(User user)
	{
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
			oos.writeObject(new ExitMsg(user));
			oos.flush();
			
			System.out.println("exit写入成功");
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("exit写入失败");
			return false;
		}
	}
}
