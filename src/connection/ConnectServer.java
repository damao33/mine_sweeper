package connection;

import java.net.*;

public class ConnectServer {
	private static ServerSocket serverSocket = null;
	private static final int port = 8189;
	public static void runServer()
	{
		try
		{
			serverSocket = new ServerSocket(port);
			while(true)
			{
				Socket imcoming =serverSocket.accept();
				System.out.println("online +1");
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

class connectedUserHandler implements Runnable
{
	private Socket imcoming = null;
	
	public connectedUserHandler(Socket imcoming) {
		super();
		this.imcoming = imcoming;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}