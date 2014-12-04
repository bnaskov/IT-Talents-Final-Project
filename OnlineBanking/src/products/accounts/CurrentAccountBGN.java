package products.accounts;

public class CurrentAccountBGN extends CurrentAccount {

	public CurrentAccountBGN(double amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "CurrentAccountBGN [getIBAN()=" + getIBAN() + ", getAmount()=" + getAmount()
				+ "]";
	}

}
