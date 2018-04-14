package interfaces;

import java.sql.SQLException;

import model.Account;

public interface IAccountDAO 
{
	String create(Account a)throws SQLException;
	String remove(Account a)throws SQLException;
	String checkAccount(Account a)throws SQLException;
	
}
