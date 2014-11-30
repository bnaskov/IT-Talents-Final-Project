package products.accounts;

import products.IBankProduct.Type;


public class CurrentAccount extends Account{

	public CurrentAccount(String name, double value) {
		super(name, value, Type.CURRENT_ACCOUNT);
	}

}
