package products.accounts;

import java.util.Random;

import products.BankProduct;
import products.IBankProduct;
import products.IBankProduct.Type;

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
		int n = max - min + 1;
		int i = rn.nextInt() % n;
		return  (min + i);
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
