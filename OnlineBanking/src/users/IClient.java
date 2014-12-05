package users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import products.accounts.Account;
import bank.IBank.depositType;

public interface IClient {
	public void transferMoney(String initiatorIban, String recipientIban,
			String reasonForTransfer, double amount);

	public void openAccount(String initiatorIban, double amount);

	public void openDeposit(String initiatorIban, double amount, depositType type);
	
	public Map<String, HashMap<String, ArrayList<Account>>> getClientAccounts();
}
