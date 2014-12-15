package com.banking.spring.web.dao;

public class Account extends BankProduct {

	public Account() {

	}

	public Account(int id, String iban, double amount, String username) {
		super(id, iban, amount, username);
	}

	@Override
	public String toString() {
		return "Account [iban=" + super.getIban() + ", amount="
				+ super.getAmount() + ", username=" + super.getUsername() + "]";
	}

}
