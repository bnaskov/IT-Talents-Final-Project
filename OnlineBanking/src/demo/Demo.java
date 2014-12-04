package demo;

import java.util.ArrayList;
import java.util.HashMap;

import products.BankProduct;
import products.accounts.Account;
import products.accounts.DepositLongTerm;
import products.accounts.DepositShortTerm;
import users.IClient;
import users.Person;
import users.Transaction;

public class Demo {

	public static void main(String[] args) {

		HashMap<String, HashMap<String, ArrayList<Account>>> accounts = new HashMap() {
			{
				put("Deposit", new HashMap() {
					{
						put("DepositShortTerm", new ArrayList<Account>() {
							{
								add(new DepositShortTerm(10000));
							}
						});
						put("DepositLongTerm", new ArrayList<Account>() {
							{
								add(new DepositLongTerm(10000));
							}
						});
					}
				});
			}
		};
//		accounts.put("Deposit", new HashMap());
//		accounts.get("Deposit").put("DepositLongTerm", new ArrayList<Account>());
//		accounts.get("Deposit").get("DepositLongTerm").add(new DepositLongTerm(5000));
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		System.out.println(accounts.get("Deposit").get("DepositShortTerm"));
		System.out.println(accounts.get("Deposit").get("DepositLongTerm"));
//		System.out.println(accounts.get("Deposit").get("DepositLongTerm"));
		IClient ivan = new Person("Ivan", "8911156858", "ivan@abv.bg", "359881742485", "pass123", "Sofia", "Knyaz Boris 1", accounts, transactions);
		ivan.transferMoney(accounts.get("Deposit").get("DepositShortTerm").get(0).getIBAN(),accounts.get("Deposit").get("DepositLongTerm").get(0).getIBAN(), "just for test", 1500);
		for(Transaction t : transactions)
		{
			System.out.println(t.getInitiatorIban());
			System.out.println(t.getRecipientIban());
			System.out.println(t.getReasonForTransfer());
			System.out.println(t.getTransferAmount());
		}
		System.out.println(accounts.get("Deposit").get("DepositShortTerm"));
		System.out.println(accounts.get("Deposit").get("DepositLongTerm"));
		
		
		System.out.println(accounts.get("Deposit").get("DepositShortTerm").get(0).getIBAN());
		System.out.println(accounts.get("Deposit").get("DepositLongTerm").get(0).getIBAN());
	}
}
