package bank;


import java.util.ArrayList;
import java.util.HashMap;

import products.IBankProduct;
import products.accounts.Account;
import products.accounts.Deposit;
import users.Client;
import users.IClient;
import users.User;

public class Bank implements IBank{
	
	private String name;
	private String address;
	
	//Singleton
	private static Bank instance = null;
	private Bank(){ }

	public static synchronized Bank getInstance(){  
		if (instance == null) {
			instance = new Bank();
		}
		return instance;
	}
	
	//HashMap of all site users
	HashMap<String, User> users = new HashMap();
	HashMap<String, ArrayList<Account>> allAccounts = new HashMap();
	
	public void displayAllDeposits(){
		
	}

	public boolean transferMoney(IClient client, String initiatorIban,
			String recipientIban, String reasonForTransfer, double amount) {
				return true;
		
	}

	public boolean openAccount(IClient client, String initiatorIban, double amount) {
		return true;
		
	}

	public boolean openDeposit(IClient client, String initiatorIban,
			double amount, Deposit deposit) {
				return true;
		
	}
	
	
}
