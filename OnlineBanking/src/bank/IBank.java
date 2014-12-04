package bank;

import products.accounts.Deposit;
import users.IClient;

public interface IBank 
{
	public boolean transferMoney(IClient client, String initiatorIban, String recipientIban, String reasonForTransfer, double amount);
	public boolean openAccount(IClient client, String initiatorIban, double amount);
	public boolean openDeposit(IClient client, String initiatorIban, double amount, Deposit deposit);
}
