package connection;

import java.io.*;
import java.net.*;
import java.util.*;

import gameRule.*;
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
	private static Set<ConnectedUserHandler> userSet = new HashSet<>();
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
				ConnectedUserHandler connectedUserHandler = new ConnectedUserHandler(imcoming);
				userSet.add(connectedUserHandler);
				//Thread t = new Thread(connectedUserHandler);
				connectedUserHandler.start();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
	
	public static synchronized void userLogin()
	{
		userOnline++;
		System.out.println("在线玩家："+userOnline);
	}
	public static synchronized void userExit()
	{
		userOnline--;
		System.out.println("在线玩家："+userOnline);
	}
	public static synchronized ChatMsg userRoom(Msg msg)
	{
		int room = 0;
		ChatMsg chatmsg = null;
		if(msg instanceof UserEnterGameMsg)
		{
			UserEnterGameMsg enterMsg = (UserEnterGameMsg)msg;
			room = (enterMsg).getRoom();
			if(room==1)room1Online++;
			else if(room==2)room2Online++;
			else if(room==3)room3Online++;
			else if(room==4)room4Online++;
			Object[] chatMsg = new Object[] {null,"欢迎"+enterMsg.getUser().getNickName()+"进入房间"};
			chatmsg = new ChatMsg(chatMsg);
		}else if(msg instanceof UserBackToRoomMsg)
		{
			UserBackToRoomMsg backMsg = (UserBackToRoomMsg)msg;
			room = (backMsg).getRoom();
			if(room==1)room1Online--;
			else if(room==2)room2Online--;
			else if(room==3)room3Online--;
			else if(room==4)room4Online--;
			Object[] chatMsg = new Object[] {null,backMsg.getUser().getNickName()+"离开房间"};
			chatmsg = new ChatMsg(chatMsg);
		}
		return chatmsg;
	}
	public static ServerSocket getServerSocket() {
		return serverSocket;
	}

	public int getUserOnline() {
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



	public static Set<ConnectedUserHandler> getUserSet() {
		return userSet;
	}

	public static void main(String[] args)
	{
		new ConnectServer().runServer();
	}
	
	class ConnectedUserHandler extends Thread
	{
		private Socket imcoming = null;
		private User user = null;
		
		public ConnectedUserHandler(Socket imcoming) {
			super();
			this.imcoming = imcoming;
		}
		@Override
		public void run() {
			try
			{
				InputStream is = this.imcoming.getInputStream();
				//while((o = ois.readObject())!=null)
				while(true)
				{
					while(is.available()!=0)
					{
						ObjectInputStream ois = new ObjectInputStream(is);
						Object o = ois.readObject();					
						if(o instanceof Msg)
						{	
							if(o instanceof UserLoginMsg)
							{
								ConnectServer.userLogin();	
								User user = ((UserLoginMsg)o).getUser();
								this.user = user;
								ConnectServer.userSet.add(this);
								Msg gameRoomMsg = this.makeMsg("GameRoomMsg", user);
								this.sendToAll(gameRoomMsg);
							}
							else if(o instanceof UserExitMsg) {
								ConnectServer.userExit();
								ConnectServer.userSet.remove(this);
								User user = ((UserExitMsg)o).getUser();
								ConnectServer.userSet.remove(this);
								Msg gameRoomMsg = this.makeMsg("GameRoomMsg", user);
								this.sendToAll(gameRoomMsg);
							}else if(o instanceof UserEnterGameMsg||o instanceof UserBackToRoomMsg)
							{
								ChatMsg chatMsg = ConnectServer.userRoom((Msg)o);
								Msg gameRoomMsg = this.makeMsg("GameRoomMsg", user);
								this.sendToAll(gameRoomMsg);
								//this.send
								this.sendToAll(chatMsg);
								if(o instanceof UserEnterGameMsg)
								{
									MineButton[][] mineButton = ServerMineButton.getMineButton();
									this.sendMsg(new ServerMineButton(mineButton));
								}
							}else if(o instanceof ChatMsg)
							{
								this.sendToAll((ChatMsg)o);
							}
							System.out.println((Msg)o);
							System.out.println(((Msg)o).getMsgType()+" has sent back to client");
						}					
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("run error");
			}
		}
		public Msg makeMsg(String msgType,User user)
		{
			Msg msg = null;
			if(msgType.equals("GameRoomMsg"))
			{
				Object[] gameRoomMsg = new Object[] {ConnectServer.this.getUserOnline(),ConnectServer.this.getRoom1Online(),
						ConnectServer.this.getRoom2Online(),ConnectServer.this.getRoom3Online(),ConnectServer.this.getRoom4Online()
						,user};
				msg = new GameRoomMsg(gameRoomMsg);
			}
			return msg;
		}
		private boolean sendMsg(Msg msg)
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
		public void sendToAll(Msg msg)
		{
			for(ConnectedUserHandler now:ConnectServer.userSet)
			{
				/*if(this.sendMsg(msg))*/
				try
				{
					OutputStream os = now.imcoming.getOutputStream();
					ObjectOutputStream oos = new ObjectOutputStream(os);
					oos.writeObject(msg);
					oos.flush();		
					System.out.println("sent to "+now.getUser().getNickName());
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}				
			}
			System.out.println(msg.getMsgType()+":has sent to all");
		}
		
		public User getUser() {
			return user;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((imcoming == null) ? 0 : imcoming.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ConnectedUserHandler other = (ConnectedUserHandler) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (imcoming == null) {
				if (other.imcoming != null)
					return false;
			} else if (!imcoming.equals(other.imcoming))
			{
				return false;
			}else if(this.user != other.user)return false;
				
			return true;
		}
		private ConnectServer getEnclosingInstance() {
			return ConnectServer.this;
		}
	}
}