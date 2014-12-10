package com.banking.spring.web.utils;

import java.util.Random;

public class RandomInRange {
	private static final int MIN_ACCOUNT_SUM = 10000;
	private static final int MAX_ACCOUNT_SUM = 100000;

	public static int randIntRange(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public static double randomAccountSum() {
		double randomAccountSum = randIntRange(MIN_ACCOUNT_SUM, MAX_ACCOUNT_SUM);

		return randomAccountSum;
	}
}
