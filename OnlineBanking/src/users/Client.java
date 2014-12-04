package users;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import bank.IBank;
import products.IBankProduct;
import products.accounts.Deposit;

public abstract class Client extends User implements IClient
{
	private HashMap<String, HashMap<String, ArrayList<IBankProduct>>> accounts;
	private ArrayList<Transaction> transactions;
	private static SimpleDateFormat SDF = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

	Client(String name, String idNumber, String email, String phone,
			String password, String city, String street, HashMap<String, HashMap<String, ArrayList<IBankProduct>>> accounts,	
			ArrayList<Transaction> transactions) 
	{
		super(name, idNumber, email, phone, password, city, street);
		this.accounts = accounts;
		this.transactions = transactions;
	}
	
	public void transferMoney(IBank bank, String initiatorIban, String recipientIban, String reasonForTransfer, double amount)
	{
		if(bank.transferMoney(this, initiatorIban, recipientIban, reasonForTransfer, amount))
		{
			transactions.add(new Transaction(SDF.format(new Date()), initiatorIban, recipientIban, reasonForTransfer, amount));
		}
	}
	
	public void openAccount(IBank bank, String initiatorIban, double amount)
	{
		if(bank.openAccount(this, initiatorIban, amount))
		{
			
		}
	}
	
	public void openDeposit(IBank bank, String initiatorIban, double amount, Deposit deposit)
	{
		if(bank.openDeposit(this, initiatorIban, amount, deposit))
		{
			
		}
	}
	
}
