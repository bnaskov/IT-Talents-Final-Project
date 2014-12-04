package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import products.accounts.Account;
import products.accounts.Deposit;
import users.IClient;
import users.User;

public class Bank implements IBank {

	private String name;
	private String address;

	private Map<String, User> users = new HashMap();
	private Map<String, ArrayList<Account>> allAccounts = new HashMap();

	private static Bank instance = null;

	private Bank() {
	}

	public static synchronized Bank getInstance() {
		if (instance == null) {
			instance = new Bank();
		}
		return instance;
	}

	public void displayAllDeposits() {

	}

	public boolean transferMoney(IClient client, String initiatorIban,
			String recipientIban, String reasonForTransfer, double amount) {
		return true;

	}

	public boolean openAccount(IClient client, String initiatorIban,
			double amount) {
		return true;

	}

	public boolean openDeposit(IClient client, String initiatorIban,
			double amount, Deposit deposit) {
		return true;

	}

}
