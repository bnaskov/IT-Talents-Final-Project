package products.accounts;

public class DepositShortTerm extends Deposit{

	public DepositShortTerm(String name, double value, double interest) {
		super(name, value, interest, 3);
	}

}
