package products;

public abstract class BankProduct {

	protected double amount;

	// private Date date = new Date();

	public BankProduct(double amount) {
		this.setAmount(amount);

	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Double getAmount() {
		return this.amount;
	}
	
}
