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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + durationMonths;
		long temp;
		temp = Double.doubleToLongBits(interest);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deposit other = (Deposit) obj;
		if (durationMonths != other.durationMonths)
			return false;
		if (Double.doubleToLongBits(interest) != Double
				.doubleToLongBits(other.interest))
			return false;
		return true;
	}
	
	

}
