package users;

import products.accounts.Deposit;

public interface IClient {
	public void transferMoney(String initiatorIban, String recipientIban,
			String reasonForTransfer, double amount);

	public void openAccount(String initiatorIban, double amount);

	public void openDeposit(String initiatorIban, double amount, Deposit deposit);
}
