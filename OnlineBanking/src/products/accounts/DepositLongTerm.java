package products.accounts;

public class DepositLongTerm extends Deposit{

	public DepositLongTerm(String name, double value, double interest) {
		super(name, value, interest, 12);
	}

}
