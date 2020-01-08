package connection;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.*;
import msg.*;
import user.User;

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
