package demo;

import java.util.ArrayList;
import java.util.HashMap;

import bank.Bank;
import products.BankProduct;
import products.accounts.Account;
import products.accounts.DepositLongTerm;
import products.accounts.DepositShortTerm;
import users.IClient;
import users.Manager;
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
		Bank bank = Bank.getInstance();
		bank.addAccountsInBank(accounts.get("Deposit").get("DepositShortTerm").get(0).getIBAN(), accounts.get("Deposit").get("DepositShortTerm").get(0));
		bank.addAccountsInBank(accounts.get("Deposit").get("DepositLongTerm").get(0).getIBAN(), accounts.get("Deposit").get("DepositLongTerm").get(0));
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		System.out.println(accounts.get("Deposit").get("DepositShortTerm"));
		System.out.println(accounts.get("Deposit").get("DepositLongTerm"));
		IClient ivan = new Person("Ivan", "8911156858", "ivan@abv.bg", "359881742485", "pass123", "Sofia", "Knyaz Boris 1", accounts, transactions);
		ivan.transferMoney(accounts.get("Deposit").get("DepositShortTerm").get(0).getIBAN(),accounts.get("Deposit").get("DepositLongTerm").get(0).getIBAN(), "just for test", 1500);
		System.out.println();
		for(Transaction t : transactions)
		{
			System.out.print("Initiator IBAN: " + t.getInitiatorIban() + " ");
			System.out.print("Recipient IBAN: " + t.getRecipientIban() + " ");
			System.out.print("Reason for transfer: " + t.getReasonForTransfer() + " ");
			System.out.print("Amount: " + t.getTransferAmount());
		}
		System.out.println();
		System.out.println();
		System.out.println(accounts.get("Deposit").get("DepositShortTerm"));
		System.out.println(accounts.get("Deposit").get("DepositLongTerm"));
		
		System.out.println();
		System.out.println();
		ivan.openAccount(accounts.get("Deposit").get("DepositShortTerm").get(0).getIBAN(), 2000);
		bank.addAccountsInBank(ivan.getClientAccounts().get("CurrentAccount").get("CurrentAccountBGN").get(0).getIBAN(), ivan.getClientAccounts().get("CurrentAccount").get("CurrentAccountBGN").get(0));
		System.out.println(accounts.get("Deposit").get("DepositShortTerm").get(0));
		System.out.println(ivan.getClientAccounts().get("CurrentAccount").get("CurrentAccountBGN"));
		
		System.out.println();
		System.out.println("MANAGER TEST: ");
		System.out.println();
		Manager miro = new Manager("Miro", "1234567", "miro@abv.bg", "35988984534", "12345", "Sofia", "Oborishte");
		miro.listAccount(accounts.get("Deposit").get("DepositShortTerm").get(0).getIBAN());
		
		System.out.println();
		Bank.getInstance().addClientToBank(ivan);
		System.out.println("Client's accounts: ");
		miro.listClientAccounts("8911156858");
		
		System.out.println();
		System.out.println("All accounts in bank: ");
		miro.listAllAccounts();
		
	}
}
