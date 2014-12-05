package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import products.accounts.Account;
import products.accounts.CurrentAccountBGN;
import products.accounts.DepositLongTerm;
import products.accounts.DepositShortTerm;
import users.Client;
import users.IClient;

public class Bank implements IBank {

	private String name;
	private String address;

	private Map<String, IClient> users = new HashMap<String, IClient>();
	private Map<String, Account> allAccounts = new HashMap<String, Account>();

	private static Bank instance = null;

	private Bank() {
	}

	public static synchronized Bank getInstance() {
		if (instance == null) {
			instance = new Bank();
		}
		return instance;
	}
	
	public Map<String, IClient> getUsers() {
		return users;
	}
	
	public Map<String, Account> getAccounts() {
		return allAccounts;
	}
	
	public void addClientToBank(IClient client) {
		users.put(((Client) client).getIdNumber(), client);
	}

	public void displayAllDeposits() {

	}
	
	public void addAccountsInBank(String iban, Account account) {
		if(iban != null && account != null)
			allAccounts.put(iban, account);
	}

	public boolean transferMoney(IClient client, String initiatorIban,
			String recipientIban, String reasonForTransfer, double amount) {
		if(allAccounts.containsKey(initiatorIban)) {
			if(allAccounts.get(initiatorIban).getAmount() >= amount) {
				if(allAccounts.containsKey(recipientIban)) {
					allAccounts.get(recipientIban).addMoneyToAccount(amount);
					allAccounts.get(initiatorIban).removeMoneyFromAccount(amount);
					return true;
				}
				else {
					System.out.println("There's no account with this IBAN in the bank!"); //for testing
					return false;
				}
			}
			else {
				System.out.println("You have not enough money for this transaction!"); //for testing
				return false;
			}
		}
		else {
			System.out.println("You don't have an account with this IBAN! Please enter a valid IBAN!");
			return false;
		}

	}

	public void openAccount(IClient client, String initiatorIban,
			double amount) {
		if(allAccounts.containsKey(initiatorIban)) {
			if(allAccounts.get(initiatorIban).getAmount() >= amount) {
				if(!client.getClientAccounts().containsKey("CurrentAccount")) {
					client.getClientAccounts().put("CurrentAccount", new HashMap<String, ArrayList<Account>>());
				}
				if(!client.getClientAccounts().get("CurrentAccount").containsKey("CurrentAccountBGN")) {
					client.getClientAccounts().get("CurrentAccount").put("CurrentAccountBGN", new ArrayList<Account>());
				}
				client.getClientAccounts().get("CurrentAccount").get("CurrentAccountBGN").add(new CurrentAccountBGN(amount));
				allAccounts.get(initiatorIban).removeMoneyFromAccount(amount);
			}
			else {
				System.out.println("You have not enough money to open this Account!"); //for testing
			}
		}
		else {
			System.out.println("You don't have an account with this IBAN! Please enter a valid IBAN!"); //for testing
		}
	}

	public void openDeposit(IClient client, String initiatorIban,
			double amount, depositType type) {
		if(allAccounts.containsKey(initiatorIban)) {
			if(allAccounts.get(initiatorIban).getAmount() >= amount) {
				if(!client.getClientAccounts().containsKey("Deposit")) {
					client.getClientAccounts().put("Deposit", new HashMap<String, ArrayList<Account>>());
				}
				if(type.equals("DepositLongTerm")) {
					if(!client.getClientAccounts().get("Deposit").containsKey("DepositLongTerm")) {
						client.getClientAccounts().get("CurrentAccount").put("DepositLongTerm", new ArrayList<Account>());
					}
					client.getClientAccounts().get("CurrentAccount").get("DepositLongTerm").add(new DepositLongTerm(amount));
					allAccounts.get(initiatorIban).removeMoneyFromAccount(amount);
				}
				else if(type.equals("DepositShortTerm")) {
					if(!client.getClientAccounts().get("Deposit").containsKey("DepositShortTerm")) {
						client.getClientAccounts().get("CurrentAccount").put("DepositShortTerm", new ArrayList<Account>());
					}
					client.getClientAccounts().get("CurrentAccount").get("DepositShortTerm").add(new DepositShortTerm(amount));
					allAccounts.get(initiatorIban).removeMoneyFromAccount(amount);
				}
			}
			else {
				System.out.println("You have not enough money to open this Deposit!"); //for testing
			}
		}
		else {
			System.out.println("You don't have an account with this IBAN! Please enter a valid IBAN!"); //for testing
		}

	}

}
