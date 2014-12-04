package products.accounts;

public class DepositShortTerm extends Deposit {

	private static final double SHORT_TERM_INTEREST = 4;
	private static final int SHORT_TERM_DURATION = 3;

	public DepositShortTerm(double amount) {
		super(amount, SHORT_TERM_INTEREST, SHORT_TERM_DURATION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DepositShortTerm [getInterest()=" + getInterest()
				+ ", getDurationMonths()=" + getDurationMonths()
				+ ", getIBAN()=" + getIBAN() + ", getAmount()=" + getAmount()
				+ "]";
	}
	
	@Override
	public String getIBAN() {
		// TODO Auto-generated method stub
		return super.getIBAN();
	}

}
