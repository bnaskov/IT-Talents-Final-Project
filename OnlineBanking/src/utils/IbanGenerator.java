package utils;

public class IbanGenerator {
	public static String generateIban() {
		StringBuilder iban = new StringBuilder("BG80 ITOB");
		for (int i = 0; i < 3; i++) {
			iban.append(" " + RandomInRange.randIntRange(1000, 9999));
		}
		iban.append(RandomInRange.randIntRange(10, 99));
		return iban.toString();
	}
}
