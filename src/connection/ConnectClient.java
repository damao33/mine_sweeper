package connection;

import java.io.*;
import java.net.*;

import gui.*;
import msg.*;

public class ConnectClient implements Runnable
{
	private Socket clientSocket = null;
	public Socket getClientSocket() {
		return clientSocket;
	}
	public ConnectClient(Socket socket) {
		super();
		this.clientSocket = socket;
	}
	public boolean sendMsg(Msg msg)
	{
		try
		{	
			OutputStream os = this.clientSocket.getOutputStream();
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
						if(o instanceof GameRoomMsg)
						{
							RoomFrame.setRoomMsg((GameRoomMsg)o);
						}/*else if(o instanceof UserLoginMsg)
						{
							GameFrame.setLoginMsg((UserLoginMsg)o);
						}*/else if(o instanceof ExpandMsg)
						{
							GameFrame.setExpendMsg((ExpandMsg)o);
						}else if(o instanceof ChatMsg)
						{
							GameFrame.setChatMsg((ChatMsg)o);
						}else if(o instanceof UserEnterGameMsg)
						{
							GameFrame.setEnterMsg((UserEnterGameMsg)o);
						}else if(o instanceof WinMsg)
						{
							//GameFrame.set
						}
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
