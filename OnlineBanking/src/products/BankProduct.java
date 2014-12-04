package products;

public abstract class BankProduct {

	private double amount;

	// private Date date = new Date();

	public BankProduct(double value) {
		this.amount = value;

	}

	public void setValue(double value) {
		this.amount = value;
	}

	public Double getAmount() {
		return this.amount;
	}
}
