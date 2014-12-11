package com.banking.spring.web.utils;

public class IbanGenerator {
	public static String generateIban() {
		StringBuilder iban = new StringBuilder("BG80");

		/*
		 * Bank identifier - 8 numbers
		 */
		iban.append("ITOB9300");

		/*
		 * Account identifier - 10 numbers
		 */
		for (int i = 0; i < 10; i++) {
			iban.append(RandomInRange.randIntRange(0, 9));
		}

		return iban.toString();
	}
}
