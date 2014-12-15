package users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import products.accounts.Account;
import bank.Bank;

public class Manager extends Employee {

	public Manager(String name, String idNumber, String email, String phone,
			String password, String city, String street) {
		super(name, idNumber, email, phone, password, city, street);
	}

	public void listAccount(String iban) {
		if(Bank.getInstance().getAccounts().containsKey(iban)) {
			System.out.println(Bank.getInstance().getAccounts().get(iban)); //for testing
		}
		else {
			System.out.println("No account with this IBAN in the bank!"); //for testing
		}
	}

	public void listClientAccounts(String clientIdNumber) {
		if(Bank.getInstance().getUsers().containsKey(clientIdNumber)) {
			for(Map.Entry<String, HashMap<String, ArrayList<Account>>> hashMap : 
				Bank.getInstance().getUsers().get(clientIdNumber).getClientAccounts().entrySet()) {
				for(Map.Entry<String, ArrayList<Account>> entry : hashMap.getValue().entrySet()) {
					System.out.println(entry.getValue());	//for testing
				}
			}
		}
		else {
			System.out.println("No client with this id number!"); //for testing
		}
	}

	public void listAllAccounts() {
		for(Map.Entry<String, Account> entry : Bank.getInstance().getAccounts().entrySet()) {
			System.out.println(entry.getValue()); //for testing
		}
	}
	public void listAccountInfo() {
		for(Map.Entry<String, Account> entry : Bank.getInstance().getAccounts().entrySet()) {
			System.out.println(entry.getValue()); //for testing
		}
	}
}
