package serverConnection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import model.Consultation;
import model.ConsultationList;


public class ServerConnection implements Runnable
{
	private Socket clientSocket;
	private ObjectOutputStream outToClient;
	private ObjectInputStream inFromClient;
	private ClientManager manager;
	private int connectionId;
	
	public ServerConnection(Socket socket, int connectionId)
	{
		this.connectionId = connectionId;
		clientSocket = socket;
		try
		{
			outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
			inFromClient = new ObjectInputStream(clientSocket.getInputStream());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public int getConnectionId()
	{
		return this.connectionId;
	}
	public void setManager(ClientManager manager)
	{
		this.manager = manager;
	}
	
	public void run() 
	{
		while(true)
		{
			try 
			{
				Message m;
				m = (Message) inFromClient.readObject();
				Message response = new Message();
				response = manager.communicateWithDB(m);
				if(m.getRequest().equals("add consultation"))
				{
					if(!response.getResult().equals("FAIL"))
					{
						Consultation c = m.getConsultations().get(0);
						c.setId(Integer.parseInt(response.getResult()));
						ConsultationList list = new ConsultationList();
						list.addConsultation(c);
						response.setConsultations(list);
					}
				}
				System.out.println("Sending response: " + response.getResult());
				outToClient.writeObject(response);
			} 
			catch (Exception e) 
			{}
		}
	}
	
}
