package products.accounts;


public abstract class Deposit extends Account{

	private double interest;
	private int durationMonths;
	
	public Deposit(String name, double value, double interest, int durationMonths) {
		super(name, value, Type.DEPOSIT);
		this.interest = interest;
		this.durationMonths = durationMonths;
	}

}
