package users;

import java.util.ArrayList;
import java.util.HashMap;

import products.BankProduct;

public abstract class Client extends User implements IClient
{
	private HashMap<String, HashMap<String, ArrayList<BankProduct>>> accounts;

	Client(String name, String idNumber, String email, String phone,
			String password, String country, String city, String street, int postCode) 
	{
		super(name, idNumber, email, phone, password, country, city, street, postCode);
		setClientAccounts();
	}
	
	public void transferMoney(String initiatorIban, String recipientIban, String reasonForTransfer, double amount)
	{
		
	}
	
	public void openAccount(String initiatorIban, double amount)
	{
		
	}
	
	public void openDeposit(String initiatorIban, double amount, int durationMonths, double interest)
	{
		
	}
	
	public HashMap<String, HashMap<String, ArrayList<BankProduct>>> getClientAccounts()
	{
		return accounts;
	}
	
	public void setClientAccounts()
	{
		accounts = new HashMap<String, HashMap<String, ArrayList<BankProduct>>>();
	}
}
