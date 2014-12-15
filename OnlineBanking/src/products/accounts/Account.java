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
	
	public void addMoneyToAccount(double amount) {
		this.amount += amount;
	}
	
	public void removeMoneyFromAccount(double amount) {
		this.amount -= amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iban == null) ? 0 : iban.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (iban == null) {
			if (other.iban != null)
				return false;
		} else if (!iban.equals(other.iban))
			return false;
		return true;
	}
	
	
}
