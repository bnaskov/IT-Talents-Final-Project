package users;

import bank.Bank;
import products.accounts.Deposit;

public interface IClient 
{
	public void transferMoney(Bank bank, String initiatorIban, String recipientIban, String reasonForTransfer, double amount);
	public void openAccount(Bank bank, String initiatorIban, double amount);
	public void openDeposit(Bank bank, String initiatorIban, double amount, Deposit deposit);
}
