package serverConnection;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server
{
	public static void main(String[] args) throws Exception
	{
		boolean isConnected = true;
		int connectionId = 1;
		final int port = 666;
		System.out.println("Starting server...");
		ServerSocket welcomeSocket = new ServerSocket(port);
		ClientManager manager = new ClientManager();
		while(isConnected)
		{
			System.out.println("Waiting for client, next id is: " + connectionId);
			Socket connectionSocket = welcomeSocket.accept();
			ServerConnection c = new ServerConnection(connectionSocket, connectionId);
			connectionId++;
			c.setManager(manager);
			manager.addConnection(c);
			new Thread(c, "Communicaton").start();
		}
	}
}
