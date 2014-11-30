package bank;


import java.util.HashMap;

import products.IBankProduct;
import users.Client;
import users.User;

public class Bank {
	
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
	
	public void openDeposit(Client onlineClient){
		onlineClient.openDeposit();
		
	}
	
	public void openAccount(Client onlineClient){
		onlineClient.openAccount();
	}
	
}
