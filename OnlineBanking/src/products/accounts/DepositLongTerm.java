package products.accounts;

public class DepositLongTerm extends Deposit {

	private static final double LONG_TERM_INTEREST = 6;
	private static final int LONG_TERM_DURATION = 12;

	public DepositLongTerm(double amount, double interest, int durationMonths) {
		super(amount, LONG_TERM_INTEREST, LONG_TERM_DURATION);
	}

}
