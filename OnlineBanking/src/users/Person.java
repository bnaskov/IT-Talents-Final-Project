package users;

import java.util.ArrayList;
import java.util.HashMap;

import products.accounts.Account;
import bank.Bank;
import bank.IBank.depositType;

public class Person extends Client {

	public Person(String name, String idNumber, String email, String phone,
			String password, String city, String street,
			HashMap<String, HashMap<String, ArrayList<Account>>> accounts,
			ArrayList<Transaction> transactions) {
		super(name, idNumber, email, phone, password, city, street, accounts,
				transactions);
	}

	public void transferMoney(Bank bank, String initiatorIban,
			String recipientIban, String reasonForTransfer, double amount) {

	}

	public void openAccount(Bank bank, String initiatorIban, double amount) {

	}

	public void openDeposit(Bank bank, String initiatorIban, double amount,
			depositType type) {

	}

}
