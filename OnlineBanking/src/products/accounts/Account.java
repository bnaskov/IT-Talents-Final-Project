package products.accounts;

import products.BankProduct;
import utils.IbanGenerator;

public abstract class Account extends BankProduct {

	private String iban;

	public Account(double amount) {
		super(amount);
		this.iban = IbanGenerator.generateIban();

	}

	public String getIBAN() {
		return this.iban;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + "]";
	}
	
}
