package com.banking.spring.web.utils;

import java.util.Random;

public class RandomInRange {
	public static int randIntRange(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}
}
