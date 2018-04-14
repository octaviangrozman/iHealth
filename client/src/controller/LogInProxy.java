package controller;
import view.AdminView;
import view.DoctorView;
import view.LogInView;
import view.PatientView;

public class LogInProxy implements LogInInterface 
{
	private LogInView login;
	private static LogInProxy instance;
	private String type = null;
	
	private LogInProxy()
	{
		login = new LogInView();
		login.start();
	}
	
	public static LogInProxy getInstance()
	{
		if(instance == null)
		{
			instance = new LogInProxy();
		}
		return instance;
	}
	
	public void showView(LogInInterface view) {
		try {
			view.start();
			login.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start() 
	{
		switch(type)
		{
			case "OK PATIENT": showView(new PatientView()); break;
			case "OK DOCTOR": showView(new DoctorView()); break;
			case "OK ADMIN": showView(new AdminView()); break;
			default: break;
		}
	}
	
	public void useProxy(String result)
	{
		this.type = result;
		start();
	}
}
