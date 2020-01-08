package connection;

import java.io.*;
import java.net.*;
import msg.*;
import user.User;

public class ConnectServer {
	private static ServerSocket serverSocket = null;
	private static final int port = 8189;
	private static int userOnline = 0;
	private static int room1Online = 0;
	private static int room2Online = 0;
	private static int room3Online = 0;
	private static int room4Online = 0;
	public static void runServer()
	{
		try
		{
			serverSocket = new ServerSocket(port);
			while(true)
			{
				Socket imcoming =serverSocket.accept();
				Runnable connectedUserHandler = new ConnectedUserHandler(imcoming);
				Thread t = new Thread(connectedUserHandler);
				t.start();
				userLogin();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
	
	public static void userLogin()
	{
		userOnline++;
		System.out.println("在线玩家："+userOnline);
	}
	public static void userExit()
	{
		userOnline--;
		System.out.println("在线玩家："+userOnline);
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
			OutputStream os = this.imcoming.getOutputStream();
			//while((o = ois.readObject())!=null)
			while(true)
			{
				while(is.available()!=0)
				{
					ObjectInputStream ois = new ObjectInputStream(is);
					Object o = ois.readObject();					
					if(o instanceof Msg)
					{
						if(o instanceof ExitMsg)ConnectServer.userExit();
						System.out.println((Msg)o);
					}
					ObjectOutputStream oos = new ObjectOutputStream(os);
					oos.writeObject(o);
					System.out.println("Msg has sent back to client");
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