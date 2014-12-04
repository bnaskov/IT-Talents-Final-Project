package products.accounts;

public class DepositLongTerm extends Deposit {

	private static final double LONG_TERM_INTEREST = 6;
	private static final int LONG_TERM_DURATION = 12;

	public DepositLongTerm(double amount) {
		super(amount, LONG_TERM_INTEREST, LONG_TERM_DURATION);
	}
	
	@Override
	public String toString() {
		return "DepositLongTerm [getInterest()=" + getInterest()
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
