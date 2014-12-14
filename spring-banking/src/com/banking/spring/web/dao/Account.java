package com.banking.spring.web.dao;

public class Account extends BankProduct {

	@Override
	public String toString() {
		return "Account [iban=" + super.getIban() + ", amount=" + super.getAmount()
				+ ", username=" + super.getUsername() + "]";
	}
}
