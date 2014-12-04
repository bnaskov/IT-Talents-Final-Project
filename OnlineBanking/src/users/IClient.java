package users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import products.accounts.Account;
import products.accounts.Deposit;

public interface IClient {
	public void transferMoney(String initiatorIban, String recipientIban,
			String reasonForTransfer, double amount);

	public void openAccount(String initiatorIban, double amount);

	public void openDeposit(String initiatorIban, double amount, Deposit deposit);
	
	public Map<String, HashMap<String, ArrayList<Account>>> getClientAccounts();
}
