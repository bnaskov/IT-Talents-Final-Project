package com.banking.spring.web.utils;

public class IbanGenerator {
	public static String generateIban() {
		StringBuilder iban = new StringBuilder("BG80");

		/*
		 * Bank identifier - 8 numbers
		 */
		iban.append("ITOB9300");

		/*
		 * Account identifier - 8 numbers
		 */
		for (int i = 0; i < 2; i++) {
			iban.append(RandomInRange.randIntRange(1000, 9999));
		}
		iban.append(RandomInRange.randIntRange(10, 99));

		return iban.toString();
	}
}
