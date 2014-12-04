package products.accounts;

public class DepositShortTerm extends Deposit {

	private static final double SHORT_TERM_INTEREST = 4;
	private static final int SHORT_TERM_DURATION = 3;

	public DepositShortTerm(double amount, double interest, int durationMonths) {
		super(amount, SHORT_TERM_INTEREST, SHORT_TERM_DURATION);
		// TODO Auto-generated constructor stub
	}

}
