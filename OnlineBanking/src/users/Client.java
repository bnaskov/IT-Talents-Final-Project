package users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import products.accounts.Account;
import products.accounts.Deposit;
import bank.Bank;

public abstract class Client extends User implements IClient {

	private Map<String, HashMap<String, ArrayList<Account>>> accounts;
	private List<Transaction> transactions;

	// Date Timestamp db

	Client(String name, String idNumber, String email, String phone,
			String password, String city, String street,
			HashMap<String, HashMap<String, ArrayList<Account>>> accounts,
			ArrayList<Transaction> transactions) {
		super(name, idNumber, email, phone, password, city, street);
		this.accounts = accounts;
		this.transactions = transactions;
	}

	public void transferMoney(String initiatorIban, String recipientIban,
			String reasonForTransfer, double amount) {
		if (Bank.getInstance().transferMoney(this, initiatorIban,
				recipientIban, reasonForTransfer, amount)) {
			transactions.add(new Transaction(initiatorIban, recipientIban,
					reasonForTransfer, amount));
		}
	}

	public void openAccount(String initiatorIban, double amount) {
		Bank.getInstance().openAccount(this, initiatorIban, amount);
	}

	public void openDeposit(String initiatorIban, double amount, Deposit deposit) {
		Bank.getInstance().openDeposit(this, initiatorIban, amount, deposit);
	}
	
	public Map<String, HashMap<String, ArrayList<Account>>> getClientAccounts() {
		return accounts;
	}

}
