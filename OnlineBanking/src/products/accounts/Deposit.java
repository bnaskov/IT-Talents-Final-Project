package products.accounts;

public abstract class Deposit extends Account {
	private double interest;
	private int durationMonths;

	public Deposit(double amount, double interest, int durationMonths) {
		super(amount);
		this.setInterest(interest);
		this.setDurationMonths(durationMonths);
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public int getDurationMonths() {
		return durationMonths;
	}

	public void setDurationMonths(int durationMonths) {
		this.durationMonths = durationMonths;
	}

}
