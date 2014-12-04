package demo;

import java.util.ArrayList;
import java.util.HashMap;

import products.BankProduct;
import products.accounts.DepositShortTerm;
import users.IClient;
import users.Person;
import users.Transaction;

public class Demo {

	public static void main(String[] args) {

		HashMap<String, HashMap<String, ArrayList<BankProduct>>> accounts = new HashMap() {
			{
				put("Deposit", new HashMap() {
					{
						put("ShortTermDeposit", new ArrayList<BankProduct>() {
							{
								add(new DepositShortTerm(10000));
							}
						});
					}
				});
			}
		};
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		System.out.println(accounts.get("Deposit").get("ShortTermDeposit"));
		IClient ivan = new Person("Ivan", "8911156858", "ivan@abv.bg", "359881742485", "pass123", "Sofia", "Knyaz Boris 1", accounts, transactions);
		ivan.transferMoney("1234", "4567", "just for test", 1500);
		ivan.transferMoney("123457457454", "456734643", "just for test2", 3500);
		for(Transaction t : transactions)
		{
			System.out.println(t.getInitiatorIban());
			System.out.println(t.getRecipientIban());
			System.out.println(t.getReasonForTransfer());
			System.out.println(t.getTransferAmount());
		}
		
	}
}
