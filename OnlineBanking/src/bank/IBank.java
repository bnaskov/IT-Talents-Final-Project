package bank;

import users.IClient;

public interface IBank 
{
	public enum depositType { DepositShortTerm, DepositLongTerm };
	public boolean transferMoney(IClient client, String initiatorIban, String recipientIban, String reasonForTransfer, double amount);
	public void openAccount(IClient client, String initiatorIban, double amount);
	public void openDeposit(IClient client, String initiatorIban, double amount, depositType type);
	public void closeDeposit(IClient client, String initiatorIban, double amount, depositType type);
}
