package users;

import java.util.ArrayList;
import java.util.HashMap;

import products.BankProduct;
import products.accounts.Deposit;
import bank.Bank;

public class Person extends Client {

	Person(String name, String idNumber, String email, String phone,
			String password, String city, String street,
			HashMap<String, HashMap<String, ArrayList<BankProduct>>> accounts,
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
			Deposit deposit) {

	}

}
