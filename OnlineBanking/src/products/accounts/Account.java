package products.accounts;

import java.util.Random;

import products.BankProduct;


public abstract class Account extends BankProduct{

	private String iban;
	
	public Account(String name, double value, Type type) {
		super(name, value, type);
		this.iban = generateIban();
		
	}

	public String getIBAN(){
		return this.iban;
	}
	
	@Override
	public String toString() {

		return super.getType() + ", " + super.getName() + ", "  + super.getValue() + ", " + this.iban;
	}
	
	private static int randIntNumRange(int min, int max){
		Random rn = new Random();
		int p = 0;
		while (true) {
			p = rn.nextInt(max);
			if ( p >= min) {
				break;
			}
		}
		return  p;
	}
	
	private static String generateIban(){
		String iban = "BG80 ITOB";
		for (int i = 0; i < 3; i++) {
			iban.concat(" "+ randIntNumRange(1000, 9999));
		}
		iban.concat(" " + randIntNumRange(10, 99));
		return iban;
	}
}
