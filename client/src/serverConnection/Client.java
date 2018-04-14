package serverConnection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client 
{
	private ObjectOutputStream outToServer;
	private ObjectInputStream inFromServer;
	private Socket clientSocket;
	private final int port = 666;
	private final String host = "localhost";
	private static Client instance;
	
	private Client()
	{
		try 
		{
			clientSocket = new Socket(host, port);
			outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
			inFromServer = new ObjectInputStream(clientSocket.getInputStream());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static synchronized Client getInstance()
	{
		if(instance == null)
		{
			instance = new Client();
		}
		return instance;
	}
	
	public Message sendMessageToServer(Message m) throws IOException
	{
		outToServer.writeObject(m);
		return receiveFromServer();
		
	}
	private Message receiveFromServer()
	{
		boolean hasGot = false;
		Message fromServer= null;
		while(!hasGot)
		{
			try {
				fromServer = (Message) inFromServer.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(fromServer != null)
			{
				hasGot = true;
			}
		}
		return fromServer;
	}
}
