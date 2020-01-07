package connection;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

import msg.ExitMsg;
import msg.LoginMsg;
import msg.Msg;
import user.User;

public class ConnectClient implements Runnable
{
	private Socket clientSocket;
	
	public Socket getClientSocket() {
		return clientSocket;
	}

	public ConnectClient(Socket socket) {
		super();
		clientSocket = socket;
	}
	public boolean sendLogin(User user)
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
	public boolean sendExit(User user)
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

	@Override
	public void run() {
		try
		{
			InputStream clientIS = clientSocket.getInputStream();
			while(true)
			{
				while(clientIS.available()!=0)
				{
					ObjectInputStream ois = new ObjectInputStream(clientIS);
					Object o = ois.readObject();					
					if(o instanceof Msg)
					{
						System.out.println("Recv message from server:");
						System.out.println((Msg)o);
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
