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
	private Socket socket = null;
	
	public ConnectServer() {
		super();
	}

	public void runServer()
	{
		try
		{
			serverSocket = new ServerSocket(port);
			while(true)
			{
				Socket imcoming =serverSocket.accept();
				Runnable connectedUserHandler = new ConnectServer.ConnectedUserHandler(imcoming);
				Thread t = new Thread(connectedUserHandler);
				t.start();
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
	
	public static ServerSocket getServerSocket() {
		return serverSocket;
	}

	public static int getUserOnline() {
		return userOnline;
	}

	public static int getRoom1Online() {
		return room1Online;
	}

	public static int getRoom2Online() {
		return room2Online;
	}

	public static int getRoom3Online() {
		return room3Online;
	}

	public static int getRoom4Online() {
		return room4Online;
	}

	public static void main(String[] args)
	{
		new ConnectServer().runServer();
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
							if(o instanceof LoginMsg)
							{
								ConnectServer.userLogin();
								Object[] gameRoomMsg = new Object[] {ConnectServer.this.getUserOnline(),ConnectServer.this.getRoom1Online(),
										ConnectServer.this.getRoom2Online(),ConnectServer.this.getRoom3Online(),ConnectServer.this.getRoom4Online()
										,((LoginMsg)o).getUser()};
								ObjectOutputStream oos = new ObjectOutputStream(os);
								oos.writeObject(new GameRoomMsg(gameRoomMsg));
								oos.flush();
								System.out.println("game room msg sent back");
							}
							if(o instanceof ExitMsg)ConnectServer.userExit();
							System.out.println((Msg)o);
							System.out.println(((Msg)o).getMsgType()+" has sent back to client");
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
		public boolean sendMsg(Msg msg)
		{
			try
			{	
				OutputStream os = this.imcoming.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(msg);
				oos.flush();		
				System.out.println(msg.getMsgType()+"写入成功");
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println(msg.getMsgType()+"写入失败");
				return false;
			}
		}
	}
}

