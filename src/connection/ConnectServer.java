package connection;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

import user.User;

public class ConnectServer {
	private static ServerSocket serverSocket = null;
	private static final int port = 8189;
	private static int userOnline = 0;
	public static void runServer()
	{
		try
		{
			serverSocket = new ServerSocket(port);
			while(true)
			{
				Socket imcoming =serverSocket.accept();
				userOnline++;
				Runnable connectedUserHandler = new ConnectedUserHandler(imcoming);
				Thread t = new Thread(connectedUserHandler);
				t.start();
				System.out.println("在线玩家："+userOnline);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
	public static void main(String[] args)
	{
		ConnectServer.runServer();
	}
}

class ConnectedUserHandler implements Runnable
{
	private Socket imcoming = null;
	
	public ConnectedUserHandler(Socket imcoming) {
		super();
		this.imcoming = imcoming;
	}

	@Override
	public void run() {
		try
		{
			InputStream is = this.imcoming.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			Object o;
			//while((o = ois.readObject())!=null)
			while(true)
			{
				while(is.available()!=0)
				{
					o = ois.readObject();
					if(o instanceof User)
					{
						User u = (User)o;
						System.out.println(u);
					}else
					{
						System.out.println("其他信息");
					}
				}
			}
			
			//ObjectOutputStream oos = new ObjectOutputStream(this.imcoming.getOutputStream());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("run error");
		}
	}
	
}