package products.accounts;

import products.IBankProduct.Type;

public class Deposit extends Account{

	private double interest;
	
	public Deposit(String name, double value, double interest) {
		super(name, value, Type.DEPOSIT);
		this.interest = interest;
	}

}
